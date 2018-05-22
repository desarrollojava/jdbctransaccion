/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.modelo.Persona;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDaoImpl implements IPersonaDao {

    private static final String SQL_UPDATE_PERSONA = "UPDATE persona set nombres=:nombres,"
            + "apellidos=:apellidos,direccionDomicilio=:direccionDomicilio where idPersona=:idPersona";
    private static final String SQL_INSERT_PERSONA = "insert into persona(nombres,apellidos,direccionDomicilio) "
            + "values(:nombres,:apellidos,:direccionDomicilio)";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    }

    @Override
    public void actualizarPersona(Persona persona) {

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(persona);
        this.namedParameterJdbcTemplate.update(SQL_UPDATE_PERSONA, parameterSource);

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
        return this.jdbcTemplate.query("select idPersona,nombres,apellidos,direccionDomicilio from persona", new PersonaRpwMapper());
    }

    @Override
    public int contarPersonasPorNombre(Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int contadorPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarPersona(Persona persona) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(persona);
        this.namedParameterJdbcTemplate.update(SQL_INSERT_PERSONA, parameterSource);
    }

}
