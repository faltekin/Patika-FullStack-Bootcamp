import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product implements Operation {

    private static int id = 1;
    private static final ArrayList<Notebook> notebooklist = new ArrayList<>();

    public Notebook(int id, String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, String memory) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
    }

    public Notebook() {
    }

    static {
        notebooklist.add(new Notebook(1, "F1", 500, 50, 50, "Apple", "30", 40, "10"));
        notebooklist.add(new Notebook(2, "K1", 5000, 30, 50, "Samsung", "30", 40, "10"));
        notebooklist.add(new Notebook(3, "D1", 5200, 20, 50, "Asus", "30", 40, "10"));
    }


    @Override
    public void runMenu() {

        Notebook adNote = new Notebook();

        Scanner inp = new Scanner(System.in);

        System.out.println("Notebook Yönetim Paneli");
        System.out.println("1 - Notebook Ekleme");
        System.out.println("2 - Notebook Silme");
        System.out.println("3 - Id ye göre filtrele");
        System.out.println("4 - Markaya göre filtrele");
        System.out.println("4 - Notebook listele");
        System.out.println("0 - Çıkış Yap");
        System.out.println();
        System.out.print("Tercihiniz: ");
        System.out.println();

        int n = inp.nextInt();

        switch (n) {
            case 1:
                adNote.addProduct();
                break;
            case 2:
                adNote.deleteProduct();
                break;
            case 3:
                adNote.filterByProductId();
                break;
            case 4:
                adNote.filterByProductBrand();
                break;
            case 5:
                adNote.showProductList();
                break;
            case 0:
                System.out.println("Çıkış Yapılıyor");
            default:
                System.out.println("Hata");
        }


    }

    @Override
    public void showProductList() {
        for (Notebook nb : notebooklist) {
            System.out.println(nb.getId()+nb.getName()+nb.getPrice()+nb.getDiscountRate()+nb.getStock()+nb.getBrandName()+nb.getScreenSize()+nb.getRam()+nb.getMemory());
        }
    }

    @Override
    public void addProduct() {

        Scanner inp = new Scanner(System.in);

        System.out.println("ID giriniz:");
        int newID = inp.nextInt();

        System.out.println("İsim giriniz:");
        String newName = inp.nextLine();

        System.out.println("Fiyat giriniz:");
        double newPrice = inp.nextDouble();

        System.out.println("İndirim giriniz:");
        double newDisc = inp.nextDouble();

        System.out.println("Stok giriniz:");
        int newStock = inp.nextInt();

        System.out.println("Marka giriniz:");
        String newBrand = inp.nextLine();

        System.out.println("Ekran boyu giriniz:");
        String newSize = inp.nextLine();

        System.out.println("Ram giriniz:");
        int newRam = inp.nextInt();

        System.out.println("Hafıza boyu giriniz:");
        String newMemory = inp.nextLine();

        notebooklist.add(new Notebook(newID, newName, newPrice, newDisc,newStock, newBrand, newSize, newRam, newMemory));
    }

    @Override
    public void deleteProduct() {

        Scanner inp = new Scanner(System.in);
        System.out.println("Silinecek ürün ID:");
        int deleteId = inp.nextInt();


    }

    @Override
    public void filterByProductId() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Filtrelenecek ürün ID:");
        int  filterId = inp.nextInt();

        for (Notebook nb : notebooklist) {
            if (nb.getId() == filterId) {
                System.out.println(nb.getId()+nb.getName()+nb.getPrice()+nb.getDiscountRate()+nb.getStock()+nb.getBrandName()+nb.getScreenSize()+nb.getRam()+nb.getMemory());
            }
        }
    }

    @Override
    public void filterByProductBrand() {

        Scanner inp = new Scanner(System.in);
        System.out.println("Filtrelenecek ürün Adı:");
        String filterBr = inp.nextLine();

        for (Notebook nb : notebooklist) {
            if (nb.getBrandName().equalsIgnoreCase(filterBr)) {
                System.out.println(nb.getId()+nb.getName()+nb.getPrice()+nb.getDiscountRate()+nb.getStock()+nb.getBrandName()+nb.getScreenSize()+nb.getRam()+nb.getMemory());
            }
        }
    }
}
