/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.impl;

import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service.ServiceClient;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.StorageClient;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage.impl.StorageClientImpl;

/**
 *
 * @author user
 */
public class ServiceClientImpl implements ServiceClient {

    StorageClient storageClient;

    public ServiceClientImpl() {
        storageClient = new StorageClientImpl();
    }

    @Override
    public Client saveClient(Client client) {
        try {
            return storageClient.saveClient(client);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Line 27 StorageClientImpl");
        }
        return null;
    }

    @Override
    public List<Client> returnAllClients() {
        try {
            return storageClient.returnAllClients();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Line 37 StorageClientImpl");
        }
        return null;
    }

    @Override
    public List<Client> returnByName(String name) {
        try {
            return storageClient.returnByName(name);
        } catch (Exception e) {
            System.out.println("Line 46 StorageClientImpl");
        }
        return null;
    }

    @Override
    public Client returnByID(int id) {
        try {
            return storageClient.returnByID(id);
        } catch (Exception e) {
            System.out.println("Line 55 StorageClientImpl");
        }
        return null;
    }

    @Override
    public boolean updateClient(Client client) {
        try {
            return storageClient.updateClient(client);
        } catch (Exception e) {
            System.out.println("Line 73 StorageClientImpl");
        }
        return false;
    }

    @Override
    public boolean deleteClient(Client client) {
        try {
            return storageClient.deleteClient(client);
        } catch (Exception e) {
            System.out.println("Line 82 StorageClientImpl");
        }
        return false;
    }

    @Override
    public boolean deleteClient(int client) {
        try {
            return storageClient.deleteClient(client);
        } catch (Exception e) {
            System.out.println("Line 82 StorageClientImpl");
        }
        return false;

    }
}
