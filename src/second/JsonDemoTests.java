package second;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonDemoTests {
    public static void main(String[] args) throws IOException {

        String inputFile = "E:\\Module9\\HW10\\file1.txt";
        String outputFile = "E:\\Module9\\HW10\\user.json";

        List<User> userList = new ArrayList<>();
        String[] line;
        String st;

        int i = 0;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {

            while ((st = bufferedReader.readLine()) != null) {
                if(i >= 1) {
                    line = st.trim().split(" ");
                    String name = line[0];
                    int age = Integer.parseInt(line[1]);
                    userList.add(new User(name, age));
                }
                i++;
            }

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String result = gson.toJson(userList);
        System.out.println(result);


        try (FileWriter fileWriter = new FileWriter(outputFile)){
            fileWriter.write(result);
            fileWriter.flush();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }


    }
}
