package sinhvien;

public class SinhVien {
	private String name;
	private ST<Mon, Integer> st;
	public SinhVien(String name) {
		this.name = name;
		this.st = new ST<Mon, Integer>();
	}
	public void NhapdiemmonSV(Mon m, Integer diem) {
		if(!st.contains(m)) st.put(m, diem);
		else {
			st.delete(m);
			st.put(m, diem);
		}
	}
	public void output() {
		boolean check = false;
		System.out.println("Kết quả của sinh viên " + this.name);
		for(Mon m : st) {
			check = true;
			System.out.print(m.toString() + ": " + st.get(m));
			System.out.println();
		}
		System.out.println();
		if(!check) {
			System.out.println("Chưa có kết quả");
		}
	}
	public void TBCHocKy(Integer hocky) {
		int sum = 0, cnt = 0;
		for(Mon m : st) {
			if(m.getHocKy() == hocky) {
				sum += st.get(m);
				cnt++;
			}
		}
		if(cnt == 0) {
			System.out.println("Chưa có kết quả của học kì này");
		} else {
			System.out.println(sum*1.0/cnt);
		}
	}
	public void TBC() {
		int sum = 0, cnt = 0;
		for(Mon m : st) {
			sum += st.get(m);
			cnt++;
		}
		if(cnt == 0) {
			System.out.println("Chưa có kết quả");
		} else {
			System.out.println(sum*1.0/cnt);
		}
	}
	public static void main(String[] args) {
		SinhVien sv = new SinhVien("A");
		sv.NhapdiemmonSV(new Mon("toan", 1), 5);
		sv.NhapdiemmonSV(new Mon("van", 1), 6);
		sv.NhapdiemmonSV(new Mon("anh", 1), 2);
		sv.NhapdiemmonSV(new Mon("toan", 2), 8);
		sv.NhapdiemmonSV(new Mon("li", 2), 9);
		sv.NhapdiemmonSV(new Mon("hoa", 2), 10);
		sv.output();
		System.out.print("Điểm trung bình cộng của cả năm: ");
		sv.TBC();
		System.out.println();
		System.out.print("Điểm trung bình cộng của học kì 2: ");
		sv.TBCHocKy(2);
	}
}
