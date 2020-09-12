package BaoCao;

public class BDDuocYeuThich {
	private String maBD, tenBD, theLoai, tenNCC;
	private int soLuotThue;

	public BDDuocYeuThich(String maBD, String tenBD, String theLoai, String tenNCC, int soLuotThue) {
		super();
		this.maBD = maBD;
		this.tenBD = tenBD;
		this.theLoai = theLoai;
		this.tenNCC = tenNCC;
		this.soLuotThue = soLuotThue;
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

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public int getSoLuotThue() {
		return soLuotThue;
	}

	public void setSoLuotThue(int soLuotThue) {
		this.soLuotThue = soLuotThue;
	}

	@Override
	public String toString() {
		return "BDDuovYeuThich [maBD=" + maBD + ", tenBD=" + tenBD + ", theLoai=" + theLoai + ", tenNCC=" + tenNCC
				+ ", soLuotThue=" + soLuotThue + "]";
	}

}
