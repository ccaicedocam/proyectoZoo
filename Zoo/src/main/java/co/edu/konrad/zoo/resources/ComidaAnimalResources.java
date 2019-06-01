/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.resources;

import co.edu.konrad.zoo.dto.comidaAnimalDTO;
import co.edu.konrad.zoo.entities.comidaAnimalEntity;
import co.edu.konrad.zoo.logic.comidaAnimalLogic;
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
@Path("/comidaAnimal")
public class ComidaAnimalResources {

    @EJB
    private comidaAnimalLogic comidaAnimalLogic;

    /**
     * Metodo que obtiene todos los datos de la comida del animal
     * @return Lista animalesDTO
     */
    @GET
    public List<comidaAnimalDTO> getComidasAnimalList(){
        List <comidaAnimalEntity> comidaAnimal = comidaAnimalLogic.obtenerComidaAnimales();
        return comidaAnimalDTO.toComidaAnimalList(comidaAnimal);
    }
    
    /**
     * Obtener comidaAnimal por su id
     * @param id
     * @return comidaAnimalEntity
     */
    @GET
    @Path("{id: \\d+}")
    public comidaAnimalDTO getComidaAnimal(@PathParam("id") Long id){
        comidaAnimalEntity comidaAnimal = comidaAnimalLogic.obtenerComidaAnimal(id);
        if (comidaAnimal == null){
            throw new RuntimeException("La comidaAnimal no existe");
        } 
        return new comidaAnimalDTO(comidaAnimal);
    }
    
    @POST
    public comidaAnimalDTO createComidaAnimal(comidaAnimalDTO comidaAnimalDTO){
        return new comidaAnimalDTO(comidaAnimalLogic.crearComidaAnimal(comidaAnimalDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un comidaAnimal
     * @param id
     * @param comidaAnimalDTO
     * @return animalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public comidaAnimalDTO updateComidaAnimal(@PathParam("id") Long id, comidaAnimalDTO comidaAnimalDTO){
        comidaAnimalEntity comidaAnimalEntity = comidaAnimalLogic.obtenerComidaAnimal(id);
        if(comidaAnimalEntity == null){
            throw new RuntimeException("La comidaAnimal no existe.");
        }
        return new comidaAnimalDTO(comidaAnimalLogic.actualizarComidaAnimal(id, comidaAnimalDTO.toEntity()));
    }
    
    @DELETE
    @Path("{comidaAnimalId: \\d+}")
    public void deleteComidaAnimal(@PathParam("comidaAnimalId") Long id){
        comidaAnimalEntity comidaAnimalEntity = comidaAnimalLogic.obtenerComidaAnimal(id);
        if(comidaAnimalEntity == null){
            throw new RuntimeException("La comidaAnimal no existe.");
        }
        comidaAnimalLogic.eliminarComida(id);
    }
}