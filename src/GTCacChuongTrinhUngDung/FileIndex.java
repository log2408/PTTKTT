package GTCacChuongTrinhUngDung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileIndex { 

    private FileIndex() { }

    public static void main(String[] args) {
        ST<String, SET<File>> st = new ST<String, SET<File>>();
        System.out.println("Indexing files");
        String[] name = new String[4];
		name[0] = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\GTCacChuongTrinhUngDung\\ex1.txt";
		name[1] = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\GTCacChuongTrinhUngDung\\ex2.txt";
		name[2] = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\GTCacChuongTrinhUngDung\\ex3.txt";
		name[3] = "\\Users\\User\\Desktop\\Javapro\\PhanTichThietKeThuatToan\\src\\GTCacChuongTrinhUngDung\\ex4.txt";
        for (String filename : name) {
            System.out.println("  " + filename);
            File file = new File(filename);
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        if (!st.contains(word)) st.put(word, new SET<File>());
                        SET<File> set = st.get(word);
                        set.add(file);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String query = "age";
        System.out.println(query);
        if (st.contains(query)) {
            SET<File> set = st.get(query);
            for (File file : set) {
                System.out.println("  " + file.getName());
            }
        }
    }
}

