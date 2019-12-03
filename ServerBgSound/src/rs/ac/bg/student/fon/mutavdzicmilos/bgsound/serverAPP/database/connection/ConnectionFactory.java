/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.controller.ServerController;

/**
 *
 * @author FON
 */
public class ConnectionFactory {

    public static void setInstance(ConnectionFactory aInstance) {
        instance = aInstance;
    }

    private Connection connection;
    private static ConnectionFactory instance;

    private ConnectionFactory() throws SQLException {
       
        String url, username, password;
            url = ServerController.getInstance().getHashmap().get("db.url").toString();
            username = ServerController.getInstance().getHashmap().get("db.username").toString();
            password = ServerController.getInstance().getHashmap().get("db.password").toString();
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);

    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
