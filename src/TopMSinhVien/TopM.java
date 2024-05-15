package TopMSinhVien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class TopM {
	private MinPQ<SinhVien> pq;
	public TopM() {}
	private void TopM(String nameFile, int n) throws IOException {
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
            pq.insert(sv);
            if(pq.size() > n) {
            	pq.delMin();
            }
		}
	}
	public void TopMAge(String nameFile, int n) {
		pq = new MinPQ<SinhVien>(SinhVien.Comparators.AGE_COMPARATOR);
		try {
			TopM(nameFile, n);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < n; i++) {
			System.out.println(pq.delMin());
		}
	}
	public void TopMName(String nameFile, int n) {
		pq = new MinPQ<SinhVien>(SinhVien.Comparators.NAME_COMPARATOR);
		try {
			TopM(nameFile, n);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < n; i++) {
			System.out.println(pq.delMin());
		}
	}
	public void TopMTBC(String nameFile, int n) {
		pq = new MinPQ<SinhVien>(SinhVien.Comparators.TBC_COMPARATOR);
		try {
			TopM(nameFile, n);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < n; i++) {
			System.out.println(pq.delMin());
		}
	}
	public static void main(String[] args) {
		String csvFilePath = "src/TopMSinhVien/test.csv";
		TopM t = new TopM();
		t.TopMTBC(csvFilePath, 4);
	}
}
