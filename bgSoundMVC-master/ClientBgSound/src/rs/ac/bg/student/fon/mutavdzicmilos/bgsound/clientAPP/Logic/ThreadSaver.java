/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.controller.ControllerConnect;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ThreadSaver {

    private static ThreadSaver instance;

    private Socket socket;
    private Map<String, Object> hashmap;
    private static List<JFrame> frames;

    public static List<JFrame> getFrames() {
        return frames;
    }

    public static ThreadSaver getInstance() {
        if (instance == null) {
            instance = new ThreadSaver();
            frames = new ArrayList<>();
        }
        return instance;
    }

    private ThreadSaver() {
        hashmap = new HashMap<>();

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;

    }

    public Map<String, Object> getHashmap() {
        return hashmap;
    }

    public void setHashmap(Map<String, Object> hashmap) {
        this.hashmap = hashmap;
    }

    public void closeApp() throws InterruptedException {
        for (JFrame f : frames) {
            f.dispose();

        }
        frames = new ArrayList<>();
        new ControllerConnect();
    }

}
