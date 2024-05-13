package Inversion;

public class SinhVien implements Comparable<SinhVien>{
	private String ten, ho, dem;
	public SinhVien(String ho, String dem, String ten) {
		super();
		this.ten = ten;
		this.ho = ho;
		this.dem = dem;
	}
	@Override
	public int compareTo(SinhVien o) {
		int ssTen = this.ten.compareTo(o.ten);
		int ssDem = this.dem.compareTo(o.dem);
		int ssHo = this.ho.compareTo(o.ho);
		if(ssTen != 0) return ssTen;
		if(ssDem != 0) return ssDem;
		return ssHo;
	}
	@Override
	public String toString() {
		return this.ho + " " + this.dem + " " + this.ten;
	}
}
