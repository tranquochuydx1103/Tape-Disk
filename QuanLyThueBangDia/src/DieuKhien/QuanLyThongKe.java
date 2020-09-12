package DieuKhien;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import BaoCao.BDDuocYeuThich;
import BaoCao.BDQuaHanTra;
import BaoCao.DoanhThu;
import BaoCao.KHQuaHanTra;
import BaoCao.KHThueNhieuNhat;
import Database.Database;


public class QuanLyThongKe {
	private ArrayList<KHQuaHanTra> qlkhQHT;
	private ArrayList<KHThueNhieuNhat> qlkhTNN;
	private ArrayList<DoanhThu> qlDT;
	private ArrayList<BDQuaHanTra> qlbdQHT;
	private ArrayList<BDDuocYeuThich> qlbdDYT;
	
	public QuanLyThongKe() {
		qlkhQHT= new ArrayList<KHQuaHanTra>();
		qlkhTNN=new ArrayList<KHThueNhieuNhat>();
		qlDT=new ArrayList<DoanhThu>();
		qlbdQHT=new ArrayList<BDQuaHanTra>();
		qlbdDYT=new ArrayList<BDDuocYeuThich>();
	}
	
	
	
	public ArrayList<KHQuaHanTra> docTuBangKHQuaHanTra(){
		try {
			Connection con= Database.getInstance().getConnection();
			String sql="select * from [dbo].[ThongKeDanhSachKhachHangTreHan]()";
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String sdt=rs.getString(3);
				Date ngaylapHD=rs.getDate(4);
				int soNgayDaThue=rs.getInt(5);
				int soNgayTreHan=rs.getInt(6);
				KHQuaHanTra KHQHT=new KHQuaHanTra(ma, ten, sdt, ngaylapHD, soNgayDaThue, soNgayTreHan);
				qlkhQHT.add(KHQHT);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return qlkhQHT;
	}
	
	public ArrayList<KHThueNhieuNhat> docTuBangKHThueNhieuNhat(java.sql.Date ngayBD, java.sql.Date ngayKT){
		try {
			
			Connection con= Database.getInstance().getConnection();
			String sql="select * from [dbo].[ThongKeDanhSachKhachHangThueNhieuNhatTrongTuan]('"+ngayBD+"','"+ngayKT+"')";
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String sdt=rs.getString(3);
				int soLuong=rs.getInt(4);
				KHThueNhieuNhat KHTNN=new KHThueNhieuNhat(ma, ten, sdt, soLuong);
				qlkhTNN.add(KHTNN);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return qlkhTNN;
	}
	public ArrayList<DoanhThu> docTuBangDoanhThu(java.sql.Date ngayBD, java.sql.Date ngayKT){
		try {
			
			Connection con= Database.getInstance().getConnection();
			String sql="select * from [dbo].[ThongKeDoanhThuTheoNgay]('"+ngayBD+"','"+ngayKT+"')";
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while (rs.next()) {
				Date ngay=rs.getDate(1);
				int tongSoHD=rs.getInt(2);
				double tongTienThue=rs.getDouble(3);
				DoanhThu DT=new DoanhThu(ngay, tongSoHD, tongTienThue);
				qlDT.add(DT);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return qlDT;
	}
	public ArrayList<BDQuaHanTra> docTuBangBDQuaHanTra(){
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select BangDia.IDBangDia,BangDia.TenBD,SoLuongBDChuaTra=sum(ChiTietHoaDon.SoLuong) \r\n" + 
					"from HoaDon join ChiTietHoaDon on HoaDon.IDHoaDon=ChiTietHoaDon.IDHoaDon\r\n" + 
					"			join BangDia on ChiTietHoaDon.IDBangDia=BangDia.IDBangDia\r\n" + 
					"where HoaDon.NgayTraDia is null and DATEDIFF(day,HoaDon.NgayLapHD,GETDATE())>7\r\n" + 
					"group by BangDia.IDBangDia, BangDia.TenBD";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maBD = rs.getString(1);
				String tenBD = rs.getString(2);
				int SoLuong= rs.getInt(3);
				BDQuaHanTra BDQHT=new BDQuaHanTra(maBD, tenBD, SoLuong);
				qlbdQHT.add(BDQHT);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return qlbdQHT;
	}
	public ArrayList<BDDuocYeuThich> docTuBangBDDuocYeuThich(java.sql.Date ngayBD, java.sql.Date ngayKT){
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from [dbo].[ThongKeTop10BangDiaYeuThichNhat]('"+ngayBD+"','"+ngayKT+"')";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String theLoai=rs.getString(3);
				String tenNCC=rs.getString(4);
				int soLuot=rs.getInt(5);
				BDDuocYeuThich BDDYT=new BDDuocYeuThich(ma, ten, theLoai, tenNCC, soLuot);
				qlbdDYT.add(BDDYT);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return qlbdDYT;
	}
}
