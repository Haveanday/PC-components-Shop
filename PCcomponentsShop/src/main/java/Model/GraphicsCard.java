package Model;

public class GraphicsCard extends HardwareProduct {
    private int coreClock;
    private int memorySize;
    private String cardInterface;

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
        objectCounter++;
        id = objectCounter;
    }

    @Override
    public void showInfo() {
        this.getName();
        this.getId();
        System.out.println(name);
        System.out.println(id);
    }
}
