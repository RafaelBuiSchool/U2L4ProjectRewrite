import java.util.ArrayList;
import java.util.List;
/**
 * The ShoppingCartOrganizer class represents a simple shopping cart organizer.
 * It allows users to add items to a shopping cart, view the cart, remove random items,
 * and generate a bill based on the items in the cart.
 */
public class ShoppingCartOrganizer {
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private List<Object> cart = new ArrayList<>();

        //Methods and constructors in the ShoppingCartOrganizer class

    /**
     * The shoppingCartOrganizer constructor creates a new ShoppingCartOrganizer with the specified item details.
     *
     * @param itemName      The name of the item.
     * @param itemPrice     The price of the item.
     * @param itemQuantity  The quantity of the item.
     */
    public ShoppingCartOrganizer(String itemName, double itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    /**
     * The ShoppingCartOrganizer constructor is a default constructor for ShoppingCartOrganizer.
     */
    public ShoppingCartOrganizer(){}

    /**
     * The toString method returns a string representation of the item in the cart
     * in a receipt format, displaying the items quantity, name and price.
     *
     * @return A string containing item details.
     */
    public String toString() {
        return "Item: " + itemQuantity + " " + itemName + "         Price: $" + getPrice() + "\n";
    }

    /**
     * The getPrice method calculates and returns the total price of the
     * item, rounded to the nearest 100th place or cent, in order to follow
     * the US currency.
     *
     * @return The total price of the item.
     */
    public double getPrice(){
        return Math.round((itemPrice*itemQuantity)*100)/100.0;
    }

    /**
     * The getItemName method returns the name of the item.
     *
     * @return The name of the item.
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * The getItemQuantity returns the quantity of the item.
     *
     * @return The quantity of the item.
     */
    public int getItemQuantity(){
        return itemQuantity;
    }

    /**
     * The showMenu method displays the menu based on the user's choice.
     * Calls the methods that correspond to the users' choice.
     *
     * @param choice The user's choice.
     */
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

    /**
     *The ifChoiceIs0 method handles the case when the user's choice is 0 and exits the shopping cart.
     *
     * @return A message indicating exiting the shopping cart organizer.
     */
    public String ifChoiceIs0(){
        return ("Exiting the shopping cart organizer. Thank you!");
    }

    /**
     * The addItemToCart method adds a new item to the shopping cart.
     * Asks the user the specifics of the items such as the name, quantity and price.
     * Returns a message to the user to let them know that their cart has successfully added
     * the new item.
     *
     * @param itemName      The name of the item.
     * @param itemPrice     The price of the item.
     * @param itemQuantity  The quantity of the item.
     * @return A message indicating successful addition.
     */
    public String addItemToCart(String itemName, double itemPrice, int itemQuantity){
        ShoppingCartOrganizer newItem = new ShoppingCartOrganizer(itemName, itemPrice, itemQuantity);
        cart.add(newItem);
        return("---------------------\nItem added sucessfully!\n---------------------");
    }

    /**
     * The removeRandomItem method removes a random item from the shopping cart.
     *
     * @return A message indicating the success or failure of item removal.
     */
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

    /**
     * The viewCart method displays the contents of the shopping cart such
     * as the item names, their quantities, and their total prices.
     *
     * @return A string representation of the item values in the cart.
     */
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

    /**
     * The generateBill method generates and returns an itemized bill for the items
     * in the shopping cart and returns the total bill.
     *
     * @return A string containing the individual item prices and the total bill.
     */
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