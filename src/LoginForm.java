
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
        String [] types = { "Admin", "Librarian", "Reader"};
        type_box = new javax.swing.JComboBox(types);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        login_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_fieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Login:");

        jLabel2.setText("Password:");

        password_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_fieldActionPerformed(evt);
            }
        });

        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        jLabel3.setText("Welcome to RS Library");

        error_msg.setForeground(new java.awt.Color(220, 0, 0));
        error_msg.setText("Error");

        type_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        type_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_boxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(error_msg)
                    .add(jLabel3)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, login_field)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, ok)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, password_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 188, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(27, 27, 27)
                        .add(type_box, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3)
                .add(27, 27, 27)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(login_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(type_box, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(password_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(ok)
                .add(28, 28, 28)
                .add(error_msg)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        error_msg.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
//TODO:Métodos para ligar uma ou outra (factory)?
    //TODO: Falar com o prof sobre o singleton que está no eclipse
    Person p = new Person();
    p.setLogin(login_field.getText());
    p.setPassword(password_field.getText());
    p = dat.checkLogin(p);
    if (p.getId() > 0) {
        int option = type_box.getSelectedIndex();
        if (option == 0 && p.type[0] == 1) {
            new AdminForm(dat).setVisible(true);
            dispose();
        } else if (option == 1 && p.type[1] == 1) {
            new LibrarianForm(dat).setVisible(true);
            dispose();
        } else if (option == 2 && p.type[2] == 1) {
            new UserForm(dat).setVisible(true);
            dispose();
        } else if(option == -1){
            error_msg.setText("Error");
            error_msg.setVisible(true);
        }
    } else if (p.getId() == -1) {
        System.out.println("cenas");
        error_msg.setText("Username invalid");
        error_msg.setVisible(true);
    } else if (p.getId() == -2) {
        System.out.println("cenas");
        error_msg.setText("Password invalid");
        error_msg.setVisible(true);
    }
}//GEN-LAST:event_okActionPerformed

private void login_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_fieldActionPerformed
}//GEN-LAST:event_login_fieldActionPerformed

private void password_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_fieldActionPerformed
}//GEN-LAST:event_password_fieldActionPerformed

    private void type_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_boxActionPerformed
    }//GEN-LAST:event_type_boxActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error_msg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField login_field;
    private javax.swing.JButton ok;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JComboBox type_box;
    // End of variables declaration//GEN-END:variables
}
