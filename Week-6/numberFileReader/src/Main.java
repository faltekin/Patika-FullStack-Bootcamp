import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            FileReader file = new FileReader("src/numbers.txt");
            BufferedReader input = new BufferedReader(file);
            String line;
            int sum = 0;

            while ((line = input.readLine()) != null) {

                try {
                    int num = Integer.parseInt(line.trim());
                    sum = sum + num;
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Toplam: " + sum);
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
