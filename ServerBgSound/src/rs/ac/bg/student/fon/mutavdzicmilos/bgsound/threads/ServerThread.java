/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.form.ServerForm;

/**
 *
 * @author user
 */
public class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private ServerForm form;
    private int port;
    private List<ClientThread> clients;

    public ServerThread(int port, ServerForm form) {
        this.form = form;
        this.port = port;
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (!isInterrupted() && serverSocket != null) {

                System.out.println("Waiting for client");
                Socket socket = serverSocket.accept();
                System.out.println("Connected");
                ClientThread client = new ClientThread(this, socket);
                clients.add(client);
                client.start();
            }
        } catch (IOException ex) {
            killClients();
        }
    }

    public void killClients() {
        for (ClientThread c : clients) {
            try {
                c.socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    public List<ClientThread> getClients() {
        return clients;
    }

    public void setClients(List<ClientThread> clients) {
        this.clients = clients;
    }
}
