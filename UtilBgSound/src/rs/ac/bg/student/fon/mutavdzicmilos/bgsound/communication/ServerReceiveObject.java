/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class ServerReceiveObject implements Serializable {

    private int operation;
    private Object object;

    public ServerReceiveObject() {
    }

    public ServerReceiveObject(int operation, Object hardObject) {
        this.operation = operation;
        this.object = hardObject;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
