

public class Main {


    public static void transpose(int[][] arr){

        int[][] newArray = new int[arr[0].length][arr.length];  // i ve j yer değiştirdi

        for (int i=0;i< arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                newArray[j][i] = arr[i][j];
            }
        }

        for (int[] ary : newArray) {
            for (int j = 0; j < newArray[0].length; j++) {
                System.out.print(ary[j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] array = {
                {2, 3, 4},
                {5, 6, 4}
        };

        System.out.print("Matris : ");
        for (int i=0;i<array.length;i++){
            System.out.println();
            for (int j=0;j<array[i].length;j++){
                    System.out.print(array[i][j]+" ");
            }
        }

        System.out.print("\nTranspoze :\n");
        transpose(array);


    }
}