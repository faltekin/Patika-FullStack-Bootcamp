import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Scanner inp = new Scanner(System.in);

        int length;
        System.out.print("Dizinin boyutu n : ");
        length = inp.nextInt();
        System.out.println("Dizinin elemanlarını giriniz : ");


        for (int i=1;i<=length;i++){

            System.out.print(i+". Elemanı : ");
            list.add(inp.nextInt());                // Döngüde devam ederken listeye eleman ekleriz
        }

        Collections.sort(list);
        System.out.println("Sıralama : " + list);


    }
}