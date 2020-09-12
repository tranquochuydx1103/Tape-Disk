package DoiTuong;

import java.sql.Date;

public class HoaDon {
	private String maHoaDon, tenKhachHang, tenNhanVien;
	private Date ngayLapHoaDon, ngayTra;

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
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
		HoaDon other = (HoaDon) obj;
		if (maHoaDon == null) {
			if (other.maHoaDon != null)
				return false;
		} else if (!maHoaDon.equals(other.maHoaDon))
			return false;
		return true;
	}

	public HoaDon(String maHoaDon, String tenKhachHang, String tenNhanVien, Date ngayLapHoaDon, Date ngayTra) {
		super();
		this.maHoaDon = maHoaDon;
		this.tenKhachHang = tenKhachHang;
		this.tenNhanVien = tenNhanVien;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.ngayTra = ngayTra;
	}

	public HoaDon(String maHoaDon, String tenKhachHang, String tenNhanVien, Date ngayLapHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
		this.tenKhachHang = tenKhachHang;
		this.tenNhanVien = tenNhanVien;
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
}
