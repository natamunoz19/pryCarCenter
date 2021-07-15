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
public class RepuestosXMantenimientos {
    int codigo;
    int unidades;
    int tiempoEstimado;
    int codMantenimiento;
    int codRepuesto;

    public RepuestosXMantenimientos() {
    }

    public RepuestosXMantenimientos(int codigo, int unidades, int tiempoEstimado, int codMantenimiento, int codRepuesto) {
        this.codigo = codigo;
        this.unidades = unidades;
        this.tiempoEstimado = tiempoEstimado;
        this.codMantenimiento = codMantenimiento;
        this.codRepuesto = codRepuesto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getCodMantenimiento() {
        return codMantenimiento;
    }

    public void setCodMantenimiento(int codMantenimiento) {
        this.codMantenimiento = codMantenimiento;
    }

    public int getCodRepuesto() {
        return codRepuesto;
    }

    public void setCodRepuesto(int codRepuesto) {
        this.codRepuesto = codRepuesto;
    }
    
    
}
