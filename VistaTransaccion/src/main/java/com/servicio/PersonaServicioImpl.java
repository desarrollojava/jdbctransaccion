/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import com.dao.IPersonaDao;
import com.modelo.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PersonaServicioImpl implements IPersonaServicio {

    @Autowired
    IPersonaDao iPersonaDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void actualizarPersona(Persona persona) {
        iPersonaDao.actualizarPersona(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarPersonaPorId(int idPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> buscarTodo() {
        return iPersonaDao.buscarTodo();
    }

    @Override
    public int contarPersonasPorNombre(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int contadorPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void agregarPersona(Persona persona) {
        iPersonaDao.agregarPersona(persona);
    }

}
