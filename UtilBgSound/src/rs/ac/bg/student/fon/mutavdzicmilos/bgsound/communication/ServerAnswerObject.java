/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication;

import java.io.Serializable;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Answer;

/**
 *
 * @author user
 */
public class ServerAnswerObject implements Serializable{
    private Answer operation;
    private Object data;
    private Exception error;

    public ServerAnswerObject(Answer operation, Object data,Exception e) {
        this.operation = operation;
        this.data = data;
        this.error= e;
    }

    public ServerAnswerObject() {
    }

 

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Answer getOperation() {
        return operation;
    }

    public void setOperation(Answer operation) {
        this.operation = operation;
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
    }

    
}
