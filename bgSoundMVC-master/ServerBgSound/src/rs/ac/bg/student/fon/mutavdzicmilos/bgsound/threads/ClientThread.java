/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.ServerAnswerObject;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.ServerReceiveObject;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Answer;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Client;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Rent;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.controller.ServerController;

/**
 *
 * @author user
 */
class ClientThread extends Thread {

    Worker worker;
    ServerThread serverThread;
    Socket socket;
    List<Worker> workers = new ArrayList<>();

    ClientThread(ServerThread aThis, Socket socket) {
        this.serverThread = aThis;
        this.socket = socket;
    }

    @Override
    public void run() {
        Worker worker = null;
        while (socket != null || !isInterrupted() || !socket.isClosed()) {
            try {
                ObjectInputStream stream = new ObjectInputStream(socket.getInputStream());

                ServerReceiveObject receive = (ServerReceiveObject) stream.readObject();
                ServerAnswerObject answer = new ServerAnswerObject();
                switch (receive.getOperation()) {
                    case 0: {
                        Worker w = (Worker) receive.getObject();
                        try {
                            w = ServerController.getInstance().getServiceWorker().checkWorker(w);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                            break;
                        }
                        if (w.getWorkerID() == null || serverThread.getForm().hasWorker(w)) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(new Exception("Already logged"));
                        } else {
                            worker = w;
                            serverThread.getForm().addWorker(w);
                            answer.setOperation(Answer.DONE);
                        }
                        answer.setData(w);
                        break;

                    }
                    case 1: {
                        List<Equipment> clients;
                        try {
                            clients = ServerController.getInstance().getServiceEquipment().getAll();
                            answer.setOperation(Answer.DONE);
                            answer.setData(clients);
                        } catch (Exception ex) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(ex);
                        }

                        break;
                    }
                    case 2: {
                        List<Client> clients;
                        try {
                            clients = ServerController.getInstance().getServiceClient().returnAllClients();
                            answer.setOperation(Answer.DONE);
                            answer.setData(clients);
                        } catch (Exception ex) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(ex);
                        }

                        break;
                    }
                    case 3: {

                        List<Copy> copies;
                        try {
                            copies = ServerController.getInstance().getServiceCopy().getAll();
                            answer.setOperation(Answer.DONE);
                            answer.setData(copies);
                        } catch (Exception ex) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(ex);
                        }

                        break;

                    }
                    case 4: {
                        try {
                            List<Rent> clients = ServerController.getInstance().getServiceRent().getAll();
                            answer.setOperation(Answer.DONE);
                            answer.setData(clients);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                    case 5: {
                        Equipment e = (Equipment) receive.getObject();
                        Equipment help;
                        try {
                            help=ServerController.getInstance().saveEquipment(e);
  // help = ServerController.getInstance().getServiceEquipment().setEquipment(e);
                            answer.setData(help);
                            answer.setOperation(Answer.DONE);
                        } catch (Exception ex) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(ex);
                        }

                        break;

                    }

                    case 8: {
                        Client c = (Client) receive.getObject();
                        try {

                            Client help = ServerController.getInstance().saveClient(c);
//Client help = ServerController.getInstance().getServiceClient().saveClient(c);
                            answer.setData(help);
                            answer.setOperation(Answer.DONE);
                        } catch (Exception ex) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(ex);
                        }

                        break;
                    }
                    case 9: {
                        Client c = (Client) receive.getObject();
                        try {
                            boolean b = ServerController.getInstance().getServiceClient().updateClient(c);
                            answer.setOperation(Answer.DONE);
                            answer.setData(b);
                        } catch (Exception ex) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(ex);
                        }

                        break;
                    }
                    case 10: {
                        Client c = (Client) receive.getObject();
                        try {
                            boolean b = ServerController.getInstance().getServiceClient().deleteClient(c);
                            answer.setOperation(Answer.DONE);
                            answer.setData(b);
                        } catch (Exception ex) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(ex);
                        }

                        break;
                    }
                    case 11: {
                        int s = (Integer) receive.getObject();

                        try {
                            Client client = ServerController.getInstance().getServiceClient().returnByID(s);
                            answer.setOperation(Answer.DONE);
                            answer.setData(client);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                    case 12: {
                        String s = receive.getObject().toString();

                        try {
                            List<Client> clients = ServerController.getInstance().getServiceClient().returnByName(s);
                            answer.setOperation(Answer.DONE);
                            answer.setData(clients);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                    case 13: {
                        int br = (Integer) receive.getObject();

                        try {
                            List<Copy> clients = ServerController.getInstance().getServiceCopy().getAllEquipment(br);
                            answer.setOperation(Answer.DONE);
                            answer.setData(clients);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                    case 14: {
                        Copy copy = (Copy) receive.getObject();
                        try {
                            boolean help = ServerController.getInstance().getServiceCopy().deleteCopy(copy.getCopyID(), copy.getEquipment().getEquipmentID());

                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                    case 15: {
                        Copy copy = (Copy) receive.getObject();

                        try {
                            boolean help = ServerController.getInstance().getServiceCopy().changeCopy(copy);
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                    case 16: {
                        int copy = (int) receive.getObject();

                        try {
                            Rent help = ServerController.getInstance().getServiceRent().get(copy);
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                    case 17: {
                        List<Rent> rents = (List<Rent>) receive.getObject();
                        try {

                            boolean help = ServerController.getInstance().getServiceRent().discharge(rents, worker);
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                    case 18: {
                        List<Rent> rents = (List<Rent>) receive.getObject();
                        for (Rent r : rents) {
                            r.setWorker(worker);
                        }

                        try {
                            boolean help = ServerController.getInstance().getServiceRent().saveAll(rents);
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                    case 19: {

                        Copy copy = (Copy) receive.getObject();
                        try {
                            Copy help = ServerController.getInstance().saveCopy(copy);

                            //    Copy help = ServerController.getInstance().getServiceCopy().setCopy(copy);
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                     case 20: {

                        int copy = (int) receive.getObject();
                        try {
                            List<Rent> help = ServerController.getInstance().getServiceRent().getAllID(copy);

                            //    Copy help = ServerController.getInstance().getServiceCopy().setCopy(copy);
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                            answer.setOperation(Answer.ERROR);
                            answer.setError(e);
                        }
                        break;
                    }
                }

                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(answer);
                output.flush();

            } catch (IOException ex) {
                if (worker != null) {
                    serverThread.getForm().removeWorker(worker);
                }
                return;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    void closeSocket() {
        try {
            socket.close();
        } catch (Exception e) {
            System.out.println("threads.ClientThread.closeSocket() line 38");
        }

    }

}
