
package Midterm;


import java.io.*;
import java.util.*;

public class mcdanold_menu {

    static final String FILE_NAME = "users.txt";
    static Scanner scanner = new Scanner(System.in);

    // Restaurant menu
    static String[] items = {"Pizza", "Burger", "Fries"};
    static double[] prices = {150.0, 100.0, 50.0};
    static int[] quantities = new int[items.length];

    public static void main(String[] args) {
        System.out.println("1. Create Account");
        System.out.println("2. Login");
        System.out.print("Enter your choice: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        if (option == 1) {
            createAccount();
        } else if (option == 2) {
            if (login()) {
                orderMenu();
            } else {
                System.out.println("Login failed. Incorrect username or password.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Create a new account
    static void createAccount() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        String encryptedPassword = encrypt(password);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + "," + encryptedPassword);
            writer.newLine();
            System.out.println("Account created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Login method
    static boolean login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username)) {
                    String decryptedPassword = decrypt(parts[1]);
                    return inputPassword.equals(decryptedPassword);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }

        return false;
    }

    // Caesar Cipher Encryption (shift +3)
    static String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                encrypted.append((char) ((ch - base + 3) % 26 + base));
            } else {
                encrypted.append(ch); // don't change symbols/numbers
            }
        }
        return encrypted.toString();
    }

    // Caesar Cipher Decryption (shift -3)
    static String decrypt(String text) {
        StringBuilder decrypted = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                decrypted.append((char) ((ch - base - 3 + 26) % 26 + base));
            } else {
                decrypted.append(ch);
            }
        }
        return decrypted.toString();
    }

    // Ordering system
    static void orderMenu() {
        int choice;

        do {
            System.out.println("\n--- Restaurant Menu ---");
            for (int i = 0; i < items.length; i++) {
                System.out.printf("%d. %s - ₱%.2f\n", i + 1, items[i], prices[i]);
            }
            System.out.println("4. Exit and Show Bill");
            System.out.print("Choose an item (1-4): ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 3) {
                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();
                quantities[choice - 1] += qty;
            } else if (choice != 4) {
                System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        printSummary();
    }

    // Show order summary
    static void printSummary() {
        System.out.println("\n--- Order Summary ---");
        double total = 0;

        for (int i = 0; i < items.length; i++) {
            if (quantities[i] > 0) {
                double subtotal = prices[i] * quantities[i];
                System.out.printf("%s x %d = ₱%.2f\n", items[i], quantities[i], subtotal);
                total += subtotal;
            }
        }

        System.out.printf("Total Bill: ₱%.2f\n", total);
    }
}