/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.worker;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class WorkerValidator implements Validation {

    @Override
    public void validate(Object o) throws Exception {
        if(!(o instanceof Worker))throw new Exception("Error validation, worker must be sent to operation");
        Worker w= (Worker)o;
        if(w.getUsername().equals("")|| w.getUsername()==null)throw new Exception("Error validation,username cant be empty");
        if(w.getPassword().equals("")|| w.getPassword()==null)throw new Exception("Error validation,password cant be empty");
        

    }
   
}
