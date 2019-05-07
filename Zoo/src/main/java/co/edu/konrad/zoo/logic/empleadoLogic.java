/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.logic;

import co.edu.konrad.zoo.entities.empleadoEntity;
import co.edu.konrad.zoo.persistence.empleadoPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ASUS-PC
 */
public class empleadoLogic {
     @Inject
    private empleadoPersistence persistence;
    
    public List<empleadoEntity> obtenerEmpleado(){
        List<empleadoEntity> empleados = persistence.encontrarTodo();
        return empleados;
    }
    
    /**
     * Obtener Empleado por su id
     * @param id
     * @return EmpleadoEntity
     */
    public empleadoEntity obtenerEmpleados(Long id){
        empleadoEntity empleado = persistence.encontrarPorId(id);
        if(empleado == null){
            throw new IllegalArgumentException("El empleado solicitado NO existe");
        }
        return empleado;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para crear un Animal
     * @param crearEmpleado
     * @return 
     */
    public empleadoEntity crearEmpleado(empleadoEntity crearEmpleado){
        persistence.insertar(crearEmpleado);
        return crearEmpleado;
    }
    
    /**
     * Metodo que conecta la logica con la transaccion para actualizar un Animal
     * @param id
     * @param actualizarEmpleado
     * @return empleado actualizado
     */
    public empleadoEntity actualizarEmpleado (Long id, empleadoEntity actualizarEmpleado){
        empleadoEntity productoUpdate = persistence.actualizar(actualizarEmpleado);
        return productoUpdate;
    }
    
    /**
     * Metodo para eliminar un objeto animal
     * @param id 
     */
    public void eliminarEmpleado(Long id){
        persistence.eliminar(id);
    }
     
}
