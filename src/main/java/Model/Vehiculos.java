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
public class Vehiculos {
    String placa;
    String color;
    int codMarca;
    int cliDocumento;
    String cliTipoDocumento;

    public Vehiculos() {
    }

    public Vehiculos(String placa, String color, int codMarca, int cliDocumento, String cliTipoDocumento) {
        this.placa = placa;
        this.color = color;
        this.codMarca = codMarca;
        this.cliDocumento = cliDocumento;
        this.cliTipoDocumento = cliTipoDocumento;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
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
    
    
}
