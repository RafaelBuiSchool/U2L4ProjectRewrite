import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ShoppingCartOrganizer {
    public class Item {
        private String itemName;
        private double itemPrice;
        private int itemQuantity;
        private List<Item> cart = new ArrayList<>();
        private Scanner s = new Scanner(System.in);
        public Item(String itemName, double itemPrice, int itemQuantity) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemQuantity = itemQuantity;
        }
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

        public class choiceManager{
            public void showMenu(String choice) {
                if (choice.equals("0")) {
                    ifChoiceIs0();
                }
                else{
                    while (choice != "0"){
                        if (choice == "1") {
                            addItemToCart(itemName,itemPrice,itemQuantity);
                        }
                        else if(choice == "2"){
                            removeItemFromCart(itemName);
                        }
                        else if(choice == "3"){
                            viewCart();
                        }
                        else if (choice == "4") {
                            generateBill();
                        }
                    }
                }
            }
        }


        public String ifChoiceIs0(){
            return ("Exiting the shopping cart organizer. Thank you!");
        }
        public String addItemToCart(String itemName, double itemPrice, int itemQuantity){
            Item newItem = new Item(itemName, itemPrice, itemQuantity);
            cart.add(newItem);
            return("Item added sucessfully!");
        }
        public String removeItemFromCart(String itemName) {
            for (Item item : cart) {
                if (item.getItemName().equals(itemName)) {
                    cart.remove(item);
                    return "Item removed successfully!";
                }
            }
            return "Item not found in the cart.";
        }

        public String viewCart() {
            String cartStatus = "";
            if (cart.isEmpty()) {
                return("Your cart is empty.");
            } else {
                cartStatus = ("\nYour Cart:");
                for (Item item : cart) {
                    cartStatus += item.getItemName() + "\n";
                }
            }
            return cartStatus;
        }
        public String generateBill() {
            String individualPrice = "";
            double total = 0;
            for (Item item : cart) {
                individualPrice += item.toString();
                total += Math.abs(item.getPrice());
            }
            individualPrice += ("--------------------------------\n" +
                    "Total Bill: $" + total);
            return individualPrice;
        }
    }
}




