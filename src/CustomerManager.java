import java.sql.*;
import java.util.Scanner;

public class CustomerManager {

    public static void addCustomer(Scanner scanner) {
        try {
            System.out.print("First name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("Zip code: ");
            String zip = scanner.nextLine();

            System.out.print("City: ");
            String city = scanner.nextLine();

            System.out.print("Personal phone: ");
            String personalPhone = scanner.nextLine();

            System.out.print("Work phone (optional): ");
            String workPhone = scanner.nextLine();

            System.out.print("E-mail address (optional): ");
            String email = scanner.nextLine();

            System.out.print("License Number: ");
            String license = scanner.nextLine();

            System.out.print("Driver Since (YYYY-MM-DD): ");
            String since = scanner.nextLine();

            String sql = "INSERT INTO customer (first_name, last_name, address, zip_code, city, personal_phone, work_phone, email, driver_license_number, driver_since) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = AccessDB.con.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, address);
            stmt.setString(4, zip);
            stmt.setString(5, city);
            stmt.setString(6, personalPhone);
            stmt.setString(7, workPhone);
            stmt.setString(8, email);
            stmt.setString(9, license);
            stmt.setString(10, since);

            stmt.executeUpdate();
            System.out.println("Customer added");

        } catch (SQLException e) {
            System.out.println("Error adding customer");
        }
    }

}
