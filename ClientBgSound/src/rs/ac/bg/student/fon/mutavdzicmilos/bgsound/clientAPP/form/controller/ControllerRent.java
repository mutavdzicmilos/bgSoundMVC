/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.TableModel.CopyTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FRent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model.ModelRent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerRent {

    FRent view;
    ModelRent model;

    public ControllerRent() {
        view = new FRent();
        model = new ModelRent();
        fillform();
        view.setVisible(true);
        view.addRentActionListener(new RentListener());
        view.addSelectActionListener(new SelectListener());
        view.addRemoveActionListener(new RemoveListener());
        view.addSetActionListener(new SetActionListener());
    }

    public void setIndex(int index) {
        view.getcClientChoose().setSelectedIndex(index);
    }

    private void fillform() {
        try {
            List<Client> clients = model.getAllClients();
            for (Client c : clients) {
                view.getcClientChoose().addItem(c);
            }
            view.getcClientChoose().setSelectedIndex(-1);
            view.gettChoose().setModel(new CopyTableModel(model.getAllCopies()));
            view.gettRent().setModel(new CopyTableModel(null));
            view.gettChoose().getColumnModel().getColumn(0).setPreferredWidth(30);
            view.gettChoose().getColumnModel().getColumn(4).setPreferredWidth(30);
            view.gettRent().getColumnModel().getColumn(0).setPreferredWidth(30);
            view.gettRent().getColumnModel().getColumn(4).setPreferredWidth(30);
            view.gettRent().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            view.gettChoose().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
        }

    }

    private ControllerRent returnCont() {
        return this;
    }

    private class SetActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerFindClient(returnCont());
        }
    }

    private class RemoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.gettRent().getSelectedRow() == -1) {
                return;
            }
            CopyTableModel tm = (CopyTableModel) view.gettChoose().getModel();
            CopyTableModel tc = (CopyTableModel) view.gettRent().getModel();
            Copy c = tm.getCopy(view.gettRent().getSelectedRow());
            tm.setCopy(c);
            tc.removeCopy(view.gettRent().getSelectedRow());

        }
    }

    private class RentListener implements ActionListener {

        public RentListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (view.getcClientChoose().getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "Please choose client");
                    return;
                }
                Client client = (Client) view.getcClientChoose().getSelectedItem();
                List<Copy> copies = ((CopyTableModel) view.gettRent().getModel()).getAll();
                if (copies == null || copies.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Please choose copies to rent");
                    return;
                }
                List<Rent> rents = new ArrayList<>();
                for (Copy c : copies) {
                    Rent r = new Rent();
                    r.setClient(client);
                    r.setCopy(c);
                    r.setDateFrom(new Date());
                    rents.add(r);
                }
                model.saveRents(rents);
                JOptionPane.showMessageDialog(null, "Success");
                fillform();
                return;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                fillform();
            }
        }
    }

    private class SelectListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.gettChoose().getSelectedRow() == -1) {
                return;
            }
            CopyTableModel tm = (CopyTableModel) view.gettChoose().getModel();
            CopyTableModel tc = (CopyTableModel) view.gettRent().getModel();
            Copy c = tm.getCopy(view.gettChoose().getSelectedRow());
            tc.setCopy(c);
            tm.removeCopy(view.gettChoose().getSelectedRow());
        }
    }

}
