/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.persistence;

import co.edu.konrad.zoo.entities.empleadoEntity;
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
public class empleadoPersistence {

    @PersistenceContext(unitName = "zoopu")
    protected EntityManager ez;

    public List<empleadoEntity> encontrarTodo() {
        Query todos = ez.createQuery("select p from empleadoEntity p");
        return todos.getResultList();
    }

    //permite traer en productoEntity el dato de la tabla por medio del id
    public empleadoEntity encontrarPorId(Long id) {
        return ez.find(empleadoEntity.class, id);
    }

    //permite insertar datos a la tabla prodcuto retornando el mismo producto
    public empleadoEntity insertar(empleadoEntity entity) {
        ez.persist(entity);
        return entity;
    }

    //permite acutalizar el dato en la tabla
    public empleadoEntity actualizar(empleadoEntity entity) {
        return ez.merge(entity);
    }

    public void eliminar(Long id) {
        empleadoEntity empleadoEliminar = ez.find(empleadoEntity.class, id);
        ez.remove(empleadoEliminar);
    }

}
