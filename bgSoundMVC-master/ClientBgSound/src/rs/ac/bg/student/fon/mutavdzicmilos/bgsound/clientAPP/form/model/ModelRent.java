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
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ModelRent {

    public List<Copy> getAllCopies() throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETALLCOPIES.ordinal(), null);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            if (answer.getOperation() == Answer.DONE) {
                return (List<Copy>) answer.getData();
            }
            throw new Exception(answer.getError());

        } catch (IOException | ClassNotFoundException ex) {
            ThreadSaver.getInstance().closeApp();
  throw new Exception("connection broken");        }

    }

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
            ThreadSaver.getInstance().closeApp();
  throw new Exception("connection broken");        }

    }

    public boolean saveRents(List<Rent> rents) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.SAVERENTS.ordinal(), rents);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            if (answer.getOperation() == Answer.DONE) {
                return (boolean) answer.getData();
            }
            throw new Exception(answer.getError());

        } catch (IOException | ClassNotFoundException ex) {
            ThreadSaver.getInstance().closeApp();
  throw new Exception("connection broken");        }
    }
}
