/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.so.impl;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.so.AbstractGenericOperation;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.equipment.SaveEquipmentValidator;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class SaveEquipment extends AbstractGenericOperation {

    private Validation validation;

    @Override
    protected void preconditions(Object entity) throws Exception {
        validation = new SaveEquipmentValidator();
        validation.validate(entity);

    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {

        databaseBroker.save((Equipment) entity);
        for (Copy c : ((Equipment) entity).getCopies()) {
            c.setEquipment((Equipment)entity);
            databaseBroker.save((Copy) c);
        }
        return entity;
    }

}
