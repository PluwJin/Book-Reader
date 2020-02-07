/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazılım_lab_1;

import javax.swing.JFrame;


public class Hatalar extends java.awt.Frame {

  
    public Hatalar() {
        initComponents();
    }

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(700, 400));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(360, 190));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(null);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(100, 80, 240, 50);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yazılım_lab_1/Pics&Icons/icons8_Delete_24px_1.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(320, 10, 30, 30);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Warning");
        add(jLabel1);
        jLabel1.setBounds(120, 20, 100, 40);

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yazılım_lab_1/Pics&Icons/icons8_Error_96px.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel2.setOpaque(true);
        add(jLabel2);
        jLabel2.setBounds(0, 0, 360, 190);

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        
    }//GEN-LAST:event_exitForm

    // JFRAME İ KAPATMAK İÇİN KULLANILAN METOD
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
  
    // HATALAR VE UYARILAR İÇİN BİR JFRAME KULLANILIR İLK METOD JFRAME DE GOSTERİLECEK LABEL YAZISINI AYARLAR
    // İKİNCİ METOD JFRAME İ GÖSTERMETE YARAR
    void hata_yazi_yaz(String hata){
        jLabel3.setText(hata);
        
    }
     void hata_goster(){
       setVisible(true);
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hatalar().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
