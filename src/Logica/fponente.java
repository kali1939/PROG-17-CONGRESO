/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vponente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ismael
 */
public class fponente {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Nombre","A Paterno","A Materno","Correo","Telefono", "Nacionalidad", "Especialidad"};
    
    String [] registro = new String [8];
    totalregistros=0;
    modelo =new DefaultTableModel(null, titulos);
    
    sSQL="select * from ponente where nombre like '%"+ buscar + "%' order by idponente";
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idponente");
                registro[1]=rs.getString("nombre");
                registro[2]=rs.getString("apaterno");
                registro[3]=rs.getString("amaterno");
                registro[4]=rs.getString("correo");
                registro[5]=rs.getString("telefono");
                registro[6]=rs.getString("nacionalidad");
                registro[7]=rs.getString("especialidad");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            
            return modelo;
            
            
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }    
}
    
    public boolean insertar (vponente dts) {
        sSQL="insert into ponente (nombre, apaterno, amaterno, correo, telefono, nacionalidad, especialidad)" +
                "values (?,?,?,?,?,?,?)";
       
        
        try {

            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getApaterno());
            pst.setString(3,dts.getAmaterno());
            pst.setString(4,dts.getCorreo());
            pst.setString(5,dts.getTelefono());
            pst.setString(6,dts.getNacionalidad());
            pst.setString(7,dts.getEspecialidad());
    
            int n=pst.executeUpdate();
            if (n!=0){
               return true;
                
            }
            else {
                return false;
            }
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);    
        return false;
        }
    }
    
    public boolean editar (vponente dts) {
        sSQL="update usuario set nombre=?, apaterno=?, amaterno=?, correo=?, telefono=?, nacionalidad=?, especialidad=?"+
             "where idponente=?"; 
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getApaterno());
            pst.setString(3,dts.getAmaterno());
            pst.setString(4,dts.getCorreo());
            pst.setString(5,dts.getTelefono());
            pst.setString(6,dts.getNacionalidad());
            pst.setString(7,dts.getEspecialidad());
            pst.setInt(8,dts.getIdponente());
            
            
            int n=pst.executeUpdate();
            if (n!=0){
               return true;
                
            }
            else {
                return false;
            }
            
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);    
        return false;
        }
    }
        
    public boolean eliminar (vponente dts) {
        sSQL="delete from ponente where idponente=?";  
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdponente());
            
            int n=pst.executeUpdate();
            if (n!=0){
               return true;
                
            }
            else {
                return false;
            }
            
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);    
        return false;
        }
    }
}