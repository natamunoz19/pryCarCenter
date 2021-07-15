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
public class RepuestosXMantenimientosDAOImpl implements RepuestosXMantenimientosDAO{
    
    public ArrayList<RepuestosXMantenimientos> listarRepuestosXMantenimientos(){
        
        ArrayList<RepuestosXMantenimientos> list = new ArrayList<RepuestosXMantenimientos>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM repuestos_x_mantenimientos;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                RepuestosXMantenimientos rep = new RepuestosXMantenimientos();
                rep.setCodigo(rs.getInt(1));
                rep.setUnidades(rs.getInt(2));
                rep.setTiempoEstimado(rs.getInt(3));
                rep.setCodMantenimiento(rs.getInt(4));
                rep.setCodRepuesto(rs.getInt(5));
                list.add(rep);
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

    public void crearRepuestosXMantenimientos(RepuestosXMantenimientos rep){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO repuestos_x_mantenimientos (codigo, unidades, tiempo_estimado, cod_mantenimiento, cod_repuesto) VALUES(?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, rep.getCodigo());
            ps.setInt(2, rep.getUnidades());
            ps.setInt(3, rep.getTiempoEstimado());
            ps.setInt(4, rep.getCodMantenimiento());
            ps.setInt(5, rep.getCodRepuesto());
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

    public void actualizarRepuestosXMantenimientos(RepuestosXMantenimientos rep){
        Conexion conec = new Conexion();
        String sql = "UPDATE repuestos_x_mantenimientos SET unidades = ?, tiempo_estimado = ?, cod_mantenimiento = ?, cod_repuesto = ? WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setInt(1, rep.getUnidades());
            ps.setInt(2, rep.getTiempoEstimado());
            ps.setInt(3, rep.getCodMantenimiento());
            ps.setInt(4, rep.getCodRepuesto());
            ps.setInt(5, rep.getCodigo());
            
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

    public void eliminarRepuestosXMantenimientos(RepuestosXMantenimientos rep){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM repuestos_x_mantenimientos WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, rep.getCodigo());
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
