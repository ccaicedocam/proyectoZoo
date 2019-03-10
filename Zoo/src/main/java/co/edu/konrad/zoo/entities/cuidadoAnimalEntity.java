/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ASUS-PC
 */
public class cuidadoAnimalEntity implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name ="id_cuidador_animal")
    private long idCuidador;
    
    @ManyToOne
    @JoinColumn(name ="id_animal")
    private AnimalEntity idAnimal;
    
    @Column (name ="id_empleado")
    private String idEmpleado;
    
    private cuidadoAnimalEntity(){
        
    }
    public long getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(long idCuidador) {
        this.idCuidador = idCuidador;
    }

    public AnimalEntity getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(AnimalEntity idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
}
