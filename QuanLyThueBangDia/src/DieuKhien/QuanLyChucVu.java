package DieuKhien;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.Database;
import DoiTuong.ChucVu;

public class QuanLyChucVu {
	private ArrayList<ChucVu> dscv;
	
	public QuanLyChucVu() {
		dscv=new ArrayList<ChucVu>();
	}
	public ArrayList<ChucVu> docTubang(){
		try {
			Connection ketnoi=Database.getConnection();
			String sqlChucVu="Select * from ChucVu";
			Statement statement=ketnoi.createStatement();
			ResultSet rs=statement.executeQuery(sqlChucVu);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				ChucVu cv=new ChucVu(ma, ten);
				dscv.add(cv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscv;
	}

	public boolean themchucVu(String maChucVu, String tenChucVu) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into ChucVu Values(?,?)");
			stmt.setString(1, maChucVu);
			stmt.setString(2, tenChucVu);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public boolean capNhatCV(String maChucVu, String tenChucVu) {
		Connection con = Database.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update ChucVu set ChucVu = ? where IDChucVu like ?");
			stmt.setString(1, tenChucVu);
			stmt.setString(2, maChucVu);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public String tuDongLayMa() {
		String maCV = "";
		try {
			Connection con = Database.getInstance().getConnection();
			String sql = "declare @ma char(5),@max int\r\n"
					+ "set @ma = RIGHT((select MAX(IDChucVu) from ChucVu),3)\r\n"
					+ "set @max = CAST(@ma as int) + 1\r\n" + "set @ma = 'CV' + cast(@max as char(3))\r\n"
					+ "select @ma";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maChucVu = rs.getString(1);
				maCV = maChucVu;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return maCV;
	}
	

}
