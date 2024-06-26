package Inversion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		SinhVien[] sv;
		String nameFile = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\Inversion\\test.txt";
		BufferedReader br = new BufferedReader(new FileReader(nameFile));
		String line = br.readLine();
		sv = new SinhVien[Integer.parseInt(line.trim())];
		int i = 0;
		while((line = br.readLine()) != null) {
			String[] w = line.split("\\s+");
			String ho = w[0];
			String dem = w[1];
			String ten = w[2];
			sv[i++] = new SinhVien(ho, dem, ten);
		}
		System.out.println(inversion.count(sv));
	    inversion.sort(sv);
		for(SinhVien s : sv) {
			System.out.println(s.toString());
		}
	}
}
