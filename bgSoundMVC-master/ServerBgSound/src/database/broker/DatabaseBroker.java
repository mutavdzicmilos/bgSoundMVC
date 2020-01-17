/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database.broker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.IGeneralObject;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.database.connection.ConnectionFactory;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class DatabaseBroker {

    public IGeneralObject save(IGeneralObject generalObject) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ")
                    .append(generalObject.getTableName())
                    .append(" (").append(generalObject.getColumnNamesForInsert()).append(")")
                    .append(" VALUES (")
                    .append(generalObject.getInsertValues())
                    .append(")");
            String query = sb.toString();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                generalObject.setId(id);
            }
        //    connection.commit();
            statement.close();
            return generalObject;

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
