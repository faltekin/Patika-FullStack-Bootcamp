import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:mysql://localhost/employees";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {

        Connection connect = null;
        Statement st = null;
        String sql = "SELECT * FROM employee";
        String prSql = "INSERT INTO employee (employee_name,employee_position,employee_salary) VALUES (?,?,?)";

        try {
            connect = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            st = connect.createStatement();
            PreparedStatement prSt = connect.prepareStatement(prSql);

            prSt.setString(1, "Fuat");
            prSt.setString(2, "Developer");
            prSt.setInt(3, 50000);
            prSt.executeUpdate();

            prSt.setString(1, "Eda");
            prSt.setString(2, "Doctor");
            prSt.setInt(3, 500000);
            prSt.executeUpdate();

            prSt.setString(1, "Caner");
            prSt.setString(2, "Teacher");
            prSt.setInt(3, 30000);
            prSt.executeUpdate();

            prSt.setString(1, "Ege");
            prSt.setString(2, "Engineer");
            prSt.setInt(3, 20000);
            prSt.executeUpdate();

            prSt.setString(1, "Damla");
            prSt.setString(2, "Developer");
            prSt.setInt(3, 100000);
            prSt.executeUpdate();

            ResultSet data = st.executeQuery(sql);

            while (data.next()){

                System.out.println("Employee ID: " + data.getInt("employee_id"));
                System.out.println("Employee Name: " + data.getString("employee_name"));
                System.out.println("Employee Position: " + data.getString("employee_position"));
                System.out.println("Employee Salary: " + data.getInt("employee_salary"));
                System.out.println("------");
            }

            prSt.close();
            st.close();

        } catch (SQLException e){
            System.out.print(e.getMessage());
        }
    }
}