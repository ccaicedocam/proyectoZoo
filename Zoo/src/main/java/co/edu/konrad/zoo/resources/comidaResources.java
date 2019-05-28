/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.resources;

import co.edu.konrad.zoo.dto.comidaDTO;
import co.edu.konrad.zoo.entities.comidaEntity;
import co.edu.konrad.zoo.logic.comidaLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jorge
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("comida")
public class comidaResources {
        
    @EJB
    private comidaLogic comidaLogic;

    /**
     * Metodo que obtiene todos los datos de comida
     * @return Lista comidaCTO
     */
    @GET
    public List<comidaDTO> getComidaList(){
        List <comidaEntity> comida = comidaLogic.obtenerComidas();
        return comidaDTO.toAnimalList(comida);
    }
    
    /**
     * Obtener comida por su id
     * @param id
     * @return comidaEntity
     */
    @GET
    @Path("{id: \\d+}")
    public comidaDTO getComida(@PathParam("id") Long id){
        comidaEntity comida = comidaLogic.obtenerComida(id);
        if (comida == null){
            throw new RuntimeException("La comida no existe");
        } 
        return new comidaDTO(comida);
    }
    
    @POST
    public comidaDTO createComida(comidaDTO comidaDTO){
        return new comidaDTO(comidaLogic.crearComida(comidaDTO.toEntity()));
    }
    
    /**
     * Actualizar un Animal
     * @param id
     * @param comidaDto
     * @return animalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public comidaDTO updateComida(@PathParam("id") Long id, comidaDTO comidaDto){
        comidaEntity comidaEntity = comidaLogic.obtenerComida(id);
        if(comidaEntity == null){
            throw new RuntimeException("La comida no existe.");
        }
        return new comidaDTO(comidaLogic.actualizarComida(id, comidaDto.toEntity()));
    }
    
    @DELETE
    @Path("{comidaId: \\d+}")
    public void deleteComida(@PathParam("comidaId") Long id){
        comidaEntity comidaEntity = comidaLogic.obtenerComida(id);
        if(comidaEntity == null){
            throw new RuntimeException("La comida no existe.");
        }
        comidaLogic.eliminarComida(id);
    }
}
