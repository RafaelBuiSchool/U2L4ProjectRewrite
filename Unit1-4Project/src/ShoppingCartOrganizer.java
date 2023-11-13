import java.util.ArrayList;
import java.util.List;

public class ShoppingCartOrganizer {
    private static String itemName;
    private static double itemPrice;
    private static int itemQuantity;
    private static List<Object> cart = new ArrayList<>();

    public ShoppingCartOrganizer(String itemName, double itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }
    public ShoppingCartOrganizer(){}
    public String toString() {
        return "Item: " + itemQuantity + " " + itemName + "                   Price: $" + itemPrice + "\n";
    }
    public double getPrice(){
        return itemPrice;
    }
    public String getItemName(){
        return itemName;
    }
    public int getItemQuantity(){
        return itemQuantity;
    }
    public void showMenu(String choice) {
        if (choice.equals("0")) {
            ifChoiceIs0();
        } else {
            while (choice != "0") {
                if (choice == "1") {
                    addItemToCart(itemName, itemPrice, itemQuantity);
                } else if (choice == "2") {
                    viewCart();
                } else if (choice == "3") {
                    generateBill();
                }
            }
        }
    }
    public String ifChoiceIs0(){
        return ("Exiting the shopping cart organizer. Thank you!");
    }
    public String addItemToCart(String itemName, double itemPrice, int itemQuantity){
        ShoppingCartOrganizer newItem = new ShoppingCartOrganizer(itemName, itemPrice, itemQuantity);
        cart.add(newItem);
        return("Item added sucessfully!\n-------------------------------");
    }
    public String viewCart() {
        String cartStatus = "";
        if (cart.isEmpty()) {
            return("Your cart is empty.");
        } else {
            cartStatus = ("\nYour Cart:");
            for (Object item : cart) {
                cartStatus += getItemName() + "\n";
            }
        }
        return cartStatus;
    }
    public String generateBill() {
        String individualPrice = "";
        double total = 0;
        for (Object item : cart) {
            individualPrice += item.toString();
            total += Math.abs(getPrice());
        }
        individualPrice += ("--------------------------------\n" +
                "Total Bill: $" + total);
        return individualPrice;
    }

}