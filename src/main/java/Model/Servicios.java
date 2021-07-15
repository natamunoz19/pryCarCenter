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
public class Servicios {
    int codigo;
    String nombreServicio;
    int precio;
    int precioMinimo;
    int precioMaximo;

    public Servicios() {
    }

    public Servicios(int codigo, String nombreServicio, int precio, int precioMinimo, int precioMaximo) {
        this.codigo = codigo;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.precioMinimo = precioMinimo;
        this.precioMaximo = precioMaximo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(int precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public int getPrecioMaximo() {
        return precioMaximo;
    }

    public void setPrecioMaximo(int precioMaximo) {
        this.precioMaximo = precioMaximo;
    }
    
}
