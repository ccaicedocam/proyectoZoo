/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.AnimalEntity;
import co.edu.konrad.zoo.persistence.AnimalPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cristian_caicedo
 */
@Stateless
public class AnimalLogic {
    
    @Inject
    private AnimalPersistence persistence;
    
    public List<AnimalEntity> obtenerProductos(){
        List<AnimalEntity> animales = persistence.encontrarTodo();
        return animales;
    }
    
    /**
     * Obtener producto por su id
     * @param id
     * @return productoEntity
     */
    public AnimalEntity obtenerProducto(Long id){
        AnimalEntity animal = persistence.encontrarPorId(id);
        if(animal == null){
            throw new IllegalArgumentException("El animal solicitado NO existe");
        }
        return animal;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear un Producto
     * @param animalCrear
     * @return 
     */
    public AnimalEntity crearProducto(AnimalEntity animalCrear){
        persistence.insertar(animalCrear);
        return animalCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar un Producto
     * @param id
     * @param animalActualizar
     * @return animal actualizado
     */
    public AnimalEntity actualizarProducto (Long id, AnimalEntity animalActualizar){
        AnimalEntity productoUpdate = persistence.actualizar(animalActualizar);
        return productoUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto Producto
     * @param id 
     */
    public void eliminarAnimal(Long id){
        persistence.eliminar(id);
    }
    
}
