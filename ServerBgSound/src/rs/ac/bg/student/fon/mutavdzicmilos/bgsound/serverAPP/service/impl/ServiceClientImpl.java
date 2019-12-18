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
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.validation.Validation;

/**
 *
 * @author user
 */
public class ServiceClientImpl implements ServiceClient {

    StorageClient storageClient;
    Validation validation;

    public ServiceClientImpl() {
        storageClient = new StorageClientImpl();
    }

    @Override
    public Client saveClient(Client client) throws Exception {
            validation= new Validation() {
                @Override
                public void validate(Object o) throws Exception {
                    //implement validation
                            throw new Exception("Wrong jmbg");
                }
            };
            validation.validate(client);
            return storageClient.saveClient(client);
    }

    @Override
    public List<Client> returnAllClients() throws Exception {
            return storageClient.returnAllClients();
    }

    @Override
    public List<Client> returnByName(String name) throws Exception {
            return storageClient.returnByName(name);
    }

    @Override
    public Client returnByID(int id) throws Exception {
            return storageClient.returnByID(id);
    }

    @Override
    public boolean updateClient(Client client) throws Exception {
            return storageClient.updateClient(client);
    }

    @Override
    public boolean deleteClient(Client client) throws Exception {
            return storageClient.deleteClient(client);
    }

    @Override
    public boolean deleteClient(int client) throws Exception {
            return storageClient.deleteClient(client);

    }
}
