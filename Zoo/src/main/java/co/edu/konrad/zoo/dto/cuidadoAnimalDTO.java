/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import co.edu.konrad.zoo.entities.AnimalEntity;
import co.edu.konrad.zoo.entities.cuidadoAnimalEntity;
import co.edu.konrad.zoo.entities.empleadoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS-PC
 */
public class cuidadoAnimalDTO {

    private Long idCuidador;

    private AnimalEntity idAnimal;

    private empleadoEntity idEmpleado;

    public Long getIdcuidadoAnimal() {
        return idCuidador;
    }

    public void setIdcuidadoAnimal(Long idcuidadoAnimal) {
        this.idCuidador = idcuidadoAnimal;
    }

    public Long getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(Long idCuidador) {
        this.idCuidador = idCuidador;
    }

    public AnimalEntity getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(AnimalEntity idAnimal) {
        this.idAnimal = idAnimal;
    }

    public empleadoEntity getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(empleadoEntity idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

  
    public cuidadoAnimalDTO(cuidadoAnimalEntity anim) {
        this.idCuidador = anim.getIdCuidador();
        this.idAnimal = anim.getIdAnimal();
        this.idEmpleado = anim.getIdCodEmpleado();
    }

    public cuidadoAnimalEntity toEntity() {
        cuidadoAnimalEntity animal = new cuidadoAnimalEntity();
        animal.setIdCuidador(this.idCuidador);
        animal.setIdAnimal(this.idAnimal);
        animal.setIdCodEmpleado(this.idEmpleado);
        return animal;
    }

        public static List<cuidadoAnimalDTO> toAnimalList(List<cuidadoAnimalEntity> listaCiudadores){
        List<cuidadoAnimalDTO> listaAnimalesDTO = new ArrayList<>();
        for(cuidadoAnimalEntity entity : listaCiudadores){
            listaAnimalesDTO.add(new cuidadoAnimalDTO(entity));
        }
        return listaAnimalesDTO;
    }
    
}
