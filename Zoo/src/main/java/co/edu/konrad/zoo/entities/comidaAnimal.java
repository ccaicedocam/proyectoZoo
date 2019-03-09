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

/**
 *
 * @author jorge
 */
@Entity
public class comidaAnimal implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id_com_animal")
    private Long idComidaAnimal;
    
    @ManyToOne
    @JoinColumn (name = "id_animal")
    private AnimalEntity idAnimal;
    
    @Column (name = "hora_comida")
    private Date horaComida;
    
    @ManyToOne
    @JoinColumn (name = "id_comida")
    private comida idComida;

    public Long getIdComidaAnimal() {
        return idComidaAnimal;
    }

    public void setIdComidaAnimal(Long idComidaAnimal) {
        this.idComidaAnimal = idComidaAnimal;
    }

    public AnimalEntity getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(AnimalEntity idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Date getHoraComida() {
        return horaComida;
    }

    public void setHoraComida(Date horaComida) {
        this.horaComida = horaComida;
    }

    public comida getIdComida() {
        return idComida;
    }

    public void setIdComida(comida idComida) {
        this.idComida = idComida;
    }
    
}
