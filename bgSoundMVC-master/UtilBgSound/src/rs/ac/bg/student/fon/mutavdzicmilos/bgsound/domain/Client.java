/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain;

import java.io.Serializable;

/**
 *
 * @author FON
 */
public class Client implements Serializable, IGeneralObject {

    private String name;
    private String surname;
    private String JMBG;
    private Integer clientID;
    private String phone;

    public Client() {
    }
//prototype

    public Client(Integer clientID) {
        this.clientID = clientID;
    }

    public Client(String name, String surname, String JMBG, Integer clientID, String phone) {
        this.name = name;
        this.surname = surname;
        this.JMBG = JMBG;
        this.clientID = clientID;
        this.phone = phone;
    }

    public Client(String name, String surname, String JMBG, String phone) {
        this.name = name;
        this.surname = surname;
        this.JMBG = JMBG;
        this.phone = phone;
    }

    public Client(String name, String surname, Object object, Integer cid, Object object0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public String getTableName() {
        return "client";
    }

    @Override
    public String getColumnNamesForInsert() {
      return "name,surname,JMBG,phone";
    }
    @Override
    public String getInsertValues() {
         StringBuilder sb = new StringBuilder();
        sb.append("'").append(name).append("',")
                .append("'").append(surname).append("','")
                .append(JMBG).append("','")
                .append(phone).append("'");
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        clientID=id;
    }

}
