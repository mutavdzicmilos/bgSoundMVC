/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.ServerAnswerObject;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.ServerReceiveObject;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Action;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Answer;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class Model {

    public Worker checkWorker(Worker worker) {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.LOGIN.ordinal(), worker);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            if (answer.getOperation().equals(Answer.ERROR)) {
                return null;
            }
            return (Worker) answer.getData();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Equipment> getAllEquipment() {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETALLEQUIPMENT.ordinal(), null);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (List<Equipment>) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Client> getAllClients() {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETALLCLIENTS.ordinal(), null);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (List<Client>) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Client> getClientsByName(String name) {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.FINDCLIENTBYNAME.ordinal(), name);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (List<Client>) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Client getClientsByID(int id) {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.FINDCLIENTBYID.ordinal(), id);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (Client) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Client saveClient(Client client) {
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
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<Copy> getAllCopies() {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETALLCOPIES.ordinal(), null);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (List<Copy>) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Rent> getAllRents() {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETALLRENTS.ordinal(), null);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (List<Rent>) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public boolean saveRents(List<Rent> rents){
        Socket socket= ThreadSaver.getInstance().getSocket();
        try{
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.SAVERENTS.ordinal(), rents);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (boolean) answer.getData();
        }catch(Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return false;
    }

    public boolean updateClient(Client client) {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.UPDATECLIENT.ordinal(), client);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (boolean) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteClient(Client client) {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.DELETECLIENT.ordinal(), client);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (boolean) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Equipment saveEquipment(Equipment equipment) {
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
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Copy> getCopies(int equipment) {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETCOPIESBYID.ordinal(), equipment);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (List<Copy>) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
            

    public boolean deleteCopy(Copy c) {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.DELETECOPY.ordinal(), c);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (boolean) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public boolean updateCopy(Copy c) {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.UPDATECOPY.ordinal(), c);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (boolean) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Rent getRentByID(int rentID) {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.GETRENTBYID.ordinal(), rentID);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (Rent) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean dischargeAll(List<Rent> rents) {
        Socket socket = ThreadSaver.getInstance().getSocket();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            ServerReceiveObject send = new ServerReceiveObject(Action.DISCHARGEALL.ordinal(), rents);
            stream.writeObject(send);
            stream.flush();
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ServerAnswerObject answer = (ServerAnswerObject) input.readObject();
            return (boolean) answer.getData();
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
