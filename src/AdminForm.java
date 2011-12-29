
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminForm.java
 *
 * Created on Nov 21, 2011, 11:46:02 PM
 */
/**
 *
 * @author jlnabais
 */
public class AdminForm extends javax.swing.JFrame {

    Library dat;
    /** Creates new form AdminForm */
    public AdminForm() {
        this.dat = Library.Instance();
        initComponents();
        list_panel.setListData(dat.loadAdminLog());
    }
    
    private void export_file(AbstractParserCreator parserCreator)
    {
        ArrayList<Book> books= dat.getAllBooks();
        Parser parser = parserCreator.createParser();
        parser.toFile(books);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_panel = new javax.swing.JList();
        user_management = new javax.swing.JButton();
        librarian_management = new javax.swing.JButton();
        export_json = new javax.swing.JButton();
        export_xml = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jLabel1.setText("Admin Panel");

        jLabel2.setText("Log:");

        jScrollPane1.setViewportView(list_panel);

        user_management.setText("User Management Panel");
        user_management.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_managementActionPerformed(evt);
            }
        });

        librarian_management.setText("Librarian Management Panel");
        librarian_management.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                librarian_managementActionPerformed(evt);
            }
        });

        export_json.setText("Export Book Database to json");
        export_json.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                export_jsonMouseReleased(evt);
            }
        });
        export_json.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_jsonActionPerformed(evt);
            }
        });

        export_xml.setText("Export Book Database to xml");
        export_xml.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                export_xmlMouseReleased(evt);
            }
        });
        export_xml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_xmlActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(325, 325, 325)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .add(328, 328, 328))
            .add(layout.createSequentialGroup()
                .add(49, 49, 49)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 418, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(export_xml, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(export_json, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(librarian_management, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .add(user_management, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(logout, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(jLabel2))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(27, 27, 27)
                .add(jLabel2)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(user_management)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(librarian_management)
                        .add(48, 48, 48)
                        .add(export_json)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(export_xml)
                        .add(78, 78, 78)
                        .add(logout))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 284, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void user_managementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_managementActionPerformed
// TODO add your handling code here:
    new AdminManageUsers().setVisible(true);
    dispose();
}//GEN-LAST:event_user_managementActionPerformed

private void librarian_managementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_librarian_managementActionPerformed
// TODO add your handling code here:
    new AdminManageLibrarians().setVisible(true);
    dispose();
}//GEN-LAST:event_librarian_managementActionPerformed

private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
// TODO add your handling code here:
    new LoginForm().setVisible(true);
    dispose();
}//GEN-LAST:event_logoutActionPerformed

    private void export_jsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_jsonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_export_jsonActionPerformed

    private void export_xmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_xmlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_export_xmlActionPerformed

    private void export_jsonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_export_jsonMouseReleased
        AbstractParserCreator json_parser = new JSONParserCreator();
        export_file(json_parser);
    }//GEN-LAST:event_export_jsonMouseReleased

    private void export_xmlMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_export_xmlMouseReleased
        AbstractParserCreator xml_parser = new XMLParserCreator();
        export_file(xml_parser);
    }//GEN-LAST:event_export_xmlMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton export_json;
    private javax.swing.JButton export_xml;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton librarian_management;
    private javax.swing.JList list_panel;
    private javax.swing.JButton logout;
    private javax.swing.JButton user_management;
    // End of variables declaration//GEN-END:variables
}
