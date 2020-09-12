package DieuKhien;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Database;
import DoiTuong.KhachHang;

public class QuanLyKhachHang {
	private ArrayList<KhachHang> qlkh;

	public QuanLyKhachHang() {
		qlkh = new ArrayList<KhachHang>();
	}

	public ArrayList<KhachHang> docTuBang() {
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from KhachHang";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String gioiTinh = rs.getString(3);
				Date ngaySinh = rs.getDate(4);
				Date ngayDK = rs.getDate(5);
				String cmnd = rs.getString(6);
				String diaChi = rs.getString(7);
				String email = rs.getString(8);
				String sdt = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, ngayDK, cmnd, diaChi, email, sdt);
				qlkh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qlkh;

	}

	public ArrayList<KhachHang> timKiemKH(String tenKh, String Sdt, String Cmnd, Date tuNgay, Date denNgay) {
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select *\r\n" + "from KhachHang\r\n" + "where HotenKH like N'%" + tenKh + "%' and SDT like '%"
					+ Sdt + "%'\r\n" + "and CMND like '%" + Cmnd + "%'and NgayDangKy >= '" + tuNgay.toString()
					+ "' and NgayDangKy <= '" + denNgay.toString() + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String gioiTinh = rs.getString(3);
				Date ngaySinh = rs.getDate(4);
				Date ngayDK = rs.getDate(5);
				String cmnd = rs.getString(6);
				String diaChi = rs.getString(7);
				String email = rs.getString(8);
				String sdt = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, ngayDK, cmnd, diaChi, email, sdt);
				qlkh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qlkh;

	}

	public boolean themKhachHang(String maKH, String hoTen, String gioiTinh, Date ngaySinh, Date ngayDK, String cMND,
			String diaChi, String email, String sdt) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into KhachHang Values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, maKH);
			stmt.setString(2, hoTen);
			stmt.setString(3, gioiTinh);
			stmt.setDate(4, ngaySinh);
			stmt.setDate(5, ngayDK);
			stmt.setString(6, cMND);
			stmt.setString(7, diaChi);
			stmt.setString(8, email);
			stmt.setString(9, sdt);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean capNhat(String maKH, String hoTen, String gioiTinh, Date ngaySinh, Date ngayDK, String cMND,
			String diaChi, String email, String sdt) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Update KhachHang " + "set hoTenKH=?," + "gioiTinh=?," + "ngaySinh=?,"
					+ "ngayDangKy=?," + "cMND=?," + "diaChi=?," + "email=?," + "sdt=?" + " where iDKhachHang=?");
			stmt.setString(1, hoTen);
			stmt.setString(2, gioiTinh);
			stmt.setDate(3, ngaySinh);
			stmt.setDate(4, ngayDK);
			stmt.setString(5, cMND);
			stmt.setString(6, diaChi);
			stmt.setString(7, email);
			stmt.setString(8, sdt);
			stmt.setString(9, maKH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public ArrayList<KhachHang> timKiemTheoSDTKhachHang(String soDienThoai) {
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select * from KhachHang where sDT like '%" + soDienThoai + "%'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String gioiTinh = rs.getString(3);

				Date ngaySinh = rs.getDate(4);
				Date ngayDK = rs.getDate(5);
				String cmnd = rs.getString(6);
				String diaChi = rs.getString(7);
				String email = rs.getString(8);
				String sdt = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, ngayDK, cmnd, diaChi, email, sdt);
				qlkh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qlkh;
	}

	public ArrayList<KhachHang> kiemTraKhachHangDangThue() {
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "select *\r\n" + "from KhachHang join HoaDon on KhachHang.IDKhachHang=HoaDon.IDKhachHang\r\n"
					+ "where HoaDon.NgayTraDia is null";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String gioiTinh = rs.getString(3);

				Date ngaySinh = rs.getDate(4);
				Date ngayDK = rs.getDate(5);
				String cmnd = rs.getString(6);
				String diaChi = rs.getString(7);
				String email = rs.getString(8);
				String sdt = rs.getString(9);
				KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, ngaySinh, ngayDK, cmnd, diaChi, email, sdt);
				qlkh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qlkh;
	}

	public String tuDongLayMa() {
		String maKH = "";
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "declare @ma char(5),@max int\r\n"
					+ "set @ma = RIGHT((select MAX(IDKhachHang) from KhachHang),3)\r\n"
					+ "set @max = CAST(@ma as int) + 1\r\n" + "set @ma = 'KH' + cast(@max as char(3))\r\n"
					+ "select @ma";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString(1);
				maKH = ma;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maKH;
	}
}
