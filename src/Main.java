import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AccessDB.connect();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- * !!! KAILUA CAR RENTAL SYSTEM !!! * ----");

            System.out.println("1. View all cars");
            System.out.println("2. Search/filter cars");
            System.out.println("3. Add new customer");
            System.out.println("4. Edit existing customer");
            System.out.println("5. Create new rental");
            System.out.println("6. End rental");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CarManager.viewCars();
                    break;
                /*case 2:
                    //search car here
                    break;*/
                case 3:
                    CustomerManager.addCustomer(scanner);
                    break;
                case 4:
                    //edit customer here
                    break;
                case 5:
                    RentalManager.createRental(scanner);
                    break;
                /*case 6:
                    //end rental
                    break;*/
                case 7:
                    System.out.println("Closing console");
                    break;
                default:

                    //System.out.println("Error. Select number between 1-7");
                    //midlertideligt error message
                    System.out.println("Error. Select another number between 1-7");
            }

        } while (choice != 7);

        AccessDB.disconnect();
        scanner.close();
    }
}
