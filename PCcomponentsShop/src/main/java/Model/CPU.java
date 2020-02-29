package Model;

public class CPU extends HardwareProduct {

    public CPU() {
        objectCounter++;
        id = objectCounter;
    }

    @Override
    public void buy() {
        System.out.print("buying CPU...");
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
