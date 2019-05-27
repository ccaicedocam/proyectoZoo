/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.horarioShowsEntity;
import co.edu.konrad.zoo.persistence.horarioShowsPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Cristian
 */
@Stateless
public class horarioShowLogic {

    @Inject
    private horarioShowsPersistence persistence;

    public List<horarioShowsEntity> obtenerHorarioShow() {
        List<horarioShowsEntity> horarioShows = persistence.encontrarTodo();
        return horarioShows;
    }

    /**
     * Obtener horarioShows por su id
     *
     * @param id
     * @return horarioShowsEntity
     */
    public horarioShowsEntity obtenerHorarioShows(Long id) {
        horarioShowsEntity horarioShows = persistence.encontrarPorId(id);
        if (horarioShows == null) {
            throw new IllegalArgumentException("El horario Shows solicitado NO existe");
        }
        return horarioShows;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear un horario
     * Shows
     *
     * @param horarioShowsCrear
     * @return
     */
    public horarioShowsEntity crearHorarioShows(horarioShowsEntity horarioShowsCrear) {
        persistence.insertar(horarioShowsCrear);
        return horarioShowsCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar un
     * Producto
     *
     * @param id
     * @param horarioShowsActualizar
     * @return horario Shows actualizado
     */
    public horarioShowsEntity actualizarhorarioShows(Long id, horarioShowsEntity horarioShowsActualizar) {
        horarioShowsEntity productoUpdate = persistence.actualizar(horarioShowsActualizar);
        return productoUpdate;
    }

    /**
     * Metodo para eliminar un objeto horario Shows
     *
     * @param id
     */
    public void eliminarHorarioShow(Long id) {
        persistence.eliminar(id);
    }

}
