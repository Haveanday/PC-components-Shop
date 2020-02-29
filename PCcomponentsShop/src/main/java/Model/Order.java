package Model;

public class Order {
    private static int id;
    private boolean state;

    public void  confirmOrder() {

    }

    public void cancelOrder() {

    }

    public void deleteOrder() {

    }

    public Order(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public static int getId() {
        return id;
    }

}
