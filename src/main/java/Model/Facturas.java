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
public class Facturas {
    int codigo;
    int cliDocumento;
    String cliTipoDocumento;
    int valorRepuestos;
    int valorServicios;
    int valorDescuento;
    int valorIva;
    int valorTotal;

    public Facturas() {
    }

    public Facturas(int codigo, int cliDocumento, String cliTipoDocumento, int valorRepuestos, int valorServicios, int valorDescuento, int valorIva, int valorTotal) {
        this.codigo = codigo;
        this.cliDocumento = cliDocumento;
        this.cliTipoDocumento = cliTipoDocumento;
        this.valorRepuestos = valorRepuestos;
        this.valorServicios = valorServicios;
        this.valorDescuento = valorDescuento;
        this.valorIva = valorIva;
        this.valorTotal = valorTotal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCliDocumento() {
        return cliDocumento;
    }

    public void setCliDocumento(int cliDocumento) {
        this.cliDocumento = cliDocumento;
    }

    public String getCliTipoDocumento() {
        return cliTipoDocumento;
    }

    public void setCliTipoDocumento(String cliTipoDocumento) {
        this.cliTipoDocumento = cliTipoDocumento;
    }

    public int getValorRepuestos() {
        return valorRepuestos;
    }

    public void setValorRepuestos(int valorRepuestos) {
        this.valorRepuestos = valorRepuestos;
    }

    public int getValorServicios() {
        return valorServicios;
    }

    public void setValorServicios(int valorServicios) {
        this.valorServicios = valorServicios;
    }

    public int getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(int valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public int getValorIva() {
        return valorIva;
    }

    public void setValorIva(int valorIva) {
        this.valorIva = valorIva;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
