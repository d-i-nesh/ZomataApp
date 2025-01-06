import java.util.ArrayList;
import java.util.Scanner;

public class ZomatoApp {
    // List to store available menu items
    private static ArrayList<String> menu = new ArrayList<>();
    // List to store the items added to the cart
    private static ArrayList<String> cart = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize the menu with some items
        menu.add("Burger");
        menu.add("Pizza");
        menu.add("Pasta");
        menu.add("Sushi");
        menu.add("Coke");

        // Create scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Menu-driven program
        int choice;
        do {
            System.out.println("\n--- Zomato App ---");
            System.out.println("1. View Menu");
            System.out.println("2. Add item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // To consume the newline character after integer input

            switch (choice) {
                case 1:
                    viewMenu();
                    break;
                case 2:
                    addToCart(scanner);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    System.out.println("Thank you for using Zomato App!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    // Method to view the menu
    private static void viewMenu() {
        System.out.println("\n--- Menu ---");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    // Method to add item to the cart
    private static void addToCart(Scanner scanner) {
        System.out.print("Enter the item number to add to cart: ");
        int itemNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (itemNumber >= 1 && itemNumber <= menu.size()) {
            cart.add(menu.get(itemNumber - 1));
            System.out.println(menu.get(itemNumber - 1) + " has been added to your cart.");
        } else {
            System.out.println("Invalid item number.");
        }
    }

    // Method to view items in the cart
    private static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
        } else {
            System.out.println("\n--- Cart ---");
            for (String item : cart) {
                System.out.println(item);
            }
        }
    }

    // Method to checkout
    private static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty. Add items to your cart first.");
        } else {
            System.out.println("\n--- Checkout ---");
            double totalAmount = 0.0;
            for (String item : cart) {
                switch (item.toLowerCase()) {
                    case "burger":
                        totalAmount += 5.99;
                        break;
                    case "pizza":
                        totalAmount += 8.99;
                        break;
                    case "pasta":
                        totalAmount += 7.49;
                        break;
                    case "sushi":
                        totalAmount += 12.99;
                        break;
                    case "coke":
                        totalAmount += 1.49;
                        break;
                    default:
                        System.out.println("Unknown item: " + item);
                        break;
                }
            }
            System.out.printf("Total amount to pay: $%.2f\n", totalAmount);
            System.out.println("Thank you for your order!");
            cart.clear(); // Clear the cart after checkout
        }
    }
}