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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jorge
 */
//@Entity (name = "Show_animal")
@Entity
public class ShowAnimalEntity implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "show_animal")
    private Long idShowAnimal;
    
    @ManyToOne
    @JoinColumn (name = "id_show")
    private ShowEntity idShow;
    
    @ManyToOne
    @JoinColumn (name = "id_animal")
    private AnimalEntity idAnimal;

    public Long getShowAnimal() {
        return idShowAnimal;
    }

    public void setShowAnimal(Long showAnimal) {
        this.idShowAnimal = showAnimal;
    }

    public Long getIdShowAnimal() {
        return idShowAnimal;
    }

    public void setIdShowAnimal(Long idShowAnimal) {
        this.idShowAnimal = idShowAnimal;
    }

    public ShowEntity getIdShow() {
        return idShow;
    }

    public void setIdShow(ShowEntity idShow) {
        this.idShow = idShow;
    }

    public AnimalEntity getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(AnimalEntity idAnimal) {
        this.idAnimal = idAnimal;
    }


}
