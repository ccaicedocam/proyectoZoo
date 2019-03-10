/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import co.edu.konrad.zoo.entities.AnimalEntity;
/**
 *
 * @author cristian_caicedo
 */
public class AnimalDTO {
    
    private Long idAnimal;
    
    private String nomAnimal;
    
    private String nomCienfitico;
    
    private String especia;
    
    private String tipoAnimal;
    
    private String descripcion;

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
        return nomCienfitico;
    }

    public void setNomCienfitico(String nomCienfitico) {
        this.nomCienfitico = nomCienfitico;
    }

    public String getEspecia() {
        return especia;
    }

    public void setEspecia(String especia) {
        this.especia = especia;
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
        this.especia = anim.getEspecia();
        this.nomAnimal = anim.getNomAnimal();
        this.nomCienfitico = anim.getNomCienfitico();
        this.tipoAnimal = anim.getTipoAnimal();
        this.descripcion = anim.getDescripcion();        
    }
    
    public AnimalEntity toEntity(){
        AnimalEntity animalEntity = new AnimalEntity();
        animalEntity.setDescripcion(this.descripcion);
        animalEntity.setEspecia(this.especia);
        animalEntity.setIdAnimal(this.idAnimal);
        animalEntity.setNomAnimal(this.nomAnimal);
        animalEntity.setNomCienfitico(this.nomCienfitico);
        animalEntity.setTipoAnimal(this.tipoAnimal);
        return animalEntity;
    }
}
