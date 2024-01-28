package view;

import business.BookManager;
import business.BrandManager;
import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;

public class AdminView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scrl_brand;
    private JTable tbl_brand;
    private JPanel pnl_model;
    private JScrollPane scrl_model;
    private JTable tbl_model;
    private JButton btn_search_model;
    private JComboBox cmb_s_model_brand;
    private JComboBox cmb_s_model_type;
    private JComboBox cmb_s_model_fuel;
    private JComboBox cmb_s_model_gear;
    private JButton btn_cncl_model;
    private JPanel pnl_car;
    private JTable tbl_car;
    private JScrollPane scrl_car;
    private JPanel pnl_booking;
    private JScrollPane scrl_booking;
    private JFormattedTextField fld_strt_date;
    private JFormattedTextField fld_fnsh_date;
    private JComboBox cmb_booking_gear;
    private JComboBox cmb_booking_fuel;
    private JComboBox cmb_booking_type;
    private JButton btn_booking_search;
    private JTable tbl_booking;
    private JButton btn_cncl_booking;
    private JPanel pnl_books;
    private JScrollPane scrl_books;
    private JTable tbl_books;
    private JTextField fld_books;
    private JButton btn_books;
    private JComboBox cmb_books;
    private BrandManager brandManager;
    private ModelManager modelManager;
    private CarManager carManager;

    private BookManager bookManager;
    private JPopupMenu brand_menu;
    private JPopupMenu model_menu;
    private JPopupMenu car_menu;
    private JPopupMenu booking_menu;
    private JPopupMenu books_menu;

    private Object[] col_model;
    private Object[] col_car;
    private Object[] col_books;
    private User user;
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();
    private DefaultTableModel tmdl_car = new DefaultTableModel();
    private DefaultTableModel tmdl_booking = new DefaultTableModel();

    private DefaultTableModel tmdl_books = new DefaultTableModel();
    public AdminView(User user){
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.carManager = new CarManager();
        this.bookManager = new BookManager();
        this.add(container);
        this.guiInitilaze(1000,500);
        this.user = user;

        if (this.user == null){
            dispose();
        }
        this.lbl_welcome.setText("Hoşgeldiniz : "+this.user.getUsername());

        loadComponent();

        loadBrandTable();
        loadBrandComponent();

        loadModelTable(null);
        loadModelComponent();
        loadModelFilter();

        loadCarTable();
        loadCarComponent();

        loadBookingTable(null);
        loadBookingComponent();
        loadBookingFilter();

        loadBooksTable(null);
        loadBooksComponent();
        loadBooksFilter();

    }

    public void loadComponent(){
        this.btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginView loginView = new LoginView();
            }
        });
    }

    private void loadModelComponent() {
        tableRowSelect(this.tbl_model);

        this.model_menu = new JPopupMenu();
        this.model_menu.add("Yeni").addActionListener(e ->{
            ModelView modelView = new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });
        });
        this.model_menu.add("Güncelle").addActionListener(e ->{
            int selectModelId = this.getTableSelectedRow(tbl_model,0);
            ModelView modelView = new ModelView(this.modelManager.getById(selectModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                    loadBookingTable(null);
                }
            });
        });
        this.model_menu.add("Sil").addActionListener(e-> {
            if (Helper.confirm("sure")){
                int selectModelId = this.getTableSelectedRow(tbl_model,0);
                if (this.modelManager.delete(selectModelId)){
                    Helper.showMsg("done");
                    loadModelTable(null);
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_model.setComponentPopupMenu(model_menu);
        this.btn_search_model.addActionListener(e -> {
            ComboItem selectedBrand = (ComboItem) this.cmb_s_model_brand.getSelectedItem(); // Cast işlemi yapmamız gerekiyor
            int brandId = 0;
            if (selectedBrand != null){
                brandId = selectedBrand.getKey();
            }
            ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
                    brandId,
                    (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
                    (Model.Gear) cmb_s_model_gear.getSelectedItem(),
                    (Model.Type) cmb_s_model_type.getSelectedItem()
            );

            // ?????????????
            // Search ettiğimiz veriyi tabloya göre uyarladık
            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.col_model.length,modelListBySearch);
            loadModelTable(modelRowListBySearch);
        });
        this.btn_cncl_model.addActionListener(e -> {
            this.cmb_s_model_type.setSelectedItem(null);
            this.cmb_s_model_gear.setSelectedItem(null);
            this.cmb_s_model_fuel.setSelectedItem(null);
            this.cmb_s_model_brand.setSelectedItem(null);
            loadModelTable(null);
        });
    }

    public void loadModelTable(ArrayList<Object[]> modelList){
        this.col_model = new Object[]{"Model_ID","Marka","Model Adı","Tip","Yıl","Yakıt Türü","Vites"};
        if (modelList == null){
            modelList = this.modelManager.getForTable(this.col_model.length,this.modelManager.findAll()); // Tablonun içerisine gelecek değerler çekilir
        }
        createTable(this.tmdl_model,this.tbl_model,col_model,modelList);
    }
    public void loadModelFilter(){
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
        loadModelFilterBrand();
    }
    public void loadModelFilterBrand(){     // Yeni brand eklediğimizde filter tablosu güncellenmesi için
        this.cmb_s_model_brand.removeAllItems();
        for (Brand obj : brandManager.findAll()){
            this.cmb_s_model_brand.addItem(new ComboItem(obj.getId(),obj.getName()));
        }
        this.cmb_s_model_brand.setSelectedItem(null);
    }
    public void loadBrandComponent(){

        tableRowSelect(this.tbl_brand);
        this.brand_menu = new JPopupMenu();
        this.brand_menu.add("Yeni").addActionListener(e ->{
            BrandView brandView = new BrandView(null); // ekleme işlemi yaptığımız için null verdik
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);  // Update işleminde anlık olarak güncelliği sağlamak için
                    loadModelFilterBrand();
                }
            });
        });
        this.brand_menu.add("Güncelle").addActionListener(e ->{
            int selectBrandId = this.getTableSelectedRow(tbl_brand,0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                    loadCarTable();
                    loadBookingTable(null);
                }
            });
        });
        this.brand_menu.add("Sil").addActionListener(e-> {
            if (Helper.confirm("sure")){
                int selectBrandId = this.getTableSelectedRow(tbl_brand,0);
                if (this.brandManager.delete(selectBrandId)){
                    Helper.showMsg("done");
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                    loadCarTable();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_brand.setComponentPopupMenu(this.brand_menu);
    }

    public void loadBrandTable(){
        Object[] col_brand = {"Marka ID", "Marka Adı"};
        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length); // Tablonun içerisine gelecek değerler çekilir
        this.createTable(this.tmdl_brand,this.tbl_brand,col_brand,brandList); // Tablo oluşturulur
    }

    public void loadCarTable(){
        col_car = new Object[]{"ID","Marka","Model","Plaka","Renk","KM","Yıl","Tip","Yakıt Türü","Vites"};
        ArrayList<Object[]> carList = this.carManager.getForTable(col_car.length,this.carManager.findAll());
        createTable(this.tmdl_car,this.tbl_car,col_car,carList);
    }
    private void loadCarComponent(){
        tableRowSelect(this.tbl_car);
        this.car_menu = new JPopupMenu();
        this.car_menu.add("Yeni").addActionListener(e ->{
            CarView carView = new CarView(new Car()); //
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Güncelle").addActionListener(e ->{
            int selectModelId = this.getTableSelectedRow(tbl_car,0);
            CarView carView = new CarView(this.carManager.getById(selectModelId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                   loadCarTable();
                }
            });
        });
        this.car_menu.add("Sil").addActionListener(e-> {
            if (Helper.confirm("sure")){
                int selectCarId = this.getTableSelectedRow(tbl_car,0);
                if (this.carManager.delete(selectCarId)){
                    Helper.showMsg("done");
                    loadCarTable();
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_car.setComponentPopupMenu(car_menu);
    }

    private void loadBookingTable(ArrayList<Object[]> carList) {    // Yapacağımız filtrelemeye göre veri getireceği için carList değeri alıyor
        Object[] col_booking_list = {"ID", "Marka", "Model", "Plaka", "Renk", "KM", "Yıl", "Tip", "Yakıt Türü", "Vites"};
        createTable(this.tmdl_booking, this.tbl_booking, col_booking_list, carList);
    }
    private void loadBookingComponent(){
        tableRowSelect(this.tbl_booking);
        this.booking_menu = new JPopupMenu();
        this.booking_menu.add("Rezervasyon Yap").addActionListener(e -> {       // ***************

            int selectCarId = this.getTableSelectedRow(this.tbl_booking,0);

            BookingView bookingView = new BookingView(
                    this.carManager.getById(selectCarId),
                    this.fld_strt_date.getText(),
                    this.fld_fnsh_date.getText()
            );
            bookingView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBookingTable(null);
                    loadBookingFilter();
                }
            });
        });
        this.tbl_booking.setComponentPopupMenu(booking_menu);

        //this.tbl_brand.setComponentPopupMenu(this.brandMenu);
        btn_booking_search.addActionListener(e -> {
            ArrayList<Car> carList = this.carManager.searchForBooking(
                    fld_strt_date.getText(),
                    fld_fnsh_date.getText(),
                    (Model.Type) cmb_booking_type.getSelectedItem(),
                    (Model.Gear) cmb_booking_gear.getSelectedItem(),
                    (Model.Fuel) cmb_booking_fuel.getSelectedItem()
            );          // Filtrelenen arabaları alıp sonra tablolara obje şeklinde yollamamız gerekiyor

            // Tablo için objeye dönüştürülür
            ArrayList<Object[]> carBookingRow = this.carManager.getForTable(this.col_car.length,carList);
            loadBookingTable(carBookingRow);
        });
        btn_cncl_booking.addActionListener(e -> {
            loadBookingFilter();
        });
    }
    private void loadBookingFilter(){   // Modelden gelen veriler veriler comboboxların içerinise atılır ?
        this.cmb_booking_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_booking_type.setSelectedItem(null);
        this.cmb_booking_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_booking_gear.setSelectedItem(null);
        this.cmb_booking_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_booking_fuel.setSelectedItem(null);

    }
    private void createUIComponents() throws ParseException {
        this.fld_strt_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_strt_date.setText("27.01.2024");
        this.fld_fnsh_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_fnsh_date.setText("30.01.2024");
    }
    private void loadBooksTable(ArrayList<Object[]> booksList) {

        this.col_books = new Object[]{"ID", "İsim", "Telefon", "Mail", "Başlangıç Tarihi ", "Bitiş Tarihi", "Fiyat", "Plaka","Kimlik No",
                "Müşteri İsmi", "Araç Markası", "Araç Modeli"};
        if (booksList == null) {
            booksList = this.bookManager.getForTable(this.col_books.length, this.bookManager.findAll());
        }
        createTable(this.tmdl_books, this.tbl_books, col_books, booksList);
    }

    private void loadBooksComponent(){

        tableRowSelect(this.tbl_books);
        this.books_menu = new JPopupMenu();

        this.books_menu.add("İşlem").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectBookId = this.getTableSelectedRow(this.tbl_books, 0);
                if (this.bookManager.delete(selectBookId)) {
                    Helper.showMsg("done");
                    loadBooksTable(null);
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        this.tbl_books.setComponentPopupMenu(books_menu);

        btn_books.addActionListener(e -> {
            ComboItem selectedCar = (ComboItem) this.cmb_books.getSelectedItem();
            int carId = (selectedCar != null) ? selectedCar.getKey() : 0;

            ArrayList<Book> bookSearchList = this.bookManager.searchForTable(carId);
            ArrayList<Object[]> bookRowListBySearch = this.bookManager.getForTable(this.col_books.length, bookSearchList);
            loadBooksTable(bookRowListBySearch);
        });
    }
    public void loadBooksFilter(){
        this.cmb_books.removeAllItems();
        for (Car obj : this.carManager.findAll()) {
            this.cmb_books.addItem(new ComboItem(obj.getId(), obj.getPlate()));
        }
        this.cmb_books.setSelectedItem(null);
    }

}
