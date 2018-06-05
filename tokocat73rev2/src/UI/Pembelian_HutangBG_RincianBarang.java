/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Class.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author 7
 */
public final class Pembelian_HutangBG_RincianBarang extends javax.swing.JFrame {

    private int totalHutang = 0;
    private int jumFaktur = 0;
    private String[] noFaktur;
    private int[] hrgItem;
    private int bank1 = 0;
    private int bank2 = 0;

    String fakturBP = null;

    int keuangan1 = 0;
    int keuangan2 = 0;

    String year = null;

    public Pembelian_HutangBG_RincianBarang() {
        initComponents();
        this.setVisible(true);
        bank();
    }

    public Pembelian_HutangBG_RincianBarang(int totalHutang, int jumFaktur, String[] noFaktur, int[] hrgItem) {
        initComponents();
        this.totalHutang = totalHutang;
        this.jumFaktur = jumFaktur;
        this.noFaktur = noFaktur;
        this.hrgItem = hrgItem;

        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Calendar cal = Calendar.getInstance();
        this.year = sdf.format(cal.getTime());

        txt_blm_byr.setText("" + totalHutang);

        for (int i = 0; i < this.jumFaktur; i++) {
            System.out.println("Data " + i + " ------" + this.noFaktur[i] + "--------" + this.hrgItem[i]);
        }

    }

    public void autoSum() {
        int bayar = 0;
        int bayar2 = 0;
        if (txt_byr_1.getText().equals("")) {
            bayar = 0;
        } else {
            bayar = Integer.parseInt(txt_byr_1.getText());
        }
        if (txt_byr_2.getText().equals("")) {
            bayar2 = 0;
        } else {
            bayar2 = Integer.parseInt(txt_byr_2.getText());
        }
        int kembali = (bayar + bayar2) + totalHutang;
        txt_kembali.setText("" + kembali);

    }

