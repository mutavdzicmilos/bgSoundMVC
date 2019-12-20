/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.client;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class SaveClientValidator implements Validation {

    @Override
    public void validate(Object o) throws Exception {
        if (!(o instanceof Client)) {
            throw new Exception("Error validation, Client must be sent to operation");
        }
        Client c = (Client) o;
        if (c.getJMBG().length() != 13) {
            throw new Exception("Error validation,JMBG is 13 digit number");
        }
        /* try {
            Integer.parseInt(c.getJMBG());
        } catch (NumberFormatException ex) {
            throw new Exception("Error validation,JMBG is 13 digit number");
        }*/
        if (c.getName() == null || c.getName().equals("") || c.getName().length() < 3) {
            throw new Exception("Enter valid name");
        }
        if (c.getSurname() == null || c.getSurname().equals("") || c.getSurname().length() < 3) {
            throw new Exception("Enter valid surname");
        }
        if (c.getPhone() == null || c.getPhone().equals("") || c.getPhone().length() < 7) {
            throw new Exception("Enter valid phone");
        }

    }
}
