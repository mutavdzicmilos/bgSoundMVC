/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.TableModel.ClientTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FFindClient;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model.ModelFindClient;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerFindClient {

    ModelFindClient model;
    FFindClient view;
    public ControllerFindClient(ControllerRent e) {
        model = new ModelFindClient();
        view = new FFindClient();
        view.setVisible(true);
        fillform();
        view.addSelectListener(new SelectListener(e));
    }

    private void fillform() {
        try {
            view.gettClients().setModel(new ClientTableModel(model.getAllClients()));
        } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
               
        }
        view.gettClients().getColumnModel().getColumn(0).setMinWidth(30);
        view.gettClients().getColumnModel().getColumn(0).setMaxWidth(30);
        view.gettClients().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private class SelectListener implements ActionListener {

        ControllerRent cont;

        public SelectListener(ControllerRent e) {
            cont = e;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.gettClients().getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select the client");
            return;
        }
            cont.setIndex(view.gettClients().getSelectedRow());
            view.dispose();

        }
    }

}
