/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditBook.java
 *
 * Created on Nov 22, 2011, 3:23:20 AM
 */
/**
 *
 * @author jlnabais
 */
public class EditBook extends javax.swing.JFrame {

    dataManager dat;
    /** Creates new form EditBook */
    public EditBook(dataManager dat) {
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

        add_user = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        title_field = new javax.swing.JTextField();
        author_field = new javax.swing.JTextField();
        isbn_field = new javax.swing.JTextField();
        category_field = new javax.swing.JTextField();
        year_field = new javax.swing.JTextField();
        copies_field = new javax.swing.JTextField();
        submit_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add_user.setText("Edit Book");

        jLabel2.setText("Title:");

        jLabel1.setText("Author:");

        jLabel3.setText("ISBN:");

        jLabel4.setText("Year:");

        jLabel5.setText("Category:");

        jLabel6.setText("Number of Copies:");

        title_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title_fieldActionPerformed(evt);
            }
        });

        author_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                author_fieldActionPerformed(evt);
            }
        });

        isbn_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbn_fieldActionPerformed(evt);
            }
        });

        category_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category_fieldActionPerformed(evt);
            }
        });

        year_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_fieldActionPerformed(evt);
            }
        });

        copies_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copies_fieldActionPerformed(evt);
            }
        });

        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        back_button.setText("Back to Panel");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(292, 292, 292)
                .add(add_user)
                .addContainerGap(358, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(130, 130, 130)
                        .add(submit_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 240, Short.MAX_VALUE)
                        .add(back_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(43, 43, 43)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel1)
                            .add(jLabel3)
                            .add(jLabel6)
                            .add(jLabel5)
                            .add(jLabel4))
                        .add(36, 36, 36)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(copies_field)
                            .add(year_field)
                            .add(category_field)
                            .add(isbn_field)
                            .add(author_field)
                            .add(title_field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))))
                .add(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(add_user)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(title_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(author_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(isbn_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(year_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(category_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(copies_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 78, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(submit_button)
                    .add(back_button))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void title_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_title_fieldActionPerformed

private void author_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_author_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_author_fieldActionPerformed

private void isbn_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbn_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_isbn_fieldActionPerformed

private void category_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_category_fieldActionPerformed

private void year_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_year_fieldActionPerformed

private void copies_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copies_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_copies_fieldActionPerformed

private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_submit_buttonActionPerformed

private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
// TODO add your handling code here:
    new ManageBooks(dat).setVisible(true);
    dispose();
}//GEN-LAST:event_back_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_user;
    private javax.swing.JTextField author_field;
    private javax.swing.JButton back_button;
    private javax.swing.JTextField category_field;
    private javax.swing.JTextField copies_field;
    private javax.swing.JTextField isbn_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton submit_button;
    private javax.swing.JTextField title_field;
    private javax.swing.JTextField year_field;
    // End of variables declaration//GEN-END:variables
}
