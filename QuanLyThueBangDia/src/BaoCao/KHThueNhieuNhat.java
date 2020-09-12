package BaoCao;

public class KHThueNhieuNhat {
	private String maKh, tenKH, sdt;
	private int soLuong;

	public KHThueNhieuNhat(String maKh, String tenKH, String sdt, int soLuong) {
		super();
		this.maKh = maKh;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.soLuong = soLuong;
	}

	public String getMaKh() {
		return maKh;
	}

	public void setMaKh(String maKh) {
		this.maKh = maKh;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "KHThueNhieuNhat [maKh=" + maKh + ", tenKH=" + tenKH + ", sdt=" + sdt + ", soLuong=" + soLuong + "]";
	}

}
