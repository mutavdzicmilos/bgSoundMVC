/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.TableModel.EquipmentTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FFindEq;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model.ModelFindEq;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerFindEq {

    ModelFindEq model;
    FFindEq view;

    public ControllerFindEq(ControllerEquipment c) {
        view = new FFindEq();
        model = new ModelFindEq();
        view.setVisible(true);
        fillForm();
        view.addSelectActionListener(new SelectActionListener(c));

    }

    private void fillForm() {
        try {
            view.gettEq().setModel(new EquipmentTableModel(model.getAllEquipment()));
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        view.gettEq().getColumnModel().getColumn(0).setMinWidth(30);
        view.gettEq().getColumnModel().getColumn(0).setMaxWidth(30);
        view.gettEq().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private class SelectActionListener implements ActionListener {

        ControllerEquipment c;

        public SelectActionListener(ControllerEquipment c) {
            this.c = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int ex = view.gettEq().getSelectedRow();
            EquipmentTableModel modele = (EquipmentTableModel) view.gettEq().getModel();
            if (ex == -1) {
                JOptionPane.showMessageDialog(null, "Please select the equipment", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Equipment eq = modele.getEquipment(ex);
            try {
                eq.setCopies(model.getCopies(eq.getEquipmentID()));
            } catch (Exception ex1) {
               JOptionPane.showMessageDialog(null, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          }
            c.set(eq);
            view.dispose();
        }
    }

}
