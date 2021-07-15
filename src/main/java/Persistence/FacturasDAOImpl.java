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
public class FacturasDAOImpl implements FacturasDAO{
    
    public ArrayList<Facturas> listarFacturas(){
        ArrayList<Facturas> list = new ArrayList<Facturas>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM facturas;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Facturas fac = new Facturas();
                fac.setCodigo(rs.getInt(1));
                fac.setCliDocumento(rs.getInt(2));
                fac.setCliTipoDocumento(rs.getString(3));
                fac.setValorRepuestos(rs.getInt(4));
                fac.setValorServicios(rs.getInt(5));
                fac.setValorDescuento(rs.getInt(6));
                fac.setValorIva(rs.getInt(7));
                fac.setValorTotal(rs.getInt(8));
                list.add(fac);
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

    public void crearFacturas(Facturas fac){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO facturas (codigo, cli_documento, cli_tipo_documento, valor_repuestos, valor_servicios, valor descuento, valor_iva, valor_total) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, fac.getCodigo());
            ps.setInt(2, fac.getCliDocumento());
            ps.setString(3, fac.getCliTipoDocumento());
            ps.setInt(4, fac.getValorRepuestos());
            ps.setInt(5, fac.getValorServicios());
            ps.setInt(6, fac.getValorDescuento());
            ps.setInt(7, fac.getValorIva());
            ps.setInt(8, fac.getValorTotal());
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

    public void actualizarFacturas(Facturas fac){
        Conexion conec = new Conexion();
        String sql = "UPDATE facturas SET cli_documento = ?, cli_tipo_documento = ?, valor_repuestos = ?, valor_servicios = ?, valor descuento = ?, valor_iva = ?, valor_total = ? WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setInt(1, fac.getCliDocumento());
            ps.setString(2, fac.getCliTipoDocumento());
            ps.setInt(3, fac.getValorRepuestos());
            ps.setInt(4, fac.getValorServicios());
            ps.setInt(5, fac.getValorDescuento());
            ps.setInt(6, fac.getValorIva());
            ps.setInt(7, fac.getValorTotal());
            ps.setInt(8, fac.getCodigo());
            
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

    public void eliminarFacturas(Facturas fac){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM facturas WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, fac.getCodigo());
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
