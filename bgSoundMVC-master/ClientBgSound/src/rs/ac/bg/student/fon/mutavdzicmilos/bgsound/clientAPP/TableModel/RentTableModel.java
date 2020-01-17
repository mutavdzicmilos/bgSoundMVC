/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.TableModel;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class RentTableModel extends AbstractTableModel {

    private final String[] columns = new String[]{"ID", "NAME", "SURNAME", "EQID", "COID", "DATE FROM"};
    private final Class[] classes = new Class[]{Integer.class, String.class, String.class, Integer.class, Integer.class, Date.class};

    public RentTableModel(List<Rent> rents) {
        this.rents = rents;
    }

    private final List<Rent> rents;

    @Override
    public int getRowCount() {
        if (rents == null) {
            return 0;
        }
        return rents.size();

    }

    @Override
    public int getColumnCount() {

        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rents == null) {
            return null;
        }
        Rent client = rents.get(rowIndex);
        if (client == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                
                return client.getRentID();
            case 1:
                return client.getClient().getName();
            case 2:
                return client.getClient().getSurname();
            case 3:
                return client.getCopy().getEquipment().getEquipmentID();
            case 4:
                return client.getCopy().getCopyID();
            case 5:
                return client.getDateFrom();
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

    public Rent getRent(int row) {
        if (rents == null || row < 0) {
            return null;
        }
        return rents.get(row);
    }

    public void addRent(Rent rent) {
        rents.add(rent);
        fireTableDataChanged();
    }

    public void removeRent(int index) {
        rents.remove(index);
        fireTableDataChanged();
    }

    public List<Rent> getAll() {
        return rents;
    }
}
