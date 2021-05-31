package Model;

abstract public class HardwareProduct {
    protected String name;
    protected double price;
    public Rating rating;

    public Rating getRating() {
        return rating;
    }

    public void addToShoppingCart() {
    }

    public void showInfo() {

    }

    public void customizeSpecifications() {

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

    public void  setRating(Rating rating) {
        this.rating = rating;
    }
}
