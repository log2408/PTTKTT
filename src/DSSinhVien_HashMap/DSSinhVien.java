package DSSinhVien_HashMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class DSSinhVien {
	ArrayList<SinhVien> danhSachSinhVien;
	public DSSinhVien(String nameFile) {
		danhSachSinhVien = new ArrayList<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(nameFile));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] parts = line.split("\\s{2,}");
	            String name = parts[0];
	            Date date = new Date(parts[1]);
	            SinhVien sv = new SinhVien(name, date);
	            danhSachSinhVien.add(sv);
	        }
	        reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(danhSachSinhVien);
	}
	public void ganMaSV(String masv) {
		HashMap<SinhVien, String> hm = new HashMap<SinhVien, String>();
		int i = 0;
		for (SinhVien sinhVien : danhSachSinhVien) {
			hm.put(sinhVien, masv + (++i));
		}
		for (Entry<SinhVien, String> entry : hm.entrySet()) {
            SinhVien sv = entry.getKey();
            String ma = entry.getValue();
            System.out.println("Tên: " + sv.getHoTen() + ", Ngày sinh: " + sv.getNgaySinh() + ", Mã SV: " + ma);
        }
	}
	public static void main(String[] args) {
		DSSinhVien ds = new DSSinhVien("src/DSSinhVien_HashMap/test.csv");
		ds.ganMaSV("UTC");
	}
}
