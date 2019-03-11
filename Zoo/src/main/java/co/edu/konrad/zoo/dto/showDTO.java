/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import javax.persistence.Column;
import co.edu.konrad.zoo.entities.ShowEntity;

/**
 *
 * @author cristian_caicedo
 */
public class showDTO {
    private Long idShow;
    private String Idnombre;
    private String Idhora;
    private String IdEmpleado;

    public Long getIdShow() {
        return idShow;
    }

    public void setIdShow(Long idShow) {
        this.idShow = idShow;
    }

    public String getIdnombre() {
        return Idnombre;
    }

    public void setIdnombre(String Idnombre) {
        this.Idnombre = Idnombre;
    }

    public String getIdhora() {
        return Idhora;
    }

    public void setIdhora(String Idhora) {
        this.Idhora = Idhora;
    }

    public String getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(String IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public showDTO(ShowEntity sho) {
        this.idShow = sho.getIdShow();
        this.Idnombre = sho.getIdnombre();
        this.Idhora = sho.getIdhora();
        this.IdEmpleado = sho.getIdEmpleado();
    }
    
        public ShowEntity toEntity(){
        ShowEntity showentity = new ShowEntity();
        showentity.setIdShow(idShow);
        showentity.setIdnombre(Idnombre);
        showentity.setIdhora(Idhora);
        showentity.setIdEmpleado(IdEmpleado);
        return showentity;
    }   
}
