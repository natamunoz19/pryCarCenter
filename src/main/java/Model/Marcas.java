/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author NATALIA-PC
 */
public class Marcas {
    int codigo;
    String nombreMarca;

    public Marcas() {
    }

    public Marcas(int codigo, String nombreMarca) {
        this.codigo = codigo;
        this.nombreMarca = nombreMarca;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }
    
    
}
