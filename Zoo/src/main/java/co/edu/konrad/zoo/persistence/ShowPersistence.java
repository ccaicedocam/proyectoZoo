/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.persistence;

import co.edu.konrad.zoo.entities.ShowEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cristian Caicedo
 */
@Stateless
public class ShowPersistence {
 @PersistenceContext (unitName = "zoopu")
    protected EntityManager ez;
    
    public List<ShowEntity> encontrarTodo(){
        Query todos = ez.createQuery("select p from ShowEntity p");
        return todos.getResultList();
    }
    
    //permite traer en productoEntity el dato de la tabla por medio del id
    public ShowEntity encontrarPorId(Long id){
      return ez.find(ShowEntity.class, id);
    }
    
    //permite insertar datos a la tabla prodcuto retornando el mismo producto
    public ShowEntity insertar(ShowEntity entity){
     ez.persist(entity);
     return entity;
    }
    
    //permite acutalizar el dato en la tabla
    public ShowEntity actualizar(ShowEntity entity){
     return ez.merge(entity);
    }
    
    public void eliminar(Long id){
      ShowEntity showEliminar = ez.find(ShowEntity.class, id);
      ez.remove(showEliminar);   
    }
}
