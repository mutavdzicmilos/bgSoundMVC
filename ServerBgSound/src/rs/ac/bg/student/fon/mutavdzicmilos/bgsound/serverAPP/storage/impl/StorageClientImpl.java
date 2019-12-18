/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.database.connection.ConnectionFactory;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageClient;

/**
 *
 * @author user
 */
public class StorageClientImpl implements StorageClient {

    @Override
    public Client saveClient(Client client) throws Exception {

        try {

            Connection connection = ConnectionFactory.getInstance().getConnection();

            String query = "insert into Client(name,surname,JMBG,phone) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getJMBG());
            preparedStatement.setString(4, client.getPhone());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    client.setClientID(rs.getInt(1));
                }
                connection.commit();
            } else {
                connection.rollback();
                throw new Exception("Error saving client to database");
            }
            preparedStatement.close();
            return client;
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }

    }

    @Override
    public List<Client> returnAllClients() throws Exception {
        List<Client> clients = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM client ORDER BY clientid";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("clientid");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String JMBG = rs.getString("jmbg");
                String phone = rs.getString("phone");
                Client client = new Client(name, surname, JMBG, id, phone);
                clients.add(client);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        return clients;
    }

    @Override
    public List<Client> returnByName(String name) throws Exception {
        List<Client> clients = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM client where name LIKE '" + name + "%' order by clientid";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String names = rs.getString("name");
                Integer id = rs.getInt("clientid");
                String surname = rs.getString("surname");
                String JMBG = rs.getString("jmbg");
                String phone = rs.getString("phone");
                Client client = new Client(names, surname, JMBG, id, phone);
                clients.add(client);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        return clients;
    }

    @Override
    public Client returnByID(int id) throws Exception {

        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM client where clientid=" + id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String JMBG = rs.getString("jmbg");
                String phone = rs.getString("phone");
                return new Client(name, surname, JMBG, id, phone);

            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        return null;
    }

    @Override
    public boolean updateClient(Client client) throws Exception {

        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "update client set name=?,surname=?,jmbg=?,phone=? where clientid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getJMBG());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setInt(5, client.getClientID());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                throw new Exception("Error updating client in database");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

    }

    @Override
    public boolean deleteClient(Client client) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "delete from client where clientid=" + client.getClientID();
            Statement statement = connection.createStatement();
            int br = statement.executeUpdate(query);
            statement.close();
            if (br > 0) {
                connection.commit();
                return true;
            }
            connection.rollback();
            throw new Exception("Error deleting client from database");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

    }

    @Override
    public boolean deleteClient(int client) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "delete from client where clientid=" + client;
            Statement statement = connection.createStatement();
            int br = statement.executeUpdate(query);
            statement.close();
            if (br > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
        throw new Exception("Error deleting client from database");
    }

}
