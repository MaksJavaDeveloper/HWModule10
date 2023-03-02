package third;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CountReplayTests {
    public static void main(String[] args) {
        CountReplayTests count = new CountReplayTests();
        String str = count.readFile( "E:\\Module9\\HW10\\src\\third\\words.txt");

        count.countReplayWord(str);



    }

    public String readFile(String file) {
        try(InputStream inputStream = new FileInputStream(file)) {

            StringBuilder res = new StringBuilder();
            byte[] buf = new byte[inputStream.available()];
            inputStream.read(buf);
            for(int i = 0; i < buf.length; i++) {
                res.append((char) buf[i]);
            }

          return res.toString();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return "";
    }

    public void countReplayWord(String text) {
        String[] word = text.split("\\s+");

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < word.length; i++) {
            if(!res.toString().contains(word[i])) {
                res.append(word[i]).append(" ");
            }
        }

        String[] uniq = res.toString().split("\\s+");

        String[][] resul = new String[uniq.length][2];
        for (int j = 0; j < uniq.length; j++) {
            int count = 0;
            for (int g = 0; g < word.length; g++) {
                if (uniq[j].equals(word[g])) {
                    count++;
                }
            }
            resul[j][1] = String.valueOf(count);
            resul[j][0] = uniq[j];

        }

        for (int i = resul.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Integer.parseInt(resul[j][1]) < Integer.parseInt(resul[j + 1][1])) {
                    String[] tmp = resul[j];
                    resul[j] = resul[j + 1];
                    resul[j + 1] = tmp;
                }
            }
        }

        for (String[] a : resul) {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}
