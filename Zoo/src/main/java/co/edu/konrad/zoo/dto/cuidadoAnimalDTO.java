/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import co.edu.konrad.zoo.entities.cuidadoAnimalEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS-PC
 */
public class cuidadoAnimalDTO {

    private Long idCuidador;

    private Long idAnimal;

    private String idEmpleado;

    public long getIdcuidadoAnimal() {
        return idCuidador;
    }

    public void setIdcuidadoAnimal(Long idcuidadoAnimal) {
        this.idCuidador = idcuidadoAnimal;
    }

    public long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }    

    public cuidadoAnimalDTO(cuidadoAnimalEntity anim) {
        this.idCuidador = anim.getIdCuidador();
        this.idAnimal = anim.getIdAnimal();
        this.idEmpleado = anim.getIdEmpleado();
    }

    public cuidadoAnimalEntity toEntity() {
        cuidadoAnimalEntity animal = new cuidadoAnimalEntity();
        animal.setIdCuidador(this.idCuidador);
        animal.setIdAnimal(this.idAnimal);
        animal.setIdEmpleado(this.idEmpleado);
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
