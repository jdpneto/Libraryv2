
import java.sql.SQLException;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FindBook.java
 *
 * Created on Nov 22, 2011, 3:01:02 AM
 */
/**
 *
 * @author jlnabais
 */
public class FindBook extends javax.swing.JFrame {

    Library dat;
    Book b;
    int id;
    /** Creates new form FindBook */
    public FindBook(int id) {
        this.dat = Library.Instance();
        initComponents();
        this.id=id;
        open_details.setEnabled(false);
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
        find_book = new javax.swing.JTextField();
        find_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_field = new javax.swing.JList();
        users_panel = new javax.swing.JButton();
        open_details = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Find Book");

        find_button.setText("Find");
        find_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                find_buttonMouseReleased(evt);
            }
        });
        find_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_buttonActionPerformed(evt);
            }
        });

        list_field.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                list_fieldValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(list_field);

        users_panel.setText("User's Panel");
        users_panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                users_panelActionPerformed(evt);
            }
        });

        open_details.setText("Open Details");
        open_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                open_detailsMouseReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(567, 567, 567)
                        .add(users_panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(300, 300, 300)
                        .add(jLabel1))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(find_book, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 544, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(find_button, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(572, Short.MAX_VALUE)
                        .add(open_details, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 151, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(find_button)
                    .add(find_book, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 231, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(open_details)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 30, Short.MAX_VALUE)
                .add(users_panel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void find_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_buttonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_find_buttonActionPerformed

private void users_panelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_users_panelActionPerformed
// TODO add your handling code here:
    new UserForm(id).setVisible(true);
    dispose();
}//GEN-LAST:event_users_panelActionPerformed

    private void find_buttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_find_buttonMouseReleased
        
            String search = find_book.getText();
            
            Vector <String> vector = dat.getBookListByTitle(search);
            if(vector.size() == 0){
                String [] temp = {"A procura não encontrou resultados"};
                list_field.setListData(temp);
            }
            else{
                list_field.setListData(vector);
            }
        
    }//GEN-LAST:event_find_buttonMouseReleased

    private void list_fieldValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_list_fieldValueChanged
         Object [] selected = list_field.getSelectedValues();
        if(selected.length > 1 || selected.length == 0)
        {
            open_details.setEnabled(false);
        }
        else if(selected.length == 1 && selected[0].equals("A procura não encontrou resultados"));
        else
        {
            b = dat.getBookByTitle((String)selected[0]);
            open_details.setEnabled(true);
        }
        
        
    }//GEN-LAST:event_list_fieldValueChanged

    private void open_detailsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_open_detailsMouseReleased
        new BookDetails(b,id).setVisible(true);
        dispose();
    }//GEN-LAST:event_open_detailsMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField find_book;
    private javax.swing.JButton find_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list_field;
    private javax.swing.JButton open_details;
    private javax.swing.JButton users_panel;
    // End of variables declaration//GEN-END:variables
}