    public void bank() {
        String sql = "select nama_keuangan "
                + "from transaksi_nama_keuangan";
        try {
            Connection conn = (Connection) Koneksi.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                com_bank1.addItem(res.getString("nama_keuangan"));
                com_bank2.addItem(res.getString("nama_keuangan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bayar() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar cal = Calendar.getInstance();
        try {
            String sqlA = null, sqlB = null;
            for (int i = 0; i < jumFaktur; i++) {

                sqlA = "update pembelian SET biaya_pembayaran = 0 WHERE no_faktur_pembelian = '" + noFaktur[i] + "'";

                sqlB = "INSERT INTO transaksi_master values ("
                        + null + ",'" + fakturBP + "','','" + noFaktur[i] + "','" + sdf.format(cal.getTime()) + "'"
                        + ",'0'," + hrgItem[i] + ",'0','0','" + txt_ket.getText() + "','" + keuangan1 + 1 + "'"
                        + ",'0','0','0000-00-00 00:00:00','0000-00-00')";

                Connection conn = (Connection) Koneksi.configDB();
                Statement stat = conn.createStatement();
                stat.executeUpdate(sqlA);
                stat.executeUpdate(sqlB);
            }
            System.out.println("Jum = " + jumFaktur);
            JOptionPane.showMessageDialog(this, "Sukses");
            Pembelian_Hutang a = new Pembelian_Hutang();
            a.loadTable();
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fakturBP() {
        String lastNo = "";
        try {
            String sql = "select faktur_bp from transaksi_master"
                    + " WHERE faktur_bp LIKE 'BP%' ORDER BY faktur_bp desc LIMIT 1";
            Connection conn = (Connection) Koneksi.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                String nomor = res.getString("faktur_bp");
                if (nomor.substring(2, 4).equalsIgnoreCase(year)) {
                    int noLama = Integer.parseInt(nomor.substring(nomor.length() - 5));
                    noLama++;
                    String no = Integer.toString(noLama);
                    if (no.length() == 1) {
                        no = "0000" + no;
                    } else if (no.length() == 2) {
                        no = "000" + no;
                    } else if (no.length() == 3) {
                        no = "00" + no;
                    } else if (no.length() == 3) {
                        no = "0" + no;
                    }
                    lastNo = no;
                } else {
                    lastNo = "00001";
                }

            } else {
                lastNo = "00001";
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR: \n" + ex.toString(),
                    "Kesalahan", JOptionPane.WARNING_MESSAGE);
            ex.printStackTrace();
        }
        this.fakturBP = "BP" + year + "-" + lastNo;

        System.out.println("Faktur BP = " + fakturBP);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel69 = new javax.swing.JLabel();
        txt_kembali = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        txt_ket = new javax.swing.JTextField();
        txt_byr_2 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        txt_blm_byr = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();
        txt_byr_1 = new javax.swing.JTextField();
        com_bank1 = new javax.swing.JComboBox<>();
        com_bank2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel69.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel69.setText("Cara Bayar");

        txt_kembali.setEditable(false);
        txt_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kembaliActionPerformed(evt);
            }
        });

        jLabel75.setForeground(new java.awt.Color(51, 51, 51));
        jLabel75.setText("Bayar");

        txt_byr_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_byr_2KeyReleased(evt);
            }
        });

        jLabel70.setForeground(new java.awt.Color(51, 51, 51));
        jLabel70.setText("Belum Bayar");

        jLabel78.setForeground(new java.awt.Color(51, 51, 51));
        jLabel78.setText("Bayar 2");

        txt_blm_byr.setEditable(false);

        jLabel77.setForeground(new java.awt.Color(51, 51, 51));
        jLabel77.setText("Keuangan 2");

        jLabel83.setForeground(new java.awt.Color(51, 51, 51));
        jLabel83.setText("Kembalian");

        jButton19.setBackground(new java.awt.Color(153, 153, 153));
        jButton19.setText("Close");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel81.setForeground(new java.awt.Color(51, 51, 51));
        jLabel81.setText("Keterangan");

        jLabel74.setForeground(new java.awt.Color(51, 51, 51));
        jLabel74.setText("Keuangan");

        jButton18.setBackground(new java.awt.Color(85, 222, 93));
        jButton18.setText("Bayar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jSeparator11.setForeground(new java.awt.Color(204, 204, 204));

        txt_byr_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_byr_1KeyReleased(evt);
            }
        });

        com_bank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_bank1ActionPerformed(evt);
            }
        });

        com_bank2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com_bank2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator11)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel81)
                                    .addComponent(jLabel83))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ket, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton18)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel70)
                                    .addComponent(jLabel74)
                                    .addComponent(jLabel75)
                                    .addComponent(jLabel77)
                                    .addComponent(jLabel78))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_blm_byr, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(txt_byr_2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(txt_byr_1)
                                    .addComponent(com_bank1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(com_bank2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 62, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_blm_byr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(com_bank1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(txt_byr_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(com_bank2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(txt_byr_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(txt_ket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kembaliActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

    }//GEN-LAST:event_jButton18ActionPerformed

    private void txt_byr_1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_byr_1KeyReleased
        autoSum();
    }//GEN-LAST:event_txt_byr_1KeyReleased

    private void txt_byr_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_byr_2KeyReleased
        autoSum();
    }//GEN-LAST:event_txt_byr_2KeyReleased

    private void com_bank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_bank1ActionPerformed
        int bank1 = com_bank1.getSelectedIndex() + 1;
        this.keuangan1 = bank1;
    }//GEN-LAST:event_com_bank1ActionPerformed

    private void com_bank2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com_bank2ActionPerformed
        int bank2 = com_bank2.getSelectedIndex() + 1;
        this.keuangan2 = bank2;
    }//GEN-LAST:event_com_bank2ActionPerformed

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
            java.util.logging.Logger.getLogger(Pembelian_HutangBG_RincianBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembelian_HutangBG_RincianBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembelian_HutangBG_RincianBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembelian_HutangBG_RincianBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembelian_HutangBG_RincianBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> com_bank1;
    private javax.swing.JComboBox<String> com_bank2;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JTextField txt_blm_byr;
    private javax.swing.JTextField txt_byr_1;
    private javax.swing.JTextField txt_byr_2;
    private javax.swing.JTextField txt_kembali;
    private javax.swing.JTextField txt_ket;
    // End of variables declaration//GEN-END:variables
}
