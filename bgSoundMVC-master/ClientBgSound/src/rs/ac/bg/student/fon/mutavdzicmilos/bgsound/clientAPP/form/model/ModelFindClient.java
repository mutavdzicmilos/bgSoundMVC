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
public class ModelFindClient {

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
}
