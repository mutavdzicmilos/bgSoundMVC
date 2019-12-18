/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.impl;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageEquipment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.database.connection.ConnectionFactory;

/**
 *
 * @author user
 */
public class StorageEquipmentImpl implements StorageEquipment {

    @Override
    public List<Equipment> getAll() throws Exception {
        List<Equipment> equipments = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM equipment ORDER BY name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("equipmentid");
                String name = rs.getString("name");
                String specification = rs.getString("specification");
                String connectivity = rs.getString("connection");

                Equipment equipment = new Equipment(id, connectivity, specification, name);
                equipments.add(equipment);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }

        return equipments;
    }

    @Override
    public Equipment getByID(Integer id) throws Exception {
        Equipment eq = new Equipment();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM equipment where equipmentid =" + id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                String specification = rs.getString("specification");
                String connectivity = rs.getString("connection");

                return new Equipment(id, connectivity, specification, name);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }

        return eq;
    }

    @Override
    public Equipment setEquipment(Equipment equipment) throws Exception {
        if (equipment == null) {
            return null;
        }
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "insert into equipment(name,connection,specification) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, equipment.getName());
            preparedStatement.setString(2, equipment.getConnection());
            preparedStatement.setString(3, equipment.getSpecification());
            int count = preparedStatement.executeUpdate();

            if (count > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    equipment.setEquipmentID(rs.getInt(1));

                } else {
                    connection.rollback();
                    throw new Exception("Error saving equipment");
                }

                int br = equipment.getCopies().size();
                String s = "insert into Copy(equipmentID,working,available,defect) values(" + equipment.getEquipmentID() + ",True,True,NULL)";
                preparedStatement = connection.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
                for (int i = 0; i < br; i++) {

                    int ia = preparedStatement.executeUpdate();
                    if (ia == 0) {
                        connection.rollback();
                        return null;
                    } else {
                        rs = preparedStatement.getGeneratedKeys();
                        System.out.println("here");
                        if (rs.next()) {
                            equipment.getCopies().get(i).setCopyID(rs.getInt(1));
                        } else {
                            connection.rollback();
                            throw new Exception("Error saving copies");
                        }
                    }
                }

                connection.commit();
                preparedStatement.close();
                return equipment;

            } else {
                connection.rollback();
                throw new Exception("Error saving equipment");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
    }

    @Override
    public List<Equipment> getByName(String Name) throws Exception {
        List<Equipment> eq = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM equipment where name Like'" + Name + "%'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("equipmentId");
                String name = rs.getString("name");
                String specification = rs.getString("specification");
                String connectivity = rs.getString("connection");

                eq.add(new Equipment(id, connectivity, specification, name));
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        return eq;
    }

    @Override
    public boolean changeEquipment(Equipment equipment) throws Exception {
        if (equipment == null) {
            return false;
        }
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            //not good !
            String query = "update equipment set name=?,connection=?,specification=? where equipmentid =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, equipment.getName());
            preparedStatement.setString(2, equipment.getConnection());
            preparedStatement.setString(3, equipment.getSpecification());
            preparedStatement.setInt(4, equipment.getEquipmentID());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                connection.commit();
                return true;
            } else {
                connection.rollback();
                throw new Exception("Error saving equipment");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "delete from equipment where equipmentid=" + id;
            Statement statement = connection.createStatement();
            int br = statement.executeUpdate(query);
            if (br > 0) {
                connection.commit();
                return true;
            }
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
        throw new Exception("Error saving equipment");
    }
}
