/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import co.edu.konrad.zoo.entities.ratingEntity;

/**
 *
 * @author ASUS-PC
 */
public class ratingDTO {

    private long idRaring;

    private int idAnimal;

    private long idShow;

    private String tipo;

    private int calificacion;

    private String comentario;

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

    public ratingDTO(ratingEntity anim) {

        this.idRaring = anim.getIdRaring();
        this.calificacion = anim.getCalificacion();
        this.comentario = anim.getComentario();
        this.idAnimal = anim.getIdAnimal();
        this.idShow = anim.getIdShow();
        this.tipo = anim.getTipo();

    }

    public ratingEntity toEntity() {
        ratingEntity rating = new ratingEntity();
        rating.setCalificacion(this.calificacion);
        rating.setComentario(this.comentario);
        rating.setIdAnimal(this.idAnimal);
        rating.setIdRaring(this.idRaring);
        rating.setIdShow(this.idShow);
        rating.setTipo(this.tipo);
        return rating;
    }

}
