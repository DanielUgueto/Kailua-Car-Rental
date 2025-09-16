import java.sql.*;

public class CarManager {

    public static void viewCars() {
        String query = "SELECT * FROM cars";

        try (Statement stmt = AccessDB.con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("\n--- All Cars ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Category: %s | Brand: %s | Model: %s | Fuel: %s | Reg#: %s | Seats: %d | HP: %d | Odometer: %d KM\n",
                        rs.getInt("carID"),
                        rs.getString("category"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("fuel_type"),
                        rs.getString("reg_number"),
                        rs.getInt("seats"),
                        rs.getInt("horsepower"),
                        rs.getInt("odometerKM"));
            }

        } catch (SQLException e) {
            System.err.println("Error");
            e.printStackTrace();
        }
    }

}
