/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.cuidadoAnimalEntity;
import co.edu.konrad.zoo.persistence.cuidadoAnimalPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ASUS-PC
 */
@Stateless
public class cuidadoAnimalLogic {

    @Inject
    private cuidadoAnimalPersistence persistence;

    public List<cuidadoAnimalEntity> obtenerCuidador() {
        List<cuidadoAnimalEntity> cuidador = persistence.encontrarTodo();
        return cuidador;
    }

    /**
     * Obtener Animal por su id
     *
     * @param id
     * @return AnimalEntity
     */
    public cuidadoAnimalEntity obtenerCuidador(Long id) {
        cuidadoAnimalEntity animal = persistence.encontrarPorId(id);
        if (animal == null) {
            throw new IllegalArgumentException("El cuidador solicitado NO existe");
        }
        return animal;
    }

    /**
     * Metodo que conecta la logica con la transaccion para crear un Animal
     *
     * @param cuidadorCrear
     * @return
     */
    public cuidadoAnimalEntity crearCuidador(cuidadoAnimalEntity cuidadorCrear) {
        persistence.insertar(cuidadorCrear);
        return cuidadorCrear;
    }

    /**
     * Metodo que conecta la logica con la transaccion para actualizar un Animal
     *
     * @param id
     * @param actualizarCuidador
     * @return animal actualizado
     */
    public cuidadoAnimalEntity actualizarCuidador(Long id, cuidadoAnimalEntity actualizarCuidador) {
        cuidadoAnimalEntity productoUpdate = persistence.actualizar(actualizarCuidador);
        return productoUpdate;
    }

    /**
     * Metodo para eliminar un objeto animal
     *
     * @param id
     */
    public void eliminarCuidador(Long id) {
        persistence.eliminar(id);
    }
}
