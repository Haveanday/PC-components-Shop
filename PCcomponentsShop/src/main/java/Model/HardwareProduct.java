package Model;

abstract public class HardwareProduct {
    protected String name;
    protected double price;
    private Rating rating;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
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
}
