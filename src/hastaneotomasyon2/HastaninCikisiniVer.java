/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastaneotomasyon2;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class HastaninCikisiniVer extends javax.swing.JFrame {
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement psmt;
    public static String hastaTCKN = ""; 
    
    private static final int GUNLUK_YATIS_UCRETI = 50;
    
    private static final double EMEKLI_INDIRIMI = 1.75;
    private static final double SSK_INDIRIMI = 1.50;
    private static final double BAGKUR_INDIRIMI = 1.25;
    /**
     * Creates new form HastaninCikisiniVer
     */
    public HastaninCikisiniVer() {
        super("Hastanın Çıkışını Ver");
        initComponents();
        conn = JDBCUtil.getConnection();
        jTextField1.setText(hastaTCKN);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Hasta TC: ");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Hasta Listesi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ücreti Hesapla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ücret: ");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButton3.setText("Tamam");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jButton1))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addComponent(jButton2))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(37, 37, 37)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton3)
                .addGap(28, 28, 28))
        );

        setSize(new java.awt.Dimension(494, 375));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        RandevuAlanHastalar ob = new RandevuAlanHastalar();
        ob.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String query = "delete from randevu where hastaTC = '"+ jTextField1.getText() + "'";
        String query2 = "delete from oda where hastaTC = '"+ jTextField1.getText() + "'";
        String query3 = "delete from hasta where hastaTC = '"+ jTextField1.getText() + "'";
        try {
            psmt = conn.prepareStatement(query);
            psmt.execute();
            psmt.close();
            
            psmt = conn.prepareStatement(query2);
            psmt.execute();
            psmt.close();
            
            psmt = conn.prepareStatement(query3);
            psmt.execute();
            psmt.close();
            JOptionPane.showMessageDialog(null, "Hastanın çıkışı alındı.");
            psmt.close();
            
            jTextField1.setText("");
            jTextField2.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        setVisible(false);
        PersonelMain ob = new PersonelMain();
        ob.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String query1 = "select hastaTC from odahastarandevudoktor";
        String query2 = "select ucret, kacGun from odahastarandevudoktor where hastaTC = ?";
        String query3 = "select ucret from randevuucreti";
        
        long hastaTC = Long.parseLong(jTextField1.getText());
        boolean flag = false;
        double randevuUcreti = 0.0;
        long deneme = 0L;
        double randevununUcreti = 0.0;
        int ucret = 0;
        try {
            psmt = conn.prepareStatement(query1);
            rs = psmt.executeQuery();
            
            while(rs.next()){
                deneme = rs.getLong("hastaTC");
                if(hastaTC == deneme){
                    flag = true;
            }
            }
            
            
            System.out.println(flag);
            if(flag==true){
                
                psmt = conn.prepareStatement(query2);
                psmt.setString(1, String.valueOf(hastaTC));
                rs = psmt.executeQuery();
                int c = 0;
                int d = 0;
                while(rs.next()){
                    c = rs.getInt("ucret");
                    d = rs.getInt("kacGun");
                }
                
                psmt = conn.prepareStatement("select sosyalGuvenlik from hasta where hastaTC = ?");
                psmt.setString(1, String.valueOf(hastaTC));
                rs = psmt.executeQuery();
                String sosyal = "";
                while(rs.next()){
                    sosyal = rs.getString(1);
                }
                if(sosyal.equals("Emekli")){
                    randevuUcreti = (c + d*GUNLUK_YATIS_UCRETI)/EMEKLI_INDIRIMI;
                }else if(sosyal.equals("SSK")){
                    randevuUcreti = (c + d*GUNLUK_YATIS_UCRETI)/SSK_INDIRIMI;
                }else if(sosyal.equals("Bağkur")){
                    randevuUcreti = (c + d*GUNLUK_YATIS_UCRETI)/BAGKUR_INDIRIMI;
                }
                
            }else if(flag==false){
                
                psmt = conn.prepareStatement(query3);
                rs = psmt.executeQuery();
                int z = 0;
                while(rs.next()){
                    z = rs.getInt("ucret");
                }
                
                psmt = conn.prepareStatement("select sosyalGuvenlik from hasta where hastaTC = ?");
                psmt.setString(1, String.valueOf(hastaTC));
                rs = psmt.executeQuery();
                String sosyal = "";
                while(rs.next()){
                    sosyal = rs.getString(1);
                }
                if(sosyal.equals("Emekli")){
                    randevuUcreti = z/EMEKLI_INDIRIMI;
                }else if(sosyal.equals("SSK")){
                    randevuUcreti = z/SSK_INDIRIMI;
                }else if(sosyal.equals("Bağkur")){
                    randevuUcreti = z/BAGKUR_INDIRIMI;
                }
            }
            
            ucret = (int) randevuUcreti;
            jTextField2.setText(String.valueOf(ucret));
            
            rs.close();
            psmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

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
            java.util.logging.Logger.getLogger(HastaninCikisiniVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HastaninCikisiniVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HastaninCikisiniVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HastaninCikisiniVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HastaninCikisiniVer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}