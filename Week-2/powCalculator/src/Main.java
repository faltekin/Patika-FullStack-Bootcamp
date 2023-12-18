import java.util.Scanner;

public class Main {

    static int power(int a,int b){

        if ((b != 0)){                      // Üs değer 0 girilirse döngüye sokulmadan 1 döner
            return  a * power(a,b-1);    // Döngüde b değeri bir azalarak kendisini tekrardan döndürür
        } else return 1;

    }


    public static void main(String[] args) {

        int base,power;

        Scanner inp = new Scanner(System.in);
        System.out.println("Taban değeri giriniz :");
        base = inp.nextInt();
        System.out.println("Üs değerini giriniz :");
        power = inp.nextInt();

        System.out.println("Sonuç : "+power(base,power));


    }
}