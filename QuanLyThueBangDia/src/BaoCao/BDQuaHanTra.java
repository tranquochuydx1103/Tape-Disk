package BaoCao;

public class BDQuaHanTra {
	private String maBD, tenBD;
	private int soLuong;

	public BDQuaHanTra(String maBD, String tenBD, int soLuong) {
		super();
		this.maBD = maBD;
		this.tenBD = tenBD;
		this.soLuong = soLuong;
	}

	public String getMaBD() {
		return maBD;
	}

	public void setMaBD(String maBD) {
		this.maBD = maBD;
	}

	public String getTenBD() {
		return tenBD;
	}

	public void setTenBD(String tenBD) {
		this.tenBD = tenBD;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "BDQuaHanTra [maBD=" + maBD + ", tenBD=" + tenBD + ", soLuong=" + soLuong + "]";
	}

}
