
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditReservation.java
 *
 * Created on Nov 22, 2011, 3:23:20 AM
 */
/**
 *
 * @author jlnabais
 */
public class EditReservation extends javax.swing.JFrame {

    Library dat;
    /** Creates new form EditReservation */
    public EditReservation() {
        this.dat = Library.Instance();
        initComponents();
        end_field.setEnabled(false);
        start_field.setEnabled(false);
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
        id_field = new javax.swing.JTextField();
        title_field = new javax.swing.JTextField();
        copies_field = new javax.swing.JTextField();
        end_field = new javax.swing.JTextField();
        start_field = new javax.swing.JTextField();
        submit_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        dPicker_start = new javax.swing.JButton();
        dPicker_end = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_list = new javax.swing.JList();
        search_field = new javax.swing.JTextField();
        search_button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reservation_list = new javax.swing.JList();
        copies_selected = new javax.swing.JComboBox();
        error = new javax.swing.JLabel();
        user_id_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add_user.setText("Edit Reservation");

        jLabel2.setText("ID:");

        jLabel1.setText("Title:");

        jLabel3.setText("Number of Copies:");

        jLabel4.setText("Start Date:");

        jLabel5.setText("End Date:");

        id_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_fieldActionPerformed(evt);
            }
        });

        title_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title_fieldActionPerformed(evt);
            }
        });

        copies_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copies_fieldActionPerformed(evt);
            }
        });

        end_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                end_fieldActionPerformed(evt);
            }
        });

        start_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_fieldActionPerformed(evt);
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

        dPicker_start.setText("Pick Date");
        dPicker_start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dPicker_startMouseReleased(evt);
            }
        });

        dPicker_end.setText("Pick Date");
        dPicker_end.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dPicker_endMouseReleased(evt);
            }
        });

        jLabel6.setText("User's List:");

        user_list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        user_list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                user_listValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(user_list);

        search_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_fieldActionPerformed(evt);
            }
        });

        search_button.setText("Search");
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        jLabel7.setText("Reservation's List:");

        reservation_list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        reservation_list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                reservation_listValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(reservation_list);

        copies_selected.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));

        error.setForeground(new java.awt.Color(255, 0, 0));
        error.setText("Error");

        user_id_field.setText("jTextField1");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(292, 292, 292)
                        .add(add_user))
                    .add(layout.createSequentialGroup()
                        .add(50, 50, 50)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel6)
                                .add(86, 86, 86)
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 281, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(search_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createSequentialGroup()
                                        .add(94, 94, 94)
                                        .add(search_button))))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel4)
                                        .add(85, 85, 85)
                                        .add(start_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 281, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                        .add(layout.createSequentialGroup()
                                            .add(jLabel3)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(copies_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 281, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                            .add(jLabel1)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(title_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 281, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jLabel2)
                                                .add(jLabel7))
                                            .add(37, 37, 37)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                .add(jScrollPane2)
                                                .add(id_field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(19, 19, 19)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(copies_selected, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(dPicker_start, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .add(layout.createSequentialGroup()
                                        .add(138, 138, 138)
                                        .add(user_id_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                    .add(layout.createSequentialGroup()
                        .add(50, 50, 50)
                        .add(jLabel5)
                        .add(92, 92, 92)
                        .add(end_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 281, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(19, 19, 19)
                        .add(dPicker_end))
                    .add(layout.createSequentialGroup()
                        .add(247, 247, 247)
                        .add(error, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 185, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(submit_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(245, 245, 245)
                        .add(back_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(add_user)
                .add(22, 22, 22)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel6))
                        .add(16, 16, 16)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel7))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(id_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(title_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(search_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(6, 6, 6)
                        .add(search_button)
                        .add(145, 145, 145)
                        .add(user_id_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(copies_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(copies_selected, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(start_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel4))
                    .add(dPicker_start))
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(end_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(dPicker_end))
                .add(18, 18, 18)
                .add(error)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(submit_button)
                    .add(back_button)))
        );

        user_id_field.setEditable(false);
        user_id_field.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void id_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_id_fieldActionPerformed

private void title_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_title_fieldActionPerformed

private void copies_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copies_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_copies_fieldActionPerformed

private void end_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_end_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_end_fieldActionPerformed

private void start_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_fieldActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_start_fieldActionPerformed

private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
    //get all the information
    int id = Integer.parseInt(id_field.getText());
    String isbn = dat.getBookByTitle(title_field.getText()).getIsbn();
    int numberOfCopies = copies_selected.getSelectedIndex()+1;
    Date startDate = dat.stringToDate(start_field.getText());
    Date endDate = dat.stringToDate(end_field.getText());

    //store all information
    Reservation tmp = new Reservation(startDate, endDate, isbn, id, numberOfCopies);
    tmp.setId(id);
    Reservation check;
    check = dat.editReservation(tmp);
    if (!check.getBook_isbn().equals("")) {
        new ManageReservations().setVisible(true);
        dispose();
    } else {
        System.out.println(tmp.toString());
        error.setText("Error");
        error.setVisible(true);
    }
}//GEN-LAST:event_submit_buttonActionPerformed

private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
// TODO add your handling code here:
    new ManageReservations().setVisible(true);
    dispose();
}//GEN-LAST:event_back_buttonActionPerformed

    private void dPicker_startMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dPicker_startMouseReleased
        start_field.setText(new DatePicker(this).setPickedDate());
    }//GEN-LAST:event_dPicker_startMouseReleased

    private void dPicker_endMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dPicker_endMouseReleased
        end_field.setText(new DatePicker(this).setPickedDate());
    }//GEN-LAST:event_dPicker_endMouseReleased

    private void search_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_fieldActionPerformed
        
    }//GEN-LAST:event_search_fieldActionPerformed

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        try {
            String login = search_field.getText();
            int [] type = {0,1,0};
            Vector <String> vector = dat.searchUser(login,type);
            if(vector.size() == 0){
                String [] temp = {"A procura não encontrou resultados"};
                user_list.setListData(temp);
            }
            else{
                user_list.setListData(vector);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_search_buttonActionPerformed

    private void user_listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_user_listValueChanged
        Object [] selected = user_list.getSelectedValues();
        if(selected.length > 1 || selected.length == 0);
        else if(selected.length == 1 && selected[0].equals("A procura não encontrou resultados"));
        else
        {
            Vector <String> vector = dat.getReservationsByUserLogin((String)selected[0]);
            if(vector.size() == 0){
                String [] temp = {"A procura não encontrou resultados"};
                reservation_list.setListData(temp);
            }
            else{
                reservation_list.setListData(vector);
            }
        }
    }//GEN-LAST:event_user_listValueChanged

    private void reservation_listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_reservation_listValueChanged
        Object [] selected = reservation_list.getSelectedValues();
        if(selected.length > 1 || selected.length == 0);
        else if(selected.length == 1 && selected[0].equals("A procura não encontrou resultados"));
        else
        {
            Reservation r = dat.getReservation(((String)selected[0]).split(" : ")[0]);
            System.out.println("idReservation = "+r.getId());
            id_field.setText(r.getId()+"");
            title_field.setText(dat.getBookByISBN(r.getBook_isbn()).getName());
            copies_field.setText(""+r.getNumber_of_copies());
            start_field.setText(dat.datetoString(r.getStart_date()));
            end_field.setText(dat.datetoString(r.getEnd_date()));
            int reserved = Integer.parseInt(copies_field.getText());
            Book b = dat.getBookByTitle(title_field.getText());

            String[] options = new String [b.getNumberOfCopies()+reserved];
            for(int i=1;i<=options.length;i++){
                options[i-1] = ""+i;
            }
            copies_selected.removeAllItems();  
            copies_selected.setModel(new DefaultComboBoxModel(options));  
        }
    }//GEN-LAST:event_reservation_listValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_user;
    private javax.swing.JButton back_button;
    private javax.swing.JTextField copies_field;
    private javax.swing.JComboBox copies_selected;
    private javax.swing.JButton dPicker_end;
    private javax.swing.JButton dPicker_start;
    private javax.swing.JTextField end_field;
    private javax.swing.JLabel error;
    private javax.swing.JTextField id_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList reservation_list;
    private javax.swing.JButton search_button;
    private javax.swing.JTextField search_field;
    private javax.swing.JTextField start_field;
    private javax.swing.JButton submit_button;
    private javax.swing.JTextField title_field;
    private javax.swing.JTextField user_id_field;
    private javax.swing.JList user_list;
    // End of variables declaration//GEN-END:variables
}
