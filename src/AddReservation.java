
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddReservation.java
 *
 * Created on Nov 22, 2011, 3:23:20 AM
 */
/**
 *
 * @author jlnabais
 */
public class AddReservation extends javax.swing.JFrame {

    Library dat;

    /** Creates new form AddReservation */
    public AddReservation() {
        this.dat = Library.Instance();
        initComponents();
        error.setVisible(false);
        start_field.setEnabled(false);
        end_field.setEnabled(false);
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
        picker_start = new javax.swing.JButton();
        picker_end = new javax.swing.JButton();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add_user.setText("Add Reservation");

        jLabel2.setText("User Name");

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

        picker_start.setText("Pick Date");
        picker_start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                picker_startMouseReleased(evt);
            }
        });
        picker_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                picker_startActionPerformed(evt);
            }
        });

        picker_end.setText("Pick Date");
        picker_end.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                picker_endMouseReleased(evt);
            }
        });

        error.setForeground(new java.awt.Color(255, 0, 0));
        error.setText("Book or user does not exist;");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(292, 292, 292)
                .add(add_user)
                .addContainerGap(324, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(130, 130, 130)
                        .add(submit_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 249, Short.MAX_VALUE)
                        .add(back_button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(43, 43, 43)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel1)
                            .add(jLabel3)
                            .add(jLabel5)
                            .add(jLabel4))
                        .add(36, 36, 36)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(end_field)
                            .add(copies_field)
                            .add(title_field)
                            .add(id_field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .add(start_field))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(picker_end)
                            .add(picker_start))))
                .add(34, 34, 34))
            .add(layout.createSequentialGroup()
                .add(251, 251, 251)
                .add(error)
                .addContainerGap(290, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(add_user)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(id_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(title_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(copies_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(start_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4)
                    .add(picker_start))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(end_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(picker_end))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 50, Short.MAX_VALUE)
                .add(error)
                .add(43, 43, 43)
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
    int id              = dat.getReader(id_field.getText()).getId();
    String title        = dat.getBookByTitle(title_field.getText()).getName();
    int numberOfCopies  = Integer.parseInt(copies_field.getText());
    Date startDate      = dat.stringToDate(start_field.getText());
    Date endDate        = dat.stringToDate(end_field.getText());

    //store all information
    Reservation tmp = new Reservation(startDate, endDate, title, id, numberOfCopies);
    Reservation check;
    if(!title.equals("")) // tirar depois de selecao de livro por lista e nao por escrita
    {
        check = dat.storeReservation(tmp);
        if(!check.getBook_title().equals("")){
            new ManageReservations().setVisible(true);
            dispose();
        }
        else{
            System.out.println(tmp.toString());
            error.setText("Too many copies requested");
            error.setVisible(true);
        }
    }
    else
    {
        error.setText("Book/User does not exist");
        error.setVisible(true);
    }
    
}//GEN-LAST:event_submit_buttonActionPerformed

private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
// TODO add your handling code here:
    new ManageReservations().setVisible(true);
    dispose();
}//GEN-LAST:event_back_buttonActionPerformed

    private void picker_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_picker_startActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_picker_startActionPerformed

    private void picker_startMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picker_startMouseReleased
        // TODO add your handling code here:
        start_field.setText(new DatePicker(this).setPickedDate());
    }//GEN-LAST:event_picker_startMouseReleased

    private void picker_endMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picker_endMouseReleased
        // TODO add your handling code here:
        end_field.setText(new DatePicker(this).setPickedDate());
    }//GEN-LAST:event_picker_endMouseReleased

    private void id_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_fieldActionPerformed

// TODO add your handling code here:}//GEN-LAST:event_id_fieldActionPerformed
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_user;
    private javax.swing.JButton back_button;
    private javax.swing.JTextField copies_field;
    private javax.swing.JTextField end_field;
    private javax.swing.JLabel error;
    private javax.swing.JTextField id_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton picker_end;
    private javax.swing.JButton picker_start;
    private javax.swing.JTextField start_field;
    private javax.swing.JButton submit_button;
    private javax.swing.JTextField title_field;
    // End of variables declaration//GEN-END:variables
}
