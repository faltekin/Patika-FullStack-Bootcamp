import java.util.Arrays;

public class Main {

    static boolean duplicate(int[] list,int length){

        boolean[] isFind = new boolean[length];

        for (int i=0;i<length;i++){

            int counter=0;

            if (isFind[i] == true){
                continue;
            }

            for (int j=0;j<length;j++){         // Bütün liste döngüye sokulur

                if (list[i] == list[j]){
                    isFind[j] = true;
                    counter++;
                }
            }
            if (counter >=1){
                System.out.println(list[i] + " sayısı " + counter+" kere tekrar edildi. ");
            }
        }
        return false;
    }


    public static void main(String[] args) {

        int[] list = {10, 20, 20, 10, 10, 20, 5, 20};
        int length = list.length;

        System.out.println("Tekrar Sayıları :");
        duplicate(list,length);



    }
}