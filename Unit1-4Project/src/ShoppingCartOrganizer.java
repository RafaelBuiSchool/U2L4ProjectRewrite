import java.util.ArrayList;
import java.util.List;

public class ShoppingCartOrganizer {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private List<Object> cart = new ArrayList<>();

    public ShoppingCartOrganizer(String itemName, double itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }
    public ShoppingCartOrganizer(){}
    public String toString() {
        return "Item: " + itemQuantity + " " + itemName + "         Price: $" + getPrice() + "\n";
    }
    public double getPrice(){
        return Math.round((itemPrice*itemQuantity)*100)/100.0;
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
        return("Item added sucessfully!\n---------------------");
    }
    public String removeRandomItem(){
        if (cart.isEmpty()) {
            return ("---------------------\nYour cart is empty. Nothing to remove.\n---------------------");
        }
        else {
            int rando = (int) (Math.random() * cart.size());
            cart.remove(rando);
            return "---------------------\nRandom Item successfully removed\n---------------------";
        }
    }
    public String viewCart() {
        String cartStatus = "";
        if (cart.isEmpty()) {
            return("---------------------\nYour cart is empty.\n---------------------");
        } else {
            cartStatus = ("---------------------\nYour Cart: \n");
            for (Object item : cart) {
                cartStatus += item.toString() + "\n";
            }
        }
        return cartStatus + "\n---------------------";
    }
    public String generateBill() {
        String individualPrice = "---------------------\n";
        double total = 0;
        for (Object item : cart) {
            individualPrice += item.toString();
            total += ((ShoppingCartOrganizer) item).getPrice();
        }
        individualPrice += ("\n" +
                "Total Bill: $" + total+"\n---------------------");
        return individualPrice;
    }

}