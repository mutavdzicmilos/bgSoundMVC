/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl;

import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceCopy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageCopy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.impl.StorageCopyImpl;

/**
 *
 * @author user
 */
public class ServiceCopyImpl implements ServiceCopy {

    StorageCopy storageCopy;

    public ServiceCopyImpl() {

        storageCopy = new StorageCopyImpl();
    }

    @Override
    public List<Copy> getAll() throws Exception {
        try {
            return storageCopy.getAll();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public boolean setCopy(Copy copy) throws Exception {
        try {
            return storageCopy.setCopy(copy);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Copy getCopy(Copy copy) throws Exception {
        try {
            return storageCopy.getCopy(copy);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean setCopy(List<Copy> copies) throws Exception {
        try {
            return storageCopy.setCopy(copies);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean changeCopy(Copy copy) throws Exception {
        try {
            return storageCopy.changeCopy(copy);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Copy> getCopy(int id) throws Exception {
        try {
            return storageCopy.getCopy(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Copy> getAllEquipment(int id) throws Exception {
        try {
            return storageCopy.getAllEquipment(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteCopy(int coId, int eqId) throws Exception {
        try {
            return storageCopy.deleteCopy(coId, eqId);
        } catch (Exception e) {
            return false;
        }
    }
}
