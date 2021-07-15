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
public interface MarcasDAO {
    public ArrayList<Marcas> listarMarcas();

    public void crearMarcas(Marcas mar);

    public void actualizarMarcas(Marcas mar);

    public void eliminarMarcas(Marcas mar);
    
}
