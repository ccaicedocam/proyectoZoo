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
 * @author cristian_caicedo
 */
@Entity (name = "horarioShows")
public class horarioShowsEntity implements Serializable {
    
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Hora_Shows")
    private Long idHoraShows;

    @Column (name = "disponibilidad")
    private String disponibilidad;

    @Column (name = "id_Lugar")
    private String idLugar;

    @Column (name = "id_Show")
    private String idShow;

    public horarioShowsEntity() {
    
    }

    public Long getIdHoraShows() {
        return idHoraShows;
    }

    public void setIdHoraShows(Long idHoraShows) {
        this.idHoraShows = idHoraShows;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public String getIdShow() {
        return idShow;
    }

    public void setIdShow(String idShow) {
        this.idShow = idShow;
    }
}
