/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 
 */
public class Rent implements Serializable{
    private int rentID;
    private Date dateFrom;
    private Date dateTo;
    private Client client;
    private Copy copy;
    private Worker worker;

    @Override
    public String toString() {
        return "Rent{" + "rentID=" + rentID + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", client=" + client + ", copy=" + copy + ", worker=" + worker + '}';
    }
    //try this
    public Rent(int rentID, Date dateFrom,Date dateTo,int clientID,int EQID,int copyID,int workerID ) {
        this.rentID = rentID;
        this.dateFrom = dateFrom;
        this.dateTo= dateTo;
        this.client= new Client(clientID);
        this.copy=new Copy(copyID,EQID);
        this.worker= new Worker(workerID);
    }
     

    public Rent(int rentID, Date dateFrom, Client client, Copy copy, Worker worker) {
        this.rentID = rentID;
        this.dateFrom = dateFrom;
        this.client = client;
        this.copy = copy;
        this.worker = worker;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.rentID;
        hash = 97 * hash + Objects.hashCode(this.dateFrom);
        hash = 97 * hash + Objects.hashCode(this.dateTo);
        hash = 97 * hash + Objects.hashCode(this.client);
        hash = 97 * hash + Objects.hashCode(this.copy);
        hash = 97 * hash + Objects.hashCode(this.worker);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rent other = (Rent) obj;
        if (this.rentID != other.rentID) {
            return false;
        }
        if (!Objects.equals(this.dateFrom, other.dateFrom)) {
            return false;
        }
        if (!Objects.equals(this.dateTo, other.dateTo)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.copy, other.copy)) {
            return false;
        }
        if (!Objects.equals(this.worker, other.worker)) {
            return false;
        }
        return true;
    }

    public Rent(int rentID, Date dateFrom, Date dateTo, Client client, Copy copy, Worker worker) {
        this.rentID = rentID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.client = client;
        this.copy = copy;
        this.worker = worker;
    }

    public Rent() {
    }

    public int getRentID() {
        return rentID;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    
}
