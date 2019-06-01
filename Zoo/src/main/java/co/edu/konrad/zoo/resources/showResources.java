package co.edu.konrad.zoo.resources;

import co.edu.konrad.zoo.dto.showDTO;
import co.edu.konrad.zoo.entities.ShowEntity;
import co.edu.konrad.zoo.logic.ShowLogic;
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
 * @author cristian
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/show")
public class showResources {
    
    @EJB
    private ShowLogic showLogic;

    /**
     * Metodo que obtiene todos los datos de show
     * @return Lista showDTO
     */
    @GET
    public List<showDTO> getshowesList(){
        List <ShowEntity> show = showLogic.obtenershowes();
        return showDTO.toShowList(show);
    }
    
    /**
     * Obtener show por su id
     * @param id
     * @return ShowEntity
     */
    @GET
    @Path("{id: \\d+}")
    public showDTO getShow(@PathParam("id") Long id){
        ShowEntity show = showLogic.obtenershow(id);
        if (show == null){
            throw new RuntimeException("El show no existe");
        } 
        return new showDTO(show);
    }
    
    @POST
    public showDTO createShow(showDTO showDTO){
        return new showDTO(showLogic.crearshow(showDTO.toEntity()));
    }
    
    /**
     * Actualizar un show
     * @param id
     * @param showDTO
     * @return showDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public showDTO updateShow(@PathParam("id") Long id, showDTO showDTO){
        ShowEntity ShowEntity = showLogic.obtenershow(id);
        if(ShowEntity == null){
            throw new RuntimeException("El show no existe.");
        }
        return new showDTO(showLogic.actualizarShow(id, showDTO.toEntity()));
    }
    
    @DELETE
    @Path("{showId: \\d+}")
    public void deleteShow(@PathParam("showId") Long id){
        ShowEntity ShowEntity = showLogic.obtenershow(id);
        if(ShowEntity == null){
            throw new RuntimeException("El show no existe.");
        }
        showLogic.eliminarShow(id);
    }
}
