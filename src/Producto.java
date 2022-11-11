

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author 18297
 */
public class Producto extends javax.swing.JFrame {

    /**
     * Creates new form Producto
     */
    DefaultTableModel Producto;
    
    public Producto() {
        initComponents();
        
        this.Producto = (DefaultTableModel) tablaproduc.getModel();
        
        Mostrardatos("");
    }
    
    
           public void Limpiar(){
        try{
        txt_nom.setText("");
        txt_des.setText("");
        txt_precio.setText("");
        txt_cant.setText("");
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }
           
           public void RefrescarTabla(){
        //Funcion encargada de Refrescar la tabla utilizando Revalidate
        try {
        Producto.setColumnCount(0);
        Producto.setRowCount(0);
        tablaproduc.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }
    
public final void Mostrardatos(String valor){
            //Funcion para llenar la jtable de Usuarios desde la BD
            //Myconnection cc=new Myconnection();
            Connection cn=Myconnection.getconnection();
            RefrescarTabla();
            Producto.addColumn("idproducto");
            Producto.addColumn("nombre_prd");
            Producto.addColumn("descripcion_producto");
            Producto.addColumn("precio");
            Producto.addColumn("cantidad");
            
            
         
            this.tablaproduc.setModel(Producto);
            String sql;
            if (valor.equals(""))
            {
            sql="SELECT * FROM producto";
            }
            else{
            sql="SELECT * FROM producto WHERE nombre_prd='"+valor+"'";
            } 

            String []datos=new String [5];
            try{
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
            datos[0]=rs.getString(1);
            datos[1]=rs.getString(2);
            datos[2]=rs.getString(3);
            datos[3]=rs.getString(4);
            datos[4]=rs.getString(5);
           
     
     

            Producto.addRow(datos);
            }
            tablaproduc.setModel(Producto);
            }catch(SQLException ex){
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fondotr = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaproduc = new javax.swing.JTable();
        txt_nom = new javax.swing.JTextField();
        txt_des = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        btn_insertar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_reporte = new javax.swing.JButton();
        txt_can = new javax.swing.JLabel();
        txt_cant = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaproduc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaproduc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaproducMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaproduc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 46, 339, 215));
        jPanel1.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 124, 158, -1));
        jPanel1.add(txt_des, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 163, 158, -1));
        jPanel1.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 202, 158, -1));

        btn_insertar.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btn_insertar.setText("Insertar");
        btn_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 290, -1, 39));

        btn_modificar.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 291, -1, 37));

        btn_borrar.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btn_borrar.setText("Borrar");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 291, 75, 37));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel4.setText("Descripcion:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 162, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel5.setText("Precio:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 201, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        jLabel6.setText("Nombre:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Control Productos");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 67, -1, -1));

        btn_reporte.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btn_reporte.setText("Reporte");
        btn_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reporteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 290, 83, 39));

        txt_can.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        txt_can.setText("Cantidad:");
        jPanel1.add(txt_can, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));
        jPanel1.add(txt_cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 241, 158, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Productos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 13, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 640, 340));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 116, -1, -1));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        jLabel9.setToolTipText("");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, -1, -1));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/tr.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        // TODO add your handling code here:
        String id = (String)Producto.getValueAt(tablaproduc.getSelectedRow(),0);

        PreparedStatement ps;
        String query = "DELETE FROM `producto` WHERE `idproducto`=?";
        try {
            ps = Myconnection.getconnection().prepareStatement(query);

            ps.setString(1, id);

            if(ps.executeUpdate() > 0)
            {

                JOptionPane.showMessageDialog(null, "producto Eliminado");
                Limpiar();
                Mostrardatos("");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertarActionPerformed
        String nom = txt_nom.getText(); 
        String desc = txt_des.getText();
        String prec= txt_precio.getText();
        String cant= txt_cant.getText();
       
      
        PreparedStatement ps;
        String query = "INSERT INTO `producto`(`nombre_prd`,`descripcion_producto`,`precio`,`cantidad`) VALUES (?,?,?,?)";
        try {
            ps = Myconnection.getconnection().prepareStatement(query);
            

            ps.setString(1, nom);
            ps.setString(2, desc);
            ps.setString(3, prec);
            ps.setString(4, cant);
            
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo dato ingresado");
                Limpiar();
                Mostrardatos("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }        // TODO add your handling code here:
    }//GEN-LAST:event_btn_insertarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

        // TODO add your handling code here:

        String nom = txt_nom.getText();
        String desc = txt_des.getText();
        String prec = txt_precio.getText();
        String cant = txt_cant.getText();
        String id = (String)Producto.getValueAt(tablaproduc.getSelectedRow(),0);
        

        

        PreparedStatement ps;
        String query = "UPDATE `producto` SET `nombre_prd`=?, `descripcion_producto`=?, `precio`=?, `cantidad`=? WHERE `idproducto`=?";
        try {
            ps = Myconnection.getconnection().prepareStatement(query);
            
            ps.setString(5, id);
            ps.setString(1, nom);
            ps.setString(2, desc);
            ps.setString(3, prec);
            ps.setString(4, cant);
    
            
            

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, " producto Modificado");
            Limpiar();
            Mostrardatos("");

        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void tablaproducMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaproducMouseClicked
        // TODO add your handling code here:
        
        try{
  
            String nom = (String)Producto.getValueAt(tablaproduc.getSelectedRow(), 1);
            String desc = (String)Producto.getValueAt(tablaproduc.getSelectedRow(), 2);
            String prec = (String)Producto.getValueAt(tablaproduc.getSelectedRow(), 3);
            String cant = (String)Producto.getValueAt(tablaproduc.getSelectedRow(),4);
            
                    
            txt_nom.setText(nom);
            txt_des.setText(desc);
            txt_precio.setText(prec);
            txt_cant.setText(cant);
           
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"error"+ex);
        }
    }//GEN-LAST:event_tablaproducMouseClicked

    private void btn_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reporteActionPerformed
         //TODO add your handling code here:
         
        Connection cn = Myconnection.getconnection();
        try {
          JasperReport jr = (JasperReport) JRLoader.loadObject(Producto.class.getResource("/Reporte/producto.jasper"));
          Map parametros = new HashMap<>();
          parametros.put("Titulo", "Reporte Productos");
            

          JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cn);
          JasperViewer jv = new JasperViewer(jp, false);
          jv.setVisible(true); 
        }  
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_btn_reporteActionPerformed

    
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_insertar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_reporte;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondotr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaproduc;
    private javax.swing.JLabel txt_can;
    private javax.swing.JTextField txt_cant;
    private javax.swing.JTextField txt_des;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

}
