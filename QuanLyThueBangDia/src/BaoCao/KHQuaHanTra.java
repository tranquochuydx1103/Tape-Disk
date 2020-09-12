package BaoCao;

import java.util.Date;

public class KHQuaHanTra {
	private String maKH,tenKH,SDT;
	private Date ngayThue;
	private int ngayDaThue,soNgayTre;
	public KHQuaHanTra(String maKH, String tenKH, String sDT, Date ngayThue, int ngayDaThue, int soNgayTre) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		SDT = sDT;
		this.ngayThue = ngayThue;
		this.ngayDaThue = ngayDaThue;
		this.soNgayTre = soNgayTre;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public Date getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(Date ngayThue) {
		this.ngayThue = ngayThue;
	}
	public int getNgayDaThue() {
		return ngayDaThue;
	}
	public void setNgayDaThue(int ngayDaThue) {
		this.ngayDaThue = ngayDaThue;
	}
	public int getSoNgayTre() {
		return soNgayTre;
	}
	public void setSoNgayTre(int soNgayTre) {
		this.soNgayTre = soNgayTre;
	}
	@Override
	public String toString() {
		return "KHQuaHanTra [maKH=" + maKH + ", tenKH=" + tenKH + ", SDT=" + SDT + ", ngayThue=" + ngayThue
				+ ", ngayDaThue=" + ngayDaThue + ", soNgayTre=" + soNgayTre + "]";
	}
	
}
