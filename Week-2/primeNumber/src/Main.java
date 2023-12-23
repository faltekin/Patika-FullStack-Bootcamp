import java.util.*;

public class Main {

    public static int prime(int num,int i){

        if (num == i){
            return 1;
        } else {
            if (num % i == 0){
                return 0;
            } else return prime(num,i+1);

        }

    }

    public static void main(String[] args) {

        int num;
        Scanner inp = new Scanner(System.in);
        System.out.print("Sayı Giriniz : ");
        num = inp.nextInt();
        int i=2;

        if (prime(num,i) == 1){
            System.out.print(num + " Sayısı asaldır !");
        } else {
            System.out.print(num + " Sayısı asal değildir !");
        }





    }




}