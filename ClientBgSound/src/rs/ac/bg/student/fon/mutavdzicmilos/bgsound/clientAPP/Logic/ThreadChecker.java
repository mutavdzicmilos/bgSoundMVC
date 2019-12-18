/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic;

import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ThreadChecker extends Thread {

    Socket socket;
    ObjectInputStream input;

    public ThreadChecker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                input = new ObjectInputStream(socket.getInputStream());
                sleep(1000);
            }

        } catch (Exception ex) {
            System.out.println("here123");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in communication.Check server,and try again");
            System.exit(0);
        }
    }

}
