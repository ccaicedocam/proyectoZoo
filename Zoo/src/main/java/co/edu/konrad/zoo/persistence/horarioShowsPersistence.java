/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.persistence;

import co.edu.konrad.zoo.entities.horarioShowsEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author cristian_caicedo
 */
@Stateless
public class horarioShowsPersistence {
    
     @PersistenceContext (unitName = "zoopu")
    protected EntityManager ez;
    
    public List<horarioShowsEntity> encontrarTodo(){
    Query todos = ez.createQuery("select p from horarioShowsEntity p");
    return todos.getResultList();
    }
    
    //permite traer en productoEntity el dato de la tabla por medio del id
    public horarioShowsEntity encontrarPorId(Long id){
      return ez.find(horarioShowsEntity.class, id);
    }
    
    //permite insertar datos a la tabla prodcuto retornando el mismo producto
    public horarioShowsEntity insertar(horarioShowsEntity entity){
     ez.persist(entity);
     return entity;
    }
    
    //permite acutalizar el dato en la tabla
    public horarioShowsEntity actualizar(horarioShowsEntity entity){
     return ez.merge(entity);
    }
    
    public void eliminar(Long id){
      horarioShowsEntity horarioShowsEntity = ez.find(horarioShowsEntity.class, id);
      ez.remove(horarioShowsEntity);
    }
}
