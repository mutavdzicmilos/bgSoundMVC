/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.storage;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;

/**
 *
 * @author user
 */
public interface StorageWorker {
    public Worker checkWorker(Worker worker) throws Exception;
}
