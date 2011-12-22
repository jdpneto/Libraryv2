
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DeleteUser.java
 *
 * Created on Nov 22, 2011, 3:46:09 AM
 */
/**
 *
 * @author jlnabais
 */
public class DeleteUser extends javax.swing.JFrame {
    
    dataManager dat;
    /** Creates new form DeleteUser */
    public DeleteUser(dataManager dat) {
        this.dat = dat;
        initComponents();
        list_panel.setListData(dat.getReaders());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        user_field = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_panel = new javax.swing.JList();
        search_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Delete User");

        list_panel.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list_panel);

        search_button.setText("Search");
        search_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                search_buttonMouseReleased(evt);
            }
        });
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        delete_button.setText("Delete User");
        delete_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delete_buttonMouseReleased(evt);
            }
        });

        back_button.setText("Back to Menu");
        back_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                back_buttonMouseReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(295, 295, 295)
                        .add(jLabel1))
                    .add(layout.createSequentialGroup()
                        .add(52, 52, 52)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 441, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(back_button)
                                    .add(delete_button)))
                            .add(layout.createSequentialGroup()
                                .add(user_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 254, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(search_button)))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(user_field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(search_button))
                .add(31, 31, 31)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 223, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(delete_button)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 178, Short.MAX_VALUE)
                        .add(back_button)
                        .add(65, 65, 65))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_buttonActionPerformed
    
    private void delete_buttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_buttonMouseReleased
        Object [] selected = list_panel.getSelectedValues();
        if(selected.length == 1 && selected[0].equals("A procura não encontrou resultados"));
        //do nothing
        else {
            for(int i=0;i<selected.length;i++){
                try {
                    dat.removeUser(""+dat.getReader((String)selected[i]).getId());
                } catch (SQLException ex) {
                    Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            list_panel.setListData(dat.getReaders());
        }
    }//GEN-LAST:event_delete_buttonMouseReleased
    
    private void back_buttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_buttonMouseReleased
        new AdminManageUsers(dat).setVisible(true);
        dispose();
    }//GEN-LAST:event_back_buttonMouseReleased
    
    private void search_buttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseReleased
        try {
            String login = user_field.getText();
            int [] type = {0,1,0};
            Vector <String> vector = dat.searchUser(login,type);
            if(vector.size() == 0){
                String [] temp = {"A procura não encontrou resultados"};
                list_panel.setListData(temp);
            }
            else{
                list_panel.setListData(vector);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_search_buttonMouseReleased
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list_panel;
    private javax.swing.JButton search_button;
    private javax.swing.JTextField user_field;
    // End of variables declaration//GEN-END:variables
}
