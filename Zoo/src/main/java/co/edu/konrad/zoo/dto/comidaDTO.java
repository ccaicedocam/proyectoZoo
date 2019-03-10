/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import co.edu.konrad.zoo.entities.comidaEntity;

/**
 *
 * @author jorge
 */
public class comidaDTO {
    
    private Long idComida;
    
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

    public comidaDTO(comidaEntity comi) {
        this.idComida = comi.getIdComida();
        this.nomComida = comi.getNomComida();
    }
    
    public comidaEntity toEntity(){
        comidaEntity comidaentity = new comidaEntity();
        comidaentity.setIdComida(this.idComida);
        comidaentity.setNomComida(this.nomComida);
        return comidaentity;
    }
}
