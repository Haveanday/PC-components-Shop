package Model;

public class ShoppingCart {
    private boolean state;
    private static int counter;

    public void clearShoppingCart() {

    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        ShoppingCart.counter = counter;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ShoppingCart(boolean state) {
        this.state = state;
    }
}
