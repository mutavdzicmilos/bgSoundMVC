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
public class DeleteClientValidator implements Validation {

    @Override
    public void validate(Object o) throws Exception {
        if (!(o instanceof Client)) {
            throw new Exception("Error validation, client must be sent to operation");
        }
        Client c = (Client) o;
        if (c.getClientID()<= 0) {
            throw new Exception("Error in validation, clientID cant be less than zero");
        }

    }

}
