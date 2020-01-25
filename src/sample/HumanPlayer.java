package sample;

public class HumanPlayer extends Player {
    private String login;
    private String password;

    public HumanPlayer(String login, String password) {
        this.login = login;
        this.password = password;
        this.numberOfChips = 1000;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
