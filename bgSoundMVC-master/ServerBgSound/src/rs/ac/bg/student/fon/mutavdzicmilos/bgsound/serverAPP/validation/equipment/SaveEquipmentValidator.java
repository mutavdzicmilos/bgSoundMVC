/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.equipment;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class SaveEquipmentValidator implements Validation {

    @Override
    public void validate(Object o) throws Exception {
        if (!(o instanceof Equipment)) {
            throw new Exception("Error validation, equipment must be sent to operation");
        }
        Equipment e = (Equipment) o;
        if (e.getName().equals("") || e.getName() == null) {
            throw new Exception("Error validation,name cant be empty");
        }
        if (e.getConnection().equals("") || e.getConnection() == null) {
            throw new Exception("Error validation,connection cant be empty");
        }
        if (e.getSpecification().equals("") || e.getSpecification() == null) {
            throw new Exception("Error validation,specification cant be empty");
        }
        if (e.getCopies() == null || e.getCopies().size() == 0) {
            throw new Exception("Error validation,copies cant be empty");
        }

    }

}
