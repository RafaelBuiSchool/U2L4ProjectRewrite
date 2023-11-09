public class ShoppingListRunner {
    public static void main(String[] args) {
        ShoppingCartOrganizer shoppingCartOrganizer = new ShoppingCartOrganizer();
        ShoppingCartOrganizer.ShoppingCartManager cartManager = shoppingCartOrganizer.new ShoppingCartManager();
        cartManager.showMenu();
    }
}
