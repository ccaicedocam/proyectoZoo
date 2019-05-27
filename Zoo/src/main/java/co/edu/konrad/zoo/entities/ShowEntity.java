/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author jorge
 */
//@Entity (name = "Show")
@Entity
public class ShowEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_show")
    private Long idShow;
    
    @Column (name = "Idnombre")
    private String Idnombre;
    
    @Column (name = "Idhora")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Idhora;
    
    @ManyToOne
    @JoinColumn(name ="id_cod_empleado")
    private empleadoEntity idCodEmpleado;

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

    public Date getIdhora() {
        return Idhora;
    }

    public void setIdhora(Date Idhora) {
        this.Idhora = Idhora;
    }

    public empleadoEntity getIdCodEmpleado() {
        return idCodEmpleado;
    }

    public void setIdCodEmpleado(empleadoEntity idCodEmpleado) {
        this.idCodEmpleado = idCodEmpleado;
    }





    public Long getIdShow() {
        return idShow;
    }

    public void setIdShow(Long idShow) {
        this.idShow = idShow;
    }
    
}
