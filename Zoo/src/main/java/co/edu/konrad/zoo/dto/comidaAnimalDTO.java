/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import co.edu.konrad.zoo.entities.AnimalEntity;
import co.edu.konrad.zoo.entities.comidaAnimalEntity;
import co.edu.konrad.zoo.entities.comidaEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorge
 */
public class comidaAnimalDTO {
    
    private Long idComidaAnimal;
    
    private AnimalEntity idAnimal;
    
    private Date horaComida;
    
    private comidaEntity idComida;

    public comidaAnimalDTO() {
    }
    
    public Long getIdComidaAnimal() {
        return idComidaAnimal;
    }

    public void setIdComidaAnimal(Long idComidaAnimal) {
        this.idComidaAnimal = idComidaAnimal;
    }

    public AnimalEntity getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(AnimalEntity idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Date getHoraComida() {
        return horaComida;
    }

    public void setHoraComida(Date horaComida) {
        this.horaComida = horaComida;
    }

    public comidaEntity getIdComida() {
        return idComida;
    }

    public void setIdComida(comidaEntity idComida) {
        this.idComida = idComida;
    }

    public comidaAnimalDTO(comidaAnimalEntity comi) {
        this.horaComida = comi.getHoraComida();
        this.idAnimal = comi.getIdAnimal();
        this.idComida = comi.getIdComida();
        this.idComidaAnimal = comi.getIdComidaAnimal();
    }
    
    public comidaAnimalEntity toEntity(){
        comidaAnimalEntity comidaanimalEntity = new comidaAnimalEntity();
        comidaanimalEntity.setHoraComida(this.horaComida);
        comidaanimalEntity.setIdAnimal(this.idAnimal);
        comidaanimalEntity.setIdComida(this.idComida);
        comidaanimalEntity.setIdComidaAnimal(this.idComidaAnimal);
        return comidaanimalEntity;
    }
    /**
     * Conversión masiva de objeto a entidad
     * @param listaComidaAnimales
     * @return 
     */
    public static List<comidaAnimalDTO> toComidaAnimalList(List<comidaAnimalEntity> listaComidaAnimales){
        List<comidaAnimalDTO> listacomidaAnimalesDTO = new ArrayList<>();
        for(comidaAnimalEntity entity : listaComidaAnimales){
            listacomidaAnimalesDTO.add(new comidaAnimalDTO(entity));
        }
        return listacomidaAnimalesDTO;
    }
}
