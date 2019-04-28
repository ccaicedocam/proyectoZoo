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
     * @return Lista cuidadorDOT
     */
    @GET
    public List<cuidadoAnimalDTO> getProductoList(){
        List <cuidadoAnimalEntity> cuidador = cuidadoLogic.obtenerCuidador();
        return cuidadoAnimalDTO.toAnimalList(cuidador);
    }
    
    /**
     * Obtener animal por su id
     * @param id
     * @return AnimalEntity
     */
    @GET
    @Path("{id: \\d+}")
    public cuidadoAnimalDTO getAnimal(@PathParam("id") Long id){
        cuidadoAnimalEntity animal = cuidadoLogic.obtenerCuidador(id);
        if (animal == null){
            throw new RuntimeException("El ciudador no existe");
        } 
        return new cuidadoAnimalDTO(animal);
    }
    
    @POST
    public cuidadoAnimalDTO createAnimal(cuidadoAnimalDTO cuidadoAnimalDTO){
        return new cuidadoAnimalDTO(cuidadoLogic.crearCuidador(cuidadoAnimalDTO.toEntity()));
    }
    
    
    /**
     * Actualizar un Cuidador
     * @param id
     * @param cuidadorDto
     * @return cuidadorDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public cuidadoAnimalDTO updateAnimal(@PathParam("id") Long id, cuidadoAnimalDTO cuidadorDto){
        cuidadoAnimalEntity animalEntity = cuidadoLogic.obtenerCuidador(id);
        if(animalEntity == null){
            throw new RuntimeException("El ciudador no existe.");
        }
        return new cuidadoAnimalDTO(cuidadoLogic.actualizarCuidador(id, cuidadorDto.toEntity()));
    }
    
    @DELETE
    @Path("{cuidadorId: \\d+}")
    public void deleteAnimal(@PathParam("cuidadorId") Long id){
        cuidadoAnimalEntity animalEntity = cuidadoLogic.obtenerCuidador(id);
        if(animalEntity == null){
            throw new RuntimeException("El ciudador no existe.");
        }
        cuidadoLogic.eliminarCuidador(id);
    }
}
