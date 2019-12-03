/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.impl;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageWorker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.database.connection.ConnectionFactory;

/**
 *
 * @author user
 */
public class StorageWorkerImpl implements StorageWorker {

    @Override
    public Worker checkWorker(Worker worker) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM worker where username=? and password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, worker.getUsername());
            preparedStatement.setString(2, worker.getPassword());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                worker.setWorkerID(rs.getInt("workerID"));
                worker.setJMBG(rs.getString("JMBG"));
                worker.setName(rs.getString("name"));
                worker.setSurname(rs.getString("surname"));
                rs.close();
                return worker;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new SQLException(ex.getMessage());
        }

        return worker;
    }

}
