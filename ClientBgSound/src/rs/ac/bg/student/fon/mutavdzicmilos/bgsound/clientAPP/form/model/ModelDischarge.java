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
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class ModelDischarge {

    public List<Rent> getAllRents() throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETALLRENTS.ordinal(), null);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
             if (answer.getOperation() == Answer.DONE) {
              return (List<Rent>) answer.getData();
            }
            throw new Exception(answer.getError());
            
        } catch (IOException | ClassNotFoundException ex) {
             ThreadSaver.getInstance().closeApp();
            throw new Exception(ex.getMessage());
        }

    }

    public boolean dischargeAll(List<Rent> rents) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.DISCHARGEALL.ordinal(), rents);
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

    public Rent getRentByID(int rentID) throws Exception {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETRENTBYID.ordinal(), rentID);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
             if (answer.getOperation() == Answer.DONE) {
              return (Rent) answer.getData();
            }
            throw new Exception(answer.getError());
            
        } catch (IOException | ClassNotFoundException ex) {
             ThreadSaver.getInstance().closeApp();
            throw new Exception(ex.getMessage());
        }

    }
}
