package Model;

public class GraphicsCard extends HardwareProduct {

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
