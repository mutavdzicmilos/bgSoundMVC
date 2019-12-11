/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.TableModel.RentTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FDischarge;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model.ModelDischarge;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerDischarge {

    ModelDischarge model;
    FDischarge view;

    public ControllerDischarge() {
        view = new FDischarge();
        model = new ModelDischarge();
        view.setVisible(true);
        view.addDeselectListener(new DeselectListener());
        view.addDischargeListener(new DischargeListener());
        view.addSelectListener(new SelectListener());
        view.addDischargeMouseClicked(new DischargeMouseClicked());
        view.addRentsMouseClicked(new RentsMouseClicked());
        fillForm();
        setTable();
    }

    private class DeselectListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.gettDischarge().getSelectedRow() == -1) {
                return;
            }
            RentTableModel rt = (RentTableModel) view.gettRents().getModel();

            RentTableModel dt = (RentTableModel) view.gettDischarge().getModel();
            rt.addRent(dt.getRent(view.gettDischarge().getSelectedRow()));
            dt.removeRent(view.gettDischarge().getSelectedRow());
            setTable();
        }
    }

    private class DischargeListener implements ActionListener {

        public DischargeListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int dialog = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog(null, "Do you want do discharge selected rents", "Confirmation", dialog);
            if (dialog == JOptionPane.YES_OPTION) {
                RentTableModel rt = (RentTableModel) view.gettDischarge().getModel();
                List<Rent> rents = rt.getAll();
                if (rents == null || rents.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Please,select the rents.");
                    return;
                }
                boolean help = model.dischargeAll(rents);
                if (help) {
                    JOptionPane.showMessageDialog(null, "Successfully discharged");
                    fillForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Error discharging");
                    fillForm();
                }
            }

        }
    }

    private class SelectListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            RentTableModel rt = (RentTableModel) view.gettRents().getModel();

            RentTableModel dt = (RentTableModel) view.gettDischarge().getModel();
            dt.addRent(rt.getRent(view.gettRents().getSelectedRow()));
            rt.removeRent(view.gettRents().getSelectedRow());
            view.getpRent().setVisible(false);
            setTable();
        }
    }

    private class DischargeMouseClicked implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int br = view.gettDischarge().getSelectedRow();
            if (br == -1) {
                view.getbDeselect().setEnabled(false);
                return;
            }
            view.getbDeselect().setEnabled(true);
            setTable();

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class RentsMouseClicked implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int br = view.gettRents().getSelectedRow();
            if (br == -1) {
                view.getpRent().setVisible(false);
                return;
            }
            int tm = (int) view.gettRents().getModel().getValueAt(br, 0);

            Rent help = model.getRentByID(tm);
            if (help != null && help.getCopy() != null && help.getCopy() != null && help.getCopy().getEquipment() != null) {
                view.gettRentID().setText(String.valueOf(help.getRentID()));
                view.gettCoID().setText(String.valueOf(help.getCopy().getCopyID()));
                view.gettEID().setText(String.valueOf(help.getCopy().getEquipment().getEquipmentID()));
                view.gettCID().setText(String.valueOf(help.getClient().getClientID()));
                view.gettCName().setText(help.getClient().getName());
                view.gettSurname().setText(help.getClient().getSurname());
                view.gettDateRented().setText(String.valueOf(help.getDateFrom()));
                view.gettEName().setText(help.getCopy().getEquipment().getName());
                view.getpRent().setVisible(true);
            }
            setTable();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public void fillForm() {
        try {

            view.gettDischarge().setModel(new RentTableModel(new ArrayList<>()));
            view.gettDischarge().getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            view.gettRents().setModel(new RentTableModel(model.getAllRents()));
            view.gettRents().getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            view.gettDischarge().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            view.gettRents().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            setTable();
            view.getpRent().setVisible(false);
            view.getbDeselect().setEnabled(false);
            view.gettCID().setEditable(false);
            view.gettCName().setEditable(false);
            view.gettCoID().setEditable(false);
            view.gettDateRented().setEditable(false);
            view.gettEID().setEditable(false);
            view.gettEName().setEditable(false);
            view.gettRentID().setEditable(false);
            view.gettSurname().setEditable(false);
        } catch (Exception ex) {
            Logger.getLogger(FDischarge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setTable() {
        view.gettDischarge().getColumnModel().getColumn(0).setMinWidth(30);
        view.gettDischarge().getColumnModel().getColumn(0).setMaxWidth(30);
        view.gettDischarge().getColumnModel().getColumn(3).setMinWidth(60);
        view.gettDischarge().getColumnModel().getColumn(3).setMaxWidth(60);
        view.gettDischarge().getColumnModel().getColumn(4).setMinWidth(60);
        view.gettDischarge().getColumnModel().getColumn(4).setMaxWidth(60);
        view.gettRents().getColumnModel().getColumn(0).setMinWidth(30);
        view.gettRents().getColumnModel().getColumn(0).setMaxWidth(30);
        view.gettRents().getColumnModel().getColumn(3).setMinWidth(60);
        view.gettRents().getColumnModel().getColumn(3).setMaxWidth(60);
        view.gettRents().getColumnModel().getColumn(4).setMinWidth(60);
        view.gettRents().getColumnModel().getColumn(4).setMaxWidth(60);
    }
}
