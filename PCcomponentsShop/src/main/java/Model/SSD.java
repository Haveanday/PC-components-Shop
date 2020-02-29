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
}
