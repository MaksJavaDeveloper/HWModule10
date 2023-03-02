package first;

import java.io.*;

public class FileReaderTests {
    public static void main(String[] args) throws IOException {


        File file = new File("file.txt");

        outputNumber(file);


        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line;

        String firstForm = "\\(?\\d{3}\\) ?\\d{3}-?\\d{4}";  //format (xxx) xxx-xxxx

        String secondForm = "\\d{3}-?\\d{3}-?\\d{4}";  //format xxx-xxx-xxxx

        while ((line = bufferedReader.readLine()) != null) {
            if (line.matches(firstForm) || line.matches(secondForm)) {
                System.out.println(line);
            }
        }


    }

    private static void outputNumber(File file) {
        try (OutputStream outputStream = new FileOutputStream(file)) {
            String numbers = "987-123-4567\n" +
                    "123 456 7890\n" +
                    "(123) 456-7890";

            outputStream.write(numbers.getBytes());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
