/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mecanicos;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
//import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.swing.JOptionPane;

/**
 *
 * @author NATALIA-PC
 */
@Named
@SessionScoped
public class MecanicoController implements Serializable{
    private MecanicoBean bean = new MecanicoBean();
    private ArrayList<Mecanicos> lista = new ArrayList<Mecanicos>();
    private Mecanicos mecanico = new Mecanicos();
    private String codDoc;

    public String getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(String codDoc) {
        this.codDoc = codDoc;
    }

    public MecanicoController() {
    }

    public ArrayList<Mecanicos> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Mecanicos> lista) {
        this.lista = lista;
    }

    public Mecanicos getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanicos mecanico) {
        this.mecanico = mecanico;
    }
    
    public String crearMecanico(){
        
        if(!this.mecanico.getTipoDocumento().isEmpty() && !this.mecanico.getPrimerNombre().isEmpty() &&
                !this.mecanico.getPrimerApellido().isEmpty() && !this.mecanico.getEmail().isEmpty() &&
                !this.mecanico.getDireccion().isEmpty() && !this.mecanico.getCelular().isEmpty() &&
                this.mecanico.getDocumento()>0){
            bean.crearMecanicos(this.mecanico);
            return "index";
        }else{
            return "";
        }
    }
    
    public void actualizarLista(){
        this.lista = bean.listarMecanicosOrden();
    }
    
    public String irListar(){
        this.lista = bean.listarMecanicosOrden();
        return "listarMecanico";
    }
    
}
