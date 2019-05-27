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
 * @author cristian_caicedo
 */
@Entity
public class horarioShowsEntity implements Serializable {
    
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Hora_Shows")
    private Long idHoraShows;

    @Column (name = "disponibilidad")
    private boolean disponibilidad;

    @ManyToOne
    @JoinColumn (name = "id_Lugar")
    private lugarEntity idLugar;
   
    @ManyToOne
    @JoinColumn (name = "id_show")
    private ShowEntity idShow;

    public horarioShowsEntity() {
    
    }

    public Long getIdHoraShows() {
        return idHoraShows;
    }

    public void setIdHoraShows(Long idHoraShows) {
        this.idHoraShows = idHoraShows;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }



    public lugarEntity getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(lugarEntity idLugar) {
        this.idLugar = idLugar;
    }

    public ShowEntity getIdShow() {
        return idShow;
    }

    public void setIdShow(ShowEntity idShow) {
        this.idShow = idShow;
    }


}
