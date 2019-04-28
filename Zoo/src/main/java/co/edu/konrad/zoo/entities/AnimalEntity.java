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
 * @author Jorge
 */
@Entity (name = "Animal")
public class AnimalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_animal")
    private Long idAnimal;
    
    @Column (name = "nom_Animal")
    private String nomAnimal;
    
    @Column (name = "nom_cientifico")
    private String nomCienfitico;
    
    @Column (name = "especie")
    private String especia;
    
    @Column (name = "Tipo_animal")
    private String tipoAnimal;
    
    @Column (name = "descripcion")
    private String descripcion;

    /**
     * Constructor
     */
    public AnimalEntity() {
    }
    
    public String getNomAnimal() {
        return nomAnimal;
    }

    public void setNomAnimal(String nomAnimal) {
        this.nomAnimal = nomAnimal;
    }

    public String getNomCienfitico() {
        return nomCienfitico;
    }

    public void setNomCienfitico(String nomCienfitico) {
        this.nomCienfitico = nomCienfitico;
    }

    public String getEspecia() {
        return especia;
    }

    public void setEspecia(String especia) {
        this.especia = especia;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }
    
}
