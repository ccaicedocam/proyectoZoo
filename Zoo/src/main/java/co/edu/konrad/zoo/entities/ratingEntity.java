/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.entities;

import co.edu.konrad.zoo.entities.AnimalEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ASUS-PC
 */
public class ratingEntity implements Serializable{
    
    @Id
    @Column (name = "id_rating")
    private long idRaring;
    
    @ManyToOne
    @JoinColumn (name = "id_animal")
    private int idAnimal;
    
    @Column (name = "id_show")
    private long idShow;
    
    @Column (name = "tipo")
    private String tipo;
    
    @Column (name = "calificacion")
    private int calificacion;
    
    @Column (name = "comentario")
    private String comentario;
    
    public ratingEntity (){
        
    }

    public long getIdRaring() {
        return idRaring;
    }

    public void setIdRaring(long idRaring) {
        this.idRaring = idRaring;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public long getIdShow() {
        return idShow;
    }

    public void setIdShow(long idShow) {
        this.idShow = idShow;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}