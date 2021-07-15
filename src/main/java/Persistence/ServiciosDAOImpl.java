/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NATALIA-PC
 */
public class ServiciosDAOImpl implements ServiciosDAO{
    
    public ArrayList<Servicios> listarServicios(){
        ArrayList<Servicios> list = new ArrayList<Servicios>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM servicios;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Servicios ser = new Servicios();
                ser.setCodigo(rs.getInt(1));
                ser.setNombreServicio(rs.getString(2));
                ser.setPrecio(rs.getInt(3));
                ser.setPrecioMinimo(rs.getInt(4));
                ser.setPrecioMaximo(rs.getInt(5));
                list.add(ser);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }

    public void crearServicios(Servicios ser){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO servicios (codigo, nombre_servicio, precio, precio_minimo, precio_maximo) VALUES(?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, ser.getCodigo());
            ps.setString(2, ser.getNombreServicio());
            ps.setInt(3, ser.getPrecio());
            ps.setInt(4, ser.getPrecioMinimo());
            ps.setInt(5, ser.getPrecioMaximo());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    public void actualizarServicios(Servicios ser){
        Conexion conec = new Conexion();
        String sql = "UPDATE servicios SET nombre_servicio = ?, precio = ?, precio_minimo = ?, precio_maximo = ? WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setString(1, ser.getNombreServicio());
            ps.setInt(2, ser.getPrecio());
            ps.setInt(3, ser.getPrecioMinimo());
            ps.setInt(4, ser.getPrecioMaximo());
            ps.setInt(5, ser.getCodigo());
            
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    public void eliminarServicios(Servicios ser){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM servicios WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, ser.getCodigo());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
    
}
