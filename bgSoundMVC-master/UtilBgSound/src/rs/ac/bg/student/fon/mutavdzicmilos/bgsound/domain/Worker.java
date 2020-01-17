/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author FON
 */
public class Worker implements Serializable{
    private Integer workerID;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String JMBG;
//prototype
    public Worker(Integer workerID) {
        this.workerID = workerID;
    }

    public Worker() {
    }
    public Worker(String username,String password){
        this.username = username;
        
        this.password = password;
    }

    public Worker(Integer workerID, String username, String password, String name, String surname, String JMBG) {
        this.workerID = workerID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.JMBG = JMBG;
    }

    

    @Override
    public String toString() {
        return "Worker: "+workerID + name +" " + surname;
    }

    public Integer getWorkerID() {
        return workerID;
    }

    public void setWorkerID(Integer workerID) {
        this.workerID = workerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.workerID);
        hash = 47 * hash + Objects.hashCode(this.username);
        hash = 47 * hash + Objects.hashCode(this.password);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.surname);
        hash = 47 * hash + Objects.hashCode(this.JMBG);
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
        final Worker other = (Worker) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        return Objects.equals(this.JMBG, other.JMBG);
    }

}
