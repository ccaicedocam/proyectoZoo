/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.ratingEntity;
import co.edu.konrad.zoo.persistence.ratingPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ASUS-PC
 */
public class ratingLogic {

    @Inject
    private ratingPersistence persistence;

    public List<ratingEntity> obtenerRating() {
        List<ratingEntity> animales = persistence.encontrarTodo();
        return animales;
    }

    /**
     * Obtener Animal por su id
     *
     * @param id
     * @return AnimalEntity
     */
    public ratingEntity obtenerRating(Long id) {
        ratingEntity animal = persistence.encontrarPorId(id);
        if (animal == null) {
            throw new IllegalArgumentException("El animal solicitado NO existe");
        }
        return animal;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear un Animal
     *
     * @param crearRating
     * @return
     */
    public ratingEntity crearRating(ratingEntity crearRating) {
        persistence.insertar(crearRating);
        return crearRating;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar un Animal
     *
     * @param id
     * @param actualizarRating
     * @return animal actualizado
     */
    public ratingEntity actualizarRating(Long id, ratingEntity actualizarRating) {
        ratingEntity productoUpdate = persistence.actualizar(actualizarRating);
        return productoUpdate;
    }

    /**
     * Metodo para eliminar un objeto animal
     *
     * @param id
     */
    public void eliminarRating(Long id) {
        persistence.eliminar(id);
    }

}
