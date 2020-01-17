/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic.ThreadSaver;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FConnect;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model.ModelConnect;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerConnect {

    FConnect view;
    ModelConnect model;

    public ControllerConnect() {
        view = new FConnect();
         ThreadSaver.getInstance().getFrames().add(view);
        view.setVisible(true);
        model = new ModelConnect();

        view.addConnectListener(new ConnectListener());
        view.addKeyListener(new EnterListener());

    }

    private  class EnterListener implements KeyListener {

       
        @Override
        public void keyTyped(KeyEvent e) {
             
        }

        @Override
        public void keyPressed(KeyEvent e) {
          if(e.getKeyCode()==KeyEvent.VK_ENTER)
              view.getbConnect().doClick();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    private class ConnectListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int port = Integer.parseInt(view.getTextFieldPort().getText().trim());
                String ip = (view.getTextFieldIP().getText().trim());
                model.connect(ip, port);
                
                view.dispose();
                new ControllerLogin();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

    }
}
