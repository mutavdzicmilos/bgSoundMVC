/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic.ThreadSaver;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.TableModel.ClientTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FSearchClient;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model.ModelClient;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Mode;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerSearchClient {

    ModelClient model;
    FSearchClient view;

    public ControllerSearchClient() {
        view = new FSearchClient();
        ThreadSaver.getInstance().getFrames().add(view);
        view.setVisible(true);
        model = new ModelClient();

        view.addClientsFocusListener(new ClientsFocusListener());
        view.addIDFocusListener(new IDFocusListener());
        view.addNameFocusListener(new NameFocusListener());
        view.addNameActionListener(new NameActionListener());
        view.addbIDActionListener(new IDActionListener());
        view.addbViewActionListener(new ViewActionListener());
        fillform();
    }

    private class ViewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int number = view.gettClients().getSelectedRow();
            if (number < 0) {
                JOptionPane.showMessageDialog(null, "Please select the client", "Invalid selection", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ClientTableModel tm = (ClientTableModel) view.gettClients().getModel();
            Client client = tm.getClient(number);
            new ControllerNewClient(Mode.Mode_View, client);
            view.dispose();

        }
    }

    private class IDActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.gettID().getText().equals("")) {
                fillform();
                return;
            }
            try {
                Client client = model.getClientsByID(Integer.parseInt(view.gettID().getText().trim()));
                view.gettClients().setModel(new ClientTableModel(client));
                TableColumnModel tm = view.gettClients().getColumnModel();
                tm.getColumn(0).setMinWidth(50);
                tm.getColumn(0).setMaxWidth(50);
            } catch (Exception ex) {
                Logger.getLogger(FSearchClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class NameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.gettName().getText().equals("")) {
                fillform();
                return;
            }
            try {

                List<Client> clients = model.getClientsByName(view.gettName().getText().trim());
                view.gettClients().setModel(new ClientTableModel(clients));
                view.gettClients().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                TableColumnModel tm = view.gettClients().getColumnModel();
                tm.getColumn(0).setMinWidth(50);
                tm.getColumn(0).setMaxWidth(50);

            } catch (Exception ex) {

                if (!ex.getMessage().equals("")) {
                    Logger.getLogger(FSearchClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class NameFocusListener implements FocusListener {

        public NameFocusListener() {
        }

        @Override
        public void focusGained(FocusEvent e) {
            view.getbSearchByName().setEnabled(true);
            view.getbSearchByID().setEnabled(false);
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }

    private class IDFocusListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            view.getbSearchByName().setEnabled(false);
            view.getbSearchByID().setEnabled(true);
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }

    private class ClientsFocusListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            ClientTableModel tm = (ClientTableModel) view.gettClients().getModel();
            tm.fireTableDataChanged();
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }

    public void fillform() {
        view.setLocationRelativeTo(null);
        //popravi
        view.setIconImage(new ImageIcon("src\\resources\\BG_Sound.jpg").getImage());
        try {
            List<Client> clients = model.getAllClients();

            view.gettClients().setModel(new ClientTableModel(clients));
            view.gettClients().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            TableColumnModel tm = view.gettClients().getColumnModel();
            tm.getColumn(0).setMinWidth(50);
            tm.getColumn(0).setMaxWidth(50);
        } catch (Exception ex) {
            if (!ex.getMessage().equals("")) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

    }

}
