/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;
import co.edu.konrad.zoo.entities.listaEmpleados;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS-PC
 */
public class empleadoDTO {

    private Long idCodEmpleado;

    private String nomEmpleado;

    private String cargoEmpleado;

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
    
     public empleadoDTO(listaEmpleados anim) {
        this.cargoEmpleado = anim.getCargoEmpleado();
        this.idCodEmpleado = anim.getIdCodEmpleado();
        this.nomEmpleado = anim.getNomEmpleado();
    }

    public listaEmpleados toEntity() {
        listaEmpleados empleadoE = new listaEmpleados();
        empleadoE.setCargoEmpleado(this.cargoEmpleado);
        empleadoE.setIdCodEmpleado(this.idCodEmpleado);
        empleadoE.setNomEmpleado(this.nomEmpleado);
        return empleadoE;
    }
    
      public static List<empleadoDTO> toAnimalList(List<listaEmpleados> listaAnimales){
        List<empleadoDTO> listaAnimalesDTO = new ArrayList<>();
        for(listaEmpleados entity : listaAnimales){
            listaAnimalesDTO.add(new empleadoDTO(entity));
        }
        return listaAnimalesDTO;
    }

}