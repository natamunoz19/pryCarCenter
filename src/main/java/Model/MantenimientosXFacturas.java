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
public class MantenimientosXFacturas {
    int codigo;
    int codigoFactura;
    int codigoMantenimiento;

    public MantenimientosXFacturas() {
    }

    public MantenimientosXFacturas(int codigo, int codigoFactura, int codigoMantenimiento) {
        this.codigo = codigo;
        this.codigoFactura = codigoFactura;
        this.codigoMantenimiento = codigoMantenimiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getCodigoMantenimiento() {
        return codigoMantenimiento;
    }

    public void setCodigoMantenimiento(int codigoMantenimiento) {
        this.codigoMantenimiento = codigoMantenimiento;
    }
    
    
}
