import java.util.*;
public class Phone extends Product implements Operation{

    private int camera;
    private int batteryCapacity;
    private String color;
    static ArrayList<Phone> phones = new ArrayList<>();

    public Phone(int id, String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, String memory, int camera, int batteryCapacity, String color) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
        this.camera = camera;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }

    public Phone() {

    }

    static {
        phones.add(new Phone(100,"S1",1000,50,100,"Samsung","300",40,"120",10,200,"yellow"));
        phones.add(new Phone(120,"C1",13000,20,100,"Apple","300",30,"1220",10,100,"black"));
    }

    @Override
    public void runMenu() {
        Phone adPhone = new Phone();

        Scanner inp = new Scanner(System.in);

        System.out.println("Telefon Yönetim Paneli");
        System.out.println("1 - Telefon Ekleme");
        System.out.println("2 - Telefon Silme");
        System.out.println("3 - Id ye göre filtrele");
        System.out.println("4 - Markaya göre filtrele");
        System.out.println("4 - Telefon listele");
        System.out.println("0 - Çıkış Yap");
        System.out.println();
        System.out.print("Tercihiniz: ");
        System.out.println();

        int n = inp.nextInt();

        switch (n) {
            case 1:
                adPhone.addProduct();
                break;
            case 2:
                adPhone.deleteProduct();
                break;
            case 3:
                adPhone.filterByProductId();
                break;
            case 4:
                adPhone.filterByProductBrand();
                break;
            case 5:
                adPhone.showProductList();
                break;
            case 0:
                System.out.println("Çıkış Yapılıyor");
            default:
                System.out.println("Hata");
        }
    }

    @Override
    public void showProductList() {
        for (Phone ph : phones) {
            System.out.println(ph.getId()+ph.getName()+ph.getPrice()+ph.getDiscountRate()+ph.getStock()+ph.getBrandName()+ph.getScreenSize()+ph.getRam()+ph.getMemory()+ph.getCamera()+ph.getBatteryCapacity()+ph.getColor());
        }
    }

    @Override
    public void addProduct() {

        Scanner inp = new Scanner(System.in);

        System.out.println("ID giriniz:");
        int newID = inp.nextInt();
        inp.nextLine();

        System.out.println("İsim giriniz:");
        String newName = inp.nextLine();

        System.out.println("Fiyat giriniz:");
        double newPrice = inp.nextDouble();

        System.out.println("İndirim giriniz:");
        double newDisc = inp.nextDouble();

        System.out.println("Stok giriniz:");
        int newStock = inp.nextInt();
        inp.nextLine();

        System.out.println("Marka giriniz:");
        String newBrand = inp.nextLine();

        System.out.println("Ekran boyu giriniz:");
        String newSize = inp.nextLine();

        System.out.println("Ram giriniz:");
        int newRam = inp.nextInt();
        inp.nextLine();

        System.out.println("Hafıza boyu giriniz:");
        String newMemory = inp.nextLine();

        phones.add(new Phone(newID, newName, newPrice, newDisc,newStock, newBrand, newSize, newRam, newMemory));
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

        for (Phone ph : phones) {
            if (ph.getId() == filterId) {
                System.out.println(ph.getId()+ph.getName()+ph.getPrice()+ph.getDiscountRate()+ph.getStock()+ph.getBrandName()+ph.getScreenSize()+ph.getRam()+ph.getMemory()+ph.getCamera()+ph.getBatteryCapacity()+ph.getColor());
            }
        }
    }

    @Override
    public void filterByProductBrand() {

        Scanner inp = new Scanner(System.in);
        System.out.println("Filtrelenecek ürün Adı:");
        String filterBr = inp.nextLine();

        for (Phone ph : phones) {
            if (ph.getBrandName().equalsIgnoreCase(filterBr)) {
                System.out.println(ph.getId()+ph.getName()+ph.getPrice()+ph.getDiscountRate()+ph.getStock()+ph.getBrandName()+ph.getScreenSize()+ph.getRam()+ph.getMemory()+ph.getCamera()+ph.getBatteryCapacity()+ph.getColor());
            }
        }
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
