/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LibrarianForm.java
 *
 * Created on Nov 21, 2011, 11:46:02 PM
 */
/**
 *
 * @author jlnabais
 */
public class LibrarianForm extends javax.swing.JFrame {

    Library dat;
    /** Creates new form LibrarianForm */
    public LibrarianForm() {
        this.dat = Library.Instance();
        initComponents();
        list_panel.setListData(dat.loadLibrarianLog());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_panel = new javax.swing.JList();
        add_user = new javax.swing.JButton();
        manage_book = new javax.swing.JButton();
        manage_reservations = new javax.swing.JButton();
        search_users = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jLabel1.setText("Librarian Panel");

        jLabel2.setText("Log");

        jScrollPane1.setViewportView(list_panel);

        add_user.setText("Add User");
        add_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_userActionPerformed(evt);
            }
        });

        manage_book.setText("Manage Books");
        manage_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_bookActionPerformed(evt);
            }
        });

        manage_reservations.setText("Manage Reservations");
        manage_reservations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manage_reservationsActionPerformed(evt);
            }
        });

        search_users.setText("Search/Edit User");
        search_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                search_usersMouseReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(384, 384, 384)
                        .add(jLabel1))
                    .add(layout.createSequentialGroup()
                        .add(74, 74, 74)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 418, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(search_users, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .add(manage_reservations, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .add(add_user, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .add(logout, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .add(manage_book, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
                            .add(jLabel2))))
                .add(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(27, 27, 27)
                .add(jLabel2)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(add_user)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(manage_book)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(manage_reservations)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(search_users)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 161, Short.MAX_VALUE)
                        .add(logout))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 284, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void add_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_userActionPerformed
// TODO add your handling code here:
    new AddUser(2).setVisible(true);
    dispose();
}//GEN-LAST:event_add_userActionPerformed

private void manage_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_bookActionPerformed
// TODO add your handling code here:
    new ManageBooks().setVisible(true);
    dispose();
}//GEN-LAST:event_manage_bookActionPerformed

private void manage_reservationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_reservationsActionPerformed
// TODO add your handling code here:
    new ManageReservations().setVisible(true);
    dispose();
}//GEN-LAST:event_manage_reservationsActionPerformed

private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
// TODO add your handling code here:
    new LoginForm().setVisible(true);
    dispose();
}//GEN-LAST:event_logoutActionPerformed

    private void search_usersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_usersMouseReleased
        new SearchEditUser().setVisible(true);
        dispose();
    }//GEN-LAST:event_search_usersMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list_panel;
    private javax.swing.JButton logout;
    private javax.swing.JButton manage_book;
    private javax.swing.JButton manage_reservations;
    private javax.swing.JButton search_users;
    // End of variables declaration//GEN-END:variables
}
