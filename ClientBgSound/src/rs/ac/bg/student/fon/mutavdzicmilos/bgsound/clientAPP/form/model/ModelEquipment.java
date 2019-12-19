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
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ModelEquipment {

    public Equipment saveEquipment(Equipment equipment) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.SAVEEQUIPMENT.ordinal(), equipment);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            System.out.println(answer.getOperation());
            if (answer.getOperation() == Answer.DONE) {
                return (Equipment) answer.getData();
            }
            throw new Exception(answer.getError());

        } catch (IOException | ClassNotFoundException ex) {
            ThreadSaver.getInstance().closeApp();
            throw new Exception(ex.getMessage());
        }

    }

    public boolean deleteCopy(Copy c) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.DELETECOPY.ordinal(), c);
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
            throw new Exception(ex.getMessage());
        }
    }

    public boolean updateCopy(Copy c) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.UPDATECOPY.ordinal(), c);
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
            throw new Exception(ex.getMessage());
        }
    }

    public List<Equipment> getAllEquipment() throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETALLEQUIPMENT.ordinal(), null);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            if (answer.getOperation() == Answer.DONE) {
                return (List<Equipment>) answer.getData();
            }
            throw new Exception(answer.getError());

        } catch (IOException | ClassNotFoundException ex) {
            ThreadSaver.getInstance().closeApp();
            throw new Exception(ex.getMessage());
        }
    }

    public Copy addCopy(Copy c) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.SAVECOPY.ordinal(), c);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            if (answer.getOperation() == Answer.DONE) {
                return (Copy) answer.getData();
            }
            throw new Exception(answer.getError());

        } catch (IOException | ClassNotFoundException ex) {
            ThreadSaver.getInstance().closeApp();
            throw new Exception(ex.getMessage());
        }
    }
}
