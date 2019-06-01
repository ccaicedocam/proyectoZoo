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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ASUS-PC
 */

@Entity
public class cuidadoAnimalEntity implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name ="id_cuidador_animal")
    private Long idCuidador;
    
    @ManyToOne
    @JoinColumn(name ="id_animal")
    private AnimalEntity idAnimal;
      
    @ManyToOne
    @JoinColumn(name ="id_cod_empleado")
    private empleadoEntity idCodEmpleado;
    
    
    public cuidadoAnimalEntity(){
        
    }

    public cuidadoAnimalEntity(Long idCuidador, AnimalEntity idAnimal, empleadoEntity idCodEmpleado) {
        this.idCuidador = idCuidador;
        this.idAnimal = idAnimal;
        this.idCodEmpleado = idCodEmpleado;
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

    public empleadoEntity getIdCodEmpleado() {
        return idCodEmpleado;
    }

    public void setIdCodEmpleado(empleadoEntity idCodEmpleado) {
        this.idCodEmpleado = idCodEmpleado;
    }

   
    
    
    
}
