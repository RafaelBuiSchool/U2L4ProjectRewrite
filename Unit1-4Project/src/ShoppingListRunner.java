import java.util.Scanner;
public class ShoppingListRunner {
    public static void main(String[] args) {
        String itemName;
        double itemPrice;
        int itemQuantity;

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to your own personalized shopping cart! Below consists of the different options you can use to track your items...\n");
        ShoppingCartOrganizer item = new ShoppingCartOrganizer();
        String choice = "";
        while (!choice.equals("0")) {
            System.out.println("Shopping Cart Organizer Menu:");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. Remove Random Item from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Generate Bill");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = s.nextLine();
            if (choice.equals("1")) {
                System.out.print("---------------------------\nEnter item name: ");
                itemName = s.nextLine();
                System.out.print("Enter item price: $");
                itemPrice = s.nextDouble();
                System.out.print("Enter item quantity: ");
                itemQuantity = s.nextInt();
                s.nextLine();
                System.out.println(item.addItemToCart(itemName, itemPrice, itemQuantity));
            }
            if(choice.equals("2")){
                System.out.println(item.removeRandomItem());
            }
            if (choice.equals("3")) {
                System.out.println(item.viewCart());
            } if (choice.equals("4")) {
                System.out.println(item.generateBill());
            } if (choice.equals("0")) {
                System.out.println(item.ifChoiceIs0());
            }
        }
    }
}