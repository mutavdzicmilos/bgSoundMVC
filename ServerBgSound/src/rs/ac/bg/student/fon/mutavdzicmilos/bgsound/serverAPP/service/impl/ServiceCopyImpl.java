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
        return storageCopy.getAll();

    }

    @Override
    public boolean setCopy(Copy copy) throws Exception {
        return storageCopy.setCopy(copy);
    }

    @Override
    public Copy getCopy(Copy copy) throws Exception {
        return storageCopy.getCopy(copy);
    }

    @Override
    public boolean setCopy(List<Copy> copies) throws Exception {
        return storageCopy.setCopy(copies);
    }

    @Override
    public boolean changeCopy(Copy copy) throws Exception {
        return storageCopy.changeCopy(copy);
    }

    @Override
    public List<Copy> getAllEquipment(int id) throws Exception {
        return storageCopy.getAllEquipment(id);
    }

    @Override
    public boolean deleteCopy(int coId, int eqId) throws Exception {
        return storageCopy.deleteCopy(coId, eqId);
    }
}
