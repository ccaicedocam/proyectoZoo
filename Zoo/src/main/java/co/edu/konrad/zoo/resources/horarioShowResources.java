package co.edu.konrad.zoo.resources;

import co.edu.konrad.zoo.dto.horarioShowDTO;
import co.edu.konrad.zoo.entities.horarioShowsEntity;
import co.edu.konrad.zoo.logic.horarioShowLogic;
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
@Path("/horarioShow")
public class horarioShowResources {
        
    @EJB
    private horarioShowLogic horarioShowLogic;

    /**
     * Metodo que obtiene todos los datos de lugar
     * @return Lista lugarCTO
     */
    @GET
    public List<horarioShowDTO> getlugarList(){
        List <horarioShowsEntity> lugar = horarioShowLogic.obtenerHorarioShow();
        return horarioShowDTO.toHoraroiShowList(lugar);
    }
    
    /**
     * Obtener lugar por su id
     * @param id
     * @return horarioShowsEntity
     */
    @GET
    @Path("{id: \\d+}")
    public horarioShowDTO getlugar(@PathParam("id") Long id){
        horarioShowsEntity lugar = horarioShowLogic.obtenerHorarioShows(id);
        if (lugar == null){
            throw new RuntimeException("La lugar no existe");
        } 
        return new horarioShowDTO(lugar);
    }
    
    @POST
    public horarioShowDTO createlugar(horarioShowDTO horarioShowDTO){
        return new horarioShowDTO(horarioShowLogic.crearHorarioShows(horarioShowDTO.toEntity()));
    }
    
    /**
     * Actualizar un Animal
     * @param id
     * @param horarioShowDTO
     * @return animalDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public horarioShowDTO updatelugar(@PathParam("id") Long id, horarioShowDTO horarioShowDTO){
        horarioShowsEntity horarioShowsEntity = horarioShowLogic.obtenerHorarioShows(id);
        if(horarioShowsEntity == null){
            throw new RuntimeException("La lugar no existe.");
        }
        return new horarioShowDTO(horarioShowLogic.actualizarhorarioShows(id, horarioShowDTO.toEntity()));
    }
    
    @DELETE
    @Path("{lugarId: \\d+}")
    public void deletelugar(@PathParam("lugarId") Long id){
        horarioShowsEntity horarioShowsEntity = horarioShowLogic.obtenerHorarioShows(id);
        if(horarioShowsEntity == null){
            throw new RuntimeException("La lugar no existe.");
        }
        horarioShowLogic.eliminarHorarioShow(id);
    }
}
