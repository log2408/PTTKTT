package GTCacChuongTrinhUngDung;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LookupIndex {
	private LookupIndex() { }
	public static void main(String[] args) throws IOException {
		String name = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\GTCacChuongTrinhUngDung\\amino.csv";
		BufferedReader br = new BufferedReader(new FileReader(name));
		String separator = ",";
		ST<String, Queue<String>> st = new ST<String, Queue<String>>();
        ST<String, Queue<String>> ts = new ST<String, Queue<String>>();
        String line = br.readLine();
        while(line != null) {
        	String[] fields = line.split(separator);
            String key = fields[0];
            if (!st.contains(key)) st.put(key, new Queue<String>());
            for(int i = 1; i < fields.length; i++) {
            	String val = fields[i];
                if (!ts.contains(val)) ts.put(val, new Queue<String>());
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
            line = br.readLine();
        }
        String query = "Serine";
        System.out.println(query);
        if(ts.contains(query)) {
        	for(String t : ts.get(query)) {
        		System.out.println(t);
        	}
        }
	}
}
