package Model;

public class SSD extends HardwareProduct {
    private String SSDInterface;
    private int capacity;
    private String maxSequentialRead;
    private String maxSequentialWrite;
    private String formFactor;

    public SSD() {
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getMaxSequentialWrite() {
        return maxSequentialWrite;
    }

    public void setMaxSequentialWrite(String maxSequentialWrite) {
        this.maxSequentialWrite = maxSequentialWrite;
    }

    public String getMaxSequentialRead() {
        return maxSequentialRead;
    }

    public void setMaxSequentialRead(String maxSequentialRead) {
        this.maxSequentialRead = maxSequentialRead;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSSDInterface() {
        return SSDInterface;
    }

    public void setSSDInterface(String SSDInterface) {
        this.SSDInterface = SSDInterface;
    }

    public SSD(String name,
               double price,
               String SSDInterface,
               int capacity,
               String maxSequentialRead,
               String maxSequentialWrite,
               String formFactor) {
        this.name = name;
        this.price = price;
        this.SSDInterface = SSDInterface;
        this.capacity = capacity;
        this.maxSequentialRead = maxSequentialRead;
        this.maxSequentialWrite = maxSequentialWrite;
        this.formFactor = formFactor;
    }

    @Override
    public String toString() {
        return "SSD\n" + "Name:" + name + "\nPrice:" + price +
                "\nInterface:" + SSDInterface + '\'' +
                "\nCapacity:" + capacity +
                "\nMax Sequential Read:" + maxSequentialRead + '\'' +
                "\nMax Sequential Write:" + maxSequentialWrite + '\'' +
                "\nForm Factor:" + formFactor + '\'' +
                '}';
    }
}
