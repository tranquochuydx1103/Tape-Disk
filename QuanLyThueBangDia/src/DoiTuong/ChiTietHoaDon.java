package DoiTuong;

public class ChiTietHoaDon {
	private String maBangDia, tenBangDia;
	private int soLuong;

	public String getMaBangDia() {
		return maBangDia;
	}

	public String getTenBangDia() {
		return tenBangDia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public ChiTietHoaDon(String maBangDia, String tenBangDia, int soLuong) {
		super();
		this.maBangDia = maBangDia;
		this.tenBangDia = tenBangDia;
		this.soLuong = soLuong;
	}

}
