import java.sql.*;
import java.util.Scanner;

public class RentalManager {

    public static void createRental(Scanner scanner) {
        try {
            System.out.print("Car ID: ");
            int carID = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Customer ID: ");
            int customerID = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Category ID: ");
            int categoryID = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Start time (YYYY-MM-DD HH:MM:SS): ");
            String startTime = scanner.nextLine();

            System.out.print("End time (YYYY-MM-DD HH:MM:SS): ");
            String endTime = scanner.nextLine();

            System.out.print("Odometer start: ");
            int odometerStart = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Odometer end: ");
            int odometerEnd = scanner.nextInt();
            scanner.nextLine();

            String sql = "INSERT INTO car_rental (categoryID, carID, customerID, rental_start, rental_end, odometer_start, odometer_end) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = AccessDB.con.prepareStatement(sql);
            stmt.setInt(1, categoryID);
            stmt.setInt(2, carID);
            stmt.setInt(3, customerID);
            stmt.setString(4, startTime);
            stmt.setString(5, endTime);
            stmt.setInt(6, odometerStart);
            stmt.setInt(7, odometerEnd);

            stmt.executeUpdate();
            System.out.println("Rental registered");

        } catch (SQLException e) {
            System.out.println("Error adding rental");
            e.printStackTrace();
        }
    }
}
