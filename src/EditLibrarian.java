
import java.sql.SQLException;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditLibrarian.java
 *
 * Created on Nov 22, 2011, 3:23:20 AM
 */
/**
 *
 * @author jlnabais
 */
public class EditLibrarian extends javax.swing.JFrame {
    
    Library dat;
    Librarian lib = new Librarian();
    Person p;
    /** Creates new form EditLibrarian */
    public EditLibrarian() {
        this.dat = Library.Instance();
        initComponents();
        error.setVisible(false);
        
        /*
         * if (!p.getAddress().equals(p2.getAddress())) {
         * ps += " address = '" + p.getAddress() + "'";
         * }
         * if (!p.getCity().equals(p2.getCity())) {
         * ps += " city = '" + p.getCity() + "'";
         * }
         * if (!p.getCountry().equals(p2.getCountry())) {
         * ps += " country = '" + p.getCountry() + "'";
         * }
         * if (!p.getEmail().equals(p2.getEmail())) {
         * ps += " email = '" + p.getEmail() + "'";
         * }
         * if (!p.getName().equals(p2.getName())) {
         * ps += " name = '" + p.getName() + "'";
         * }
         * if (!p.getPassword().equals(p2.getPassword())) {
         * ps += " expires = '" + p.getPassword() + "'";
         * }
         * if (!p.getPhone().equals(p2.getPhone())) {
         * ps += " phonenumber = '" + p.getPhone() + "'";
         * }
         * if (!p.getPostalcode().equals(p2.getPostalcode())) {
         * ps += " postalcode = '" + p.getPostalcode() + "'";
         */
        
        
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
        name_field = new javax.swing.JTextField();
        phone_field = new javax.swing.JTextField();
        email_field = new javax.swing.JTextField();
        id_field = new javax.swing.JTextField();
        submit_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        street_field = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        city_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        postal_code_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        country_field = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        date_field = new javax.swing.JTextField();
        dPicker = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_field = new javax.swing.JList();
        search_field = new javax.swing.JTextField();
        search_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add_user.setText("Edit Librarian");

        jLabel2.setText("Name:");

        jLabel1.setText("Phone:");

        jLabel3.setText("Email:");

        jLabel4.setText("ID:");

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

        id_field.setEnabled(false);
        id_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_fieldActionPerformed(evt);
            }
        });

        submit_button.setText("Submit");
        submit_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                submit_buttonMouseReleased(evt);
            }
        });
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

        country_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                country_fieldActionPerformed(evt);
            }
        });

        jLabel11.setText("Country:");

        jLabel5.setText("Expires:");

        dPicker.setText("Pick Date");
        dPicker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dPickerMouseReleased(evt);
            }
        });

        error.setForeground(new java.awt.Color(204, 0, 51));
        error.setText("error saving Librarian");

        list_field.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        list_field.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                list_fieldValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(list_field);

        search_button.setText("Search");
        search_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                search_buttonMouseReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(292, 292, 292)
                        .add(add_user))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(130, 130, 130)
                        .add(submit_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 267, Short.MAX_VALUE)
                        .add(back_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel1)
                            .add(jLabel3)
                            .add(jLabel4)
                            .add(jLabel7)
                            .add(jLabel8)
                            .add(jLabel9)
                            .add(jLabel11)
                            .add(jLabel5))
                        .add(47, 47, 47)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(country_field)
                                    .add(postal_code_field)
                                    .add(city_field)
                                    .add(street_field)
                                    .add(id_field)
                                    .add(email_field)
                                    .add(phone_field)
                                    .add(name_field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                    .add(jScrollPane1))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(47, 47, 47)
                                        .add(error))
                                    .add(layout.createSequentialGroup()
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(search_button)
                                            .add(search_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 228, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                            .add(layout.createSequentialGroup()
                                .add(date_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 166, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(dPicker)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(add_user)
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 207, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(search_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(search_button)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 32, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
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
                            .add(id_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(street_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel8)
                            .add(city_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel9)
                            .add(postal_code_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel11)
                            .add(country_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(date_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(dPicker))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(error)
                        .add(258, 258, 258)))
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

private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
    // TODO add your handling code here:
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

private void country_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_country_fieldActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_country_fieldActionPerformed

private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
    // TODO add your handling code here:
    new AdminManageLibrarians().setVisible(true);
    dispose();
}//GEN-LAST:event_back_buttonActionPerformed

    private void id_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_fieldActionPerformed
    }
// TODO add your handling code here:}//GEN-LAST:event_id_fieldActionPerformed
    
    private void dPickerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dPickerMouseReleased
        date_field.setText(new DatePicker(this).setPickedDate());
    }//GEN-LAST:event_dPickerMouseReleased
    
    private void submit_buttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submit_buttonMouseReleased
        
        
        p.setEmail(email_field.getText());
        //this.email_field.setText(this.lib.getEmail());
        p.setName(name_field.getText());
        //this.name_field.setText(this.lib.getName());
        p.setPhone(phone_field.getText());
        //this.phone_field.setText(this.lib.getPhone());
        p.setId(Integer.parseInt(id_field.getText()));
        //this.id_field.setText(""+this.lib.getId());
        p.setAddress(street_field.getText());
        //this.street_field.setText(this.lib.getAddress());
        p.setCity(city_field.getText());
        //this.city_field.setText(this.lib.getCity());
        p.setPostalcode(postal_code_field.getText());
        //this.postal_code_field.setText(this.lib.getPostalcode());
        p.setCountry(country_field.getText());
        //this.country_field.setText(this.lib.getCountry());
        String str = date_field.getText();
        //this.date_field.setText(this.lib.getExpires());
        EditPersonObject to = new EditPersonObject();
        to.setP(p);
        to.setLimit(-1);
        to.setExpires(str);
        p = dat.editUser(to);
        if(p.getId() == -1)
            error.setVisible(true);
        else
        {
            new AdminManageLibrarians().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_submit_buttonMouseReleased
    
    private void search_buttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseReleased
        try {
            String login = search_field.getText();
            int [] type = {0,0,1};
            Vector <String> vector = dat.searchUser(login,type);
            if(vector.size() == 0){
                String [] temp = {"A procura não encontrou resultados"};
                list_field.setListData(temp);
            }
            else{
                list_field.setListData(vector);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_search_buttonMouseReleased
    
    private void list_fieldValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_list_fieldValueChanged
        Object [] selected = list_field.getSelectedValues();
        if(selected.length > 1 || selected.length == 0);
        else if(selected.length == 1 && selected[0].equals("A procura não encontrou resultados"));
        else
        {
            lib = dat.getLibrarian((String)selected[0]);
            this.email_field.setText(this.lib.getEmail());
            this.name_field.setText(this.lib.getName());
            this.phone_field.setText(this.lib.getPhone());
            this.id_field.setText(""+this.lib.getId());
            this.street_field.setText(this.lib.getAddress());
            this.city_field.setText(this.lib.getCity());
            this.postal_code_field.setText(this.lib.getPostalcode());
            this.country_field.setText(this.lib.getCountry());
            this.date_field.setText(this.lib.getExpires());
            p = lib.getPerson();
            
        }
    }//GEN-LAST:event_list_fieldValueChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_user;
    private javax.swing.JButton back_button;
    private javax.swing.JTextField city_field;
    private javax.swing.JTextField country_field;
    private javax.swing.JButton dPicker;
    private javax.swing.JTextField date_field;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel error;
    private javax.swing.JTextField id_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list_field;
    private javax.swing.JTextField name_field;
    private javax.swing.JTextField phone_field;
    private javax.swing.JTextField postal_code_field;
    private javax.swing.JButton search_button;
    private javax.swing.JTextField search_field;
    private javax.swing.JTextField street_field;
    private javax.swing.JButton submit_button;
    // End of variables declaration//GEN-END:variables
}
