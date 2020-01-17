/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.service;

import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;

/**
 *
 * @author user
 */
public interface ServiceWorker {

    public Worker checkWorker(Worker worker) throws Exception;
}
