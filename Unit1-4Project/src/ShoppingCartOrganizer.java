import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ShoppingCartOrganizer {
    class Item {
        private String itemName;
        private double itemPrice;
        private int itemQuantity;

        public Item(String itemName, double itemPrice, int itemQuantity) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemQuantity = itemQuantity;
        }

        public String getItemName() {
            return itemName;
        }

        public double getItemPrice() {
            return itemPrice;
        }

        public int getItemQuantity() {
            return itemQuantity;
        }

        public void setItemQuantity(int quantity) {
            this.itemQuantity = quantity;
        }

        public double calculateTotal() {
            return itemPrice * itemQuantity;
        }

        @Override
        public String toString() {
            return "Item: " + itemName + "\nPrice: $" + itemPrice + "\nQuantity: " + itemQuantity;
        }
    }

    public class ShoppingCartManager {

        private List<Item> cart = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public void showMenu() {
            int choice;

            do {
                System.out.println("\nShopping Cart Organizer Menu:");
                System.out.println("1. Add Item to Cart");
                System.out.println("2. View Cart");
                System.out.println("3. Generate Bill");
                System.out.println("0. Exit");

                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addItemToCart();
                        break;
                    case 2:
                        viewCart();
                        break;
                    case 3:
                        generateBill();
                        break;
                    case 0:
                        System.out.println("Exiting the shopping cart organizer. Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 0);
        }

        public void addItemToCart() {
            System.out.print("Enter item name: ");
            String itemName = scanner.next();

            System.out.print("Enter item price: $");
            double itemPrice = scanner.nextDouble();

            System.out.print("Enter item quantity: ");
            int itemQuantity = scanner.nextInt();

            Item newItem = new Item(itemName, itemPrice, itemQuantity);
            cart.add(newItem);

            System.out.println("Item added to the cart: " + newItem.getItemName());
        }

        public void viewCart() {
            if (cart.isEmpty()) {
                System.out.println("Your cart is empty.");
            } else {
                System.out.println("\nYour Cart:");
                for (Item item : cart) {
                    System.out.println(item.toString());
                    System.out.println("Total: $" + item.calculateTotal() + "\n");
                }
            }
        }

        public void generateBill() {
            double total = 0;

            System.out.println("\nGenerating Bill:");
            for (Item item : cart) {
                System.out.println(item.toString());
                System.out.println("Total: $" + item.calculateTotal() + "\n");
                total += item.calculateTotal();
            }

            System.out.println("Total Bill: $" + total);
        }
    }
}