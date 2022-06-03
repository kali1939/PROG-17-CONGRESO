/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vactividad;
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
public class factividad {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Tipo","Titulo","Duracion","Lugar"};
    
    String [] registro = new String [6];
    totalregistros=0;
    modelo =new DefaultTableModel(null, titulos);
    
    sSQL="select * from actividad where tipo like '%"+ buscar + "%' order by idactividad";
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idactividad");
                registro[1]=rs.getString("tipo");
                registro[2]=rs.getString("titulo");
                registro[3]=rs.getString("duracion");
                registro[4]=rs.getString("lugar");
               ;
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            
            return modelo;
            
            
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }    
}
    
    public boolean insertar (vactividad dts) {
        sSQL="insert into actividad (tipo, titulo, duracion, lugar)" +
                "values (?,?,?,?)";
       
        
        try {

            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getTipo());
            pst.setString(2,dts.getTitulo());
            pst.setString(3,dts.getDuracion());
            pst.setString(4,dts.getLugar());
            
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
    
    public boolean editar (vactividad dts) {
        sSQL="update actividad set tipo=?, titulo=?, duracion=?, lugar=?"+
             "where idactividad=?"; 
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getTipo());
            pst.setString(2,dts.getTitulo());
            pst.setString(3,dts.getDuracion());
            pst.setString(4,dts.getLugar());
            pst.setInt(5,dts.getIdactividad());
            
            
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
        
    public boolean eliminar (vactividad dts) {
        sSQL="delete from actividad where idactividad=?";  
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdactividad());
            
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