/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;


/**
 *
 * @author 18297
 */
public class codebasura {
                   
//public final void Mostrardatos(String valor){
//            //Funcion para llenar la jtable de Usuarios desde la BD
            //Myconnection cc=new Myconnection();
//            Connection cn=Myconnection.getconnection();
//            RefrescarTabla();
//            Controlproductos.addColumn("idproducto");
//            Controlproductos.addColumn("nombre_prd");
//            Controlproductos.addColumn("descripcion_producto");
//            Controlproductos.addColumn("precio");
//            Controlproductos.addColumn("cantidad");
//            
//            
//         
//            this.tablafac.setModel(Controlproductos);
//            String sql;
//            if (valor.equals(""))
//            {
//            sql="SELECT * FROM detalle_factura";
//            }
//            else{
//            sql="SELECT * FROM detalle_factura WHERE nombrepr='"+valor+"'";
//            } 
//
//            String []datos=new String [6];
//            try{
//            Statement st=cn.createStatement();
//            ResultSet rs=st.executeQuery(sql);
//            while(rs.next()){
//            datos[0]=rs.getString(1);
//            datos[1]=rs.getString(2);
//            datos[2]=rs.getString(3);
//            datos[3]=rs.getString(4);
//            datos[4]=rs.getString(5);
//            datos[5]=rs.getString(6);
//           
//     
     

//            Controlproductos.addRow(datos);
//            }
//            tablafac.setModel(Controlproductos);
//            }catch(SQLException ex){
//            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,null,ex);
//            JOptionPane.showMessageDialog(null, "error "+ex);
//            }
//        }
  
    
//}
    
    
//     public static void monto() {
//        para hacer la multiplicacion de precio y cantidad

//        int mon,prec,canti;
//        prec = Integer.parseInt(txt_pre.getText());
//        canti = Integer.parseInt(txt_can.getText());
//        mon=prec*canti;
//        txt_canve.setText(String.valueOf(mon));
//    }
//     {
//        
//        try {
//            
//            txt_numf.setText(" ");
//            txt_fecha.setText(" ");
//            txt_apeemp.setText(" ");
//            
//        }
//        catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "error; " +ex);
//            
//        }
    
    
//hacer update
//        String id = (String)Controlproductos.getValueAt(tablafac.getSelectedRow(),0);
//        int can_1 = Integer.parseInt((String)Controlproductos.getValueAt(tablafac.getSelectedRow(),4));
//        int can_2 = Integer.parseInt(txt_can.getText());
//        String total = String.valueOf(can_1-can_2);
//        
//
//        
//
//        PreparedStatement ps;
//        String query = "UPDATE `producto` SET cantidad=?  WHERE `idproducto`=?";
//        try {
//            ps = Myconnection.getconnection().prepareStatement(query);
//            
//            ps.setString(2, id);
//            ps.setString(1, total);
//
//            
//            
//
//            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Producto/s Vendido/s ");
//            Limpiar();
//            Mostrardatos("");
//
//        } catch (SQLException ex) {
//            Logger.getLogger(venta_producto.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "error "+ex);
//        }


//    public float sumar(){
//       para hacer la suma del total
    
//        int contar = tablafac.getRowCount();
//        float subtotal = 0;
//        
//        for (int i = 0; i < contar; i++){
//        
//            subtotal = subtotal + Float.parseFloat(tablafac.getValueAt(i,3).toString());
//        
//        }
//        
//        
//       return subtotal;
//    }
}