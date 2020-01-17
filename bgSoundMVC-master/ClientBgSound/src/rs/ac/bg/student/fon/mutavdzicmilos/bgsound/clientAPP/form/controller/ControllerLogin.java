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
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.FLogin;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model.ModelLogin;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.password.Password;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ControllerLogin {

    FLogin view;
    ModelLogin model;

    public ControllerLogin() {
        view = new FLogin();
 ThreadSaver.getInstance().getFrames().add(view);
        model = new ModelLogin();
        view.setVisible(true);
        view.addLoginListener(new LoginListener());
         view.addKeyListener(new EnterListener());

    }
     private  class EnterListener implements KeyListener {

       
        @Override
        public void keyTyped(KeyEvent e) {
             
        }

        @Override
        public void keyPressed(KeyEvent e) {
          if(e.getKeyCode()==KeyEvent.VK_ENTER)
              view.getbLogin().doClick();
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    private class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.gettUsername().getText().trim();
            String password = Password.generate(String.valueOf(view.gettPassword().getPassword()), "password");
            try {
                model.login(username, password);
                JOptionPane.showMessageDialog(null, "Succesfully logged");
                new ControllerClient();
                view.dispose();
            } catch (Exception ex) {
                 if(!ex.getMessage().equals(""))
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }

}
