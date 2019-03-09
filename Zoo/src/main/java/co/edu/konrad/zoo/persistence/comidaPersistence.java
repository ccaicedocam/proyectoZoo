/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.persistence;

import co.edu.konrad.zoo.entities.comidaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jorge
 */
@Stateless
public class comidaPersistence {
 @PersistenceContext (unitName = "zoopu")
    protected EntityManager ez;
    
    public List<comidaEntity> encontrarTodo(){
        Query todos = ez.createQuery("select p from comidaEntity p");
        return todos.getResultList();
    }
    
    //permite traer en productoEntity el dato de la tabla por medio del id
    public comidaEntity encontrarPorId(Long id){
      return ez.find(comidaEntity.class, id);
    }
    
    //permite insertar datos a la tabla prodcuto retornando el mismo producto
    public comidaEntity insertar(comidaEntity entity){
     ez.persist(entity);
     return entity;
    }
    
    //permite acutalizar el dato en la tabla
    public comidaEntity actualizar(comidaEntity entity){
     return ez.merge(entity);
    }
    
    public void eliminar(Long id){
      comidaEntity comidaEliminar = ez.find(comidaEntity.class, id);
      ez.remove(comidaEliminar);   
    }
}
