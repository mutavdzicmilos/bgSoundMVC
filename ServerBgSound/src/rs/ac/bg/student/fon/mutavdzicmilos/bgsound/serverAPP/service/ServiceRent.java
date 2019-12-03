/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service;

import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;

/**
 *
 * @author user
 */
public interface ServiceRent {

    public boolean discharge(List<Rent> rents,Worker worker) throws Exception;
    public List<Rent> getAll()throws Exception;
    public Rent getByID(int id)throws Exception;
    public Rent get(int id)throws Exception;
     public boolean saveAll(List<Rent> rents)throws Exception;
}
