/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vusuario;
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
public class fusuario {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Nombre","A Paterno","A Materno","Username","Password", "sexo"};
    
    String [] registro = new String [7];
    totalregistros=0;
    modelo =new DefaultTableModel(null, titulos);
    
    sSQL="select * from usuario where nombre like '%"+ buscar + "%' order by idusuario";
    
        try {
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(sSQL);
            
            while(rs.next()){
                registro[0]=rs.getString("idusuario");
                registro[1]=rs.getString("nombre");
                registro[2]=rs.getString("apaterno");
                registro[3]=rs.getString("amaterno");
                registro[4]=rs.getString("username");
                registro[5]=rs.getString("password");
                registro[6]=rs.getString("sexo");
                
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
                
            }
            
            return modelo;
            
            
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }    
}
    
    public boolean insertar (vusuario dts) {
        sSQL="insert into usuario (nombre, apaterno, amaterno, username, password, sexo)" +
                "values (?,?,?,?,?,?)";
       
        
        try {

            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getApaterno());
            pst.setString(3,dts.getAmaterno());
            pst.setString(4,dts.getUsername());
            pst.setString(5,dts.getPassword());
            pst.setString(6,dts.getSexo());
    
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
    
    public boolean editar (vusuario dts) {
        sSQL="update usuario set nombre=?, apaterno=?, amaterno=?, username=?,password=?,sexo=?"+
             "where idusuario=?"; 
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getNombre());
            pst.setString(2,dts.getApaterno());
            pst.setString(3,dts.getAmaterno());
            pst.setString(4,dts.getUsername());
            pst.setString(5,dts.getPassword());
            pst.setString(6,dts.getSexo());
            pst.setInt(7,dts.getIdusuario());
            
            
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
        
    public boolean eliminar (vusuario dts) {
        sSQL="delete from usuario where idusuario=?";  
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdusuario());
            
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