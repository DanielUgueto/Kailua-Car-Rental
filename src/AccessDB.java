import java.sql.*;

public class AccessDB {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/kailua_car_rental";
    public static final String USER = "root";
    //slettede mit password til når jeg pusher
    public static final String PASSWORD = "";

    public static Connection con;

    public static void connect() {
        try {
            Class.forName(JDBC_DRIVER);

            con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("Succesfull");

        }catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
            e.printStackTrace();

        } catch (SQLException e) {
            System.err.println("Connection error");
            e.printStackTrace();
        }


    }
    public static void disconnect() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Disconnected");
            }
        } catch (SQLException e) {
            System.err.println("Connection error");
            e.printStackTrace();
        }
    }

/*    public static void main(String[] args) {
        connect();
        disconnect();
    }
*/
}


