/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic.ThreadSaver;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FNewClient;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model.ModelClient;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Mode;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerNewClient {

    ModelClient model;
    FNewClient view;
    int id;

    ControllerNewClient(Mode mode, Client client) {
        view = new FNewClient(mode);
        ThreadSaver.getInstance().getFrames().add(view);
        model = new ModelClient();
        id = -1;
        view.setVisible(true);
        view.addCancelListener(new CancelListener());
        view.addResetListener(new ResetListener());
        view.addEnableChangesListener(new EnableChangesListener());
        view.addUpdateClientListener(new UpdateListener());
        view.addSaveClientListener(new SaveClientListener());
        view.addDeleteClientListener(new DeleteListener());
        view.addTransactionsListener(new TransactionsListener());
        fillForm(mode, client);
    }

    private void fillForm(Mode mode, Client client) {
        if (client != null) {
            id = client.getClientID();
            view.gettID().setText(client.getClientID().toString());
            view.gettJMBG().setText(client.getJMBG());
            view.gettName().setText(client.getName());
            view.gettSurname().setText(client.getSurname());
            view.gettPhone().setText(client.getPhone());
        }
        if (mode == Mode.Mode_Add) {
            view.gettID().setEditable(false);
            view.getjNew().setVisible(true);
            view.getbCancel().setVisible(true);
            view.gettJMBG().setEditable(true);
            view.getbReset().setVisible(true);
            view.gettPhone().setEditable(true);
            view.getbSave().setVisible(true);
            view.gettSurname().setEditable(true);
            view.getbDelete().setVisible(false);
            view.getbTransactions().setVisible(false);
            view.getbEnableChanges().setVisible(false);

            view.getbUpdate().setVisible(false);
            return;
        }
        if (mode == Mode.Mode_Update) {
            view.gettID().setEditable(false);
            view.gettJMBG().setEditable(true);
            view.gettName().setEditable(true);
            view.gettPhone().setEditable(true);
            view.gettSurname().setEditable(true);
            view.getbTransactions().setVisible(true);

            view.getjNew().setVisible(false);
            view.getbCancel().setVisible(true);

            view.getbReset().setVisible(false);

            view.getbSave().setVisible(false);

            view.getbDelete().setVisible(true);

            view.getbEnableChanges().setVisible(false);

            view.getbUpdate().setVisible(true);
            return;
        }
        if (mode == Mode.Mode_View) {
            view.gettID().setEditable(false);
            view.gettJMBG().setEditable(false);
            view.gettName().setEditable(false);
            view.gettPhone().setEditable(false);
            view.gettSurname().setEditable(false);
            view.getbTransactions().setVisible(true);
            view.getjNew().setVisible(false);
            view.getbCancel().setVisible(true);

            view.getbReset().setVisible(false);

            view.getbSave().setVisible(false);

            view.getbDelete().setVisible(false);

            view.getbEnableChanges().setVisible(true);

            view.getbUpdate().setVisible(false);
        }
    }

    private class TransactionsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (id != -1) {
                new ControllerTransactions(id);
            }
        }
    }

    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(view.gettID().getText().trim());

            try {
                model.deleteClient(new Client(id));
                JOptionPane.showMessageDialog(null, "Client deleted sucessfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                new ControllerSearchClient();
                view.dispose();
            } catch (Exception ex) {
                if (!ex.getMessage().equals("")) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "PROBLEM", JOptionPane.ERROR_MESSAGE);
                }
                view.dispose();
            }

        }

    }

    private class SaveClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.gettName().getText().trim();
            String jmbg = view.gettJMBG().getText().trim();
            String surname = view.gettSurname().getText().trim();
            String phone = view.gettPhone().getText().trim();
            Client client = new Client(name, surname, jmbg, phone);
            Client help;
            try {
                help = model.saveClient(client);
                JOptionPane.showMessageDialog(null, "Client saved sucessfully!");

                view.gettID().setText(help.getClientID().toString());
            } catch (Exception ex) {
                if (!ex.getMessage().equals("")) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "PROBLEM", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(view.gettID().getText().trim());
                String name = view.gettName().getText().trim();
                String jmbg = view.gettJMBG().getText().trim();
                String surname = view.gettSurname().getText().trim();
                String phone = view.gettPhone().getText().trim();
                Client client = new Client(name, surname, jmbg, id, phone);
                model.updateClient(client);
                JOptionPane.showMessageDialog(null, "Client updated sucessfully");
                new ControllerSearchClient();
                view.dispose();

            } catch (Exception ex) {

                if (!ex.getMessage().equals("")) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "PROBLEM", JOptionPane.ERROR_MESSAGE);
                }
                view.dispose();
            }

        }

    }

    private class EnableChangesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fillForm(Mode.Mode_Update, null);
        }
    }

    private class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.gettName().setText("");
            view.gettSurname().setText("");
            view.gettJMBG().setText("");
            view.gettPhone().setText("");
        }

    }

    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
        }

    }

}
