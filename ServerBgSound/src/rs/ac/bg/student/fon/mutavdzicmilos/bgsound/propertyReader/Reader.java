/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.propertyReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.controller.ServerController;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.form.ServerForm;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class Reader {

    public static void read() {
        try {
            Properties prop = new Properties();

            prop.load(new FileInputStream("src\\resources\\config.properties"));
            ServerController.getInstance().getHashmap().put("db.url", prop.getProperty("db.url"));
            ServerController.getInstance().getHashmap().put("db.username", prop.getProperty("db.username"));
            ServerController.getInstance().getHashmap().put("db.password", prop.getProperty("db.password"));
            ServerController.getInstance().getHashmap().put("port", prop.getProperty("port"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

