/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.TableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class CopyTableModel extends AbstractTableModel {

    private final String[] columns = new String[]{"Eq.ID", "Name", "Connection", "Specification", "Copy ID",};
    private final Class[] classes = new Class[]{Integer.class, String.class, String.class, String.class, Integer.class};

    private final List<Copy> copies;

    public CopyTableModel(List<Copy> copies) {
        if (copies == null) {
            copies = new ArrayList<>();
        }
        this.copies = copies;
    }

    @Override
    public int getRowCount() {
        if (copies == null) {
            return 0;
        }
        return copies.size();

    }

    @Override
    public int getColumnCount() {

        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (copies == null) {
            return null;
        }
        Copy copy = copies.get(rowIndex);
        if (copy == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return copy.getEquipment().getEquipmentID();
            case 1:
                return copy.getEquipment().getName();
            case 2:
                return copy.getEquipment().getConnection();
            case 3:
                return copy.getEquipment().getSpecification();
            case 4:
                return copy.getCopyID();
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

    public Copy getCopy(int row) {
        if (copies == null || row < 0) {
            return null;
        }
        return copies.get(row);
    }

    public void setCopy(Copy copy) {
        copies.add(copy);
        fireTableDataChanged();
    }

    public void removeCopy(int index) {
        copies.remove(index);
        fireTableDataChanged();
    }

    public List<Copy> getAll() {
        return copies;
    }
}
