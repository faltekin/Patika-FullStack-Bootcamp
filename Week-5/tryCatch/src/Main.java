import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int num;


        Scanner inp = new Scanner(System.in);
        System.out.println("İndeks giriniz : ");
        num = inp.nextInt();

        try {
            printIndexNum(arr,num);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public static void printIndexNum (int[] arr,int index){
        try {
            if (index < 0 || index >= arr.length){
                throw new ArrayIndexOutOfBoundsException("Geçersiz");
            } else {
                System.out.println("Doğru");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            throw e;
        }
    }
}