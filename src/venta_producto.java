/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */






import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class venta_producto extends javax.swing.JFrame {

   DefaultTableModel Controlproductos;
   Object[] detalle = new Object [6];
   
    
    public venta_producto() {
        initComponents();
        this. Controlproductos= (DefaultTableModel) tablafac.getModel();
       numfac(); 
      txt_fecha.setText(Fecha());
      this.Controlproductos = (DefaultTableModel)tablafac.getModel();
    }

 
     public void Limpiar(){
//         Esto es para limpiar todo de la factura cuando se venda
        try{
       
        txt_nombreemp.setText("");
        txt_apeemp.setText("");
        txt_cod.setText("");
        txt_nombrec.setText("");
        txt_apellidoc.setText("");
        txt_total.setText("");
        txt_codprd.setText("");
        txt_nomprd.setText("");
        txt_pre.setText("");
        txt_can.setText("");
        txt_canve.setText("");
        
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }
     
     
     public void Limpiarprd(){
//         Esto sirve para limpiar los datos de cantidad y monto
        try{
        
      
        txt_can.setText("");
        txt_canve.setText("");
       
        
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }
//     La fecha automatica
     public static String Fecha() {
         Date fecha = new Date();
         SimpleDateFormat formatofecha=new SimpleDateFormat("YYYY/MM/dd");
         return formatofecha.format(fecha);
     }
     
     public boolean stock(int cant,int id_pro) {
//      presenta error si el stock es 0
       PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query ="select * from producto where cantidad > ? AND idproducto = ?";
        
        try {
            ps = Myconnection.getconnection().prepareStatement(query);
            ps.setInt(1,cant);
            ps.setInt(2,id_pro);
            rs = ps.executeQuery(); 
            if (rs.next()) {
                checkUser = true;
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error" + ex);
        }
        return checkUser;
     }
     
    public static void llenafac() {
        
//        Este sirve para insertar en factura
       
        String nomemp = txt_nombreemp.getText();
        String apeemp= txt_apeemp.getText();
        String idcli= txt_cod.getText();
        String nomcli= txt_nombrec.getText();
        String apecli= txt_apellidoc.getText();
        String fec = txt_fecha.getText();
        String total= txt_total.getText().substring(1);
        PreparedStatement ps;
        String query = "INSERT INTO `factura`(`nombre_emp`,`apellido_emp`,`id_cli`,`nombre_cli`,`apellido_cli`,`fecha`,`total`) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = Myconnection.getconnection().prepareStatement(query);
            
            
//            ps.setInt(1, iddet);
            ps.setString(1, nomemp);
            ps.setString(2, apeemp);
            ps.setString(3, idcli);
            ps.setString(4, nomcli);
            ps.setString(5, apecli);
            ps.setString(6, fec);
            ps.setString(7, total);
            
      

            if(ps.executeUpdate() > 0)
            {
              

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(venta_producto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error: "+ex);
            } 
    }
    
      public void RefrescarTabla(){
        //Funcion encargada de Refrescar la tabla utilizando Revalidate
        try {
        Controlproductos.setColumnCount(0);
        Controlproductos.setRowCount(0);
        tablafac.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }
      
      
      public void RefrescarTablaFactura() {
//          para refrescar la tabla
          try {
             Controlproductos.setColumnCount(0);
             Controlproductos.setRowCount(0);
             tablafac.revalidate();
          }
          catch(Exception ex) {
              JOptionPane.showMessageDialog(null,"error" +ex);
          }
      }
      
      
      public final void MostrarDatosFactura(String valor) {
//          aqui muestras los datos de la tabla
          Myconnection cc=new Myconnection();
          Connection cn = Myconnection.getconnection();
          RefrescarTablaFactura();
          Controlproductos.addColumn("NOMBRE");
          Controlproductos.addColumn("PRECIO");
          Controlproductos.addColumn("CANT");
          Controlproductos.addColumn("TOTAL");
          venta_producto.tablafac.setModel(Controlproductos);
          
                  
          
      }
      public static void numfac() {
//          Este sirve para poner factura automtico
          int lastid;
    Statement st;
    ResultSet rs;
  
    
        try{
            Connection con = Myconnection.getconnection();
            String sql = "select max(num_factura) from factura";
            st= con.createStatement();
            
            rs=st.executeQuery(sql);
            if(rs.next()){
                lastid = rs.getInt(1);
                lastid++;
                venta_producto.txt_numf.setText(Integer.toString(lastid));
            }
            else{
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(venta_producto.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        imprimir = new javax.swing.JButton();
        insertar = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_canve = new javax.swing.JTextField();
        txt_can = new javax.swing.JTextField();
        txt_pre = new javax.swing.JTextField();
        txt_nomprd = new javax.swing.JTextField();
        txt_codprd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Producto = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        txt_nombrec = new javax.swing.JTextField();
        txt_apellidoc = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txt_nombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_apeemp = new javax.swing.JTextField();
        txt_nombreemp = new javax.swing.JTextField();
        titulo2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablafac = new javax.swing.JTable();
        txt_numf = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/signo-de-mas.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 40, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menos.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 40, 30));

        imprimir.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        imprimir.setText("IMPRIMIR");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        jPanel1.add(imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 93, 34));

        insertar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        insertar.setText("VENDER");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        jPanel1.add(insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, -1, 32));

        total.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        total.setText("TOTAL:");
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 390, -1, -1));

        txt_total.setEditable(false);
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 390, 98, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 0));
        jLabel14.setText("Monto:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, -1, -1));

        txt_canve.setEditable(false);
        jPanel1.add(txt_canve, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 116, -1));

        txt_can.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_canActionPerformed(evt);
            }
        });
        txt_can.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_canKeyReleased(evt);
            }
        });
        jPanel1.add(txt_can, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 116, -1));

        txt_pre.setEditable(false);
        txt_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_preActionPerformed(evt);
            }
        });
        jPanel1.add(txt_pre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 114, -1));

        txt_nomprd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nomprdKeyPressed(evt);
            }
        });
        jPanel1.add(txt_nomprd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 112, -1));
        jPanel1.add(txt_codprd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 112, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 0));
        jLabel13.setText("Cantidad:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 0));
        jLabel12.setText("Precio unitario:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("Codigo de producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("Nombre de producto:");
        jLabel5.setToolTipText("");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 40, 30));

        Producto.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        Producto.setForeground(new java.awt.Color(255, 255, 255));
        Producto.setText("Producto:");
        jPanel1.add(Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        titulo1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setText("Datos del cliente:");
        jPanel1.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("codigo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 0));
        jLabel11.setText("Nombre:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("Apellido:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));
        jPanel1.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 113, -1));
        jPanel1.add(txt_nombrec, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 113, -1));
        jPanel1.add(txt_apellidoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 113, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 40, 30));

        txt_nombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 204, 0));
        txt_nombre.setText("Nombre:");
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Apellido:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, -1, -1));
        jPanel1.add(txt_apeemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 120, -1));
        jPanel1.add(txt_nombreemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 120, -1));

        titulo2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        titulo2.setForeground(new java.awt.Color(255, 255, 255));
        titulo2.setText("Empleado:");
        jPanel1.add(titulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 40, 30));

        tablafac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "PRECIO", "CANT", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablafac);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 490, 180));

        txt_numf.setEditable(false);
        txt_numf.setBackground(new java.awt.Color(204, 204, 204));
        txt_numf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numfActionPerformed(evt);
            }
        });
        jPanel1.add(txt_numf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 104, -1));

        txt_fecha.setEditable(false);
        txt_fecha.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 104, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("NO.factura:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        titulo.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setText("Datos Generales:");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/23.jpg"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 970, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        // para insertar productos en detalle_factura
        llenafac();
        guardarDetalleFactura();
          
    }//GEN-LAST:event_insertarActionPerformed
     void guardarDetalleFactura() {

        int id_fact = Integer.parseInt(txt_numf.getText());
        PreparedStatement ps;
        for (int i = 0; i < tablafac.getRowCount(); i++) {
            
            String nombre = (tablafac.getValueAt(i, 0).toString());
            int precio = Integer.parseInt(tablafac.getValueAt(i, 1).toString());
            int cant = Integer.parseInt(tablafac.getValueAt(i, 2).toString());
            int subtotal = Integer.parseInt(tablafac.getValueAt(i, 3).toString());
        String query = "INSERT INTO `detalle_factura`(`id_factura`,`nombrepr`,`precio`,`cantidad`,`importe`) VALUES (?,?,?,?,?)";
        try {
            ps = Myconnection.getconnection().prepareStatement(query);
            
            
            ps.setInt(1, id_fact);
            ps.setString(2, nombre);
            ps.setInt(3, precio);
            ps.setInt(4, cant);
            ps.setInt(5, subtotal);
            
      

            if(ps.executeUpdate() > 0)
            {
                 numfac();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(venta_producto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error: "+ex);
            } 

        }
                   MostrarDatosFactura("");
//                 numfac(); 
                   Limpiar();
                   txt_fecha.setText(Fecha());

    }
    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
        // TODO add your handling code here:
        Connection cn = Myconnection.getconnection();
        try {
            int fac = Integer.parseInt(txt_numf.getText());
          JasperReport jr = (JasperReport) JRLoader.loadObject(venta_producto.class.getResource("/Reporte/FerreteriaNYTT.jasper"));
          Map parametros = new HashMap<>();
        parametros.put("id",fac-1);
            

          JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cn);
          JasperViewer jv = new JasperViewer(jp, false);
          jv.setVisible(true); 
        }  
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
                                   

    }//GEN-LAST:event_imprimirActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         {
            frm_clientes mf = new frm_clientes ();
            mf.setVisible(true);
            mf.pack();
            mf.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public float sumar(){
       
        int contar = tablafac.getRowCount();
        float subtotal = 0;
        
        for (int i = 0; i < contar; i++){
        
            subtotal = subtotal + Float.parseFloat(tablafac.getValueAt(i,3).toString());
        
        }
        
        
       return subtotal;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         {
            frm_empleado mf = new frm_empleado();
            mf.setVisible(true);
            mf.pack();
            mf.setLocationRelativeTo(null);
            
            
            
        }                        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_nomprdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomprdKeyPressed
        // para buscar algo en un tex fild:
//         try {
//            if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
//        String B = txt_nomprd.getText()+"";
//        Mostrardatos(B);
//            }
//        }
//        catch (Exception ex){
//        JOptionPane.showMessageDialog(null, "error "+ex);
//        }
    }//GEN-LAST:event_txt_nomprdKeyPressed

    private void txt_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_preActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_preActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        {
            productopanel mf = new productopanel();
            mf.setVisible(true);
            mf.pack();
            mf.setLocationRelativeTo(null);
            
            
            
        }
        Limpiarprd();

    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
