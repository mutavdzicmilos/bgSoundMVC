/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.so.impl;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.so.AbstractGenericOperation;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.client.SaveClientValidator;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class SaveClient extends AbstractGenericOperation {

    private Validation validation;

    @Override
    protected void preconditions(Object entity) throws Exception {
        validation = new SaveClientValidator();
        validation.validate(entity);

    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        return databaseBroker.save((Client) entity);
    }

}
