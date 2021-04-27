package se.hkr.core;

import se.hkr.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthProvider {

    public int login(String username, String password) {
        try {
            Connection connection = Main.getDatabase().provideConnection();

            String query = "SELECT id FROM users WHERE username = ? AND password = ? LIMIT 1;";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultset = statement.executeQuery();
            if (resultset.next()) {
                return resultset.getInt("id");
            }

            resultset.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;
    }

    private static AuthProvider instance;

    public static AuthProvider getInstance() {
        if (instance == null) instance = new AuthProvider();

        return instance;
    }
}
