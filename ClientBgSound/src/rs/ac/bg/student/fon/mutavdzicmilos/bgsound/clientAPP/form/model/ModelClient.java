/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic.ThreadSaver;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.ServerAnswerObject;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.ServerReceiveObject;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Action;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Answer;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ModelClient {

    public List<Client> getAllClients() throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETALLCLIENTS.ordinal(), null);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            if (answer.getOperation() == Answer.DONE) {
                return (List<Client>) answer.getData();
            }
            throw new Exception(answer.getError());
        } catch (IOException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }

    }

    public Client getClientsByID(int id) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.FINDCLIENTBYID.ordinal(), id);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            if (answer.getOperation() == Answer.DONE) {
                return (Client) answer.getData();
            }
            throw new Exception(answer.getError());
        } catch (IOException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }

    }

    public List<Client> getClientsByName(String name) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.FINDCLIENTBYNAME.ordinal(), name);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            if (answer.getOperation() == Answer.DONE) {
                return (List<Client>) answer.getData();
            }
            throw new Exception(answer.getError());
        } catch (IOException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }

    }

    public boolean updateClient(Client client) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.UPDATECLIENT.ordinal(), client);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            if (answer.getOperation() == Answer.DONE) {
                return (boolean) answer.getData();
            }
            throw new Exception(answer.getError());
        } catch (IOException | ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public Client saveClient(Client client) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.SAVECLIENT.ordinal(), client);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            System.out.println(answer.getOperation());
            if (answer.getOperation() == Answer.DONE) {
                return (Client) answer.getData();
            }
            throw new Exception(answer.getError());
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }

    }

    public boolean deleteClient(Client client) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.DELETECLIENT.ordinal(), client);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            if (answer.getOperation() == Answer.DONE) {
                return (boolean) answer.getData();
            }
            throw new Exception(answer.getError());
        } catch (IOException | ClassNotFoundException e) {
            throw new Exception(e.getMessage());
        }
    }
}
