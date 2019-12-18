/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.rent;

import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class DischargeRentsValidator implements Validation {

    @Override
    public void validate(Object o) throws Exception {
        if (o instanceof List) {
            if (((List) o).size() > 0 && (((List) o).get(0) instanceof Rent)) {
            } else {
                throw new Exception("Error validation, list of rents must be sent to operation");
            }
        }
    }

}
