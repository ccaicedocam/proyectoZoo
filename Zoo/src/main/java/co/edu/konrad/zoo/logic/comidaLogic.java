/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.comidaEntity;
import co.edu.konrad.zoo.persistence.comidaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jorge
 */
@Stateless
public class comidaLogic {
    
    @Inject
    private comidaPersistence persistence;
    
    public List<comidaEntity> obtenerComidas(){
        List<comidaEntity> comida = persistence.encontrarTodo();
        return comida;
    }
    
    /**
     * Obtener comida por su id
     * @param id
     * @return comidaEntity
     */
    public comidaEntity obtenerComida(Long id){
        comidaEntity comida = persistence.encontrarPorId(id);
        if(comida == null){
            throw new IllegalArgumentException("La comida solicitado NO existe");
        }
        return comida;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear una comida
     * @param comidaCrear
     * @return 
     */
    public comidaEntity crearComida(comidaEntity comidaCrear){
        persistence.insertar(comidaCrear);
        return comidaCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar una comida
     * @param id
     * @param comidaActualizar
     * @return comida actualizado
     */
    public comidaEntity actualizarComida (Long id, comidaEntity comidaActualizar){
        comidaEntity entity = persistence.actualizar(comidaActualizar);
        return entity;
    }
    
    /**
     * Metodo para eliminar un objeto Comida
     * @param id 
     */
    public void eliminarComida(Long id){
        persistence.eliminar(id);
    }
}
