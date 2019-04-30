/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.lugarEntity;
import co.edu.konrad.zoo.persistence.lugarPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Cristian
 */
@Stateless
public class lugarLogic {
    
    @Inject
    private lugarPersistence persistence;
    
    public List<lugarEntity> obtenerLugar(){
        List<lugarEntity> lugarShow = persistence.encontrarTodo();
        return lugarShow;
    }
    
    /**
     * Obtener lugarShow por su id
     * @param id
     * @return lugarEntity
     */
    public lugarEntity obtenerlugarShow(Long id){
        lugarEntity lugarShow = persistence.encontrarPorId(id);
        if(lugarShow == null){
            throw new IllegalArgumentException("la lugar solicitado NO existe");
        }
        return lugarShow;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear un lugar
     * @param lugarShowCrear
     * @return 
     */
    public lugarEntity crearlugarShow(lugarEntity lugarShowCrear){
        persistence.insertar(lugarShowCrear);
        return lugarShowCrear;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar un Producto
     * @param id
     * @param lugarShowActualizar
     * @return animal actualizado
     */
    public lugarEntity actualizarlugarShow (Long id, lugarEntity lugarShowActualizar){
        lugarEntity productoUpdate = persistence.actualizar(lugarShowActualizar);
        return productoUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto Animal
     * @param id 
     */
    public void eliminarLugar(Long id){
        persistence.eliminar(id);
    }
    
}