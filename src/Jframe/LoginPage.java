/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import static Jframe.DBConnection.con;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author diyaa
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form SignUp Page
     */
    public LoginPage() {
        initComponents();
    }
    public boolean validateLogin(){
          String name = txt_username.getText();
         String pwd = txt_password.getText();
            if(name.equals("")){
               JOptionPane.showMessageDialog(this,"Please enter username");
               return false;
         }
          if(pwd.equals("")){
               JOptionPane.showMessageDialog(this,"Please enter password");
               return false;
         } 
          return true;
    }

    public void login(){
        String name = txt_username.getText();
         String pwd = txt_password.getText();
        try{
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","Ra@09091976");
             PreparedStatement pst = con.prepareStatement("select * from user where name = ? and password = ?");
         pst.setString(1, name);
           pst.setString(2, pwd);
             ResultSet rs = pst.executeQuery();
             if (rs.next()){
               JOptionPane.showMessageDialog(this,"Login Successfully");
              Home home = new Home();
              home.setVisible(true);
              this.dispose();
             }
             else{
                 JOptionPane.showMessageDialog(this,"Wrong credential");
             }
         } catch(Exception e){
             e.printStackTrace();
             
         }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        jLabel18 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 800));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Vivekananand ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, 30));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("LIBRARY !");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 130, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Swami ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 30));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("WELCOME TO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 160, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/library-3.png.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 80, 740, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 830));

        jPanel2.setBackground(new java.awt.Color(150, 0, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 170, 20));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 40, 30));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Welcome, Login to your Account");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 280, 20));

        txt_password.setBackground(new java.awt.Color(153, 0, 153));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setPhColor(new java.awt.Color(255, 255, 255));
        txt_password.setPlaceholder("Password");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 90, 80));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 90, 80));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Username");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 170, 20));

        txt_username.setBackground(new java.awt.Color(153, 0, 153));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setPhColor(new java.awt.Color(255, 255, 255));
        txt_username.setPlaceholder("Enter your Username");
        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle1.setText("Sign Up");
        rSMaterialButtonCircle1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rSMaterialButtonCircle1FocusLost(evt);
            }
        });
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 200, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 102, 255));
        rSMaterialButtonCircle2.setText("Login");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 200, 60));

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Login Page ");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 160, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 540, 830));

        setSize(new java.awt.Dimension(1308, 758));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
  
       
       
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
       if(validateLogin()== true){
           login();
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
   
    }//GEN-LAST:event_txt_usernameFocusLost

    private void rSMaterialButtonCircle1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1FocusLost

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
