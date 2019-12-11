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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FEquipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model.ModelEquipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Mode;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerEquipment {

    ModelEquipment model;
    FEquipment view;

    ControllerEquipment(Mode mode) {

        view = new FEquipment();

        model = new ModelEquipment();
        fillForm(mode);
        view.setVisible(true);
        view.addCancelListener(new CancelListener());
        view.addResetEqListener(new ResetEqListener());
        view.addSaveEqListener(new SaveEqListener());
        view.addEnableChangesListener(new EnableChangesListener());
        view.addUpdateCopyListener(new UpdateCopyListener());
        view.addDeleteCopyListener(new DeleteCopyListener());
        view.addRWFalseListener(new RWFalseListener());
        view.addtDefectFocusGained(new DefectListener());
        view.addRWtrueActionListener(new RWActionListener());
        view.addFindActionListener(new FindActionListener());

    }
    private ControllerEquipment returnThis(){
        return this;
    }
    private class FindActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerFindEq(returnThis());
        }
    }
    
    private class RWActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.gettDefect().setText("");
            view.gettDefect().setEditable(false);
        }

    }

    private class DefectListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            view.getrWFalse().setSelected(true);
        }

        @Override
        public void focusLost(FocusEvent e) {
        }

    }

    private class RWFalseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.gettDefect().setEditable(true);
        }
    }

    private class DeleteCopyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getcCopyChooser().getItemCount() == 0) {
                return;
            }
            int eID = Integer.parseInt(view.gettID().getText());
            int cID = Integer.parseInt(view.getcCopyChooser().getSelectedItem().toString());
            Copy c = new Copy(cID, eID);
            boolean help = model.deleteCopy(c);
            if (help) {
                JOptionPane.showMessageDialog(null, "Success");
                view.getcCopyChooser().removeItemAt(view.getcCopyChooser().getSelectedIndex());
                if (view.getcCopyChooser().getItemCount() == 0) {
                    view.getjCopyPanel().setVisible(false);
                }
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Error delete!Check if equipment is rented!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

    }

    private class UpdateCopyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.getcCopyChooser().getItemCount() == 0) {
                return;
            }
            int eID = Integer.parseInt(view.gettID().getText());
            int cID = Integer.parseInt(view.getcCopyChooser().getSelectedItem().toString());

            Copy c = new Copy(cID, view.getrWTrue().isSelected(), view.getrATrue().isSelected(), new Equipment(eID), view.gettDefect().getText().trim());
            boolean help = model.updateCopy(c);
            if (help) {
                JOptionPane.showMessageDialog(null, "Success");
                view.getcCopyChooser().removeItemAt(view.getcCopyChooser().getSelectedIndex());
                if (view.getcCopyChooser().getItemCount() == 0) {
                    view.getjCopyPanel().setVisible(false);
                }
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Error update!Check equipment!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

    }

    private class EnableChangesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fillForm(Mode.Mode_Update);
        }

    }

    private class SaveEqListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ex) {
            String name = view.gettName().getText().trim();
            String specification = view.gettSpecification().getText().trim();
            String connection = view.gettConnection().getText().trim();
            int copiesNo = Integer.valueOf(view.gettNumber().getValue().toString());

            if (name.equals("") || specification.equals("") || connection.equals("")) {
                JOptionPane.showMessageDialog(null, "Error input.Check values.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            List<Copy> copies = new ArrayList<>();
            for (int i = 0; i < copiesNo; i++) {
                copies.add(new Copy(i, true, true, null, null));

            }
            Equipment e = model.saveEquipment(new Equipment(connection, specification, name, copies));

            if (e != null) {
                JOptionPane.showMessageDialog(null, "Saved sucessfully");
                set(e);
            }

        }

    }

    public void set(Equipment e) {
        if (e == null) {
            return;
        }
        view.getbSaveEq().setVisible(false);
        view.getbReset().setVisible(false);
        view.getbCancel().setVisible(false);
        view.getcCopyChooser().removeAllItems();
        view.gettID().setText(e.getEquipmentID().toString());
        view.gettID().setEditable(false);
        view.gettName().setText(e.getName());
        view.gettName().setEditable(false);
        view.gettConnection().setText(e.getConnection());
        view.gettConnection().setEditable(false);
        view.gettSpecification().setText(e.getSpecification());
        view.gettSpecification().setEditable(false);
        view.getjLabel6().setVisible(false);
        view.gettNumber().setVisible(false);
        if (e.getCopies() == null || e.getCopies().size() == 0) {
            view.getjCopyPanel().setVisible(false);
            return;
        } else {
            view.getjCopyPanel().setVisible(true);
            view.getbEnableChanges().setVisible(true);
            view.getbDeleteCopy().setVisible(false);
            view.getbUpdateCopy().setVisible(false);
            for (Copy c : e.getCopies()) {
                view.getcCopyChooser().addItem(c.getCopyID().toString());

            }
        }
        view.getrATrue().setSelected(e.getCopies().get(0).getAvailable());
        view.getrWTrue().setSelected(e.getCopies().get(0).getWorking());
        view.gettDefect().setText(e.getCopies().get(0).getDefect());
        view.gettDefect().setEnabled(false);
        view.getrATrue().setEnabled(false);
        view.getrWTrue().setEnabled(false);
        view.getrAFalse().setEnabled(false);
        view.getrWFalse().setEnabled(false);
    }

    private class ResetEqListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.gettName().setText("");
            view.gettSpecification().setText("");
            view.gettConnection().setText("");
            view.gettNumber().setValue(0);
        }
    }

    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
        }
    }

    public void fillForm(Mode mode) {
        if (mode == Mode.Mode_Add) {
            view.gettConnection().setEditable(true);
            view.gettDefect().setEditable(true);
            view.getbFind().setVisible(false);
            view.gettName().setEditable(true);
            view.gettID().setEditable(false);
            view.getbSaveEq().setVisible(true);
            view.getbCancel().setVisible(true);
            view.getbReset().setVisible(true);
            view.getjCopyPanel().setVisible(false);
            view.getbEnableChanges().setVisible(false);
            return;
        }
        if (mode == Mode.Mode_View) {
            view.gettConnection().setEditable(false);
            view.gettDefect().setEditable(false);
            view.getbFind().setVisible(true);
            view.gettName().setEditable(false);
            view.gettID().setEditable(false);
            view.getbSaveEq().setVisible(false);
            view.getbCancel().setVisible(true);
            view.gettSpecification().setEditable(false);
            view.getbReset().setVisible(false);
            view.getjCopyPanel().setVisible(false);
            view.gettNumber().setEnabled(false);
            view.getbEnableChanges().setVisible(false);
            view.getrATrue().setEnabled(false);
            view.getrAFalse().setEnabled(false);
            view.getrWTrue().setEnabled(false);
            view.getrWFalse().setEnabled(false);
            return;
        }
        if (mode == Mode.Mode_Update) {
            view.gettConnection().setEditable(false);
            view.gettDefect().setEditable(true);
            view.gettDefect().setEnabled(true);
            view.getbFind().setVisible(true);
            view.gettName().setEditable(false);
            view.gettSpecification().setEditable(false);
            view.gettID().setEditable(false);
            view.getbSaveEq().setVisible(false);
            view.getbCancel().setVisible(true);
            view.getbReset().setVisible(false);
            view.getjCopyPanel().setVisible(true);
            view.gettNumber().setEnabled(false);
            view.getbUpdateCopy().setVisible(true);
            view.getbDeleteCopy().setVisible(true);
            view.getbEnableChanges().setVisible(false);
            view.getrATrue().setEnabled(true);
            view.getrAFalse().setEnabled(true);
            view.getrWTrue().setEnabled(true);
            view.getrWFalse().setEnabled(true);
            view.gettDefect().setEditable(true);
            return;
        }
    }
}