package Model;

public class User {
   private static int id;
   private boolean isRegistred;
   private String login;
   private String password;
   private String firstName;
   private String secondName;

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isRegistered() {
        return isRegistred;
    }

    public void setRegistered(boolean registred) {
        isRegistred = registred;
    }

    public static int getId() {
        return id;
    }

    public User() {
    }

    public void createReview() {

    }

    public void createAccount() {

    }

    public void signIn() {
        
    }
}
