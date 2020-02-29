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
        objectCounter++;
        id = objectCounter;
    }

    @Override
    public void buy() {
        System.out.println("buying CPU...");
    }

    @Override
    public void showInfo() {
        this.getName();
        this.getId();
        System.out.print("name:");
        System.out.println(name.toString());
        System.out.print("id:");
        System.out.println(id);
    }

    @Override
    public String toString() {
        return "CPU" + '\n' +
                "name: " + name + '\n' + " id: " + id + '\n';
    }
}
