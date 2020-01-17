/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.so;

import database.broker.DatabaseBroker;
import java.sql.SQLException;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.database.connection.ConnectionFactory;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public abstract class AbstractGenericOperation {

    protected DatabaseBroker databaseBroker;

    public AbstractGenericOperation() {
        databaseBroker = new DatabaseBroker();
    }

    public final Object execute(Object entity) throws Exception {
        try {
            preconditions(entity);
            startTransaction();
            Object result = executeOperation(entity);
            commitTransaction();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        }
    }

    protected abstract void preconditions(Object entity) throws Exception;

    private void startTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().setAutoCommit(false);
    }

    protected abstract Object executeOperation(Object entity) throws Exception;

    private void commitTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().commit();
    }

    private void rollbackTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().rollback();
    }

}
