/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.copy;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class UpdateCopyValidator implements Validation {

    @Override
    public void validate(Object o) throws Exception {
        if (!(o instanceof Copy)) {
            throw new Exception("Error validation, worker must be sent to operation");
        }
        Copy c = (Copy) o;
        if (c.getWorking() == true && !c.getDefect().equals("")) {
            throw new Exception("Defect must be empty if copy is working");
        }
        if (c.getWorking() == false && c.getDefect().equals("")) {
            throw new Exception("Error validation,you must enter defect for non working equipment");
        }
    }

}
