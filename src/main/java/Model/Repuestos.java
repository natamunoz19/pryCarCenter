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
public class Repuestos {
    int codigo;
    String nombreRepuesto;
    int precioUnitario;
    int unidadesInventario;
    String proveedor;

    public Repuestos(int codigo, String nombreRepuesto, int precioUnitario, int unidadesInventario, String proveedor) {
        this.codigo = codigo;
        this.nombreRepuesto = nombreRepuesto;
        this.precioUnitario = precioUnitario;
        this.unidadesInventario = unidadesInventario;
        this.proveedor = proveedor;
    }

    public Repuestos() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getUnidadesInventario() {
        return unidadesInventario;
    }

    public void setUnidadesInventario(int unidadesInventario) {
        this.unidadesInventario = unidadesInventario;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
}
