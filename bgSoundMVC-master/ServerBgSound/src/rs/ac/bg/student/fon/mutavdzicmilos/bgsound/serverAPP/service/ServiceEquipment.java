/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service;

import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;

/**
 *
 * @author user
 */
public interface ServiceEquipment {
   List<Equipment> getAll()throws Exception;
   Equipment getByID(int id)throws Exception;
    public Equipment setEquipment(Equipment equipment)throws Exception;
    public List<Equipment> getByName(String Name)throws Exception;
    public boolean changeEquipment(Equipment equipment)throws Exception;
    public boolean delete(int id)throws Exception;
}
