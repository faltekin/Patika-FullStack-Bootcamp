import java.util.Scanner;

public class PatikaStore {

    Scanner scanner = new Scanner(System.in);
    boolean isRunning = true;


    public void run(){

        while (isRunning){

            System.out.println("PatikaStore Ürün Yönetim Paneli");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Markaları Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.println();
            System.out.print("Tercihiniz: ");
            System.out.println();

            int selection = scanner.nextInt();

            switch (selection) {

                case 0:
                    System.out.println("Çıkış Yapıldı");
                    isRunning = false;
                    break;
                case 1:
                    Notebook notebook=new Notebook();
                    notebook.runMenu();
                    break;
                case 2:
                    Phone phone = new Phone();
                    phone.runMenu();
                    break;
                case 3:
                    Brand brand = new Brand();
                    brand.printBrand();
                    break;
                default:
                    System.out.println("Hatalı Değer");
            }

        }
    }

}
