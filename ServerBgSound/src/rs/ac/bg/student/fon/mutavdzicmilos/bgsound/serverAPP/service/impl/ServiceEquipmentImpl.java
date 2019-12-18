/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl;

import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceEquipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageEquipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.impl.StorageEquipmentImpl;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;

/**
 *
 * @author user
 */
public class ServiceEquipmentImpl implements ServiceEquipment {

    private StorageEquipment storageEquipment;
    private Validation validator;
    public ServiceEquipmentImpl() {
        this.storageEquipment = new StorageEquipmentImpl();
    }

    @Override
    public List<Equipment> getAll() throws Exception {
        return storageEquipment.getAll();
    }

    @Override
    public Equipment getByID(int id) throws Exception {
        return storageEquipment.getByID(id);
    }

    @Override
    public Equipment setEquipment(Equipment equipment) throws Exception {
        validator.validate(equipment);
        return storageEquipment.setEquipment(equipment);
    }

    @Override
    public List<Equipment> getByName(String name) throws Exception {
        return storageEquipment.getByName(name);
    }

    @Override
    public boolean changeEquipment(Equipment equipment) throws Exception {
        return storageEquipment.changeEquipment(equipment);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return storageEquipment.delete(id);
    }
}
