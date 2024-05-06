package GTCacChuongTrinhUngDung;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FrequencyCounter {
	private FrequencyCounter() { }
	public static void main(String[] args) throws IOException {
		String name = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\GTCacChuongTrinhUngDung\\tale.txt";
		BufferedReader br = new BufferedReader(new FileReader(name));
		int distinct = 0, words = 0;
        int minlen = 8;
        ST<String, Integer> st = new ST<String, Integer>();
        String line = br.readLine();
        while(line != null) {
        	String[] word = line.split("\\s+");
        	for(int i = 0; i < word.length; i++) {
        		if(word[i].length() < minlen) continue;
        		words++;
        		if (st.contains(word[i])) {
                    st.put(word[i], st.get(word[i]) + 1);
                } else {
                    st.put(word[i], 1);
                    distinct++;
                }
        	}
        	line = br.readLine();
        }
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }
        System.out.println(max + " " + st.get(max));
        System.out.println("distinct = " + distinct);
        System.out.println("words    = " + words);
	}
}
