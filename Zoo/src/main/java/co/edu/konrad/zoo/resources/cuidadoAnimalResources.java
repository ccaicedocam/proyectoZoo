/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.resources;

import co.edu.konrad.zoo.dto.cuidadoAnimalDTO;
import co.edu.konrad.zoo.entities.cuidadoAnimalEntity;
import co.edu.konrad.zoo.logic.cuidadoAnimalLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author ASUS-PC
 */
public class cuidadoAnimalResources {
        
    @EJB
    private cuidadoAnimalLogic cuidadoLogic;

    /**
     * Metodo que obtiene todos los datos de animal
     * @return Lista animalesDTO
     */
    @GET
    public List<cuidadoAnimalDTO> getProductoList(){
        List <cuidadoAnimalEntity> animales = cuidadoLogic.obtenerAnimales();
        return cuidadoAnimalDTO.toAnimalList(animales);
    }
    
    /**
     * Obtener animal por su id
     * @param id
     * @return AnimalEntity
     */
    @GET
    @Path("{id: \\d+}")
    public cuidadoAnimalDTO getAnimal(@PathParam("id") Long id){
        cuidadoAnimalEntity animal = cuidadoLogic.obtenerAnimal(id);
        if (animal == null){
            throw new RuntimeException("El animal no existe");
        } 
        return new cuidadoAnimalDTO(animal);
    }
    
    @POST
    public cuidadoAnimalDTO createAnimal(cuidadoAnimalDTO cuidadoAnimalDTO){
        return new cuidadoAnimalDTO(cuidadoLogic.crearAnimal(cuidadoAnimalDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un Animal
     * @param id
     * @param animalDto
     * @return animalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public cuidadoAnimalDTO updateAnimal(@PathParam("id") Long id, cuidadoAnimalDTO animalDto){
        cuidadoAnimalEntity animalEntity = cuidadoLogic.obtenerAnimal(id);
        if(animalEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        return new cuidadoAnimalDTO(cuidadoLogic.actualizarAnimal(id, animalDto.toEntity()));
    }
    
    @DELETE
    @Path("{animalId: \\d+}")
    public void deleteAnimal(@PathParam("animalId") Long id){
        cuidadoAnimalEntity animalEntity = cuidadoLogic.obtenerAnimal(id);
        if(animalEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        cuidadoLogic.eliminarAnimal(id);
    }
}
