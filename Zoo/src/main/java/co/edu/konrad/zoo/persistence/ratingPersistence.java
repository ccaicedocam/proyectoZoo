/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.persistence;

import co.edu.konrad.zoo.entities.ratingEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ASUS-PC
 */
@Stateless
public class ratingPersistence {
       @PersistenceContext (unitName = "zoopu")
    protected EntityManager ez;
    
    public List<ratingEntity> encontrarTodo(){
        Query todos = ez.createQuery("select p from ratingEntity p");
        return todos.getResultList();
    }
    
    //permite traer en productoEntity el dato de la tabla por medio del id
    public ratingEntity encontrarPorId(Long id){
      return ez.find(ratingEntity.class, id);
    }
    
    //permite insertar datos a la tabla prodcuto retornando el mismo producto
    public ratingEntity insertar(ratingEntity entity){
     ez.persist(entity);
     return entity;
    }
    
    //permite acutalizar el dato en la tabla
    public ratingEntity actualizar(ratingEntity entity){
     return ez.merge(entity);
    }
    
    public void eliminar(Long id){
      ratingEntity ratingEliminar = ez.find(ratingEntity.class, id);
      ez.remove(ratingEliminar);   
    } 
    
    
}
