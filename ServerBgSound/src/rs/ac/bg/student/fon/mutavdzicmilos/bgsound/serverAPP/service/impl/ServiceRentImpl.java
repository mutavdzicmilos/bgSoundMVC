/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl;

import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceRent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageRent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.impl.StorageRentImpl;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.rent.DischargeRentsValidator;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.rent.SaveRentsValidator;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.rent.WorkerRentsValidator;

/**
 *
 * @author user
 */
public class ServiceRentImpl implements ServiceRent {
    
    StorageRent storageRent;
    Validation validate;

    public ServiceRentImpl() {
        storageRent = new StorageRentImpl();
    }
    
    @Override
    public boolean discharge(List<Rent> rents, Worker worker) throws Exception {
        try {
            validate = new SaveRentsValidator();
            validate.validate(rents);
            validate = new WorkerRentsValidator();
            validate.validate(worker);
            return storageRent.discharge(rents, worker);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Override
    public List<Rent> getAll() throws Exception {
        try {
            return storageRent.getAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Override
    public Rent getByID(int id) throws Exception {
        try {
            return storageRent.getByID(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Override
    public Rent get(int id) throws Exception {
        try {
            return storageRent.get(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Override
    public boolean saveAll(List<Rent> rents) throws Exception {
        try {
            validate = new DischargeRentsValidator();
            validate.validate(rents);
            return storageRent.saveAll(rents);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
