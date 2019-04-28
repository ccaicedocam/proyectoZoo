/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.comidaAnimalEntity;
import co.edu.konrad.zoo.persistence.comidaAnimalPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jorge
 */
@Stateless
public class comidaAnimalLogic {
    
    @Inject
    private comidaAnimalPersistence persistence;
    
    public List<comidaAnimalEntity> obtenerProductos(){
        List<comidaAnimalEntity> comidaAnimal = persistence.encontrarTodo();
        return comidaAnimal;
    }
    
    /**
     * Obtener producto por su id
     * @param id
     * @return productoEntity
     */
    public comidaAnimalEntity obtenerProducto(Long id){
        comidaAnimalEntity comidaAnimal = persistence.encontrarPorId(id);
        if(comidaAnimal == null){
            throw new IllegalArgumentException("la comida solicitado NO existe");
        }
        return comidaAnimal;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear un Producto
     * @param comidaAnimalCrear
     * @return 
     */
    public comidaAnimalEntity crearProducto(comidaAnimalEntity comidaAnimalCrear){
        persistence.insertar(comidaAnimalCrear);
        return comidaAnimalCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar un Producto
     * @param id
     * @param comidaAnimalActualizar
     * @return animal actualizado
     */
    public comidaAnimalEntity actualizarProducto (Long id, comidaAnimalEntity comidaAnimalActualizar){
        comidaAnimalEntity productoUpdate = persistence.actualizar(comidaAnimalActualizar);
        return productoUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto Animal
     * @param id 
     */
    public void elimiinarComida(Long id){
        persistence.eliminar(id);
    }
    
}
