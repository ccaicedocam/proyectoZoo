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

/**
 *
 * @author ASUS-PC
 */
public class empleadoEntity implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id_cod_empleado")
    private Long idCodEmpleado;
    
    @Column (name ="nom_empleado")
    private String nomEmpleado;
    
    @Column (name ="cargo_empleado")
    private String cargoEmpleado;
    
    public empleadoEntity(){
        
    }

    public Long getIdCodEmpleado() {
        return idCodEmpleado;
    }

    public void setIdCodEmpleado(Long idCodEmpleado) {
        this.idCodEmpleado = idCodEmpleado;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getCargoEmpleado() {
        return cargoEmpleado;
    }

    public void setCargoEmpleado(String cargoEmpleado) {
        this.cargoEmpleado = cargoEmpleado;
    }
    
    
}
