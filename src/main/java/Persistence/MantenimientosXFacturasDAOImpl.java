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
public class MantenimientosXFacturasDAOImpl implements MantenimientosXFacturasDAO{
    
    public ArrayList<MantenimientosXFacturas> listarMantenimientosXFacturas(){
        ArrayList<MantenimientosXFacturas> list = new ArrayList<MantenimientosXFacturas>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM mantenimientos_x_facturas;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                MantenimientosXFacturas man = new MantenimientosXFacturas();
                man.setCodigo(rs.getInt(1));
                man.setCodigoFactura(rs.getInt(2));
                man.setCodigoMantenimiento(rs.getInt(3));
                list.add(man);
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

    public void crearMantenimientosXFacturas(MantenimientosXFacturas man){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO mantenimientos_x_facturas (codigo, codigo_factura, codigo_mantenimiento) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, man.getCodigo());
            ps.setInt(2, man.getCodigoFactura());
            ps.setInt(3, man.getCodigoMantenimiento());
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

    public void actualizarMantenimientosXFacturas(MantenimientosXFacturas man){
        Conexion conec = new Conexion();
        String sql = "UPDATE mantenimientos_x_facturas SET codigo_factura = ?, codigo_mantenimiento = ? WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setInt(1, man.getCodigoFactura());
            ps.setInt(2, man.getCodigoMantenimiento());
            ps.setInt(3, man.getCodigo());
            
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

    public void eliminarMantenimientosXFacturas(MantenimientosXFacturas man){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM mantenimientos_x_facturas WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, man.getCodigo());
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
