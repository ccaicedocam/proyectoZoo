package co.edu.konrad.zoo.resources;

import co.edu.konrad.zoo.dto.lugarDTO;
import co.edu.konrad.zoo.entities.lugarEntity;
import co.edu.konrad.zoo.logic.lugarLogic;
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
 * @author Cristian
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/lugar")
public class lugarResources {
        
    @EJB
    private lugarLogic lugarLogic;

    /**
     * Metodo que obtiene todos los datos de lugar
     * @return Lista lugarCTO
     */
    @GET
    public List<lugarDTO> getlugarList(){
        List <lugarEntity> lugar = lugarLogic.obtenerLugar();
        return lugarDTO.toLugarList(lugar);
    }
    
    /**
     * Obtener lugar por su id
     * @param id
     * @return lugarEntity
     */
    @GET
    @Path("{id: \\d+}")
    public lugarDTO getlugar(@PathParam("id") Long id){
        lugarEntity lugar = lugarLogic.obtenerlugarShow(id);
        if (lugar == null){
            throw new RuntimeException("La lugar no existe");
        } 
        return new lugarDTO(lugar);
    }
    
    @POST
    public lugarDTO createlugar(lugarDTO lugarDTO){
        return new lugarDTO(lugarLogic.crearlugarShow(lugarDTO.toEntity()));
    }
    
    /**
     * Actualizar un Animal
     * @param id
     * @param lugarDTO
     * @return animalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public lugarDTO updatelugar(@PathParam("id") Long id, lugarDTO lugarDTO){
        lugarEntity lugarEntity = lugarLogic.obtenerlugarShow(id);
        if(lugarEntity == null){
            throw new RuntimeException("La lugar no existe.");
        }
        return new lugarDTO(lugarLogic.actualizarlugarShow(id, lugarDTO.toEntity()));
    }
    
    @DELETE
    @Path("{lugarId: \\d+}")
    public void deletelugar(@PathParam("lugarId") Long id){
        lugarEntity lugarEntity = lugarLogic.obtenerlugarShow(id);
        if(lugarEntity == null){
            throw new RuntimeException("La lugar no existe.");
        }
        lugarLogic.eliminarLugar(id);
    }
}
