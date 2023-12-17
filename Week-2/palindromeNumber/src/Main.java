import java.util.Scanner;

public class Main {

    static boolean isPalindrome(int number){

        int temp = number;                          // Karşılaştırmada kullanacağımız için number değerini  temp olarakcd..cd tutuyoruz
        int reverseNumber = 0, lastNumber;

        while (temp != 0){                          // Döngü temp sayısı 0 olana kadar devam eder

            lastNumber = temp % 10;                 // % 10 kullanarak son basamağa ulaşabiliriz
            reverseNumber = (reverseNumber * 10) + lastNumber;
            temp /= 10;                             // / kullanarak son basamağı çıkartmış oluyoruz

        }

        if (number == reverseNumber){
            return  true;
        } else return  false;

    }

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        System.out.println("Sayı giriniz:");
        int num = inp.nextInt();

        System.out.println(isPalindrome(num));

    }
}