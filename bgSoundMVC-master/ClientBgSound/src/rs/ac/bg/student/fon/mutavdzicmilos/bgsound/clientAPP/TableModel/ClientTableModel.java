/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ClientTableModel extends AbstractTableModel {

    private final String[] columns = new String[]{"ID", "NAME", "SURNAME"};
    private final Class[] classes = new Class[]{Integer.class, String.class, String.class};

    private final List<Client> clients;

    public ClientTableModel(List<Client> clients) {
        this.clients = clients;
    }
    public ClientTableModel(Client client){
        clients= new ArrayList<>();
        clients.add(client);
    }
    @Override
    public int getRowCount() {
         if (clients == null) {
            return 0;
        }
        return clients.size();
     
    }

    @Override
    public int getColumnCount() {
        
          return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (clients == null) {
            return null;
        }
        Client client = clients.get(rowIndex);
        if(client==null)return null;
        switch (columnIndex) {
            case 0:
                return client.getClientID();
            case 1:
                return client.getName();
            case 2:
                return client.getSurname();
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        if (column > columns.length) {
            return "n/a";
        }
        return columns[column];

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }
    public Client getClient(int row){
        if(clients==null||row<0)return null;
        return clients.get(row);
    }

}
