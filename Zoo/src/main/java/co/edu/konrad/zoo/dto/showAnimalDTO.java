/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import co.edu.konrad.zoo.entities.ShowAnimalEntity;

/**
 *
 * @author jorge
 */
public class showAnimalDTO {
    
    private Long showAnimal;
    private Long idShow;
    private Long idAnimal;

    public Long getShowAnimal() {
        return showAnimal;
    }

    public void setShowAnimal(Long showAnimal) {
        this.showAnimal = showAnimal;
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

    public showAnimalDTO(ShowAnimalEntity sho) {
        this.idAnimal = sho.getIdAnimal();
        this.idShow = sho.getIdShow();
        this.showAnimal = sho.getShowAnimal();
    }
    
    public ShowAnimalEntity toEntity(){
        ShowAnimalEntity showAnimalEntity = new ShowAnimalEntity();
        showAnimalEntity.setIdAnimal(this.idAnimal);
        showAnimalEntity.setIdShow(this.idShow);
        showAnimalEntity.setShowAnimal(this.showAnimal);
        return showAnimalEntity;
    }
}    
