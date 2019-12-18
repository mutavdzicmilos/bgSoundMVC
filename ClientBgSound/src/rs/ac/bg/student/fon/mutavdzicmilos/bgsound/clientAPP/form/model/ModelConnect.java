/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic.ThreadSaver;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ModelConnect {

    public void connect(String ip, int port) throws Exception {
        try {
            Socket socket = new Socket(ip, port);
            ThreadSaver.getInstance().setSocket(socket);
           
            JOptionPane.showMessageDialog(null, "Connection success!\nPlease now type your login information.");

        } catch (HeadlessException | IOException e) {
            throw new Exception("Unable to connect.");
        }
    }

}
