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
    private Long idAnimal;
    
//    @Column (name ="id_empleado")
//    private String idEmpleado;
    
    @ManyToOne
    @JoinColumn(name ="id_cod_empleado")
    private Long idCodEmpleado;
    
    
    public cuidadoAnimalEntity(){
        
    }

//    public cuidadoAnimalEntity(Long idCuidador, Long idAnimal, String idEmpleado) {
//        this.idCuidador = idCuidador;
//        this.idAnimal = idAnimal;
//        this.idCodEmpleado = idCodEmpleado;
//    }

    public cuidadoAnimalEntity(Long idCuidador, Long idAnimal, Long idCodEmpleado) {
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

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

//    public String getIdEmpleado() {
//        return idEmpleado;
//    }
//
//    public void setIdEmpleado(String idEmpleado) {
//        this.idEmpleado = idEmpleado;
//    }  

    public Long getIdCodEmpleado() {
        return idCodEmpleado;
    }

    public void setIdCodEmpleado(Long idCodEmpleado) {
        this.idCodEmpleado = idCodEmpleado;
    }
    
    
    
}
