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
public class FotosDAOImpl implements FotosDAO{
    
    public ArrayList<Fotos> listarFotos(){
        ArrayList<Fotos> list = new ArrayList<Fotos>();
        Conexion conec = new Conexion();
        String sql = "SELECT * FROM fotos;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Fotos pic = new Fotos();
                pic.setCodigo(rs.getInt(1));
                pic.setRuta(rs.getString(2));
                pic.setCodMantenimiento(rs.getInt(3));
                list.add(pic);
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

    public void crearFotos(Fotos pic){
        Conexion conec = new Conexion();
        String sql = "INSERT INTO fotos (codigo, ruta, cod_mantenimiento) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, pic.getCodigo());
            ps.setString(2, pic.getRuta());
            ps.setInt(3, pic.getCodMantenimiento());
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

    public void actualizarFotos(Fotos pic){
        Conexion conec = new Conexion();
        String sql = "UPDATE fotos SET ruta = ?, cod_mantenimiento = ? WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            
            ps.setString(1, pic.getRuta());
            ps.setInt(2, pic.getCodMantenimiento());
            ps.setInt(3, pic.getCodigo());
            
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

    public void eliminarFotos(Fotos pic){
        Conexion conec = new Conexion();
        String sql = "DELETE FROM fotos WHERE codigo = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, pic.getCodigo());
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
