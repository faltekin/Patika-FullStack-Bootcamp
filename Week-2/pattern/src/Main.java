

public class Main {


    public static int pattern(int a,int b,boolean isDecreasing){

        if (a>0 && isDecreasing){

            System.out.println(a+" ");
            return pattern(a-5,b,true);

        } else
        {
            if (a<=b){
                System.out.print(a+" ");
                return pattern(a+5,b,false);
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        pattern(10,10,true);
    }
}