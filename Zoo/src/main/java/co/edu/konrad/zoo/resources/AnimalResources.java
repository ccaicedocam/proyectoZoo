/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.resources;

import co.edu.konrad.zoo.dto.AnimalDTO;
import co.edu.konrad.zoo.entities.AnimalEntity;
import co.edu.konrad.zoo.logic.AnimalLogic;
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
@Path("/animales")
public class AnimalResources {
    
    @EJB
    private AnimalLogic animalLogic;

    /**
     * Metodo que obtiene todos los datos de animal
     * @return Lista animalesDTO
     */
    @GET
    public List<AnimalDTO> getProductoList(){
        List <AnimalEntity> animales = animalLogic.obtenerAnimales();
        return AnimalDTO.toAnimalList(animales);
    }
    
    /**
     * Obtener animal por su id
     * @param id
     * @return AnimalEntity
     */
    @GET
    @Path("{id: \\d+}")
    public AnimalDTO getAnimal(@PathParam("id") Long id){
        AnimalEntity animal = animalLogic.obtenerAnimal(id);
        if (animal == null){
            throw new RuntimeException("El animal no existe");
        } 
        return new AnimalDTO(animal);
    }
    
    @POST
    public AnimalDTO createAnimal(AnimalDTO animalDto){
        return new AnimalDTO(animalLogic.crearAnimal(animalDto.toEntity()));
    }
    
    
    /**
     * Actualizar un Animal
     * @param id
     * @param animalDto
     * @return animalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public AnimalDTO updateAnimal(@PathParam("id") Long id, AnimalDTO animalDto){
        AnimalEntity animalEntity = animalLogic.obtenerAnimal(id);
        if(animalEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        return new AnimalDTO(animalLogic.actualizarAnimal(id, animalDto.toEntity()));
    }
    
    @DELETE
    @Path("{animalId: \\d+}")
    public void deleteAnimal(@PathParam("animalId") Long id){
        AnimalEntity animalEntity = animalLogic.obtenerAnimal(id);
        if(animalEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        animalLogic.eliminarAnimal(id);
    }
}
