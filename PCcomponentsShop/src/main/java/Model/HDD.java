package Model;

public class HDD extends HardwareProduct {
    private String HDDInterface;
    private int capacity;
    private int RPM;
    private int cache;
    private int formFactor;

    public HDD() {
    }

    public int getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(int formFactor) {
        this.formFactor = formFactor;
    }

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public int getRPM() {
        return RPM;
    }

    public void setRPM(int RPM) {
        this.RPM = RPM;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getHDDInterface() {
        return HDDInterface;
    }

    public void setHDDInterface(String HDDInterface) {
        this.HDDInterface = HDDInterface;
    }
}
