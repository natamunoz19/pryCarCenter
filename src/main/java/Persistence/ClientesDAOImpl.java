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
public class ClientesDAOImpl implements ClientesDAO{
    
    public ArrayList<Clientes> listarClientes(){
        ArrayList<Clientes> list = new ArrayList<Clientes>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM clientes;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Clientes cli = new Clientes();
                cli.setTipoDocumento(rs.getString(1));
                cli.setDocumento(rs.getInt(2));
                cli.setPrimerNombre(rs.getString(3));
                cli.setSegundoNombre(rs.getString(4));
                cli.setPrimerApellido(rs.getString(5));
                cli.setSegundoApellido(rs.getString(6));
                cli.setCelular(rs.getString(7));
                cli.setDireccion(rs.getString(8));
                cli.setEmail(rs.getString(9));
                list.add(cli);
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

    public void crearClientes(Clientes cli){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO clientes (tipo_documento, documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, celular, direccion, email) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, cli.getTipoDocumento());
            ps.setInt(2, cli.getDocumento());
            ps.setString(3, cli.getPrimerNombre());
            ps.setString(4, cli.getSegundoNombre());
            ps.setString(5, cli.getPrimerApellido());
            ps.setString(6, cli.getSegundoApellido());
            ps.setString(7, cli.getCelular());
            ps.setString(8, cli.getDireccion());
            ps.setString(9, cli.getEmail());
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

    public void actualizarClientes(Clientes cli){
        Conexion conec = new Conexion();
        String sql = "UPDATE clientes SET primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, celular = ?, direccion = ?, email = ? WHERE tipo_documento = ? AND documento = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setString(1, cli.getPrimerNombre());
            ps.setString(2, cli.getSegundoNombre());
            ps.setString(3, cli.getPrimerApellido());
            ps.setString(4, cli.getSegundoApellido());
            ps.setString(5, cli.getCelular());
            ps.setString(6, cli.getDireccion());
            ps.setString(7, cli.getEmail());
            ps.setString(8, cli.getTipoDocumento());
            ps.setInt(9, cli.getDocumento());
            
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

    public void eliminarClientes(Clientes cli){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM clientes WHERE tipo_documento = ? AND documento = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, cli.getTipoDocumento());
            ps.setInt(2, cli.getDocumento());
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
