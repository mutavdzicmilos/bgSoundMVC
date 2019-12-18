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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.database.connection.ConnectionFactory;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageRent;

/**
 *
 * @author user
 */
public class StorageRentImpl implements StorageRent {
//need help here

    @Override
    public boolean discharge(List<Rent> rents, Worker worker) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        try {

            String query = "update rent r,copy c set r.dateTo=?,r.workerID=?,c.available=? where rentID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            connection.setAutoCommit(false);
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            String date = df.format(new Date());
            for (Rent re : rents) {
                preparedStatement.setString(1, date);
                preparedStatement.setBoolean(3, true);
                preparedStatement.setInt(4, re.getRentID());
                preparedStatement.setInt(2, worker.getWorkerID());
               int br= preparedStatement.executeUpdate();
                System.out.println(br);
            }
            connection.commit();
            preparedStatement.close();
            return true;
        } catch (SQLException ex) {
            connection.rollback();
            throw new Exception("Error in saving rents");
        }

    }

    public boolean saveAll(List<Rent> rents) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "INSERT INTO rent (ClientID,EquipmentID,CopyID,DateFRom,DateTo,WorkerID) VALUES(?,?,?,?,?,?)";
            String query2 = "UPDATE COPY SET AVAILABLE=FALSE WHERE EQUIPMENTID=? AND COPYID=?";
            for (Rent r : rents) {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, r.getClient().getClientID());
                ps.setInt(2, r.getCopy().getEquipment().getEquipmentID());
                ps.setInt(3, r.getCopy().getCopyID());

                ps.setDate(4, new java.sql.Date(r.getDateFrom().getTime()));
                ps.setDate(5, null);
                ps.setInt(6, r.getWorker().getWorkerID());
                if (ps.executeUpdate() == 0) {
                    connection.rollback();
                    throw new Exception("Error saving rent.");
                }
                ps = connection.prepareStatement(query2);
                ps.setInt(1, r.getCopy().getEquipment().getEquipmentID());
                ps.setInt(2, r.getCopy().getCopyID());
                if (ps.executeUpdate() == 0) {
                    connection.rollback();
                    throw new Exception("Error saving rent in copies.");
                }

            }
            connection.commit();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return true;
    }

    @Override
    public List<Rent> getAll() throws Exception {
        List<Rent> rents = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT r.rentid,r.workerid,c.clientid,r.equipmentid,r.copyid,c.name,c.surname,r.datefrom,r.dateto FROM rent r INNER JOIN CLIENT c ON r.clientid=c.clientid WHERE r.dateto IS NULL";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                Integer rid = rs.getInt("r.rentid");
                String name = rs.getString("c.name");
                Integer wid = rs.getInt("r.workerid");
                String surname = rs.getString("c.surname");
                Integer eid = rs.getInt("r.equipmentid");
                Integer coid = rs.getInt("r.copyid");
                Integer cid = rs.getInt("c.clientid");
                Date dateFrom = rs.getDate("r.DateFrom");
                Date dateTo = rs.getDate("r.DateTo");
                Client client = new Client(name, surname, "", cid, "");
                Rent rent = new Rent(rid, dateFrom, dateTo, client, new Copy(coid, eid), new Worker(wid));
                rents.add(rent);
            }
            rs.close();
            statement.close();
            return rents;
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }

    }

    @Override
    public Rent getByID(int id) throws Exception {
        Rent rent = new Rent();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT * from rent where rentID=" + id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer rid = rs.getInt("rentid");
                Integer wid = rs.getInt("workerid");
                Integer eid = rs.getInt("equipmentid");
                Integer coid = rs.getInt("copyid");
                Integer cid = rs.getInt("clientid");
                String dateFrom = rs.getString("DateFrom");
                String dateTo = rs.getString("DateTo");
                rent = new Rent(rid, new Date(dateFrom), new Date(dateTo), eid, coid, cid, wid);
            }
            rs.close();
            statement.close();
            return rent;
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }

    }

    @Override
    public Rent get(int id) throws Exception {
        Rent rent = new Rent();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT r.rentID,r.workerID,r.ClientID,r.EquipmentID,r.CopyID,r.DateTo,r.DateFrom,c.name,c.surname,c.jmbg,c.phone,w.name,w.surname,w.jmbg,w.username,w.password,\n"
                    + "co.available,co.working,co.defect,e.name,e.connection,e.specification FROM rent r INNER JOIN worker w ON r.workerID=w.WorkerID INNER JOIN CLIENT c ON c.clientID=r.ClientID INNER JOIN Copy co ON \n"
                    + "(co.equipmentID,co.copyID)=(r.equipmentID,r.copyID) INNER JOIN equipment e ON r.equipmentID=e.equipmentID WHERE r.rentID= " + id;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer rid = rs.getInt("r.rentid");
                Date dateFrom = rs.getDate("r.DateFrom");
                Date dateTo = rs.getDate("r.DateTo");
                Worker worker = new Worker(rs.getInt("r.workerID"), rs.getString("w.username"), rs.getString("w.password"), rs.getString("w.name"), rs.getString("w.surname"), rs.getString("w.jmbg"));
                Equipment eq = new Equipment(rs.getInt("r.equipmentID"), rs.getString("e.connection"), rs.getString("e.specification"), rs.getString("e.name"));
                Copy co = new Copy(rs.getInt("r.CopyID"), rs.getBoolean("co.working"), rs.getBoolean("co.available"), eq, rs.getString("co.defect"));
                Client c = new Client(rs.getString("c.name"), rs.getString("c.surname"), rs.getString("c.jmbg"), rs.getInt("r.clientID"), rs.getString("c.phone"));
                rent = new Rent(rid, dateFrom, dateTo, c, co, worker);
            }
            rs.close();
            statement.close();

            return rent;
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }


    }

}
