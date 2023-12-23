import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] list = {15, 12, 788, 1, -1, -778, 2, 0};

        int num;
        int min = list[0];
        int max = list[0];

        System.out.println(Arrays.toString(list));
        Scanner inp = new Scanner(System.in);
        System.out.println("Sayı giriniz: ");
        num = inp.nextInt();

        for (int i : list) {
            if (i < min) {
                min = i;        // Dizideki min değer
            }
            if (i > max) {
                max = i;        // Dizideki max değer
            }
        }

        for (int i : list) {

            if (i > num){       // Sayıdan büyüklüğü kontrol edilir
                if (i<max){
                    max = i;
                }
            }
            if (i < num){
                if (i>min){
                    min = i;
                }
            }
        }

        System.out.println("Girilen Sayı : " + num);
        System.out.println("Girilen sayıdan küçük en yakın sayı : " + min);
        System.out.println("Girilen sayıdan büyük en yakın sayı : " + max);


    }
}