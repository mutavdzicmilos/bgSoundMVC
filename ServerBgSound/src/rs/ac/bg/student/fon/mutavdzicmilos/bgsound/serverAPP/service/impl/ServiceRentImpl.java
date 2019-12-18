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

/**
 *
 * @author user
 */
public class ServiceRentImpl implements ServiceRent {

    StorageRent storageRent;

    public ServiceRentImpl() {
        storageRent = new StorageRentImpl();
    }

    @Override
    public boolean discharge(List<Rent> rents, Worker worker) throws Exception {
        try {
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
            return storageRent.saveAll(rents);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
