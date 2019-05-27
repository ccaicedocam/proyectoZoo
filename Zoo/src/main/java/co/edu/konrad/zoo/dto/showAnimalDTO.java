/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import co.edu.konrad.zoo.entities.AnimalEntity;
import co.edu.konrad.zoo.entities.ShowAnimalEntity;
import co.edu.konrad.zoo.entities.ShowEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class showAnimalDTO {
    
    private Long showAnimal;
    private ShowEntity idShow;
    private AnimalEntity idAnimal;

    public Long getShowAnimal() {
        return showAnimal;
    }

    public void setShowAnimal(Long showAnimal) {
        this.showAnimal = showAnimal;
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
    /**
     * Conversión masiva de objeto a entidad
     * @param listaShowAnimales
     * @return 
     */
    public static List<showAnimalDTO> toShowAnimalList(List<ShowAnimalEntity> listaShowAnimales){
        List<showAnimalDTO> listaShowAnimalDTO = new ArrayList<>();
        for(ShowAnimalEntity entity : listaShowAnimales){
            listaShowAnimalDTO.add(new showAnimalDTO(entity));
        }
        return listaShowAnimalDTO;
    }
}    
