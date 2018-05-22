/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.modelo.Persona;
import com.servicio.IPersonaServicio;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/configuracion/dataSource-test.xml",
    "classpath:/com/configuracion/applicationContextJdbc.xml"})
public class Test {

    private static Log Logger = LogFactory.getLog(Test.class);

    @Autowired
    private IPersonaServicio iPersonaServicio;

    @org.junit.Test
//    @Transactional
     @Ignore
    public void TestTransaccion() {
        //buscar los registros
        List<Persona> lista = iPersonaServicio.buscarTodo();
        for (Persona obj : lista) {
            Logger.info(obj.getIdPersona() + obj.getNombres() + obj.getApellidos());

        }
        Persona persona = new Persona();
        persona.setIdPersona(1);
        persona.setApellidos("Morales");
        persona.setDireccionDomicilio("Quito");
        persona.setNombres("Juan");
        iPersonaServicio.actualizarPersona(persona);

        //buscar los registros
        List<Persona> listat = iPersonaServicio.buscarTodo();
        for (Persona obj : listat) {
            Logger.info(obj.getIdPersona() + obj.getNombres() + obj.getApellidos());

        }

    }

    @org.junit.Test
//    @Transactional
    public void test1Operaciones() {
        try {
            Persona person = new Persona();
            person.setApellidos("SOLISdf");
            person.setDireccionDomicilio("Quito sur");
            person.setNombres("Ana");
            iPersonaServicio.agregarPersona(person);
            List<Persona> lista = iPersonaServicio.buscarTodo();
            for (Persona obj : lista) {
                Logger.info("personas: " + obj.getNombres());
            }
        } catch (Exception ex) {
            Logger.error("error: " + ex);
        }
    }

    @org.junit.Test
    public void test2CompruebaOperaciones() {
        try {
            List<Persona> personas = iPersonaServicio.buscarTodo();
            Logger.info("cantidad personas: " + personas.size());
        } catch (Exception ex) {
            Logger.error("error: " + ex);
        }
    }

}
