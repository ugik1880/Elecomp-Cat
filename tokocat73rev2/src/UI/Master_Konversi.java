/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JFrame;

/**
 *
 * @author Dii
 */
public class Master_Konversi extends javax.swing.JFrame {

    /**
     * Creates new form Konversi
     */
    public Master_Konversi() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dTambahUpdateKonversi = new javax.swing.JDialog();
        vHarga3 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        btnBatal3 = new javax.swing.JButton();
        btnBatal4 = new javax.swing.JButton();
        jKonversi = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnTambahKonversi = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        vSearchKonversi = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();

        dTambahUpdateKonversi.setTitle("Tambah/Update Akun");
        dTambahUpdateKonversi.setBackground(new java.awt.Color(255, 255, 255));
        dTambahUpdateKonversi.setResizable(false);
        dTambahUpdateKonversi.setSize(new java.awt.Dimension(359, 131));

        jLabel34.setText("Nama");

        btnBatal3.setText("Batal");
        btnBatal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatal3ActionPerformed(evt);
            }
        });

        btnBatal4.setText("Simpan");
        btnBatal4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatal4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dTambahUpdateKonversiLayout = new javax.swing.GroupLayout(dTambahUpdateKonversi.getContentPane());
        dTambahUpdateKonversi.getContentPane().setLayout(dTambahUpdateKonversiLayout);
        dTambahUpdateKonversiLayout.setHorizontalGroup(
            dTambahUpdateKonversiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dTambahUpdateKonversiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dTambahUpdateKonversiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dTambahUpdateKonversiLayout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dTambahUpdateKonversiLayout.createSequentialGroup()
                        .addComponent(btnBatal4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(dTambahUpdateKonversiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dTambahUpdateKonversiLayout.createSequentialGroup()
                        .addComponent(btnBatal3)
                        .addGap(0, 135, Short.MAX_VALUE))
                    .addComponent(vHarga3))
                .addContainerGap())
        );
        dTambahUpdateKonversiLayout.setVerticalGroup(
            dTambahUpdateKonversiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dTambahUpdateKonversiLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(dTambahUpdateKonversiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vHarga3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(dTambahUpdateKonversiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal3)
                    .addComponent(btnBatal4))
                .addGap(21, 21, 21))
        );

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jKonversi.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setBackground(new java.awt.Color(217, 237, 247));
        jLabel24.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel24.setText("Konversi Form");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Tanggal | Waktu");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnTambahKonversi.setText("Tambah Konversi");
        btnTambahKonversi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKonversiActionPerformed(evt);
            }
        });

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "No", "Nama"
            }
        ));
        jScrollPane7.setViewportView(jTable7);

        vSearchKonversi.setText("Search");
        vSearchKonversi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vSearchKonversiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vSearchKonversiFocusLost(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jKonversiLayout = new javax.swing.GroupLayout(jKonversi);
        jKonversi.setLayout(jKonversiLayout);
        jKonversiLayout.setHorizontalGroup(
            jKonversiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jKonversiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jKonversiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jKonversiLayout.createSequentialGroup()
                        .addComponent(btnTambahKonversi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vSearchKonversi, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );
        jKonversiLayout.setVerticalGroup(
            jKonversiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jKonversiLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jKonversiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambahKonversi)
                    .addComponent(vSearchKonversi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jKonversi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jKonversi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahKonversiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKonversiActionPerformed
        dTambahUpdateKonversi.show();
        dTambahUpdateKonversi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnTambahKonversiActionPerformed

    private void vSearchKonversiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vSearchKonversiFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_vSearchKonversiFocusGained

    private void vSearchKonversiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vSearchKonversiFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_vSearchKonversiFocusLost

    private void btnBatal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatal3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBatal3ActionPerformed

    private void btnBatal4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatal4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBatal4ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        dTambahUpdateKonversi.show();
        dTambahUpdateKonversi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEditActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Master_Konversi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Master_Konversi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Master_Konversi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Master_Konversi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Master_Konversi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal3;
    private javax.swing.JButton btnBatal4;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnTambahKonversi;
    private javax.swing.JDialog dTambahUpdateKonversi;
    private javax.swing.JPanel jKonversi;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField vHarga3;
    private javax.swing.JTextField vSearchKonversi;
    // End of variables declaration//GEN-END:variables
}