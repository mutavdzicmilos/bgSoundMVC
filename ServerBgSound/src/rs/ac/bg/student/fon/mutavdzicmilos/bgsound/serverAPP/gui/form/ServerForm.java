/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.form;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Worker;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.gui.controller.ServerController;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.serverAPP.tableModel.WorkerTableModel;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.threads.ServerThread;

/**
 *
 * @author FON
 */
public class ServerForm extends javax.swing.JFrame {

    /**
     * Creates new form ServerForm
     */
    public ServerForm() {
        initComponents();
        setComponents();
        fillForm();
    }

    private void setComponents() {
        setLocationRelativeTo(null);
        //popravi
        this.setIconImage(new ImageIcon("src\\resources\\BG_Sound.jpg").getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tWorkers = new javax.swing.JTable();
        jOnline = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bDisconnect = new javax.swing.JButton();
        bConnect = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        configureDataBase = new javax.swing.JMenuItem();
        configureServer = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        aboutSoftware = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BG SOUND");
        setPreferredSize(new java.awt.Dimension(508, 338));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tWorkers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tWorkers);
        if (tWorkers.getColumnModel().getColumnCount() > 0) {
            tWorkers.getColumnModel().getColumn(0).setResizable(false);
            tWorkers.getColumnModel().getColumn(1).setResizable(false);
            tWorkers.getColumnModel().getColumn(2).setResizable(false);
            tWorkers.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 163, 500, 130));

        jOnline.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jOnline.setText("Online Workers :");
        getContentPane().add(jOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 114, 234, 43));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel2.setText("Server is down!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 788, 43));

        bDisconnect.setText("Disconnect");
        bDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDisconnectActionPerformed(evt);
            }
        });
        getContentPane().add(bDisconnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 231, 51));

        bConnect.setText("Connect");
        bConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConnectActionPerformed(evt);
            }
        });
        getContentPane().add(bConnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 231, 51));

        jMenu1.setText("Configure");

        configureDataBase.setText("DataBase");
        configureDataBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configureDataBaseActionPerformed(evt);
            }
        });
        jMenu1.add(configureDataBase);

        configureServer.setText("Server");
        configureServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configureServerActionPerformed(evt);
            }
        });
        jMenu1.add(configureServer);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");

        aboutSoftware.setText("Software");
        aboutSoftware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutSoftwareActionPerformed(evt);
            }
        });
        jMenu2.add(aboutSoftware);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutSoftwareActionPerformed
        JOptionPane.showMessageDialog(null, "This is software created by Milos Mutavdzic.");
    }//GEN-LAST:event_aboutSoftwareActionPerformed

    private void configureDataBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configureDataBaseActionPerformed
        // TODO add your handling code here:
        JFrame frame = new DatabaseSetup();
        frame.setVisible(true);
    }//GEN-LAST:event_configureDataBaseActionPerformed

    private void configureServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configureServerActionPerformed
        // TODO add your handling code here:
        JFrame frame = new ServerSetup();
        frame.setVisible(true);
    }//GEN-LAST:event_configureServerActionPerformed
    ServerThread serverThread;
    private void bConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConnectActionPerformed

        if (serverThread == null || !serverThread.isAlive()) {

            int port = Integer.parseInt(ServerController.getInstance().getHashmap().get("port").toString());
            System.out.println(port);
            serverThread = new ServerThread(port, this);
            serverThread.start();
        } else {
            System.out.println("Server is up already");
            return;
        }
        fillConnected();

    }//GEN-LAST:event_bConnectActionPerformed

    private void bDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDisconnectActionPerformed
        try {
            if (serverThread.getServerSocket() != null && serverThread.getServerSocket().isBound()) {
                serverThread.getServerSocket().close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        fillForm();
        tWorkers.setModel(new WorkerTableModel());


    }//GEN-LAST:event_bDisconnectActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutSoftware;
    private javax.swing.JButton bConnect;
    private javax.swing.JButton bDisconnect;
    private javax.swing.JMenuItem configureDataBase;
    private javax.swing.JMenuItem configureServer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jOnline;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tWorkers;
    // End of variables declaration//GEN-END:variables

    private void fillForm() {
        jLabel2.setText("Server is down!");
        jScrollPane1.setVisible(false);
        jLabel2.setVisible(true);
        bConnect.setVisible(true);
        jOnline.setVisible(false);
        bDisconnect.setVisible(false);

    }

    private void fillConnected() {
        jLabel2.setText("Server is up!");
        jScrollPane1.setVisible(true);
        tWorkers.setVisible(true);
        jOnline.setVisible(true);
        bDisconnect.setVisible(true);
        bConnect.setVisible(false);
        tWorkers.setModel(new WorkerTableModel());
        tWorkers.getColumnModel().getColumn(0).setMinWidth(50);
        tWorkers.getColumnModel().getColumn(0).setMaxWidth(50);

    }

    public void addWorker(Worker w) {
        WorkerTableModel tm = (WorkerTableModel) tWorkers.getModel();
        tm.addWorker(w);

    }

    public void removeWorker(Worker worker) {
        WorkerTableModel tm = (WorkerTableModel) tWorkers.getModel();
        tm.removeWorker(worker);
    }

    public boolean hasWorker(Worker w) {
        WorkerTableModel tm = (WorkerTableModel) tWorkers.getModel();
        return tm.getWorkers().contains(w);
    }
}
