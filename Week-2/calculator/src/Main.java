import java.util.Scanner;

public class Main {

    static int plus(int a,int b){

        int result = a+b;
        System.out.println("Toplam : "+result);
        return  result;
    }
    static int minus(int a,int b){

        int result = a-b;
        System.out.println("Çıkarma : "+result);
        return  result;
    }
    static int times(int a,int b){

        int result = a*b;
        System.out.println("Çarpma : "+result);
        return  result;
    }
    static int divided(int a,int b){

        int result = a/b;
        System.out.println("Bölme : "+result);
        return  result;
    }
    static int power(int a,int b){

        int result = 1;

        for (int i=1;i<=b;i++){
            result *= a;
        }
        return result;
    }
    static int mod(int a,int b){
        return a % b;
    }
    static void calc(int a,int b){

        System.out.println("Çevresi : "+(2*(a+b)));
        System.out.println("Alanı : "+(a*b));

    }


    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        int select;

        String menu = "1- Toplama İşlemi\n"
                + "2- Çıkarma İşlemi\n"
                + "3- Çarpma İşlemi\n"
                + "4- Bölme işlemi\n"
                + "5- Üslü Sayı Hesaplama\n"
                + "6- Mod Alma\n"
                + "7- Dikdörtgen Alan ve Çevre Hesabı\n";

        System.out.println(menu);

        while (true){

            System.out.println("Lütfen bir işlem seçiniz:");
            select = inp.nextInt();

            if (select==0){
                break;
            }

            System.out.print("1. sayıyı giriniz: ");
            int num1 = inp.nextInt();
            System.out.print("2. sayıyı giriniz: ");
            int num2 = inp.nextInt();


            switch (select){

                case 1:
                    plus(num1,num2);
                    break;
                case 2:
                    minus(num1,num2);
                    break;
                case 3:
                    times(num1,num2);
                    break;
                case 4:
                    divided(num1,num2);
                    break;
                case 5:
                    System.out.println("Üs Hesabı : "+power(num1,num2));
                    break;
                case 6:
                    System.out.println("Mod İşlemi : "+mod(num1,num2));
                    break;
                case 7:
                    calc(num1,num2);
                    break;
                default:
                    System.out.println("Yanlış bir değer girdiniz, tekrar deneyiniz.");

            }

        }

    }
}