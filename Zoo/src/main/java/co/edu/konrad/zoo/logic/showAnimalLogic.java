/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.ShowAnimalEntity;
import co.edu.konrad.zoo.persistence.showAnimalPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jorge
 */
@Stateless
public class showAnimalLogic {
    
    @Inject
    private showAnimalPersistence persistence;
    
    public List<ShowAnimalEntity> obtenerProductos(){
        List<ShowAnimalEntity> showAnimal = persistence.encontrarTodo();
        return showAnimal;
    }
    
    /**
     * Obtener ShowAnimal por su id
     * @param id
     * @return showAnimalEntity
     */
    public ShowAnimalEntity obtenerProducto(Long id){
        ShowAnimalEntity showAnimal = persistence.encontrarPorId(id);
        if(showAnimal == null){
            throw new IllegalArgumentException("El showAnimal solicitado NO existe");
        }
        return showAnimal;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear un ShowAnimal
     * @param showAnimalCrear
     * @return 
     */
    public ShowAnimalEntity crearProducto(ShowAnimalEntity showAnimalCrear){
        persistence.insertar(showAnimalCrear);
        return showAnimalCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar un ShowAnimal
     * @param id
     * @param showAnimalActualizar
     * @return animal actualizado
     */
    public ShowAnimalEntity actualizarProducto (Long id, ShowAnimalEntity showAnimalActualizar){
        ShowAnimalEntity productoUpdate = persistence.actualizar(showAnimalActualizar);
        return productoUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto ShowAnimal
     * @param id 
     */
    public void eliminarShowAnimal(Long id){
        persistence.eliminar(id);
    }
}
