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
public class MantenimientosDAOImpl implements MantenimientosDAO{
    public ArrayList<Mantenimientos> listarMantenimientos(){
        ArrayList<Mantenimientos> list = new ArrayList<Mantenimientos>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM mantenimientos;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Mantenimientos mant = new Mantenimientos();
                mant.setCodigo(rs.getInt(1));
                mant.setEstado(rs.getInt(2));
                mant.setCodPlaca(rs.getString(3));
                mant.setFecha(rs.getString(4));
                mant.setMecDocumento(rs.getInt(5));
                mant.setMecTipoDocumento(rs.getString(6));
                list.add(mant);
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
    
    public ArrayList<Mantenimientos> listarMantenimientosUltimoMes(){
        ArrayList<Mantenimientos> list = new ArrayList<Mantenimientos>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM mantenimientos where fecha>= CURDATE()-30;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Mantenimientos mant = new Mantenimientos();
                mant.setCodigo(rs.getInt(1));
                mant.setEstado(rs.getInt(2));
                mant.setCodPlaca(rs.getString(3));
                mant.setFecha(rs.getString(4));
                mant.setMecDocumento(rs.getInt(5));
                mant.setMecTipoDocumento(rs.getString(6));
                list.add(mant);
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

    public void crearMantenimientos(Mantenimientos mant){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO mantenimientos (codigo, estado, codPlaca, fecha, mecDocumento, mecTipoDocumento, limitePresupuesto) VALUES(?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, mant.getCodigo());
            ps.setInt(2, mant.getEstado());
            ps.setString(3, mant.getCodPlaca());
            ps.setString(4, mant.getFecha());
            ps.setInt(5, mant.getMecDocumento());
            ps.setString(6, mant.getMecTipoDocumento());
            ps.setInt(7, mant.getLimitePresupuesto());
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

    public void actualizarMantenimientos(Mantenimientos mant){
        Conexion conec = new Conexion();
        String sql = "UPDATE mantenimientos SET estado = ?, codPlaca = ?, fecha = ?, mecDocumento = ?, mecTipoDocumento = ?, limitePresupuesto = ? WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setInt(1, mant.getEstado());
            ps.setString(2, mant.getCodPlaca());
            ps.setString(3, mant.getFecha());
            ps.setInt(4, mant.getMecDocumento());
            ps.setString(5, mant.getMecTipoDocumento());
            ps.setInt(6, mant.getLimitePresupuesto());
            ps.setInt(7, mant.getCodigo());
            
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

    public void eliminarMantenimientos(Mantenimientos mant){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM mantenimientos WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, mant.getCodigo());
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
