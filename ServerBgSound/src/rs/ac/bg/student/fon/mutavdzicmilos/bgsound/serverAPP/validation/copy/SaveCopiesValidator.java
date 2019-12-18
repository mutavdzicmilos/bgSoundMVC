/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.copy;

import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class SaveCopiesValidator implements Validation {

    @Override
    public void validate(Object object) throws Exception {
        if (object instanceof List) {
            if (((List) object).size() > 0 && (((List) object).get(0) instanceof Copy)) {
            } else {
                throw new Exception("Error in validation,must send list of Copies");
            }
        }
    }

}
