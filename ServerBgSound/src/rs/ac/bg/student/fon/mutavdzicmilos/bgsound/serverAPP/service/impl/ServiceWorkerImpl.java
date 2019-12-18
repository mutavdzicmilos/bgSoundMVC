/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.impl.StorageWorkerImpl;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceWorker;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageWorker;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.worker.WorkerValidator;

/**
 *
 * @author user
 */
public class ServiceWorkerImpl implements ServiceWorker{
    
    StorageWorker storageWorker;
    Validation validation;
    public ServiceWorkerImpl() {
        storageWorker=new StorageWorkerImpl();
        validation= new WorkerValidator();
    }
    
    @Override
    public Worker checkWorker(Worker worker) throws Exception{
        validation.validate(worker);
        return storageWorker.checkWorker(worker);
   
    }
    
}
