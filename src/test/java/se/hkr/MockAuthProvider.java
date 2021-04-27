package se.hkr;

public class MockAuthProvider {

    private final String username;
    private final String password;

    public MockAuthProvider(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int login(String username, String password) {
        if (username.equals(this.username) && password.equals(this.password)) return 1;

        return -1;
    }
}
