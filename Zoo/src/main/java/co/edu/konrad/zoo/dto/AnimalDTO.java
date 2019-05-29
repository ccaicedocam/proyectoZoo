/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import co.edu.konrad.zoo.entities.AnimalEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jorge
 */
public class AnimalDTO {
    
    private Long idAnimal;
    private String nomAnimal;
    private String nomCientifico;
    private String especie;
    private String tipoAnimal;
    private String descripcion;

    public AnimalDTO() {
    }
    
    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomAnimal() {
        return nomAnimal;
    }

    public void setNomAnimal(String nomAnimal) {
        this.nomAnimal = nomAnimal;
    }

    public String getNomCienfitico() {
        return nomCientifico;
    }

    public void setNomCienfitico(String nomCienfitico) {
        this.nomCientifico = nomCienfitico;
    }

    public String getEspecia() {
        return especie;
    }

    public void setEspecia(String especia) {
        this.especie = especia;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public AnimalDTO(AnimalEntity anim){
        this.idAnimal = anim.getIdAnimal();
        this.especie = anim.getEspecie();
        this.nomAnimal = anim.getNomAnimal();
        this.nomCientifico = anim.getNomCientifico();
        this.tipoAnimal = anim.getTipoAnimal();
        this.descripcion = anim.getDescripcion();        
    }
    
    public AnimalEntity toEntity(){
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setDescripcion(this.descripcion);
        animalEntity.setEspecie(this.especie);
        animalEntity.setIdAnimal(this.idAnimal);
        animalEntity.setNomAnimal(this.nomAnimal);
        animalEntity.setNomCientifico(this.nomCientifico);
        animalEntity.setTipoAnimal(this.tipoAnimal);
        return animalEntity;
    }
    
    /**
     * Conversión masiva de objeto a entidad
     * @param listaAnimales
     * @return 
     */
    public static List<AnimalDTO> toAnimalList(List<AnimalEntity> listaAnimales){
        List<AnimalDTO> listaAnimalesDTO = new ArrayList<>();
        for(AnimalEntity entity : listaAnimales){
            listaAnimalesDTO.add(new AnimalDTO(entity));
        }
        return listaAnimalesDTO;
    }    
}
