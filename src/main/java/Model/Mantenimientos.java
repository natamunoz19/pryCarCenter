/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author NATALIA-PC
 */
public class Mantenimientos {
    int codigo;
    int estado;
    String codPlaca;
    String fecha;
    int mecDocumento;
    String mecTipoDocumento;
    int limitePresupuesto;
    
    Mecanicos mec;
    ArrayList<ServiciosXMantenimiento> listaServicios;

    public Mantenimientos() {
        mec= new Mecanicos();
        listaServicios = new ArrayList<ServiciosXMantenimiento>();
    }

    public Mantenimientos(int codigo, int estado, String codPlaca, String fecha, int mecDocumento, String mecTipoDocumento, int limitePresupuesto) {
        this.codigo = codigo;
        this.estado = estado;
        this.codPlaca = codPlaca;
        this.fecha = fecha;
        this.mecDocumento = mecDocumento;
        this.mecTipoDocumento = mecTipoDocumento;
        this.limitePresupuesto = limitePresupuesto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCodPlaca() {
        return codPlaca;
    }

    public void setCodPlaca(String codPlaca) {
        this.codPlaca = codPlaca;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMecDocumento() {
        return mecDocumento;
    }

    public void setMecDocumento(int mecDocumento) {
        this.mecDocumento = mecDocumento;
    }

    public String getMecTipoDocumento() {
        return mecTipoDocumento;
    }

    public void setMecTipoDocumento(String mecTipoDocumento) {
        this.mecTipoDocumento = mecTipoDocumento;
    }

    public int getLimitePresupuesto() {
        return limitePresupuesto;
    }

    public void setLimitePresupuesto(int limitePresupuesto) {
        this.limitePresupuesto = limitePresupuesto;
    }

    public Mecanicos getMec() {
        return mec;
    }

    public void setMec(Mecanicos mec) {
        this.mec = mec;
    }

    public ArrayList<ServiciosXMantenimiento> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<ServiciosXMantenimiento> listaServicios) {
        this.listaServicios = listaServicios;
    }
    
    
}
