package FileFrequencyIndex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileFrequencyindex {
	private ST<String, Integer> st;
	private String nameFile;
	public FileFrequencyindex(String name) throws IOException {
		this.nameFile = name;
		st = new ST<String, Integer>();
		BufferedReader br = new BufferedReader(new FileReader(this.nameFile));
		String line = br.readLine();
		while(line != null) {
			if(!line.isEmpty()) {
				String[] w = line.split("\\s+");
				for(String t : w) {
					if(!st.contains(t)) st.put(t, 1);
					else st.put(t, st.get(t) + 1);
				}
			}
			line = br.readLine();
		}
	}
	public int query(String word) {
		if(st.contains(word)) {
			return st.get(word);
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		String name = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\GTCacChuongTrinhUngDung\\tale.txt";
		FileFrequencyindex f = new FileFrequencyindex(name);
		System.out.println(f.query("business"));
	}
}
