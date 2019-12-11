/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.impl;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageCopy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.database.connection.ConnectionFactory;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.controller.ServerController;

/**
 *
 * @author milos
 */
public class StorageCopyImpl implements StorageCopy {

    @Override
    public List<Copy> getAll() throws Exception {
        List<Copy> copies = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT  e.equipmentID,e.specification,e.connection,c.copyId,e.name FROM COPY c INNER JOIN equipment e ON c.equipmentid=e.equipmentid WHERE c.working=1 AND c.available=1";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("c.copyid");

                Equipment eq;
                eq = new Equipment(rs.getInt("e.equipmentID"), rs.getString("e.connection"), rs.getString("e.specification"), rs.getString("e.name"));
                Copy copy = new Copy(id, true, true, eq, "");

                copies.add(copy);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        return copies;
    }

    @Override
    public boolean setCopy(Copy copy) throws Exception {
        if (copy == null || copy.getEquipment() == null) {
            return false;
        }
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            //not good !
            String query = "insert into Copy(equipmentID,working,available,defect) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, copy.getEquipment().getEquipmentID().toString());
            preparedStatement.setString(2, copy.getWorking().toString());
            preparedStatement.setString(3, copy.getAvailable().toString());
            preparedStatement.setString(4, copy.getDefect());
            int count = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (count > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    copy.setCopyID(rs.getInt(1));

                }

                connection.commit();
                return true;

            } else {
                connection.rollback();
                return false;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
    }

    @Override
    public Copy getCopy(Copy copy) throws Exception {
        if (copy == null || copy.getEquipment() == null) {
            return null;
        }
        Copy save = null;
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM COPY where copyid=" + copy.getCopyID() + "and equipmentid=" + copy.getEquipment().getEquipmentID();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("id");
                Boolean working = rs.getBoolean("working");
                Boolean available = rs.getBoolean("available");
                Integer eqId = rs.getInt("equipmentID");
                String defect = rs.getString("defect");
                Equipment eq = ServerController.getInstance().getServiceEquipment().getByID(eqId);
                save = new Copy(id, working, available, eq, defect);

            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        return save;

    }


    @Override
    public boolean setCopy(List<Copy> copies) throws Exception {
        boolean save = true;
        for (Copy copy : copies) {
            save = save && setCopy(copy);

        }

        return save;
    }

    @Override
    public boolean changeCopy(Copy copy) throws Exception {
        if (copy == null || copy.getEquipment() == null) {
            return false;
        }
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "update copy set working=?,available=?,defect=? where copyID=? and equipmentID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            preparedStatement.setBoolean(1, copy.getWorking());
            preparedStatement.setBoolean(2, copy.getAvailable());
            preparedStatement.setString(3, copy.getDefect());
            preparedStatement.setInt(4, copy.getCopyID());
            preparedStatement.setInt(5, copy.getEquipment().getEquipmentID());
            int count = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (count > 0) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        return false;
    }

    @Override
    public List<Copy> getAllEquipment(int id) throws Exception {
        List<Copy> copies = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT c.copyID,c.working,c.available,e.name,c.defect,e.specification,e.connection FROM COPY c inner join equipment e on c.equipmentid=e.equipmentid where c.equipmentID= " + id;

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer copyid = rs.getInt("c.copyid");
                Boolean working = rs.getBoolean("c.working");
                Boolean available = rs.getBoolean("c.available");

                String defect = rs.getString("c.defect");

                Equipment eq;
                eq = new Equipment(id, rs.getString("e.connection"), rs.getString("e.specification"), rs.getString("e.name"));
                Copy copy = new Copy(copyid, working, available, eq, defect);

                copies.add(copy);
            }
            rs.close();
            statement.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        return copies;
    }

    @Override
    public boolean deleteCopy(int copyid, int eqid) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "delete from copy where copyid=" + copyid + " and equipmentid=" + eqid;
            Statement statement = connection.createStatement();
            int br = statement.executeUpdate(query);

            statement.close();
            if (br != 0) {
                connection.commit();
            }
            return br != 0;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
    }

}
