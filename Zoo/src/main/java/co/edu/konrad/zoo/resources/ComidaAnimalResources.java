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
@Path("/comidaanimal")
public class ComidaAnimalResources {

    @EJB
    private comidaAnimalLogic comidaAnimalLogic;

    /**
     * Metodo que obtiene todos los datos de la comida del animal
     * @return Lista animalesDTO
     */
    @GET
    public List<comidaAnimalDTO> getAnimalesList(){
        List <comidaAnimalEntity> animales = comidaAnimalLogic.obtenerComidaAnimales();
        return comidaAnimalDTO.toComidaAnimalList(animales);
    }
    
    /**
     * Obtener animal por su id
     * @param id
     * @return AnimalEntity
     */
    @GET
    @Path("{id: \\d+}")
    public comidaAnimalDTO getComidaAnimal(@PathParam("id") Long id){
        comidaAnimalEntity animal = comidaAnimalLogic.obtenerComidaAnimal(id);
        if (animal == null){
            throw new RuntimeException("El animal no existe");
        } 
        return new comidaAnimalDTO(animal);
    }
    
    @POST
    public comidaAnimalDTO createAnimal(comidaAnimalDTO animalDto){
        return new comidaAnimalDTO(comidaAnimalLogic.crearComidaAnimal(animalDto.toEntity()));
    }
    
    
    /**
     * Actualizar un Animal
     * @param id
     * @param animalDto
     * @return animalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public comidaAnimalDTO updateAnimal(@PathParam("id") Long id, comidaAnimalDTO animalDto){
        comidaAnimalEntity animalEntity = comidaAnimalLogic.obtenerComidaAnimal(id);
        if(animalEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        return new comidaAnimalDTO(comidaAnimalLogic.actualizarComidaAnimal(id, animalDto.toEntity()));
    }
    
    @DELETE
    @Path("{comidaAnimalId: \\d+}")
    public void deleteAnimal(@PathParam("comidaAnimalId") Long id){
        comidaAnimalEntity animalEntity = comidaAnimalLogic.obtenerComidaAnimal(id);
        if(animalEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        comidaAnimalLogic.eliminarComida(id);
    }
}