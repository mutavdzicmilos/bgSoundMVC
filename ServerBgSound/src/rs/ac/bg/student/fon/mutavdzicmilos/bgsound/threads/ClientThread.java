/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.threads;

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
                        w = ServerController.getInstance().getServiceWorker().checkWorker(w);

                        if (w.getWorkerID() == null || serverThread.getForm().hasWorker(w)) {
                            answer.setOperation(Answer.ERROR);
                        } else {
                            worker = w;
                            serverThread.getForm().addWorker(w);
                            answer.setOperation(Answer.DONE);
                        }
                        answer.setData(w);
                        break;

                    }
                    case 1: {
                        List<Equipment> clients = ServerController.getInstance().getServiceEquipment().getAll();
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(clients);
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case 2: {
                        List<Client> clients = ServerController.getInstance().getServiceClient().returnAllClients();
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(clients);
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case 3: {

                        List<Copy> copies = ServerController.getInstance().getServiceCopy().getAll();
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(copies);
                        } catch (Exception e) {
                        }
                        break;

                    }
                    case 4: {
                        List<Rent> clients = ServerController.getInstance().getServiceRent().getAll();
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(clients);
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case 5: {
                        Equipment e = (Equipment) receive.getObject();
                        Equipment help;
                        try {
                            help = ServerController.getInstance().getServiceEquipment().setEquipment(e);
                            if (help != null && help.getEquipmentID() != null) {
                                answer.setOperation(Answer.DONE);
                            } else {
                                answer.setOperation(Answer.ERROR);
                            }

                            answer.setData(help);

                        } catch (Exception ex) {
                            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;

                    }

                    case 8: {
                        Client c = (Client) receive.getObject();
                        try {
                            Client help = ServerController.getInstance().getServiceClient().saveClient(c);
                            if (help.getClientID() != null) {
                                answer.setOperation(Answer.DONE);
                            } else {
                                answer.setOperation(Answer.ERROR);

                            }
                            answer.setData(help);
                        } catch (Exception ex) {
                            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    }
                    case 9: {
                        Client c = (Client) receive.getObject();
                        try {
                            boolean b = ServerController.getInstance().getServiceClient().updateClient(c);
                            if (b == true) {
                                answer.setOperation(Answer.DONE);
                            } else {
                                answer.setOperation(Answer.ERROR);
                            }
                            answer.setData(b);
                        } catch (Exception ex) {
                            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    }
                    case 10: {
                        Client c = (Client) receive.getObject();
                        try {
                            boolean b = ServerController.getInstance().getServiceClient().deleteClient(c);
                            if (b == true) {
                                answer.setOperation(Answer.DONE);
                            } else {
                                answer.setOperation(Answer.ERROR);
                            }
                            answer.setData(b);
                        } catch (Exception ex) {
                            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    }
                    case 11: {
                        int s = (Integer) receive.getObject();
                        Client client = ServerController.getInstance().getServiceClient().returnByID(s);
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(client);
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case 12: {
                        String s = receive.getObject().toString();
                        List<Client> clients = ServerController.getInstance().getServiceClient().returnByName(s);
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(clients);
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case 13: {
                        int br = (Integer) receive.getObject();
                        List<Copy> clients = ServerController.getInstance().getServiceCopy().getAllEquipment(br);
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(clients);
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case 14: {
                        Copy copy = (Copy) receive.getObject();
                        boolean help = ServerController.getInstance().getServiceCopy().deleteCopy(copy.getCopyID(), copy.getEquipment().getEquipmentID());
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case 15: {
                        Copy copy = (Copy) receive.getObject();
                        boolean help = ServerController.getInstance().getServiceCopy().changeCopy(copy);
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case 16: {
                        int copy = (int) receive.getObject();
                        Rent help = ServerController.getInstance().getServiceRent().get(copy);
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case 17: {
                        List<Rent> rents = (List<Rent>) receive.getObject();
                        boolean help = ServerController.getInstance().getServiceRent().discharge(rents, worker);
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case 18: {
                        List<Rent> rents = (List<Rent>) receive.getObject();
                        for (Rent r : rents) {
                            r.setWorker(worker);
                        }
                        boolean help = ServerController.getInstance().getServiceRent().saveAll(rents);
                        try {
                            answer.setOperation(Answer.DONE);
                            answer.setData(help);
                        } catch (Exception e) {
                        }
                        break;
                    }
                }

                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(answer);
                output.flush();

            } catch (Exception ex) {
                if (worker != null) {
                    serverThread.getForm().removeWorker(worker);
                }
                return;
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
