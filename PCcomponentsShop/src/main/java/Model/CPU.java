package Model;

public class CPU extends HardwareProduct {
    private String coreName;
    private String socketType;
    private int coreNumber;
    private int threadsNumber;
    private double frequency;
    private int releaseDate;

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getThreadsNumber() {
        return threadsNumber;
    }

    public void setThreadsNumber(int threadsNumber) {
        this.threadsNumber = threadsNumber;
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public void setCoreNumber(int coreNumber) {
        this.coreNumber = coreNumber;
    }

    public String getSocketType() {
        return socketType;
    }

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }

    public String getCoreName() {
        return coreName;
    }

    public void setCoreName(String coreName) {
        this.coreName = coreName;
    }



    public CPU() {
    }

    public CPU(String name,
               double price,
               String coreName,
               String socketType,
               int coreNumber,
               int threadsNumber,
               double frequency,
               int releaseDate) {
        this.coreName = coreName;
        this.name = name;
        this.price = price;
        this.socketType = socketType;
        this.coreNumber = coreNumber;
        this.threadsNumber = threadsNumber;
        this.frequency = frequency;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "CPU\n" + "Name: " + name + "\nPrice: " + price +
                "\nCore name:" + coreName +
                "\nSocket type: " + socketType +
                "\nCore number: " + coreNumber +
                "\nThreads number: " + threadsNumber +
                "\nFrequency: " + frequency +
                "\nRelease date: " + releaseDate;
    }
}
