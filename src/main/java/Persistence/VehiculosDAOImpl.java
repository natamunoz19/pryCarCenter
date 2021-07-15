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
public class VehiculosDAOImpl implements VehiculosDAO{
    
    public ArrayList<Vehiculos> listarVehiculos(){
        ArrayList<Vehiculos> list = new ArrayList<Vehiculos>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM vehiculos;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Vehiculos veh = new Vehiculos();
                veh.setPlaca(rs.getString(1));
                veh.setColor(rs.getString(2));
                veh.setCodMarca(rs.getInt(3));
                veh.setCliDocumento(rs.getInt(4));
                veh.setCliTipoDocumento(rs.getString(5));
                list.add(veh);
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

    public void crearVehiculos(Vehiculos veh){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO vehiculos (placa, color, cod_marca, cli_documento, cli_tipo_documento) VALUES(?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, veh.getPlaca());
            ps.setString(2, veh.getColor());
            ps.setInt(3, veh.getCodMarca());
            ps.setInt(4, veh.getCliDocumento());
            ps.setString(5, veh.getCliTipoDocumento());
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

    public void actualizarVehiculos(Vehiculos veh){
        Conexion conec = new Conexion();
        String sql = "UPDATE vehiculos SET color = ?, cod_marca = ?, cli_documento = ?, cli_tipo_documento = ? WHERE placa = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setString(1, veh.getColor());
            ps.setInt(2, veh.getCodMarca());
            ps.setInt(3, veh.getCliDocumento());
            ps.setString(4, veh.getCliTipoDocumento());
            ps.setString(5, veh.getPlaca());
            
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

    public void eliminarVehiculos(Vehiculos veh){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM vehiculos WHERE placa = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, veh.getPlaca());
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
