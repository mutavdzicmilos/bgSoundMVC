/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl.ServiceWorkerImpl;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceClient;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceCopy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceEquipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceRent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceWorker;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl.ServiceClientImpl;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl.ServiceCopyImpl;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl.ServiceEquipmentImpl;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl.ServiceRentImpl;

/**
 *
 * @author milos
 * 
 */
public class ServerController {

    private static  ServerController instance;
    private final ServiceEquipment serviceEquipment;
    private final ServiceCopy serviceCopy;
    private final ServiceWorker serviceWorker;
    private final ServiceClient serviceClient;
    private final ServiceRent serviceRent;
            
    private static Map<String,Object> hashmap;
        
    private  ServerController() {
        serviceEquipment = new ServiceEquipmentImpl();
        serviceCopy= new ServiceCopyImpl();
        serviceWorker= new ServiceWorkerImpl();
        serviceClient= new ServiceClientImpl();
        serviceRent=new ServiceRentImpl();
    }

    

    
    public static ServerController getInstance() {
        
        if (instance == null) {
            instance= new ServerController();
        }
        return instance;
    }

    public Map<String,Object> getHashmap() {
        if(hashmap==null){
         hashmap=new HashMap<>();
        }
        return hashmap;
    }


    public ServiceEquipment getServiceEquipment() {
        return serviceEquipment;
    }

    public ServiceCopy getServiceCopy() {
        return serviceCopy;
    }


    public ServiceWorker getServiceWorker() {
        return serviceWorker;
    }

    public ServiceClient getServiceClient() {
        return serviceClient;
    }

    public ServiceRent getServiceRent() {
        return serviceRent;
    }
}
