/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.resources;

import co.edu.konrad.zoo.dto.showAnimalDTO;
import co.edu.konrad.zoo.entities.ShowAnimalEntity;
import co.edu.konrad.zoo.logic.showAnimalLogic;
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
@Path("/showAnimales")
public class showAnimalResources {
        
    @EJB
    private showAnimalLogic showAnimalLogic;

    /**
     * Metodo que obtiene todos los datos de show animal
     * @return Lista animalesDTO
     */
    @GET
    public List<showAnimalDTO> getShowAnimalesList(){
        List <ShowAnimalEntity> showsAnimales = showAnimalLogic.obtenerShowsAnimal();
        return showAnimalDTO.toShowAnimalList(showsAnimales);
    }
    
    /**
     * Obtener showAnimal por su id
     * @param id
     * @return showAnimalEntity
     */
    @GET
    @Path("{id: \\d+}")
    public showAnimalDTO getShowAnimal(@PathParam("id") Long id){
        ShowAnimalEntity showAnimal = showAnimalLogic.obtenerShowAnimal(id);
        if (showAnimal == null){
            throw new RuntimeException("El show animal no existe");
        } 
        return new showAnimalDTO(showAnimal);
    }
    
    @POST
    public showAnimalDTO createShowAnimal(showAnimalDTO animalDto){
        return new showAnimalDTO(showAnimalLogic.crearShowAnimal(animalDto.toEntity()));
    }
    
    /**
     * Actualizar un showAnimal
     * @param id
     * @param showAnimalDto
     * @return showAnimalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public showAnimalDTO updateShowAnimal(@PathParam("id") Long id, showAnimalDTO showAnimalDto){
        ShowAnimalEntity showAnimalEntity = showAnimalLogic.obtenerShowAnimal(id);
        if(showAnimalEntity == null){
            throw new RuntimeException("El show animal no existe.");
        }
        return new showAnimalDTO(showAnimalLogic.actualizarShowAnimal(id, showAnimalDto.toEntity()));
    }
    
    @DELETE
    @Path("{showAnimalId: \\d+}")
    public void deleteShowAnimal(@PathParam("showAnimalId") Long id){
        ShowAnimalEntity showAnimalEntity = showAnimalLogic.obtenerShowAnimal(id);
        if(showAnimalEntity == null){
            throw new RuntimeException("El show Animal no existe.");
        }
        showAnimalLogic.eliminarShowAnimal(id);
    }
}
