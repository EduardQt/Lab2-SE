package se.hkr.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String host;
    private final String user;
    private final String password;
    private final String database;
    private final int port;

    public Database(String host, String user, String password, String database, int port) throws ClassNotFoundException {
        this.host = host;
        this.user = user;
        this.password = password;
        this.database = database;
        this.port = port;

        Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection provideConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?serverTimezone=UTC", this.user, this.password);
    }
}
