package Model;

public class Account {
    private static int id;
    private boolean state;
    private int bonus;

    public void deleteAccount() {

    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public static int getId() {
        return id;
    }

    public Account(boolean state) {
        this.state = state;
    }
}
