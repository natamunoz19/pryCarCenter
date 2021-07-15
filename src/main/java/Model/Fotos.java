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
public class Fotos {
    int codigo;
    String ruta;
    int codMantenimiento;

    public Fotos() {
    }

    public Fotos(int codigo, String ruta, int codMantenimiento) {
        this.codigo = codigo;
        this.ruta = ruta;
        this.codMantenimiento = codMantenimiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getCodMantenimiento() {
        return codMantenimiento;
    }

    public void setCodMantenimiento(int codMantenimiento) {
        this.codMantenimiento = codMantenimiento;
    }
    
    
}
