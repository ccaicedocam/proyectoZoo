/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.dto;
import co.edu.konrad.zoo.entities.lugarEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cristian_caicedo
 */
public class lugarDTO {
    private Long idLugar;
    private String nombre;

    public Long getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(Long idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public lugarDTO(lugarEntity lug) {
        this.idLugar = lug.getIdLugar();
        this.nombre = lug.getNombre();
    }
    
    public lugarEntity toEntity(){
        lugarEntity lugarEntity = new lugarEntity();
        lugarEntity.setIdLugar(this.idLugar);
        lugarEntity.setNombre(this.nombre);
        return lugarEntity;
    }
    
        /**
     * Conversión masiva de objeto a entidad
     * @param listaLugar
     * @return 
     */
    public static List<lugarDTO> toLugarList(List<lugarEntity> listaLugar){
        List<lugarDTO> listaLugarShowDTO = new ArrayList<>();
        for(lugarEntity entity : listaLugar){
            listaLugarShowDTO.add(new lugarDTO(entity));
        }
        return listaLugarShowDTO;
    }
    
}
