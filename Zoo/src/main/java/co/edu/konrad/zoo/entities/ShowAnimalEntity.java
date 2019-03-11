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
@Entity (name = "Show_animal")
public class ShowAnimalEntity implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "show_animal")
    private Long idShowAnimal;
    
    @ManyToOne
    @JoinColumn (name = "id_show")
    private Long idShow;
    
    @ManyToOne
    @JoinColumn (name = "id_animal")
    private Long idAnimal;

    public Long getShowAnimal() {
        return idShowAnimal;
    }

    public void setShowAnimal(Long showAnimal) {
        this.idShowAnimal = showAnimal;
    }

    public Long getIdShow() {
        return idShow;
    }

    public void setIdShow(Long idShow) {
        this.idShow = idShow;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }
}
