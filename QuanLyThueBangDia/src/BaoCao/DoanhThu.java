package BaoCao;

import java.util.Date;

public class DoanhThu {
	private Date ngay;
	private int tongSoHD;
	private double tongTienThue;

	public DoanhThu(Date ngay, int tongSoHD, double tongTienThue) {
		super();
		this.ngay = ngay;
		this.tongSoHD = tongSoHD;
		this.tongTienThue = tongTienThue;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public int getTongSoHD() {
		return tongSoHD;
	}

	public void setTongSoHD(int tongSoHD) {
		this.tongSoHD = tongSoHD;
	}

	public double getTongTienThue() {
		return tongTienThue;
	}

	public void setTongTienThue(double tongTienThue) {
		this.tongTienThue = tongTienThue;
	}

	@Override
	public String toString() {
		return "DoanhThu [ngay=" + ngay + ", tongSoHD=" + tongSoHD + ", tongTienThue=" + tongTienThue + "]";
	}

}
