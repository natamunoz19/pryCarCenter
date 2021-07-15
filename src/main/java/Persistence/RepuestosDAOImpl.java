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
public class RepuestosDAOImpl implements RepuestosDAO{
    
    public ArrayList<Repuestos> listarRepuestos(){
        ArrayList<Repuestos> list = new ArrayList<Repuestos>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM repuestos;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Repuestos rep = new Repuestos();
                rep.setCodigo(rs.getInt(1));
                rep.setNombreRepuesto(rs.getString(2));
                rep.setPrecioUnitario(rs.getInt(3));
                rep.setUnidadesInventario(rs.getInt(4));
                rep.setProveedor(rs.getString(5));
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

    public void crearRepuestos(Repuestos rep){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO repuestos (codigo, nombre_repuesto, precio_unitario, unidades_inventario, proveedor) VALUES(?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, rep.getCodigo());
            ps.setString(2, rep.getNombreRepuesto());
            ps.setInt(3, rep.getPrecioUnitario());
            ps.setInt(4, rep.getUnidadesInventario());
            ps.setString(5, rep.getProveedor());
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

    public void actualizarRepuestos(Repuestos rep){
        Conexion conec = new Conexion();
        String sql = "UPDATE repuestos SET nombre_repuesto = ?, precio_unitario = ?, unidades_inventario = ?, proveedor = ? WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setString(1, rep.getNombreRepuesto());
            ps.setInt(2, rep.getPrecioUnitario());
            ps.setInt(3, rep.getUnidadesInventario());
            ps.setString(4, rep.getProveedor());
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

    public void eliminarRepuestos(Repuestos rep){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM repuestos WHERE codigo = ?;";
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
