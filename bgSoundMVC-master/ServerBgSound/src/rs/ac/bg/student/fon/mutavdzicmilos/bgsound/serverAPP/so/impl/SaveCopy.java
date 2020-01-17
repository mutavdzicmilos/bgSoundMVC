/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.so.impl;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.so.AbstractGenericOperation;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.copy.SaveCopyValidator;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class SaveCopy extends AbstractGenericOperation {

    private Validation validation;

   

    @Override
    protected void preconditions(Object entity) throws Exception {
        validation=new SaveCopyValidator();
        validation.validate(entity);
        
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
         return databaseBroker.save((Copy) entity);
    }

}
