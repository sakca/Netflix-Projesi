package projekod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class giris extends javax.swing.JFrame {

    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst =null;
    
    
    public giris() {
        initComponents();
        conn=baglama.java_baglama();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_sifre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        kayit_butonu = new javax.swing.JButton();
        txt_mail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Giris Sayfasi");
        setBackground(new java.awt.Color(0, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        setForeground(java.awt.Color.white);
        setLocation(new java.awt.Point(500, 250));
        setPreferredSize(new java.awt.Dimension(500, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_sifre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sifreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_sifre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 150, 30));

        jLabel2.setText("Sifre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 50, -1));

        jButton1.setText("Giris Yap");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        kayit_butonu.setText("Kayit Ol");
        kayit_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kayit_butonuActionPerformed(evt);
            }
        });
        getContentPane().add(kayit_butonu, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        txt_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mailActionPerformed(evt);
            }
        });
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 150, 30));

        jLabel1.setText("Mail adresi");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 60, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projekod/WhatsApp Image 2020-06-01 at 16.37.56.jpeg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -150, 500, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kayit_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kayit_butonuActionPerformed

        kayit j= new kayit();
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kayit_butonuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String sql="select mail, sifre from kullanicilar where (mail=? and sifre=?)";

        try {

            int count=0;

            pst=conn.prepareStatement(sql);

            pst.setString(1, txt_mail.getText());
            pst.setString(2, txt_sifre.getText());

            rs=pst.executeQuery();

            while(rs.next())
            {
                count= count+1;
            }
            String access1 =txt_mail.getText();
            String access2 =txt_sifre.getText();

            if(access1!=null && access2!=null)
            {
                if(count==1)
                {
                    JOptionPane.showMessageDialog(null, "Basarili");
                    menu j= new menu();
                    j.setVisible(true);
                    this.dispose();


                }

                else {

                    JOptionPane.showMessageDialog(null, "Mail ya da sifre yanlis");

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        finally {

            try {

                rs.close();
                pst.close();

            } catch (Exception e) {
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_sifreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sifreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sifreActionPerformed

    private void txt_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mailActionPerformed

    
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
            java.util.logging.Logger.getLogger(giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(giris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new giris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton kayit_butonu;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_sifre;
    // End of variables declaration//GEN-END:variables
}