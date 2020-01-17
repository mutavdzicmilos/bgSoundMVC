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
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.copy.SaveCopyValidator;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.copy.UpdateCopyValidator;

/**
 *
 * @author user
 */
public class ServiceCopyImpl implements ServiceCopy {

    StorageCopy storageCopy;
    private Validation validation;

    public ServiceCopyImpl() {

        storageCopy = new StorageCopyImpl();
    }

    @Override
    public List<Copy> getAll() throws Exception {
        return storageCopy.getAll();

    }

    @Override
    public Copy setCopy(Copy copy) throws Exception {
        validation = new SaveCopyValidator();
        validation.validate(copy);
        return storageCopy.setCopy(copy);
    }

    @Override
    public Copy getCopy(Copy copy) throws Exception {
        return storageCopy.getCopy(copy);
    }

    @Override
    public boolean setCopy(List<Copy> copies) throws Exception {
        validation = new SaveCopyValidator();
        validation.validate(copies);
        return storageCopy.setCopy(copies);
    }

    @Override
    public boolean changeCopy(Copy copy) throws Exception {
        validation = new UpdateCopyValidator();
        validation.validate(copy);
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
