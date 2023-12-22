import java.util.Arrays;

public class Main {

    static boolean isFind(int[] arr,int value){

        for (int i: arr){
            if (i == value){
                return true;
            }
        }
        return  false;
    }

    static  void isEven(int[] arr){
        for (int i: arr){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }


    public static void main(String[] args) {

        int[] list = {3,7,3,3,2,8,10,21,1,33,8,1,4,4,6,6,2};
        int[] duplicate = new int[list.length];
        int startIndex = 0;

        for (int i=0;i<list.length;i++){                                            // Bütün listeyi dolaşmak için

            for (int j=0;j< list.length;j++){

                if ((i != j) && (list[i] == list[j])){                              // ( i != j) dememizim sebebi iki tane aynı indexi karşılaştırmamak

                    if (!isFind(duplicate,list[i])){                                // !isFind() içinde tekrarlayan sayı yoksa if içine girer

                        duplicate[startIndex++]  = list[i];                         // startIndex önce 0 değerini verir sonra bir artar
                    }
                    break;
                }
            }
        }
        isEven(duplicate);

    }
}