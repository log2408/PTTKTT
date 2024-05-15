package InDanhSachTheoTruyVan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class DSLop {
	private ST<String, SET<SinhVien>> st;
	private ArrayList<SinhVien> arr;
	private MaxPQ<SinhVien> pq;
	public DSLop(String nameFile, double diem) throws IOException{
		arr = new ArrayList<SinhVien>();
		pq = new MaxPQ<SinhVien>();
		st = new ST<String, SET<SinhVien>>();
		BufferedReader br = new BufferedReader(new FileReader(nameFile));
		String line = br.readLine();
		while((line = br.readLine()) != null) {
			String[] data = line.split("\\s{2,}");
            int maSV = Integer.parseInt(data[0]);
            String name = data[1];
            String diachi = data[2];
            Date date = new Date(data[3]);
            double tbc = Double.parseDouble(data[4]);
            SinhVien sv = new SinhVien(maSV, name, diachi, date, tbc);
            if(!st.contains(diachi)) {
            	st.put(diachi, new SET<SinhVien>());
            } 
            SET<SinhVien> set = st.get(diachi);
            check(sv, diem);
            set.add(sv);
            arr.add(sv);
		}
	}
	public void InDanhSachDonHuong(String query) {
		if(!st.contains(query)) {
			System.out.println("Không tìm thấy");
		} else {
			for(SinhVien s : st.get(query)) {
				System.out.println(s.toString());
			}
		}
	}
	private void check(SinhVien sv, double diem) {
		if(sv.getTbc() >= diem) {
			pq.insert(sv);
		}
	}
	public void InDanhSachSinhVien() {
		while(!pq.isEmpty()) {
			System.out.println(pq.delMax());
		}
	}
	public static void main(String[] args) throws IOException {
		String csvFilePath = "src/TopMSinhVien/test.csv";
		DSLop ds = new DSLop(csvFilePath, 4);
		ds.InDanhSachDonHuong("");
		System.out.println();
		ds.InDanhSachSinhVien();
	}
}
