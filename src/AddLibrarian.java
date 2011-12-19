
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddLibrarian.java
 *
 * Created on Nov 22, 2011, 3:23:20 AM
 */
/**
 *
 * @author jlnabais
 */
public class AddLibrarian extends javax.swing.JFrame {
    
    dataManager dat;
    /** Creates new form AddLibrarian */
    public AddLibrarian(dataManager dat) {
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
        name_field = new javax.swing.JTextField();
        phone_field = new javax.swing.JTextField();
        email_field = new javax.swing.JTextField();
        login_field = new javax.swing.JTextField();
        expires_field = new javax.swing.JTextField();
        password_field = new javax.swing.JTextField();
        submit_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        street_field = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        city_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        postal_code_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        door_number_field = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        country_field = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add_user.setText("Add Librarian");

        jLabel2.setText("Name:");

        jLabel1.setText("Phone:");

        jLabel3.setText("Email:");

        jLabel4.setText("Expires:");

        jLabel5.setText("Login:");

        jLabel6.setText("Password:");

        name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_fieldActionPerformed(evt);
            }
        });

        phone_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_fieldActionPerformed(evt);
            }
        });

        email_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_fieldActionPerformed(evt);
            }
        });

        login_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_fieldActionPerformed(evt);
            }
        });

        expires_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expires_fieldActionPerformed(evt);
            }
        });

        password_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_fieldActionPerformed(evt);
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

        street_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                street_fieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Street");

        city_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                city_fieldActionPerformed(evt);
            }
        });

        jLabel8.setText("City:");

        postal_code_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postal_code_fieldActionPerformed(evt);
            }
        });

        jLabel9.setText("Postal Code:");

        door_number_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                door_number_fieldActionPerformed(evt);
            }
        });

        jLabel10.setText("Door Number:");

        country_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country_fieldActionPerformed(evt);
            }
        });

        jLabel11.setText("Country:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(292, 292, 292)
                .add(add_user)
                .addContainerGap(308, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(130, 130, 130)
                        .add(submit_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 221, Short.MAX_VALUE)
                        .add(back_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(43, 43, 43)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel1)
                            .add(jLabel3)
                            .add(jLabel6)
                            .add(jLabel5)
                            .add(jLabel4)
                            .add(jLabel7)
                            .add(jLabel8)
                            .add(jLabel9)
                            .add(jLabel10)
                            .add(jLabel11))
                        .add(36, 36, 36)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(country_field)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, door_number_field)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, postal_code_field)
                            .add(street_field)
                            .add(password_field)
                            .add(expires_field)
                            .add(login_field)
                            .add(email_field)
                            .add(phone_field)
                            .add(name_field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, city_field))))
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
                    .add(name_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(phone_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(email_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(expires_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(login_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(password_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(street_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(city_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(postal_code_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(door_number_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(country_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 115, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(submit_button)
                    .add(back_button))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void name_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_name_fieldActionPerformed

private void phone_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_phone_fieldActionPerformed

private void email_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_email_fieldActionPerformed

private void login_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_login_fieldActionPerformed

private void expires_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expires_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_expires_fieldActionPerformed

private void password_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_password_fieldActionPerformed

private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
    
    //get all the information
    String name         = name_field.getText();
    String email        = email_field.getText();
    String street       = street_field.getText();
    String city         = city_field.getText();
    String postal_code  = postal_code_field.getText();
    String country      = country_field.getText();
    int door_number     = Integer.parseInt(door_number_field.getText());
    String username     = login_field.getText();
    String password     = password_field.getText();
    String phone        = phone_field.getText();
    Date date           = dat.stringToDate(expires_field.getText());

    //store all information
    //dat.storeAddress(street,city,postal_code,country);
    //address = dat.getAddressByStreet(street);
    //public Person(int id, String email, String address, String login, String password, String name, String postalcode, String city, String phone, int[] type, String country) {
    int[] type = new int[3];
    type[0] = 0;
    type[1] = 0;
    type[2] = 1;
    Person p = new Person(-1,email,street,username,password,name,postal_code,city,phone,type,country);
    Librarian l = new Librarian(p, dat.datetoString(date));
    dat.storeLibrarian(l);
    new AdminManageLibrarians(dat).setVisible(true);
    dispose();
}//GEN-LAST:event_submit_buttonActionPerformed

private void street_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_street_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_street_fieldActionPerformed

private void city_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_city_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_city_fieldActionPerformed

private void postal_code_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postal_code_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_postal_code_fieldActionPerformed

private void door_number_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_door_number_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_door_number_fieldActionPerformed

private void country_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_country_fieldActionPerformed

private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
// TODO add your handling code here:
    new AdminManageLibrarians(dat).setVisible(true);
    dispose();
}//GEN-LAST:event_back_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_user;
    private javax.swing.JButton back_button;
    private javax.swing.JTextField city_field;
    private javax.swing.JTextField country_field;
    private javax.swing.JTextField door_number_field;
    private javax.swing.JTextField email_field;
    private javax.swing.JTextField expires_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField login_field;
    private javax.swing.JTextField name_field;
    private javax.swing.JTextField password_field;
    private javax.swing.JTextField phone_field;
    private javax.swing.JTextField postal_code_field;
    private javax.swing.JTextField street_field;
    private javax.swing.JButton submit_button;
    // End of variables declaration//GEN-END:variables
}
