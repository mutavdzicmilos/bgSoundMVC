/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.form.ServerForm;

/**
 *
 * @author user
 */
public class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private ServerForm form;

    public ServerThread(ServerSocket serverSocket,ServerForm form) {
        this.serverSocket = serverSocket;
        this.form=form;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                System.out.println("Waiting for client");
                Socket socket = serverSocket.accept();
                System.out.println("Connected");
                ClientThread client = new ClientThread(this, socket);
                client.start();

            } catch (IOException ex) {
                System.out.println("Server error line 40 serverThread ");
            }
        }
    }

    public void killClients() {
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public ServerForm getForm() {
        return form;
    }

    public void setForm(ServerForm form) {
        this.form = form;
    }
}
