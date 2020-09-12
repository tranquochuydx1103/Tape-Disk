package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DieuKhien.QuanLyNhanVien;
import DoiTuong.NhanVien;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import java.awt.Color;

public class GiaoDienTong extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmCNBangDia, mntmTaiKhoan, mntmDangXuat, mntmThoat, mntmCNNCC, mntmCNKhachHang, mntmCNNhanVien,
			mntmTraBangDia, mntmThueBangDia, mntmTKBangDia, mntmTKHoaDon, mntmTKKhachHang, mntmCNTheLoai, mntmCNQuocGia,
			mntmYeuThich, mntmBDQuaHan, mntmDoanhThu, mntmThueNhieu, mntmKHQuaHan;
	private String maNV;
	private JLabel lblNhanVien, lblChucVu;
	private QuanLyNhanVien NV;
	private JMenuItem mntmCNChucVu;

	public GiaoDienTong(String maNV) {
		setTitle("Quản Lý Cửa Hàng Thuê Băng Đĩa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1014, 572);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.maNV = maNV;

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(0, 0, 1360, 32);
		contentPane.add(menuBar);

		JMenu mnHeThong = new JMenu("Hệ Thống  ");
		mnHeThong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnHeThong);

		mntmTaiKhoan = new JMenuItem("Đổi Mật Khẩu");
		mntmTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnHeThong.add(mntmTaiKhoan);

		mntmDangXuat = new JMenuItem("Đăng Xuất");
		mntmDangXuat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnHeThong.add(mntmDangXuat);
		mntmDangXuat.addActionListener(this);

		mntmThoat = new JMenuItem("Thoát");
		mntmThoat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnHeThong.add(mntmThoat);
		mntmThoat.addActionListener(this);

		JMenu mnQuanLy = new JMenu("Danh Mục ");
		mnQuanLy.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnQuanLy);

		mntmCNBangDia = new JMenuItem("Băng Đĩa");
		mntmCNBangDia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnQuanLy.add(mntmCNBangDia);
		mntmCNBangDia.addActionListener(this);

		mntmCNNCC = new JMenuItem("Nhà Cung Cấp");
		mntmCNNCC.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnQuanLy.add(mntmCNNCC);
		mntmCNNCC.addActionListener(this);

		mntmCNKhachHang = new JMenuItem("Khách Hàng");
		mntmCNKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnQuanLy.add(mntmCNKhachHang);
		mntmCNKhachHang.addActionListener(this);

		mntmCNNhanVien = new JMenuItem("Nhân Viên");
		mntmCNNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnQuanLy.add(mntmCNNhanVien);

		mntmCNTheLoai = new JMenuItem("Thể Loại");
		mntmCNTheLoai.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnQuanLy.add(mntmCNTheLoai);
		mntmCNTheLoai.addActionListener(this);
		mntmCNQuocGia = new JMenuItem("Quốc Gia");
		mntmCNQuocGia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnQuanLy.add(mntmCNQuocGia);

		mntmCNChucVu = new JMenuItem("Chức Vụ");
		mntmCNChucVu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnQuanLy.add(mntmCNChucVu);
		mntmCNQuocGia.addActionListener(this);
		mntmCNNhanVien.addActionListener(this);

		JMenu mnThueTra = new JMenu("Xử Lý ");
		mnThueTra.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnThueTra);

		mntmThueBangDia = new JMenuItem("Thuê Băng Đĩa");
		mntmThueBangDia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnThueTra.add(mntmThueBangDia);
		mntmThueBangDia.addActionListener(this);

		mntmTraBangDia = new JMenuItem("Trả Băng Đĩa");
		mntmTraBangDia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnThueTra.add(mntmTraBangDia);
		mntmTraBangDia.addActionListener(this);

		JMenu mnTimKiem = new JMenu("Tìm Kiếm  ");
		mnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnTimKiem);

		mntmTKBangDia = new JMenuItem("Băng Đĩa");
		mntmTKBangDia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnTimKiem.add(mntmTKBangDia);

		mntmTKHoaDon = new JMenuItem("Hóa Đơn");
		mntmTKHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnTimKiem.add(mntmTKHoaDon);

		mntmTKKhachHang = new JMenuItem("Khách Hàng");
		mntmTKKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnTimKiem.add(mntmTKKhachHang);

		JMenu mnThongKe = new JMenu("Thống Kê  / Báo Cáo");
		mnThongKe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnThongKe);

		JMenu mnBnga = new JMenu("Băng Đĩa");
		mnBnga.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnThongKe.add(mnBnga);

		mntmYeuThich = new JMenuItem("Yêu Thích");
		mntmYeuThich.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnBnga.add(mntmYeuThich);
		mntmYeuThich.addActionListener(this);

		mntmBDQuaHan = new JMenuItem("Quá Hạn Trả");
		mntmBDQuaHan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnBnga.add(mntmBDQuaHan);
		mntmBDQuaHan.addActionListener(this);

		mntmDoanhThu = new JMenuItem("Doanh Thu");
		mntmDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnThongKe.add(mntmDoanhThu);
		mntmDoanhThu.addActionListener(this);

		JMenu mnKhchHng = new JMenu("Khách Hàng");
		mnKhchHng.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnThongKe.add(mnKhchHng);

		mntmThueNhieu = new JMenuItem("Thuê Nhiều Nhất");
		mntmThueNhieu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnKhchHng.add(mntmThueNhieu);
		mntmThueNhieu.addActionListener(this);

		mntmKHQuaHan = new JMenuItem("Quá Hạn Trả");
		mntmKHQuaHan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnKhchHng.add(mntmKHQuaHan);
		mntmKHQuaHan.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Nhân Viên : ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 475, 88, 23);
		contentPane.add(lblNewLabel_1);

		lblNhanVien = new JLabel("");
		lblNhanVien.setForeground(Color.BLACK);
		lblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhanVien.setBounds(90, 475, 203, 23);
		contentPane.add(lblNhanVien);

		JLabel lblChcV = new JLabel("Chức Vụ  : ");
		lblChcV.setForeground(Color.BLACK);
		lblChcV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChcV.setBounds(10, 509, 88, 23);
		contentPane.add(lblChcV);

		lblChucVu = new JLabel("");
		lblChucVu.setForeground(Color.BLACK);
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChucVu.setBounds(90, 509, 203, 23);
		contentPane.add(lblChucVu);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/5474953677_e90dfcbb71_b.jpg")));
		lblNewLabel.setBounds(0, 31, 1008, 512);
		contentPane.add(lblNewLabel);

		mntmTKHoaDon.addActionListener(this);
		mntmTKBangDia.addActionListener(this);
		mntmTKKhachHang.addActionListener(this);
		mntmTaiKhoan.addActionListener(this);
		mntmCNChucVu.addActionListener(this);
		

		int chucVu = 0;
		NV = new QuanLyNhanVien();
		List<NhanVien> nv = NV.docTuBang();
		for (NhanVien nhanVien : nv) {
			if (nhanVien.getMaNV().trim().equals(maNV.trim())) {
				lblNhanVien.setText(nhanVien.getTenNV());
				lblChucVu.setText(nhanVien.getChuVu());
				if (nhanVien.getChuVu().equals("Quản Lý"))
					chucVu = 1;
			}
		}

		if (chucVu == 0) {
			mntmCNNCC.setVisible(false);
			mntmCNNhanVien.setVisible(false);
			mntmCNChucVu.setVisible(false);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(mntmCNBangDia)) {
			GiaoDienQuanLyBangDia bd = new GiaoDienQuanLyBangDia();
			bd.setVisible(true);
		} else if (o.equals(mntmCNKhachHang)) {
			GiaoDienQuanLyKhachHang kh = new GiaoDienQuanLyKhachHang();
			kh.setVisible(true);
		} else if (o.equals(mntmCNNhanVien)) {
			GiaoDienQuanLyNhanVien nv = new GiaoDienQuanLyNhanVien();
			nv.setVisible(true);
		} else if (o.equals(mntmCNNCC)) {
			GiaoDienQuanLyNhaCungCap ncc = new GiaoDienQuanLyNhaCungCap();
			ncc.setVisible(true);
		} else if (o.equals(mntmThueBangDia)) {
			GiaoDienDanhSachKhachHang kh = new GiaoDienDanhSachKhachHang(maNV);
			kh.setVisible(true);
		} else if (o.equals(mntmTraBangDia)) {
			GiaoDienDanhSachPhieuThue t = new GiaoDienDanhSachPhieuThue(maNV);
			t.setVisible(true);
		} else if (o.equals(mntmTKBangDia)) {
			GiaoDienTimKiemBangDia bd = new GiaoDienTimKiemBangDia();
			bd.setVisible(true);
		} else if (o.equals(mntmTKHoaDon)) {
			GiaoDienTimKiemHoaDon hd = new GiaoDienTimKiemHoaDon(maNV);
			hd.setVisible(true);
		} else if (o.equals(mntmTKKhachHang)) {
			GiaoDienTimKiemKhachHang kh = new GiaoDienTimKiemKhachHang();
			kh.setVisible(true);
		} else if (o.equals(mntmCNTheLoai)) {
			GiaoDienQuanLyTheLoai tl = new GiaoDienQuanLyTheLoai();
			tl.setVisible(true);
		} else if (o.equals(mntmCNQuocGia)) {
			GiaoDienQuanLyQuocGia qg = new GiaoDienQuanLyQuocGia();
			qg.setVisible(true);
		} else if (o.equals(mntmThoat)) {
			setVisible(false);
		} else if (o.equals(mntmDangXuat)) {
			GiaoDienDangNhap dn = new GiaoDienDangNhap();
			dn.setVisible(true);
			setVisible(false);
		} else if (o.equals(mntmYeuThich)) {
			GiaoDienThongKeSoBangDiaDuocYeuThich t = new GiaoDienThongKeSoBangDiaDuocYeuThich();
			t.setVisible(true);
		} else if (o.equals(mntmBDQuaHan)) {
			GiaoDienThongKeSoBangDiaQuaHan t = new GiaoDienThongKeSoBangDiaQuaHan();
			t.setVisible(true);
		} else if (o.equals(mntmDoanhThu)) {
			GiaoDienThongKeDoanhThu t = new GiaoDienThongKeDoanhThu();
			t.setVisible(true);
		} else if (o.equals(mntmKHQuaHan)) {
			GiaoDienThongKeDanhSachKhachHangQuaHanTra t = new GiaoDienThongKeDanhSachKhachHangQuaHanTra();
			t.setVisible(true);
		} else if (o.equals(mntmThueNhieu)) {
			GiaoDienThongKeKhachHangThueBangDiaNhieuNhat t = new GiaoDienThongKeKhachHangThueBangDiaNhieuNhat();
			t.setVisible(true);
		} else if (o.equals(mntmTaiKhoan)) {
			NV = new QuanLyNhanVien();
			String maTK = NV.layMaTK(maNV);
			GiaoDienDoiMatKhau t = new GiaoDienDoiMatKhau(maTK);
			t.setVisible(true);
			setVisible(false);
		} else if (o.equals(mntmCNChucVu)) {
			GiaoDienQuanLyChucVu t = new GiaoDienQuanLyChucVu();
			t.setVisible(true);
		}
	}
}
