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
public class ServiciosXMantenimientoDAOImpl implements ServiciosXMantenimientoDAO{
    
    public ArrayList<ServiciosXMantenimiento> listarServiciosXMantenimiento(){
        ArrayList<ServiciosXMantenimiento> list = new ArrayList<ServiciosXMantenimiento>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM servicios_x_mantenimientos;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ServiciosXMantenimiento ser = new ServiciosXMantenimiento();
                ser.setCodigo(rs.getInt(1));
                ser.setTiempoEstimado(rs.getInt(2));
                ser.setCodServicio(rs.getInt(3));
                ser.setCodMantenimiento(rs.getInt(4));
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
    
    public ArrayList<ServiciosXMantenimiento> listarServiciosXMantenimiento(ServiciosXMantenimiento sxm){
        ArrayList<ServiciosXMantenimiento> list = new ArrayList<ServiciosXMantenimiento>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM servicios_x_mantenimientos where 1=1 ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        if(sxm.getCodMantenimiento()!=0){
            sql = sql + "AND cod_mantenimiento = " + sxm.getCodMantenimiento();
        }
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ServiciosXMantenimiento ser = new ServiciosXMantenimiento();
                ser.setCodigo(rs.getInt(1));
                ser.setTiempoEstimado(rs.getInt(2));
                ser.setCodServicio(rs.getInt(3));
                ser.setCodMantenimiento(rs.getInt(4));
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

    public void crearServiciosXMantenimiento(ServiciosXMantenimiento sxm){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO servicios_x_mantenimientos (codigo, tiempo_estimado, cod_servicio, cod_mantenimiento) VALUES(?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, sxm.getCodigo());
            ps.setInt(2, sxm.getTiempoEstimado());
            ps.setInt(3, sxm.getCodServicio());
            ps.setInt(4, sxm.getCodMantenimiento());
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

    public void actualizarServiciosXMantenimiento(ServiciosXMantenimiento sxm){
        Conexion conec = new Conexion();
        String sql = "UPDATE servicios_x_mantenimientos SET tiempo_estimado = ?, cod_servicio = ?, cod_mantenimiento = ? WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setInt(1, sxm.getTiempoEstimado());
            ps.setInt(2, sxm.getCodServicio());
            ps.setInt(3, sxm.getCodMantenimiento());
            ps.setInt(4, sxm.getCodigo());
            
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

    public void eliminarServiciosXMantenimiento(ServiciosXMantenimiento sxm){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM servicios_x_mantenimientos WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, sxm.getCodigo());
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
