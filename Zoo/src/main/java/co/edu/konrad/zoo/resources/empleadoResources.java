/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.zoo.resources;

import co.edu.konrad.zoo.dto.empleadoDTO;
import co.edu.konrad.zoo.entities.empleadoEntity;
import co.edu.konrad.zoo.logic.empleadoLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author ASUS-PC
 */
public class empleadoResources {
   @EJB
    private empleadoLogic empleadosLogic;

    /**
     * Metodo que obtiene todos los datos de animal
     * @return Lista animalesDTO
     */
    @GET
    public List<empleadoDTO> getEmpleadoList(){
        List <empleadoEntity> empleados = empleadosLogic.obtenerEmpleado();
        return empleadoDTO.toEmpleadoList(empleados);
    }
    
    /**
     * Obtener empleado por su id
     * @param id
     * @return EmpleadoEntity
     */
    @GET
    @Path("{id: \\d+}")
    public empleadoDTO getEmpleado(@PathParam("id") Long id){
        empleadoEntity empleados = empleadosLogic.obtenerEmpleados(id);
        if (empleados == null){
            throw new RuntimeException("El empleado no existe");
        } 
        return new empleadoDTO(empleados);
    }
    
    @POST
    public empleadoDTO createAnimal(empleadoDTO empleadoDto){
        return new empleadoDTO(empleadosLogic.crearEmpleado(empleadoDto.toEntity()));
    }
    
    
    /**
     * Actualizar un Animal
     * @param id
     * @param empleadoDto
     * @return empleadoDto actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public empleadoDTO updateAnimal(@PathParam("id") Long id, empleadoDTO empleadoDto){
        empleadoEntity empleadoEntity = empleadosLogic.obtenerEmpleados(id);
        if(empleadoEntity == null){
            throw new RuntimeException("El animal no existe.");
        }
        return new empleadoDTO(empleadosLogic.actualizarEmpleado(id, empleadoDto.toEntity()));
    }
    
    @DELETE
    @Path("{empleadoId: \\d+}")
    public void deleteAnimal(@PathParam("empleadoId") Long id){
        empleadoEntity empleadoEntity = empleadosLogic.obtenerEmpleados(id);
        if(empleadoEntity == null){
            throw new RuntimeException("El empleado no existe.");
        }
        empleadosLogic.eliminarEmpleado(id);
    }
    
    
    
}
