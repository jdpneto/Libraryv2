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

    dataManager dat;
    /** Creates new form LibrarianForm */
    public LibrarianForm(dataManager dat) {
        this.dat = dat;
        initComponents();
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
        list_field = new javax.swing.JList();
        add_user = new javax.swing.JButton();
        manage_book = new javax.swing.JButton();
        manage_reservations = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jLabel1.setText("Librarian Panel");

        jLabel2.setText("Critical Reservations:");

        jScrollPane1.setViewportView(list_field);

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
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(97, 97, 97)
                        .add(add_user)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(manage_book)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(manage_reservations)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 158, Short.MAX_VALUE)
                        .add(logout))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1)
                        .add(27, 27, 27)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 284, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void add_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_userActionPerformed
// TODO add your handling code here:
    new AddUser(dat).setVisible(true);
    dispose();
}//GEN-LAST:event_add_userActionPerformed

private void manage_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_bookActionPerformed
// TODO add your handling code here:
    new ManageBooks(dat).setVisible(true);
    dispose();
}//GEN-LAST:event_manage_bookActionPerformed

private void manage_reservationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manage_reservationsActionPerformed
// TODO add your handling code here:
    new ManageReservations(dat).setVisible(true);
    dispose();
}//GEN-LAST:event_manage_reservationsActionPerformed

private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
// TODO add your handling code here:
    new LoginForm(dat).setVisible(true);
    dispose();
}//GEN-LAST:event_logoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list_field;
    private javax.swing.JButton logout;
    private javax.swing.JButton manage_book;
    private javax.swing.JButton manage_reservations;
    // End of variables declaration//GEN-END:variables
}
