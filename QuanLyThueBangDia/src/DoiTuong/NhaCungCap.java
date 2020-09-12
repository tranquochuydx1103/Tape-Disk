package DoiTuong;

public class NhaCungCap {
	private String maNCC, tenNCC, quocGia, soDienThoai, Email;

	public NhaCungCap(String maNCC, String tenNCC, String quocGia, String soDienThoai, String email) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.quocGia = quocGia;
		this.soDienThoai = soDienThoai;
		Email = email;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNCC == null) ? 0 : maNCC.hashCode());
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
		NhaCungCap other = (NhaCungCap) obj;
		if (maNCC == null) {
			if (other.maNCC != null)
				return false;
		} else if (!maNCC.equals(other.maNCC))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", quocGia=" + quocGia + ", soDienThoai="
				+ soDienThoai + ", Email=" + Email + "]";
	}

}
