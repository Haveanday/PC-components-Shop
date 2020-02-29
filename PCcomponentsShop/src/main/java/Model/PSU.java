package Model;

public class PSU extends HardwareProduct {
    private int maxPower;
    private String fans;
    private String mainConnector; //pins
    private String inputVoltage;
    private String inputFrequency;

    public PSU() {
    }

    public String getInputFrequency() {
        return inputFrequency;
    }

    public void setInputFrequency(String inputFrequency) {
        this.inputFrequency = inputFrequency;
    }

    public String getInputVoltage() {
        return inputVoltage;
    }

    public void setInputVoltage(String inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    public String getMainConnector() {
        return mainConnector;
    }

    public void setMainConnector(String mainConnector) {
        this.mainConnector = mainConnector;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }
}
