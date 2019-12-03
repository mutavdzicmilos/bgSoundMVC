/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceEquipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageEquipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.impl.StorageEquipmentImpl;

/**
 *
 * @author user
 */
public class ServiceEquipmentImpl implements ServiceEquipment {

    private StorageEquipment storageEquipment;

    public ServiceEquipmentImpl() {
        this.storageEquipment = new StorageEquipmentImpl();
    }

    @Override
    public List<Equipment> getAll() {
        try {
            return storageEquipment.getAll();
        } catch (Exception ex) {
            Logger.getLogger(ServiceEquipmentImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Equipment getByID(int id) {
        try {
            return storageEquipment.getByID(id);
        } catch (Exception ex) {
            Logger.getLogger(ServiceEquipmentImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }}

    @Override
    public Equipment setEquipment(Equipment equipment) throws Exception {
        try {
            return storageEquipment.setEquipment(equipment);
        } catch (Exception ex) {
            Logger.getLogger(ServiceEquipmentImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Equipment> getByName(String name) throws Exception {
     try {
            return storageEquipment.getByName(name);
        } catch (Exception ex) {
            Logger.getLogger(ServiceEquipmentImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
     }

    @Override
    public boolean changeEquipment(Equipment equipment) throws Exception {
       try {
            return storageEquipment.changeEquipment(equipment);
        } catch (Exception ex) {
            Logger.getLogger(ServiceEquipmentImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return false;
        }
     }

    @Override
    public boolean delete(int id) throws Exception {
      try {
            return storageEquipment.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ServiceEquipmentImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return false;
        }
     }
}
