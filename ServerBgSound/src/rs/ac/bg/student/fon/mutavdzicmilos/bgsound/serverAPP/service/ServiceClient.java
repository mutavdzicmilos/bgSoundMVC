/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service;

import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;

/**
 *
 * @author user
 */
public interface ServiceClient {
    Client saveClient(Client client) throws Exception;
    List<Client> returnAllClients() throws Exception;
    List<Client> returnByName(String name)throws Exception;
    Client returnByID(int id)throws Exception;
     boolean deleteClient(int  client) throws Exception ;

    boolean updateClient(Client client)throws Exception;
    
    boolean deleteClient(Client client)throws Exception;
    
}
