package Model;

public class Motherboard extends HardwareProduct {
    private String CPUSocketType;
    private String chipset;
    private String numberOfMemorySlots;

    public Motherboard() {
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
    }

    public String getNumberOfMemorySlots() {
        return numberOfMemorySlots;
    }

    public void setNumberOfMemorySlots(String numberOfMemorySlots) {
        this.numberOfMemorySlots = numberOfMemorySlots;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getCPUSocketType() {
        return CPUSocketType;
    }

    public void setCPUSocketType(String CPUSocketType) {
        this.CPUSocketType = CPUSocketType;
    }

    private int maxMemory;

}
