package GTCacChuongTrinhUngDung;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BlackFilter {
	private BlackFilter() { }
	public static void main(String[] args) throws IOException {
		String name = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\GTCacChuongTrinhUngDung\\tale.txt";
		BufferedReader br = new BufferedReader(new FileReader(name));
		SET<String> set = new SET<String>();
		String line = br.readLine();
		while(line != null) {
			String[] w = line.split("\\s+");
			for(int i = 0; i < w.length; i++) {
				set.add(w[i]);
			}
			line = br.readLine();
		}
		String name2 = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\GTCacChuongTrinhUngDung\\tale.txt";
		br = new BufferedReader(new FileReader(name2));
		line = br.readLine();
		while(line != null) {
			String[] w = line.split("\\s+");
			for(int i = 0; i < w.length; i++) {
				if(!set.contains(w[i])) {
					System.out.println(w[i]);
				}
			}
			line = br.readLine();
		}
	}
}
