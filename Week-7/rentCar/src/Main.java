import business.UserManager;
import core.Db;
import entity.User;
import view.AdminView;
import view.LoginView;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection con = Db.getInstance();

        LoginView loginView = new LoginView();

        //UserManager userManager = new UserManager();
        //AdminView adminView = new AdminView(userManager.findByLogin("admin","1234"));

    }
}