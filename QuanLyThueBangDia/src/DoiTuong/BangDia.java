package DoiTuong;

public class BangDia {
	private String maBangDia, tenBangDia, moTA, theLoai, nhaCungCap;
	private double giaThue;
	private int soLuong;

	public String getMaBangDia() {
		return maBangDia;
	}

	public String getTenBangDia() {
		return tenBangDia;
	}

	public void setTenBangDia(String tenBangDia) {
		this.tenBangDia = tenBangDia;
	}

	public String getMoTA() {
		return moTA;
	}

	public void setMoTA(String moTA) {
		this.moTA = moTA;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public double getGiaThue() {
		return giaThue;
	}

	public void setGiaThue(double giaThue) {
		this.giaThue = giaThue;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maBangDia == null) ? 0 : maBangDia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangDia other = (BangDia) obj;
		if (maBangDia == null) {
			if (other.maBangDia != null)
				return false;
		} else if (!maBangDia.equals(other.maBangDia))
			return false;
		return true;
	}

	public BangDia(String maBangDia, String tenBangDia, String moTA, String theLoai, String nhaCungCap, double giaThue,
			int soLuong) {
		super();
		this.maBangDia = maBangDia;
		this.tenBangDia = tenBangDia;
		this.moTA = moTA;
		this.theLoai = theLoai;
		this.nhaCungCap = nhaCungCap;
		this.giaThue = giaThue;
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "BangDia [maBangDia=" + maBangDia + ", tenBangDia=" + tenBangDia + ", moTA=" + moTA + ", theLoai="
				+ theLoai + ", nhaCungCap=" + nhaCungCap + ", giaThue=" + giaThue + ", soLuong=" + soLuong + "]";
	}

}
