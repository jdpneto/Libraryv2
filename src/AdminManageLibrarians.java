/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminManageLibrarians.java
 *
 * Created on Nov 22, 2011, 1:48:00 AM
 */
/**
 *
 * @author jlnabais
 */
public class AdminManageLibrarians extends javax.swing.JFrame {

    Library dat;
    /** Creates new form AdminManageLibrarians */
    public AdminManageLibrarians() {
        this.dat = Library.Instance();
        initComponents();
        list_panel.setListData(dat.getLibrarians());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        search_field = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_panel = new javax.swing.JList();
        add_librarian = new javax.swing.JButton();
        edit_librarian = new javax.swing.JButton();
        delete_librarian = new javax.swing.JButton();
        admins_panel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Manage Librarians");

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(list_panel);

        add_librarian.setText("Add Librarian");
        add_librarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_librarianActionPerformed(evt);
            }
        });

        edit_librarian.setText("Edit Librarian");
        edit_librarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_librarianActionPerformed(evt);
            }
        });

        delete_librarian.setText("Delete Librarian");
        delete_librarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_librarianActionPerformed(evt);
            }
        });

        admins_panel.setText("Admin's Panel");
        admins_panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admins_panelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(306, 306, 306)
                        .add(jLabel1))
                    .add(layout.createSequentialGroup()
                        .add(30, 30, 30)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 444, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(33, 33, 33)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(admins_panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, edit_librarian, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, add_librarian, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .add(delete_librarian, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                            .add(layout.createSequentialGroup()
                                .add(search_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 193, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(search)))))
                .add(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(search_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(search))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(add_librarian)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(edit_librarian)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(delete_librarian)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(admins_panel))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void add_librarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_librarianActionPerformed
// TODO add your handling code here:
    new AddLibrarian().setVisible(true);
    dispose();
}//GEN-LAST:event_add_librarianActionPerformed

private void edit_librarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_librarianActionPerformed
// TODO add your handling code here:
    new EditLibrarian().setVisible(true);
    dispose();
}//GEN-LAST:event_edit_librarianActionPerformed

private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_searchActionPerformed

private void delete_librarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_librarianActionPerformed
// TODO add your handling code here:
    new DeleteLibrarian().setVisible(true);
    dispose();
}//GEN-LAST:event_delete_librarianActionPerformed

private void admins_panelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admins_panelActionPerformed
// TODO add your handling code here:
    new AdminForm().setVisible(true);
    dispose();
}//GEN-LAST:event_admins_panelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_librarian;
    private javax.swing.JButton admins_panel;
    private javax.swing.JButton delete_librarian;
    private javax.swing.JButton edit_librarian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list_panel;
    private javax.swing.JButton search;
    private javax.swing.JTextField search_field;
    // End of variables declaration//GEN-END:variables
}
