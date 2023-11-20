import java.util.Scanner;

/**
 * The ShoppingListRunner class contains the main method to run the shopping cart application.
 */
public class ShoppingCartRunner {
    /**
     * The main method that initializes the shopping cart and provides a menu for user interaction.
     *
     * @param args The command-line arguments (unused).
     */
    public static void main(String[] args) {
        //Defines the variables used
        String itemName;
        double itemPrice;
        int itemQuantity;

        //Creates a new scanner for user input & a new ShoppingCartOrganizer object so the
        //user can add new items to a list.
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to your own personalized shopping cart! Below consists of the different options you can use to track your items...\n");
        ShoppingCartOrganizer item = new ShoppingCartOrganizer();

        //Tells the user their choices they can make regarding their shopping cart
        String choice = "";
        while (!choice.equals("0")) {
            System.out.println("Shopping Cart Organizer Menu:");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. Remove Random Item from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Generate Bill");
            System.out.println("0. Exit");
            System.out.print("Enter your numerical choice(e.g. \"1\"): ");
            choice = s.nextLine();

            //Choice 1 actions
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

            //choice 2 actions
            if(choice.equals("2")){
                System.out.println(item.removeRandomItem());
            }

            //choice 3 actions
            if (choice.equals("3")) {
                System.out.println(item.viewCart());
            }

            //choice 4 actions
            if (choice.equals("4")) {
                System.out.println(item.generateBill());
            }

            //choice 0 actions
            if (choice.equals("0")) {
                System.out.println(item.ifChoiceIs0());
            }
        }
    }
}