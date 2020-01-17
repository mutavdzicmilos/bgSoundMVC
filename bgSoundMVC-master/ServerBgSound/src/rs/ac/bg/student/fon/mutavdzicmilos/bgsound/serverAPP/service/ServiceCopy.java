/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service;

import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;

/**
 *
 * @author user
 */
public interface ServiceCopy {
    public List<Copy> getAll() throws Exception;
    public Copy setCopy(Copy copy)throws Exception;
    public Copy getCopy(Copy copy)throws Exception;
    public boolean setCopy(List<Copy> copies)throws Exception;
    public boolean changeCopy(Copy copy)throws Exception;
     public List<Copy> getAllEquipment(int id) throws Exception;
     public boolean deleteCopy(int coId,int eqId)throws Exception;
}
