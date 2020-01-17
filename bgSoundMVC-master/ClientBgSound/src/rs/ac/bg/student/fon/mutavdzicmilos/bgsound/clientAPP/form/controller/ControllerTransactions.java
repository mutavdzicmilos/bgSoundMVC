/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.controller;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic.ThreadSaver;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.TableModel.RentTransTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FTransactions;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model.ModelTransactions;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerTransactions {

    ModelTransactions model;
    FTransactions view;
    int clientID;

    public ControllerTransactions(int clientID) {
        view = new FTransactions();
        this.clientID = clientID;
        ThreadSaver.getInstance().getFrames().add(view);
        model = new ModelTransactions();
        view.setVisible(true);
        fillForm();

    }

    private void fillForm() {
        try {
            view.gettClients().setModel(new RentTransTableModel(model.getAllClient(clientID)));
        } catch (Exception ex) {
            if (!ex.getMessage().equals("")) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        view.gettClients().getColumnModel().getColumn(0).setMinWidth(30);
        view.gettClients().getColumnModel().getColumn(0).setMaxWidth(30);
        view.gettClients().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }


}
