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
public class MecanicosDAOImpl implements MecanicosDAO{
    
    public ArrayList<Mecanicos> listarMecanicos(){
        ArrayList<Mecanicos> list = new ArrayList<Mecanicos>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM mecanicos;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Mecanicos mec = new Mecanicos();
                mec.setTipoDocumento(rs.getString(1));
                mec.setDocumento(rs.getInt(2));
                mec.setPrimerNombre(rs.getString(3));
                mec.setSegundoNombre(rs.getString(4));
                mec.setPrimerApellido(rs.getString(5));
                mec.setSegundoApellido(rs.getString(6));
                mec.setCelular(rs.getString(7));
                mec.setDireccion(rs.getString(8));
                mec.setEmail(rs.getString(9));
                mec.setEstado(rs.getString(10));
                list.add(mec);
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
    
    public ArrayList<Mecanicos> listarMecanicos(Mecanicos meca){
        ArrayList<Mecanicos> list = new ArrayList<Mecanicos>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM mecanicos where 1=1 ";
        ResultSet rs = null;
        PreparedStatement ps = null;
        if(meca.getEstado() != null && !meca.getEstado().isEmpty()){
            sql = sql + " AND estado = " + (char)34 + meca.getEstado() + (char)34;
        }
        if(meca.getTipoDocumento() != null && !meca.getTipoDocumento().isEmpty() && meca.getDocumento()!=0){
            sql = sql + " AND tipo_documento = " + (char)34 + meca.getTipoDocumento() + (char)34 + " AND documento = " + meca.getDocumento()+ " ";
        }
        //sql = sql + ";";
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Mecanicos mec = new Mecanicos();
                mec.setTipoDocumento(rs.getString(1));
                mec.setDocumento(rs.getInt(2));
                mec.setPrimerNombre(rs.getString(3));
                mec.setSegundoNombre(rs.getString(4));
                mec.setPrimerApellido(rs.getString(5));
                mec.setSegundoApellido(rs.getString(6));
                mec.setCelular(rs.getString(7));
                mec.setDireccion(rs.getString(8));
                mec.setEmail(rs.getString(9));
                mec.setEstado(rs.getString(10));
                list.add(mec);
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

    public void crearMecanicos(Mecanicos mec){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO mecanicos (tipo_documento, documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, celular, direccion, email, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, mec.getTipoDocumento());
            ps.setInt(2, mec.getDocumento());
            ps.setString(3, mec.getPrimerNombre());
            ps.setString(4, mec.getSegundoNombre());
            ps.setString(5, mec.getPrimerApellido());
            ps.setString(6, mec.getSegundoApellido());
            ps.setString(7, mec.getCelular());
            ps.setString(8, mec.getDireccion());
            ps.setString(9, mec.getEmail());
            ps.setString(10, mec.getEstado());
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

    public void actualizarMecanicos(Mecanicos mec){
        Conexion conec = new Conexion();
        String sql = "UPDATE mecanicos SET primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, celular = ?, direccion = ?, email = ?, estado = ? WHERE tipo_documento = ? and documento = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setString(1, mec.getPrimerNombre());
            ps.setString(2, mec.getSegundoNombre());
            ps.setString(3, mec.getPrimerApellido());
            ps.setString(4, mec.getSegundoApellido());
            ps.setString(5, mec.getCelular());
            ps.setString(6, mec.getDireccion());
            ps.setString(7, mec.getEmail());
            ps.setString(8, mec.getEstado());
            ps.setString(9, mec.getTipoDocumento());
            ps.setInt(10, mec.getDocumento());
            
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

    public void eliminarMecanicos(Mecanicos mec){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM mecanicos WHERE tipo_documento = ? and documento = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, mec.getTipoDocumento());
            ps.setInt(1, mec.getDocumento());
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
