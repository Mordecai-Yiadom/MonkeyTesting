import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Monkey Testing Practice App
 *
 * REMEMBER TO REMOVE BUG COMMENTS
 */
public class MonkeyTestingPracticeApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> accounts = new ArrayList<>();
    private static boolean loggedIn = false;
    private static String currentUser = "";
    private static double balance = 100.0;

    public static void main(String[] args) {
        seedData();
        showWelcomeMessage();

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerAccount();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    calculateDiscount();
                    break;
                case "4":
                    submitFeedback();
                    break;
                case "5":
                    viewAccountList();
                    break;
                case "6":
                    deleteAccount();
                    break;
                case "7":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid menu option. Try again.");
            }
        }
    }

    private static void seedData() {
        accounts.add("admin");
        accounts.add("student");
        accounts.add("tester");
    }

    private static void showWelcomeMessage() {
        System.out.println("====================================");
        System.out.println(" Monkey Testing Practice App");
        System.out.println("====================================");
        System.out.println("Try to find crashes, logic errors, and bad validation.");
    }

    private static void printMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Register Account");
        System.out.println("2. Login");
        System.out.println("3. Calculate Discount");
        System.out.println("4. Submit Feedback");
        System.out.println("5. View Account List");
        System.out.println("6. Delete Account");
        System.out.println("7. Exit");
    }

    private static void registerAccount() {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        // BUG: Allows blank usernames.
        // BUG: Allows duplicate usernames.
        // BUG: Allows extremely long usernames.
        accounts.add(username);

        System.out.println("Account registered for: " + username);
    }

    private static void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // BUG: Any password works as long as the username exists.
        if (accounts.contains(username)) {
            loggedIn = true;
            currentUser = username;
            System.out.println("Login successful. Welcome, " + currentUser + "!");
        } else {
            System.out.println("Login failed. Username does not exist.");
        }
    }

    private static void calculateDiscount() {
        System.out.print("Enter item price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter discount percent: ");
        double discountPercent = Double.parseDouble(scanner.nextLine());

        // BUG: Allows negative prices.
        // BUG: Allows discounts over 100%.
        // BUG: Allows negative discounts.
        double finalPrice = price - (price * discountPercent / 100);

        System.out.println("Final price: $" + finalPrice);
    }

    private static void submitFeedback() {
        System.out.print("Enter your feedback: ");
        String feedback = scanner.nextLine();

        // BUG: Crashes if feedback is empty because charAt(0) is called.
        char firstLetter = feedback.charAt(0);

        // BUG: Does not limit feedback size.
        System.out.println("Feedback received. Your feedback starts with: " + firstLetter);
    }

    private static void viewAccountList() {
        // BUG: Sensitive data exposure. Any user can view all accounts without logging in.
        System.out.println("Registered accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + ": " + accounts.get(i));
        }
    }

    private static void deleteAccount() {
        System.out.print("Enter account index to delete: ");
        int index = Integer.parseInt(scanner.nextLine());

        // BUG: No login required.
        // BUG: No check for invalid index.
        String removed = accounts.remove(index);

        // BUG: If the current logged-in account is deleted, session is not updated.
        System.out.println("Deleted account: " + removed);
    }

    private static void withdrawMoney() {
        System.out.println("Current balance: $" + balance);
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());

        // BUGS:
        // - No login required
        // - Negative amount increases balance
        // - No limit checks
        balance -= amount;

        System.out.println("New balance: $" + balance);

    
}
