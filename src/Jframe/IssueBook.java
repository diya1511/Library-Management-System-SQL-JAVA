/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author diyaa
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
  public void getBookDetails(){
      int bookId = Integer.parseInt(txt_bookid.getText());
      try{
             Connection con = DBConnection.getConnection();
             String sql ="select * from book_details where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1,bookId);
            ResultSet rs = pst.executeQuery();
             if(rs.next()){
                 lbl_bookid.setText(rs.getString("book_id"));
                  lbl_bookname.setText(rs.getString("book_name"));
                  lbl_author.setText(rs.getString("author"));
                  lbl_quantity.setText(rs.getString("quantity"));
                 
                  
             }
             else{
                 lbl_bookerror.setText("Invalid Book ID");
             }
   
        }catch(Exception e){
             e.printStackTrace();
        }
      
          
  }
   public void getStudentDetails(){
      int studentId = Integer.parseInt(txt_studentid.getText());
      try{
             Connection con = DBConnection.getConnection();
             String sql ="select * from student_details where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1,studentId);
            ResultSet rs = pst.executeQuery();
             if(rs.next()){
                 lbl_studentid.setText(rs.getString("student_id"));
                  lbl_studentname.setText(rs.getString("name"));
                  lbl_course.setText(rs.getString("course"));
                  lbl_branch.setText(rs.getString("branch"));
                 
                  
             }
              else{
                 lbl_studenterror.setText("Invalid student ID");
             }
   
   
        }catch(Exception e){
             e.printStackTrace();
        }}
   public boolean issueBook(){
       boolean isIssued = false;
       int bookId = Integer.parseInt(txt_bookid.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());
        String bookName = lbl_bookname.getText();
        String studentName = lbl_studentname.getText();
         Date uIssueDate = date_issuedate.getDatoFecha();
   Date uDueDate = date_duedate.getDatoFecha();
   long l1 =uIssueDate.getTime();
      long l2 =uDueDate.getTime();
   java.sql.Date sIssueDate = new java.sql.Date(l1);
   java.sql.Date sDueDate = new java.sql.Date(l2);
   try{
             Connection con = DBConnection.getConnection();
             String sql ="insert into issue_book_details(book_id,book_name,student_id,student_name,"+"issue_date,due_date,status)values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1,bookId);
              pst.setString(2,bookName);
               pst.setInt(3,studentId);
              pst.setString(4,studentName);
              pst.setDate(5, sIssueDate);
              pst.setDate(6, sDueDate);
              pst.setString(7,"pending");
            int rowCount = pst.executeUpdate();
           if(rowCount >0){
                isIssued = true;
            }
            else{
                 isIssued = false;
            }
   
   
        }catch(Exception e){
             e.printStackTrace();
        }
   return isIssued;
   }
   public void updateBookCount(){
          int bookId = Integer.parseInt(txt_bookid.getText());
    try{
             Connection con = DBConnection.getConnection();
             String sql ="update book_details set quantity = quantity-1 where book_id = ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1,bookId);

            int rowCount = pst.executeUpdate();
           if(rowCount >0){
                 JOptionPane.showMessageDialog(this,"Book count updated");
            int initialcount = Integer.parseInt(lbl_quantity.getText());
           lbl_quantity.setText(Integer.toString(initialcount-1));}
           else{
               JOptionPane.showMessageDialog(this," Cant Update Book count");
            }
   
   
        }catch(Exception e){
             e.printStackTrace();
        }
   }
   
   public boolean isAlreadyIssued(){
       boolean isAlreadyIssued = false;
         int bookId = Integer.parseInt(txt_bookid.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());
        try{
              Connection con = DBConnection.getConnection();
             String sql ="select * from issue_book_details where book_id = ? and student_id = ?  and status = ?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setInt(1,bookId);
              pst.setInt(2,studentId);
               pst.setString(3,"pending");
                ResultSet rs = pst.executeQuery();
               if(rs.next()){
                isAlreadyIssued = true;
            }
            else{
                 isAlreadyIssued = false;
            }
   
            
        }catch(Exception e){
             e.printStackTrace();
        }
        return isAlreadyIssued;
   }
   
   
   
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_studentid = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel1128 = new javax.swing.JLabel();
        lbl_studenterror = new javax.swing.JLabel();
        jLabel1123 = new javax.swing.JLabel();
        txt_bookid = new app.bolivia.swing.JCTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel1126 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_bookid = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lbl_bookerror = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel23 = new javax.swing.JLabel();
        date_issuedate = new rojeru_san.componentes.RSDateChooser();
        date_duedate = new rojeru_san.componentes.RSDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(150, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 260, 5));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student Name :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 100, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 80, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Branch :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 80, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student Id :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 80, -1));

        lbl_course.setBackground(new java.awt.Color(255, 255, 255));
        lbl_course.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 100, 20));

        lbl_studentid.setBackground(new java.awt.Color(255, 255, 255));
        lbl_studentid.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl_studentid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 100, 20));

        lbl_studentname.setBackground(new java.awt.Color(255, 255, 255));
        lbl_studentname.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 130, 20));

        lbl_branch.setBackground(new java.awt.Color(255, 51, 0));
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 80, 20));

        jLabel1128.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel1128.setText(" Student Details");
        jPanel1.add(jLabel1128, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        lbl_studenterror.setBackground(new java.awt.Color(255, 255, 255));
        lbl_studenterror.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl_studenterror.setForeground(new java.awt.Color(255, 204, 0));
        jPanel1.add(lbl_studenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 190, 20));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, -10, 340, 670));

        jLabel1123.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1123.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel1123.setText("Issue Book");
        panel_main.add(jLabel1123, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, -1, -1));

        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 51, 0)));
        txt_bookid.setPlaceholder("Enter Book ID");
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        txt_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookidActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 250, -1, -1));

        jPanel10.setBackground(new java.awt.Color(255, 51, 0));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(150, 0, 153));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel28.setText("Back");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel28)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jLabel1126.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1126.setText(" Book Details");
        jPanel10.add(jLabel1126, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 260, 5));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Book Name :");
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 80, -1));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Author :");
        jPanel10.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 80, -1));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Book Id :");
        jPanel10.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 80, -1));

        lbl_author.setBackground(new java.awt.Color(255, 255, 255));
        lbl_author.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 100, 20));

        lbl_bookid.setBackground(new java.awt.Color(255, 255, 255));
        lbl_bookid.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl_bookid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lbl_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 100, 20));

        lbl_bookname.setBackground(new java.awt.Color(255, 255, 255));
        lbl_bookname.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 100, 20));

        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 70, 20));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Quantity:");
        jPanel10.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 80, -1));

        lbl_bookerror.setBackground(new java.awt.Color(255, 255, 255));
        lbl_bookerror.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl_bookerror.setForeground(new java.awt.Color(255, 204, 0));
        jPanel10.add(lbl_bookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 190, 20));

        panel_main.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 660));

        jLabel22.setBackground(new java.awt.Color(255, 51, 0));
        jLabel22.setFont(new java.awt.Font("Bahnschrift", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 51, 0));
        jLabel22.setText("Enter Book ID :");
        panel_main.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 170, 20));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 51, 0)));
        txt_studentid.setPlaceholder("Enter Student ID");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        txt_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentidActionPerformed(evt);
            }
        });
        panel_main.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 182, -1, 40));

        jLabel23.setBackground(new java.awt.Color(255, 51, 0));
        jLabel23.setFont(new java.awt.Font("Bahnschrift", 0, 17)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 0));
        jLabel23.setText("Enter Student ID :");
        panel_main.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 199, 170, -1));

        date_issuedate.setColorBackground(new java.awt.Color(255, 51, 0));
        date_issuedate.setColorButtonHover(new java.awt.Color(255, 153, 0));
        date_issuedate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_issuedate.setPlaceholder("Select Issue date");
        panel_main.add(date_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 340, -1, -1));

        date_duedate.setColorBackground(new java.awt.Color(255, 51, 0));
        date_duedate.setColorButtonHover(new java.awt.Color(255, 153, 0));
        date_duedate.setColorForeground(new java.awt.Color(0, 0, 0));
        date_duedate.setPlaceholder("Select due date");
        panel_main.add(date_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 440, -1, 40));

        jLabel24.setBackground(new java.awt.Color(255, 51, 0));
        jLabel24.setFont(new java.awt.Font("Bahnschrift", 0, 17)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 0));
        jLabel24.setText("Issue Date :");
        panel_main.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, 170, 30));

        jLabel25.setBackground(new java.awt.Color(255, 51, 0));
        jLabel25.setFont(new java.awt.Font("Bahnschrift", 0, 17)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 51, 0));
        jLabel25.setText("Due Date :");
        panel_main.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 170, 30));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 0));
        rSMaterialButtonCircle4.setText("ISSUE BOOK");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, 270, 50));
        rSMaterialButtonCircle4.getAccessibleContext().setAccessibleName("ISSUE BOOK");

        jPanel5.setBackground(new java.awt.Color(150, 0, 153));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        panel_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 50, 40));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 680));

        setSize(new java.awt.Dimension(1200, 658));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookidFocusLost
      if(!txt_bookid.getText().equals("")){
          
        getBookDetails();}
    }//GEN-LAST:event_txt_bookidFocusLost

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
       getStudentDetails();
    }//GEN-LAST:event_txt_studentidFocusLost

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
       if(lbl_quantity.getText().equals("0")){
            JOptionPane.showMessageDialog(this,"Book is not available");
       }
       else{
           if(isAlreadyIssued() == false){
              if(issueBook()== true){
           JOptionPane.showMessageDialog(this,"Book Issued Successfully");
           updateBookCount();
       }
       else{
           JOptionPane.showMessageDialog(this,"Can't issue the book");
       }
        }
        else{
             JOptionPane.showMessageDialog(this,"This student have already issued the book");
        }
      
       }
        
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
       Home home = new Home();
       home.setVisible(true);
       dispose();
    }//GEN-LAST:event_jPanel11MouseClicked

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_duedate;
    private rojeru_san.componentes.RSDateChooser date_issuedate;
    private javax.swing.JLabel jLabel1123;
    private javax.swing.JLabel jLabel1126;
    private javax.swing.JLabel jLabel1128;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookerror;
    private javax.swing.JLabel lbl_bookid;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studenterror;
    private javax.swing.JLabel lbl_studentid;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private app.bolivia.swing.JCTextField txt_bookid;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}
