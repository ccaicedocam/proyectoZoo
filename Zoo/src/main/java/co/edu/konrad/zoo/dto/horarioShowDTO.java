/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;
import co.edu.konrad.zoo.entities.horarioShowsEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cristian_caicedo
 */
public class horarioShowDTO {
    private Long idHoraShows;
    private String disponibilidad;
    private String idLugar;
    private String idShow; 

    public Long getIdHoraShows() {
        return idHoraShows;
    }

    public void setIdHoraShows(Long idHoraShows) {
        this.idHoraShows = idHoraShows;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public String getIdShow() {
        return idShow;
    }

    public void setIdShow(String idShow) {
        this.idShow = idShow;
    }

    public horarioShowDTO(horarioShowsEntity hor) {
        this.idHoraShows = hor.getIdHoraShows();
        this.disponibilidad = hor.getDisponibilidad();
        this.idLugar = hor.getIdLugar();
        this.idShow = hor.getIdShow();
    }
    
    public horarioShowsEntity toEntity(){
        horarioShowsEntity horarioShowsEntity = new horarioShowsEntity();
        horarioShowsEntity.setDisponibilidad(this.disponibilidad);
        horarioShowsEntity.setIdHoraShows(this.idHoraShows);
        horarioShowsEntity.setIdLugar(this.idLugar);
        horarioShowsEntity.setIdShow(this.idShow);
        return horarioShowsEntity;
    }
    
        /**
     * Conversión masiva de objeto a entidad
     * @param listahorarioShows
     * @return 
     */
    public static List<horarioShowDTO> toShowAnimalList(List<horarioShowsEntity> listahorarioShows){
        List<horarioShowDTO> listahorarioShowDTO = new ArrayList<>();
        for(horarioShowsEntity entity : listahorarioShows){
            listahorarioShowDTO.add(new horarioShowDTO(entity));
        }
        return listahorarioShowDTO;
    }
    
}
