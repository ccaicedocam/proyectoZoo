/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;

import co.edu.konrad.zoo.entities.ShowEntity;
import co.edu.konrad.zoo.entities.empleadoEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author cristian_caicedo
 */
public class showDTO {
    private Long idShow;
    private String Idnombre;
    private Date Idhora;
    private empleadoEntity IdEmpleado;

    public Long getIdShow() {
        return idShow;
    }

    public void setIdShow(Long idShow) {
        this.idShow = idShow;
    }

    public String getIdnombre() {
        return Idnombre;
    }

    public void setIdnombre(String Idnombre) {
        this.Idnombre = Idnombre;
    }

    public Date getIdhora() {
        return Idhora;
    }

    public void setIdhora(Date Idhora) {
        this.Idhora = Idhora;
    }

    public empleadoEntity getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(empleadoEntity IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public showDTO(ShowEntity sho) {
        this.idShow = sho.getIdShow();
        this.Idnombre = sho.getIdnombre();
        this.Idhora = sho.getIdhora();
        this.IdEmpleado = sho.getIdCodEmpleado();
    }
    
        public ShowEntity toEntity(){
        ShowEntity showentity = new ShowEntity();
        showentity.setIdShow(idShow);
        showentity.setIdnombre(Idnombre);
        showentity.setIdhora(Idhora);
        showentity.setIdCodEmpleado(IdEmpleado);
        return showentity;
    }   
        
    	    /**
     * Conversión masiva de objeto a entidad
     * @param listaShow
     * @return 
     */
    public static List<showDTO> toShowList(List<ShowEntity> listaShow){
        List<showDTO> listaShowDTO = new ArrayList<>();
        for(ShowEntity entity : listaShow){
            listaShowDTO.add(new showDTO(entity));
        }
        return listaShowDTO;
    }  
}
