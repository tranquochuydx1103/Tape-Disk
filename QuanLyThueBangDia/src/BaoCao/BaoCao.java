package BaoCao;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import BaoCao.KHQuaHanTra;
import Database.Database;
import DieuKhien.QuanLyKhachHang;
import DieuKhien.QuanLyThongKe;
import DoiTuong.KhachHang;

public class BaoCao {
	FileDialog fd = new FileDialog(new JFrame(), "Xuất excel", FileDialog.SAVE);

    private String getFile() {
        fd.setFile("untitled.xls");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }
	// Xuất file Excel Khách hàng quá hạn trả đĩa  
    public void xuatFileExcelKHQuaHanTra() {
        fd.setTitle("Xuất dữ liệu khách hàng quá hạn trả đĩa ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("DSKH Quá Hạn Trả Đĩa");

            QuanLyThongKe qlkhQHT = new QuanLyThongKe();
            ArrayList<KHQuaHanTra> list = qlkhQHT.docTuBangKHQuaHanTra();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã Khách Hàng");
            row.createCell(2, CellType.STRING).setCellValue("Tên Khách Hàng");
            row.createCell(3, CellType.STRING).setCellValue("Số Điện Thoại");
            row.createCell(4, CellType.STRING).setCellValue("Ngày Thuê");
            row.createCell(5, CellType.STRING).setCellValue("Ngày Đã Thuê");
            row.createCell(6, CellType.STRING).setCellValue("Số Ngày Trễ");

            for (KHQuaHanTra KH : list) {
				
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(KH.getMaKH());
                row.createCell(2, CellType.STRING).setCellValue(KH.getTenKH());
                row.createCell(3, CellType.STRING).setCellValue(KH.getSDT());
                row.createCell(4, CellType.STRING).setCellValue(KH.getNgayThue());
                row.createCell(5, CellType.STRING).setCellValue(KH.getNgayDaThue());
                row.createCell(6, CellType.STRING).setCellValue(KH.getSoNgayTre());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
        	Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IOException ex) {
        	Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
         
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    //Xuát excel KH Thuê Đĩa nhiều nhất( top10)
 
    public void xuatFileExcelKHThueDiaNhieuNhat(java.sql.Date ngayBD, java.sql.Date ngayKT) {
        fd.setTitle("Xuất dữ liệu khách hàng thuê đĩa nhiều nhất ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
        	
            HSSFWorkbook workbook = new HSSFWorkbook();	
            HSSFSheet sheet = workbook.createSheet("DSKH Thuê Đĩa Nhiều Nhất");

            QuanLyThongKe qlkhTNN = new QuanLyThongKe();
            ArrayList<KHThueNhieuNhat> list = qlkhTNN.docTuBangKHThueNhieuNhat(ngayBD, ngayKT);

            int rownum = 0;
            Row row = sheet.createRow(rownum);
            
            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã Khách Hàng");
            row.createCell(2, CellType.STRING).setCellValue("Tên Khách Hàng");
            row.createCell(3, CellType.STRING).setCellValue("Số Điện Thoại");
            row.createCell(4, CellType.STRING).setCellValue("Số Lượng");


            for (KHThueNhieuNhat KH : list) {
				
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(KH.getMaKh());
                row.createCell(2, CellType.STRING).setCellValue(KH.getTenKH());
                row.createCell(3, CellType.STRING).setCellValue(KH.getSdt());
                row.createCell(4, CellType.STRING).setCellValue(KH.getSoLuong());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
        	Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IOException ex) {
        	Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
         
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Xuát excel Doanh Thu
    
    public void xuatFileExcelDoanhThu(java.sql.Date ngayBD,java.sql.Date ngayKT) {
        fd.setTitle("Xuất dữ liệu doanh thu ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();	
            HSSFSheet sheet = workbook.createSheet("Doanh Thu");

            QuanLyThongKe qlDT = new QuanLyThongKe();
            ArrayList<DoanhThu> list = qlDT.docTuBangDoanhThu(ngayBD, ngayKT);

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Ngày");
            row.createCell(2, CellType.STRING).setCellValue("Tổng Số Hóa Đơn");
            row.createCell(3, CellType.STRING).setCellValue("Tổng Tiền Thuê");


            for (DoanhThu dt : list) {
				
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(dt.getNgay());
                row.createCell(2, CellType.STRING).setCellValue(dt.getTongSoHD());
                row.createCell(3, CellType.STRING).setCellValue(dt.getTongTienThue());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
        	Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IOException ex) {
        	Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
         
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Xuất excel số băng đĩa được yêu thích
    
    public void xuatFileExcelDBDuocYeuThich(java.sql.Date ngayBD, java.sql.Date ngayKT) {
        fd.setTitle("Xuất dữ liệu băng đĩa được yêu thích ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();	
            HSSFSheet sheet = workbook.createSheet("DSDB Được Yêu Thích");

            QuanLyThongKe qlbdDYT = new QuanLyThongKe();
            ArrayList<BDDuocYeuThich> list = qlbdDYT.docTuBangBDDuocYeuThich(ngayBD, ngayKT);

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã Băng Đĩa");
            row.createCell(2, CellType.STRING).setCellValue("Tên Băng Đĩa");
            row.createCell(3, CellType.STRING).setCellValue("Thể Loại");
            row.createCell(4, CellType.STRING).setCellValue("Tên Nhà cung Cấp");
            row.createCell(5, CellType.STRING).setCellValue("Số lượt Thuê");


            for (BDDuocYeuThich BD : list) {
				
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(BD.getMaBD());
                row.createCell(2, CellType.STRING).setCellValue(BD.getTenBD());
                row.createCell(3, CellType.STRING).setCellValue(BD.getTheLoai());
                row.createCell(4, CellType.STRING).setCellValue(BD.getTenNCC());
                row.createCell(5, CellType.STRING).setCellValue(BD.getSoLuotThue());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
        	Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IOException ex) {
        	Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
         
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
 //Xuất excel băng đĩa quá hạn trả
    
    public void xuatFileExcelDBQuaHanTra() {
        fd.setTitle("Xuất dữ liệu băng đĩa quá hạn trả ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();	
            HSSFSheet sheet = workbook.createSheet("DSDB Quá Hạn Trả");

            QuanLyThongKe qlbdQHT = new QuanLyThongKe();
            ArrayList<BDQuaHanTra> list = qlbdQHT.docTuBangBDQuaHanTra();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã Băng Đĩa");
            row.createCell(2, CellType.STRING).setCellValue("Tên Băng Đĩa");
            row.createCell(3, CellType.STRING).setCellValue("Số Lượng");


            for (BDQuaHanTra BD : list) {
				
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(BD.getMaBD());
                row.createCell(2, CellType.STRING).setCellValue(BD.getTenBD());
                row.createCell(3, CellType.STRING).setCellValue(BD.getSoLuong());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
        	Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IOException ex) {
        	Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
         
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BaoCao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private String getTime() {
        return new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    }
	private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}



}
