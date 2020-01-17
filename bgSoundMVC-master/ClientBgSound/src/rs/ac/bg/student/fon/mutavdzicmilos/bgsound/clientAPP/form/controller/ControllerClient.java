/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic.ThreadSaver;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FClient;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Mode;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerClient {
    
    FClient view;
    
    public ControllerClient() {
        view = new FClient();
        ThreadSaver.getInstance().getFrames().add(view);
        view.setVisible(true);
                
        view.addNewClientListener(new ClientListener(Mode.Mode_Add));
        view.addRentListener(new RentListener());
        view.addDischargeListener(new DischargeListener());
        view.addNewEquipmentListener(new NewEquipmentListener(Mode.Mode_Add));
        view.addSearchClientListener(new SearchClientListener());
        view.addSearchEquipmentListener(new NewEquipmentListener(Mode.Mode_View));
    }
    
    private static class ClientListener implements ActionListener {
        
        Mode mode;
        
        private ClientListener(Mode mode) {
            this.mode = mode;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerNewClient(mode,null);
            
        }
    }
    
    private static class RentListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerRent();
        }
    }
    
    private static class DischargeListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerDischarge();
        }
    }
    
    private static class NewEquipmentListener implements ActionListener {
        
        Mode mode;
        
        private NewEquipmentListener(Mode mode) {
            this.mode = mode;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerEquipment(mode);
        }
    }

    private static class SearchClientListener implements ActionListener {
 
        @Override
        public void actionPerformed(ActionEvent e) {
            new ControllerSearchClient();
        }
    }
    
}
