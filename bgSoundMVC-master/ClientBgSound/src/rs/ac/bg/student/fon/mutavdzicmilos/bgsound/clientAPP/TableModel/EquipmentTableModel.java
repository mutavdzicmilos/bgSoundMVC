/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class EquipmentTableModel extends AbstractTableModel{
    private final String[] columns = new String[]{"ID", "NAME"};
    private final Class[] classes = new Class[]{Integer.class, String.class};

    public EquipmentTableModel(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    private final List<Equipment> equipments;

   
    
    
    @Override
    public int getRowCount() {
         if (equipments == null) {
            return 0;
        }
        return equipments.size();
     
    }

    @Override
    public int getColumnCount() {
        
          return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (equipments == null) {
            return null;
        }
       Equipment client = equipments.get(rowIndex);
        if(client==null)return null;
        switch (columnIndex) {
            case 0:
                return client.getEquipmentID();
            case 1:
                return client.getName();
           
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
    public Equipment getEquipment(int row){
        if(equipments==null||row<0)return null;
        return equipments.get(row);
    }
}
