/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.start;

import javax.swing.JFrame;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.propertyReader.Reader;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.form.ServerForm;

/**
 *
 * @author FON
 */
public class Main {
    public static void main(String[] args) {
        
        JFrame serverForm= new ServerForm();
        Reader.read();
        serverForm.setVisible(true);
       
    }
}
