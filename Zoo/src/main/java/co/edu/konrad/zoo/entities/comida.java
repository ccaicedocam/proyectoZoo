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

@Entity
public class comida implements Serializable{
 
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id_comida")
    private Long idComida;
    
    @Column (name = "nom_comida")
    private String nomComida;

    public Long getIdComida() {
        return idComida;
    }

    public void setIdComida(Long idComida) {
        this.idComida = idComida;
    }

    public String getNomComida() {
        return nomComida;
    }

    public void setNomComida(String nomComida) {
        this.nomComida = nomComida;
    }
}
