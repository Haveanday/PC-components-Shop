package Model;

import Repository.ComponentsRepository;

public class GraphicsCard extends HardwareProduct {
    private int coreClock;
    private int memorySize;
    private String cardInterface;
    Rating rating;
    private double price;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Rating getRating() {
        return rating;
    }

    public String getCardInterface() {
        return cardInterface;
    }

    public void setCardInterface(String cardInterface) {
        this.cardInterface = cardInterface;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getCoreClock() {
        return coreClock;
    }

    public void setCoreClock(int coreClock) {
        this.coreClock = coreClock;
    }

    public GraphicsCard() {
    }

    public GraphicsCard(String name,
                        double price,
                        int coreClock,
                        int memorySize,
                        String cardInterface,
                        Rating rating) {
        this.name = name;
        this.price = price;
        this.coreClock = coreClock;
        this.memorySize = memorySize;
        this.cardInterface = cardInterface;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Graphics Card\n" + "Name: " + name + "\nPrice: " + price +
                "\nCore clock:" + coreClock +
                "\nMemory size: " + memorySize +
                "\nInterface: " + cardInterface +
                "\nRating:" + rating;
    }
}
