import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {

            FileReader file = new FileReader("src/note.txt");
            BufferedReader input = new BufferedReader(file);
            String line;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();

            Scanner inp = new Scanner(System.in);
            System.out.print("Bir metin girin: ");
            String notes = inp.nextLine();

            FileWriter fileWriter = new FileWriter("src/note.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(notes);

            printWriter.close();

            BufferedReader buffReader = new BufferedReader(new FileReader("src/note.txt"));
            String noteRead = buffReader.readLine();

            System.out.println("Not : " + noteRead);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}