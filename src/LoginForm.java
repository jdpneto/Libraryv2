
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginForm.java
 *
 * Created on Nov 21, 2011, 11:40:47 PM
 */
/**
 *
 * @author jlnabais
 */
public class LoginForm extends javax.swing.JFrame {
    
    dataManager dat;
    /** Creates new form LoginForm */
    public LoginForm(dataManager dat) {
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

        login_field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        ok = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        error_msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        login_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_fieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Login:");

        jLabel2.setText("Password:");

        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        jLabel3.setText("Welcome to RS Library");

        error_msg.setForeground(new java.awt.Color(255, 0, 0));
        error_msg.setText("jLabel4");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(error_msg)
                    .add(jLabel3)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, login_field)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, ok)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, password_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 188, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3)
                .add(27, 27, 27)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(login_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(password_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(ok)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 36, Short.MAX_VALUE)
                .add(error_msg)
                .addContainerGap())
        );

        error_msg.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
// TODO add your handling code here:
    int option = dat.checkLogin(login_field.getText(),password_field.getText());
    if(option == 0){
        new AdminForm(dat).setVisible(true);
        dispose();
    }
    else if(option == 1){
        new LibrarianForm(dat).setVisible(true);
        dispose();
    }
    else if(option == 2){
        new UserForm(dat).setVisible(true);
        dispose();
    }

    else if(option == -1){
        System.out.println("cenas");
        error_msg.setText("Password invalid");
        error_msg.setVisible(true);
    }
    else if(option == -2){
        System.out.println("cenas");
        error_msg.setText("Username invalid");
        error_msg.setVisible(true);
    }
}//GEN-LAST:event_okActionPerformed

private void login_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_login_fieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error_msg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField login_field;
    private javax.swing.JButton ok;
    private javax.swing.JPasswordField password_field;
    // End of variables declaration//GEN-END:variables
}
