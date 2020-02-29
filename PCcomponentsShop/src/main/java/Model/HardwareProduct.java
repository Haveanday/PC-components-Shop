package Model;

abstract public class HardwareProduct {
    protected static int objectCounter = 0;
    protected int id;
    protected String name;
    protected double price;
    protected int rating;

    public int getId() {
        return id;
    }

    public void buy() {

    }

    public void addToShoppingCart() {

    }

    public void showInfo() {

    }

    public void customizeSpecifications() {

    }

    public int getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
