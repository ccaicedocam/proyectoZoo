/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jorge
 */
@Entity (name = "Show")
public class ShowEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_show")
    private Long idShow;
    
    @Column (name = "Idnombre")
    private String Idnombre;
    
    @Column (name = "Idhora")
    private String Idhora;
    
    @Column (name = "IdEmpleado")
    private String IdEmpleado;

    /**
     * Constructor
     */
    public ShowEntity() {
        
    }

    public String getIdnombre() {
        return Idnombre;
    }

    public void setIdnombre(String Idnombre) {
        this.Idnombre = Idnombre;
    }

    public String getIdhora() {
        return Idhora;
    }

    public void setIdhora(String Idhora) {
        this.Idhora = Idhora;
    }

    public String getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(String IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public Long getIdShow() {
        return idShow;
    }

    public void setIdShow(Long idShow) {
        this.idShow = idShow;
    }
    
}
