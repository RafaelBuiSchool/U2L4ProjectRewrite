import java.util.Scanner;

public class ShoppingListRunner {
    public static void main(String[] args) {
        ShoppingCartOrganizer shoppingCartOrganizer = new ShoppingCartOrganizer();
        ShoppingCartOrganizer.Item choiceManager = shoppingCartOrganizer.new Item();
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to your own personalized shopping cart! Below consists of the different options you can use to track your items...");

        String choice = "";
        while (choice != "0") {
            System.out.println("Shopping Cart Organizer Menu:");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. Remove Item from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Generate Bill");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = s.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter item name: ");
                String itemName = s.nextLine();
                System.out.print("Enter item price: $");
                double itemPrice = s.nextDouble();
                System.out.print("Enter item quantity: ");
                int itemQuantity = s.nextInt();
                choiceManager.addItemToCart(itemName, itemPrice, itemQuantity);
            } else if (choice.equals("2")) {
                System.out.print("Enter the name of the item to remove: ");
                String itemNameToRemove = s.nextLine();
                choiceManager.removeItemFromCart(itemNameToRemove);
            } else if (choice.equals("3")) {
                choiceManager.viewCart();
            } else if (choice.equals("4")) {
                choiceManager.generateBill();
            } else if (choice.equals("0")) {
                choiceManager.ifChoiceIs0();
            }
        }
    }
}
