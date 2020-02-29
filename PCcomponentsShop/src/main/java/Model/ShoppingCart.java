package Model;

public class ShoppingCart {
    private boolean state;
    private int OrderCounter;

    public void clearShoppingCart() {
    }

    public int getCounter() {
        return OrderCounter;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ShoppingCart() {
    }
}
