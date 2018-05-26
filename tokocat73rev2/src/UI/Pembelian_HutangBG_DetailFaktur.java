/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Class.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public final class Pembelian_HutangBG_DetailFaktur extends javax.swing.JFrame {

    private int totalHutang = 0;
    private int jumFaktur = 0;
    private String[] noFaktur;
    private int[] hrgItem;

    String noFakturBG = null;

    /**
     * Creates new form NewJFrame
     */
    public Pembelian_HutangBG_DetailFaktur() {
        initComponents();
        this.setVisible(true);
        //  loadTable();
    }

    public Pembelian_HutangBG_DetailFaktur(String noFakturBG) {
        initComponents();
        this.noFakturBG = noFakturBG;
        System.out.println(noFakturBG);
        loadTable();
    }

    public void loadTable() {

        DefaultTableModel model = (DefaultTableModel) tbl_hutangBgFaktur.getModel();
        int i = 1;
        try {
            String sql = "SELECT pembelian.faktur_bg, pembelian.tgl_pembelian, supplier.nama_supplier, pembelian.biaya_pembayaran"
                    + " FROM pembelian, supplier WHERE pembelian.kode_supplier = supplier.kode_supplier and faktur_bg = '" + noFakturBG + "'";

            //System.out.println(sql);
            Connection conn = (Connection) Koneksi.configDB();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{
                    false,
                    i++,
                    res.getString("faktur_bg"),
                    dotConverter(res.getString("tgl_pembelian")),
                    res.getString("nama_supplier"),
                    res.getString("biaya_pembayaran")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeRow() {
        DefaultTableModel model = (DefaultTableModel) tbl_hutangBgFaktur.getModel();
        int row = tbl_hutangBgFaktur.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }
    }

    static String dotConverter(String b) {
        b = b.replace(".0", "");
        return b;
    }

    void selectAll() {
        DefaultTableModel model = (DefaultTableModel) tbl_hutangBgFaktur.getModel();
        if (chk_pilihSemua.isSelected()) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(true, i, 0);
            }
        } else {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.setValueAt(false, i, 0);
            }
        }
        autoSum();
    }

    public void autoSum() {
        int totalHutang = 0;
        int jumlahBaris = tbl_hutangBgFaktur.getRowCount();
        boolean action;
        int hargaItem = 0;
        int totalPotongan = 0;
        int jumFaktur = 0;
        noFaktur = new String[jumlahBaris];
        hrgItem = new int[jumlahBaris];

        TableModel tabelModel = tbl_hutangBgFaktur.getModel();
        for (int i = 0; i < jumlahBaris; i++) {
            action = (boolean) tabelModel.getValueAt(i, 0);
            if (action == true) {
                hargaItem = Integer.valueOf(tabelModel.getValueAt(i, 5).toString());
                hrgItem[jumFaktur] = hargaItem;
                //totalPotongan = Integer.valueOf(tabelModel.getValueAt(i, 5).toString());
                noFaktur[jumFaktur] = String.valueOf(tabelModel.getValueAt(i, 2));
                jumFaktur++;
            } else {
                hargaItem = 0;
                totalPotongan = 0;
            }
            totalHutang += hargaItem;
        }
        txt_total.setText("" + totalHutang);

        for (int i = 0; i < jumFaktur; i++) {
            System.out.println("noFaktur " + i + " " + noFaktur[i] + " Harga = " + hrgItem[i]);
        }
        System.out.println("=================================");
        this.jumFaktur = jumFaktur;
        this.totalHutang = totalHutang;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_total = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_hutangBgFaktur = new javax.swing.JTable();
        chk_pilihSemua = new javax.swing.JCheckBox();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Detail Faktur");

        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(71, 166, 227));
        jButton12.setText("Bayar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        tbl_hutangBgFaktur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "No", "No Faktur Pembelian", "Tanggal", "Supplier", "biaya"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_hutangBgFaktur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hutangBgFakturMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_hutangBgFaktur);

        chk_pilihSemua.setText("Pilih Semua");
        chk_pilihSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_pilihSemuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12)
                                .addGap(18, 18, 18)
                                .addComponent(chk_pilihSemua))
                            .addComponent(jLabel48))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12)
                    .addComponent(chk_pilihSemua))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(804, 454));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Pembelian_HutangBG_RincianBarang rb = new Pembelian_HutangBG_RincianBarang(totalHutang, jumFaktur, noFaktur, hrgItem);
        rb.setVisible(true);
        rb.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void chk_pilihSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_pilihSemuaActionPerformed
        selectAll();
    }//GEN-LAST:event_chk_pilihSemuaActionPerformed

    private void tbl_hutangBgFakturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hutangBgFakturMouseClicked
        autoSum();
    }//GEN-LAST:event_tbl_hutangBgFakturMouseClicked

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
            java.util.logging.Logger.getLogger(Pembelian_HutangBG_DetailFaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembelian_HutangBG_DetailFaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembelian_HutangBG_DetailFaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembelian_HutangBG_DetailFaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Pembelian_HutangBG_DetailFaktur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chk_pilihSemua;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_hutangBgFaktur;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