//Entrar los productos a la tabla
try
{
       if(txt_codprd.getText().equals("Buscar producto")){
             JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto.","Campo de producto vacío",2);
             Limpiar();
            
             //Si se selecciono un producto, con ayuda de un array almacenaremos los datos
        }else{
           int idp = Integer.parseInt(txt_codprd.getText());
           int can = Integer.parseInt(txt_can.getText());
           
           if(stock(can,idp) == true){
            Integer importe = Integer.parseInt(txt_pre.getText()) * Integer.parseInt(String.valueOf(txt_can.getText()));
            detalle[0] = txt_nomprd.getText();
            detalle[1] = txt_pre.getText();
            detalle[2] = txt_can.getText();
            detalle[3] = importe;
            Controlproductos.addRow(detalle);
            txt_total.setText("$"+String.valueOf(sumar()));
            Limpiarprd();
           }else{
               JOptionPane.showMessageDialog(null, "La cantidad a vender supera el stock disponible.","Error",2);
               Limpiarprd();
           
           
           
           }
            } 
        
 }
catch(HeadlessException | NumberFormatException ex){
            Logger.getLogger(venta_producto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: "+ex);
          
 }
               
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // esto es para eliminar producto de la tabla
        DefaultTableModel dtm = (DefaultTableModel) tablafac.getModel();
        dtm.removeRow(tablafac.getSelectedRow());
        txt_total.setText("$"+String.valueOf(sumar()));
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txt_canKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_canKeyReleased
        int precio_unidad = Integer.parseInt(txt_pre.getText());
        int cant = Integer.parseInt(txt_can.getText());
        
        int importe = cant * precio_unidad;
        
        txt_canve.setText(String.valueOf(importe));
        
        
    }//GEN-LAST:event_txt_canKeyReleased

    private void txt_numfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numfActionPerformed

    private void txt_canActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_canActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_canActionPerformed

    
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
            java.util.logging.Logger.getLogger(venta_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(venta_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(venta_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(venta_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new venta_producto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Producto;
    private javax.swing.JButton imprimir;
    private javax.swing.JButton insertar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablafac;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel total;
    public static javax.swing.JTextField txt_apeemp;
    public static javax.swing.JTextField txt_apellidoc;
    public static javax.swing.JTextField txt_can;
    public static javax.swing.JTextField txt_canve;
    public static javax.swing.JTextField txt_cod;
    public static javax.swing.JTextField txt_codprd;
    public static javax.swing.JTextField txt_fecha;
    private javax.swing.JLabel txt_nombre;
    public static javax.swing.JTextField txt_nombrec;
    public static javax.swing.JTextField txt_nombreemp;
    public static javax.swing.JTextField txt_nomprd;
    public static javax.swing.JTextField txt_numf;
    public static javax.swing.JTextField txt_pre;
    public static javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
