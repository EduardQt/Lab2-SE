package se.hkr.core;

import se.hkr.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceProvider {

    public int provideBalance(int userId) {
        try {
            Connection connection = Main.getDatabase().provideConnection();

            String query = "SELECT balance FROM users WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, userId);

            ResultSet resultset = statement.executeQuery();
            if (resultset.next()) {
                return resultset.getInt("balance");
            }

            resultset.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;
    }

    private static BalanceProvider instance;

    public static BalanceProvider getInstance() {
        if (instance == null) instance = new BalanceProvider();

        return instance;
    }
}
