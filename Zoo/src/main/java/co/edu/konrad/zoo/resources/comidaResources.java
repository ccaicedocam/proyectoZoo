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
@Path("/comida")
public class comidaResources {
        
    @EJB
    private comidaLogic comidaLogic;

    /**
     * Metodo que obtiene todos los datos de animal
     * @return Lista animalesDTO
     */
    @GET
    public List<comidaDTO> getAnimalesList(){
        List <comidaEntity> animales = comidaLogic.obtenerComidas();
        return comidaDTO.toAnimalList(animales);
    }
    
    /**
     * Obtener animal por su id
     * @param id
     * @return AnimalEntity
     */
    @GET
    @Path("{id: \\d+}")
    public comidaDTO getAnimal(@PathParam("id") Long id){
        comidaEntity animal = comidaLogic.obtenerComida(id);
        if (animal == null){
            throw new RuntimeException("El animal no existe");
        } 
        return new comidaDTO(animal);
    }
    
    @POST
    public comidaDTO createAnimal(comidaDTO animalDto){
        return new comidaDTO(comidaLogic.crearComida(animalDto.toEntity()));
    }
    
    /**
     * Actualizar un Animal
     * @param id
     * @param animalDto
     * @return animalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public comidaDTO updateAnimal(@PathParam("id") Long id, comidaDTO animalDto){
        comidaEntity animalEntity = comidaLogic.obtenerComida(id);
        if(animalEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        return new comidaDTO(comidaLogic.actualizarComida(id, animalDto.toEntity()));
    }
    
    @DELETE
    @Path("{animalId: \\d+}")
    public void deleteAnimal(@PathParam("animalId") Long id){
        comidaEntity animalEntity = comidaLogic.obtenerComida(id);
        if(animalEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        comidaLogic.eliminarComida(id);
    }
}
