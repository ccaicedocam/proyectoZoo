/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.resources;

import co.edu.konrad.zoo.dto.ratingDTO;
import co.edu.konrad.zoo.entities.ratingEntity;
import co.edu.konrad.zoo.logic.ratingLogic;
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
 * @author ASUS-PC
 */
@Path("/rating")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ratingResources {

    @EJB
    private ratingLogic ratingLogic;

    /**
     * Metodo que obtiene todos los datos de la comida del animal
     *
     * @return Lista animalesDTO
     */
    @GET
    public List<ratingDTO> getAnimalesList() {
        List<ratingEntity> rating = ratingLogic.obtenerRating();
        return ratingDTO.toRatingList(rating);
    }

    /**
     * Obtener Rating por su id
     *
     * @param id
     * @return RatingEntity
     */
    @GET
    @Path("{id: \\d+}")
    public ratingDTO getComidaAnimal(@PathParam("id") Long id) {
        ratingEntity rating = ratingLogic.obtenerRating(id);
        if (rating == null) {
            throw new RuntimeException("La calificacion no existe");
        }
        return new ratingDTO(rating);
    }

    @POST
    public ratingDTO createRating(ratingDTO ratingDTO) {
        return new ratingDTO(ratingLogic.crearRating(ratingDTO.toEntity()));
    }

    /**
     * Actualizar un Rating
     *
     * @param id
     * @param ratingDTO
     * @return ratingDTO actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public ratingDTO updateAnimal(@PathParam("id") Long id, ratingDTO ratingDTO) {
        ratingEntity ratingEntity = ratingLogic.obtenerRating(id);
        if (ratingEntity == null) {
            throw new RuntimeException("La calificacion no existe.");
        }
        return new ratingDTO(ratingLogic.actualizarRating(id, ratingDTO.toEntity()));
    }

    @DELETE
    @Path("{ratingId: \\d+}")
    public void deleteAnimal(@PathParam("ratingId") Long id) {
        ratingEntity animalEntity = ratingLogic.obtenerRating(id);
        if (animalEntity == null) {
            throw new RuntimeException("La calificacion no existe.");
        }
        ratingLogic.eliminarRating(id);
    }
}
