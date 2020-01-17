package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.tableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;

/**
 *
 * @author milos
 */
public class WorkerTableModel extends AbstractTableModel {

    private final List<Worker> workers;
    private final String[] columnNames = new String[]{"ID", "NAME", "SURNAME"};
    private final Class[] columnClasses = new Class[]{Integer.class, String.class, String.class};

    public List<Worker> getWorkers() {
        return workers;
    }

    public WorkerTableModel() {
        this.workers = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if (workers == null) {
            return 0;
        }
        return workers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Worker worker = workers.get(row);
        switch (column) {
            case 0:
                return worker.getWorkerID();
            case 1:
                return worker.getName();
            case 2:
                return worker.getSurname();

            default:
                return "n/a";
        }
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
        fireTableDataChanged();
    }

    public void removeWorker(Worker worker) {
        workers.remove(worker);
        fireTableDataChanged();
    }

    public Worker getWorker(int index) {
        if (index >= workers.size()) {
            return null;
        }
        return workers.get(index);
    }

    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }

        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        Worker worker = workers.get(row);
        switch (column) {
            case 0:
                break;
            case 1:
                worker.setName(value.toString());
                break;
            case 2:
                worker.setSurname(value.toString());
                break;
        }
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return columnClasses[column];
    }

}
