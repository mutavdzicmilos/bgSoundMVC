/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.form;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.clientAPP.Logic.ThreadSaver;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.communication.utilities.Mode;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Copy;
import rs.ac.bg.student.fon.mutavdzicmilos.bgsound.domain.Equipment;

/**
 *
 * @author Milos <mm20160088@student.fon.bg.ac.rs>
 */
public class FEquipment extends javax.swing.JFrame {

    /**
     * Creates new form FEquipment
     */
    public FEquipment(Mode mode) {
        initComponents();
        buttonGroup1.add(rATrue);
        buttonGroup1.add(rAFalse);
        buttonGroup2.add(rWTrue);
        buttonGroup2.add(rWFalse);
        fillForm(mode);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tID = new javax.swing.JTextField();
        tName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tConnection = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tSpecification = new javax.swing.JTextArea();
        tNumber = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bFind = new javax.swing.JButton();
        bReset = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        bSaveEq = new javax.swing.JButton();
        jCopyPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cCopyChooser = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        rAFalse = new javax.swing.JRadioButton();
        rATrue = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        rWFalse = new javax.swing.JRadioButton();
        rWTrue = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tDefect = new javax.swing.JTextArea();
        bSaveCopy = new javax.swing.JButton();
        bDeleteCopy = new javax.swing.JButton();
        bEnableChanges = new javax.swing.JButton();
        bUpdateCopy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Equipment");
        setPreferredSize(new java.awt.Dimension(978, 690));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipment"));
        jPanel1.setName("jEquipmentPanel"); // NOI18N

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel1.setText("Equipment:");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel3.setText("ID:");

        tID.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        tID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIDActionPerformed(evt);
            }
        });

        tName.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel5.setText("Name:");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setText("Specification");

        tConnection.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N

        tSpecification.setColumns(20);
        tSpecification.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tSpecification.setRows(5);
        jScrollPane1.setViewportView(tSpecification);

        tNumber.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        tNumber.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel7.setText("Connection:");

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel6.setText("No. of Copies:");

        bFind.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        bFind.setText("Find");
        bFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFindActionPerformed(evt);
            }
        });

        bReset.setText("Reset values");
        bReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResetActionPerformed(evt);
            }
        });

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        bSaveEq.setText("Save Equipment");
        bSaveEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveEqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(bFind)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tNumber)
                        .addGap(146, 146, 146))
                    .addComponent(tConnection)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(tName)
                    .addComponent(tID, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSaveEq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bFind, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tConnection)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReset, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSaveEq, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jCopyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Copy"));

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel8.setText("Copy:");

        cCopyChooser.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        cCopyChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cCopyChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCopyChooserActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Available", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N

        rAFalse.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        rAFalse.setText("false");

        rATrue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        rATrue.setSelected(true);
        rATrue.setText("true");
        rATrue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rATrueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rAFalse, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(rATrue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(rAFalse, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rATrue, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Working", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanel3.setName(""); // NOI18N

        rWFalse.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        rWFalse.setText("false");
        rWFalse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rWFalseActionPerformed(evt);
            }
        });

        rWTrue.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        rWTrue.setSelected(true);
        rWTrue.setText("true");
        rWTrue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rWTrueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rWFalse, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(rWTrue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rWFalse, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rWTrue, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Defect", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 18))); // NOI18N

        tDefect.setColumns(20);
        tDefect.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tDefect.setRows(5);
        tDefect.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tDefectFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(tDefect);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bSaveCopy.setText("Save Copy");

        bDeleteCopy.setText("Delete Copy");
        bDeleteCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteCopyActionPerformed(evt);
            }
        });

        bEnableChanges.setText("Enable changes");
        bEnableChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEnableChangesActionPerformed(evt);
            }
        });

        bUpdateCopy.setText("Update Copy");
        bUpdateCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateCopyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jCopyPanelLayout = new javax.swing.GroupLayout(jCopyPanel);
        jCopyPanel.setLayout(jCopyPanelLayout);
        jCopyPanelLayout.setHorizontalGroup(
            jCopyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCopyPanelLayout.createSequentialGroup()
                .addGroup(jCopyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jCopyPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cCopyChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jCopyPanelLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jCopyPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jCopyPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCopyPanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jCopyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bUpdateCopy, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(bSaveCopy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jCopyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bEnableChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDeleteCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(160, 160, 160))
        );
        jCopyPanelLayout.setVerticalGroup(
            jCopyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCopyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jCopyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCopyChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jCopyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jCopyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSaveCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEnableChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jCopyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bUpdateCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDeleteCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCopyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCopyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIDActionPerformed

    private void bResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResetActionPerformed
        tName.setText("");
        tSpecification.setText("");
        tConnection.setText("");
        tNumber.setValue(0);
    }//GEN-LAST:event_bResetActionPerformed

    private void rWTrueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rWTrueActionPerformed
        // TODO add your handling code here:
        tDefect.setText("");
        tDefect.setEditable(false);
    }//GEN-LAST:event_rWTrueActionPerformed

    private void rATrueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rATrueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rATrueActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bUpdateCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateCopyActionPerformed
        // TODO add your handling code here:
        if (cCopyChooser.getItemCount() == 0) {
            return;
        }
        int eID = Integer.parseInt(tID.getText());
        int cID = Integer.parseInt(cCopyChooser.getSelectedItem().toString());

        Copy c = new Copy(cID, rWTrue.isSelected(), rATrue.isSelected(), new Equipment(eID), tDefect.getText().trim());
        boolean help = ThreadSaver.getInstance().getModel().updateCopy(c);
        if (help) {
            JOptionPane.showMessageDialog(null, "Success");
            cCopyChooser.removeItemAt(cCopyChooser.getSelectedIndex());
            if (cCopyChooser.getItemCount() == 0) {
                jCopyPanel.setVisible(false);
            }
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Error update!Check equipment!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }//GEN-LAST:event_bUpdateCopyActionPerformed

    private void bDeleteCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteCopyActionPerformed
        if (cCopyChooser.getItemCount() == 0) {
            return;
        }
        int eID = Integer.parseInt(tID.getText());
        int cID = Integer.parseInt(cCopyChooser.getSelectedItem().toString());
        Copy c = new Copy(cID, eID);
        boolean help = ThreadSaver.getInstance().getModel().deleteCopy(c);
        if (help) {
            JOptionPane.showMessageDialog(null, "Success");
            cCopyChooser.removeItemAt(cCopyChooser.getSelectedIndex());
            if (cCopyChooser.getItemCount() == 0) {
                jCopyPanel.setVisible(false);
            }
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Error delete!Check if equipment is rented!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_bDeleteCopyActionPerformed

    private void tDefectFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tDefectFocusGained
        // TODO add your handling code here:
        rWFalse.setSelected(true);
        rWTrue.setSelected(false);
    }//GEN-LAST:event_tDefectFocusGained

    private void bSaveEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveEqActionPerformed
        // TODO add your handling code here:
        String name = tName.getText().trim();
        String specification = tSpecification.getText().trim();
        String connection = tConnection.getText().trim();
        if (name.equals("") || specification.equals("") || connection.equals("")) {
            JOptionPane.showMessageDialog(null, "Error input.Check values.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Equipment e = ThreadSaver.getInstance().getModel().saveEquipment(new Equipment(connection, specification, name, null));
        if (e != null) {
            JOptionPane.showMessageDialog(null, "Saved sucessfully");
            tID.setText(e.getEquipmentID().toString());
        }


    }//GEN-LAST:event_bSaveEqActionPerformed

    private void bEnableChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEnableChangesActionPerformed
        fillForm(Mode.Mode_Update);
    }//GEN-LAST:event_bEnableChangesActionPerformed

    private void rWFalseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rWFalseActionPerformed
        // TODO add your handling code here:
        tDefect.setEditable(true);
    }//GEN-LAST:event_rWFalseActionPerformed

    private void bFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFindActionPerformed
        // TODO add your handling code here:
        JFrame frame = new FFindEq(this);
        frame.setVisible(true);
    }//GEN-LAST:event_bFindActionPerformed

    private void cCopyChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCopyChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cCopyChooserActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bDeleteCopy;
    private javax.swing.JButton bEnableChanges;
    private javax.swing.JButton bFind;
    private javax.swing.JButton bReset;
    private javax.swing.JButton bSaveCopy;
    private javax.swing.JButton bSaveEq;
    private javax.swing.JButton bUpdateCopy;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cCopyChooser;
    private javax.swing.JPanel jCopyPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rAFalse;
    private javax.swing.JRadioButton rATrue;
    private javax.swing.JRadioButton rWFalse;
    private javax.swing.JRadioButton rWTrue;
    private javax.swing.JTextField tConnection;
    private javax.swing.JTextArea tDefect;
    private javax.swing.JTextField tID;
    private javax.swing.JTextField tName;
    private javax.swing.JSpinner tNumber;
    private javax.swing.JTextArea tSpecification;
    // End of variables declaration//GEN-END:variables

    private void fillForm(Mode mode) {
        if (mode == Mode.Mode_Add) {
            tConnection.setEditable(true);
            tDefect.setEditable(true);
            bFind.setVisible(false);
            tName.setEditable(true);
            tID.setEditable(false);
            bSaveEq.setVisible(true);
            bCancel.setVisible(true);
            bReset.setVisible(true);
            jCopyPanel.setVisible(false);
            bEnableChanges.setVisible(false);
            return;
        }
        if (mode == Mode.Mode_View) {
            tConnection.setEditable(false);
            tDefect.setEditable(false);
            bFind.setVisible(true);
            tName.setEditable(false);
            tID.setEditable(false);
            bSaveEq.setVisible(false);
            bCancel.setVisible(true);
            tSpecification.setEditable(false);
            bReset.setVisible(false);
            jCopyPanel.setVisible(false);
            tNumber.setEnabled(false);
            bEnableChanges.setVisible(false);
            rATrue.setEnabled(false);
            rAFalse.setEnabled(false);
            rWTrue.setEnabled(false);
            rWFalse.setEnabled(false);
            return;
        }
        if (mode == Mode.Mode_Update) {
            tConnection.setEditable(false);
            tDefect.setEditable(true);
            tDefect.setEnabled(true);
            bFind.setVisible(true);
            tName.setEditable(false);
            tSpecification.setEditable(false);
            tID.setEditable(false);
            bSaveEq.setVisible(false);
            bCancel.setVisible(true);
            bReset.setVisible(false);
            jCopyPanel.setVisible(true);
            tNumber.setEnabled(false);
            bUpdateCopy.setVisible(true);
            bDeleteCopy.setVisible(true);
            bEnableChanges.setVisible(false);
            rATrue.setEnabled(true);
            rAFalse.setEnabled(true);
            rWTrue.setEnabled(true);
            rWFalse.setEnabled(true);
            tDefect.setEditable(true);
            return;
        }
    }

    public void set(Equipment e) {
        if (e == null) {
            return;
        }
        cCopyChooser.removeAllItems();
        tID.setText(e.getEquipmentID().toString());
        tID.setEditable(false);
        tName.setText(e.getName());
        tName.setEditable(false);
        tConnection.setText(e.getConnection());
        tConnection.setEditable(false);
        tSpecification.setText(e.getSpecification());
        tSpecification.setEditable(false);
        jLabel6.setVisible(false);
        tNumber.setVisible(false);
        if (e.getCopies() == null || e.getCopies().size() == 0) {
            jCopyPanel.setVisible(false);
            return;
        } else {
            jCopyPanel.setVisible(true);
            bEnableChanges.setVisible(true);
            bDeleteCopy.setVisible(false);
            bSaveCopy.setVisible(false);
            bUpdateCopy.setVisible(false);
            for (Copy c : e.getCopies()) {
                cCopyChooser.addItem(c.getCopyID().toString());

            }
        }
        rATrue.setSelected(e.getCopies().get(0).getAvailable());
        rWTrue.setSelected(e.getCopies().get(0).getWorking());
        tDefect.setText(e.getCopies().get(0).getDefect());
        tDefect.setEnabled(false);
    }

}