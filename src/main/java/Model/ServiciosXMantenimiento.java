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
public class ServiciosXMantenimiento {
    int codigo;
    int tiempoEstimado;
    int codServicio;
    int codMantenimiento;

    public ServiciosXMantenimiento() {
    }

    public ServiciosXMantenimiento(int codigo, int tiempoEstimado, int codServicio, int codMantenimiento) {
        this.codigo = codigo;
        this.tiempoEstimado = tiempoEstimado;
        this.codServicio = codServicio;
        this.codMantenimiento = codMantenimiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(int codServicio) {
        this.codServicio = codServicio;
    }

    public int getCodMantenimiento() {
        return codMantenimiento;
    }

    public void setCodMantenimiento(int codMantenimiento) {
        this.codMantenimiento = codMantenimiento;
    }
    
    
}
