/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.service.implement;

import edu.utpl.pft.dao.PftPersonaDao;
import edu.utpl.pft.entity.PftPersona;
import edu.utpl.pft.service.PftPersonaService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel Tenezaca
 */
@Stateless
public class PftPersonaServiceImplement implements PftPersonaService {

    @EJB
    private PftPersonaDao personaDao;

    @Override
    public List<PftPersona> buscarTodo() {
        List<PftPersona> personas = personaDao.buscarTodo();
        List<PftPersona> result = new ArrayList<>();
        try {
            for (PftPersona persona : personas) {
                PftPersona pftPersona = new PftPersona();
                pftPersona.setEcvId(persona.getEcvId());
                pftPersona.setEntId(persona.getEntId());
                pftPersona.setPerPrimerNombre(new String(persona.getPerPrimerNombre().getBytes(), "UTF-8"));
                pftPersona.setPerSegundoNombre(new String(persona.getPerSegundoNombre().getBytes(), "UTF-8"));
                pftPersona.setPerPrimerApellido(new String(persona.getPerPrimerApellido().getBytes(), "UTF-8"));
                pftPersona.setPerSegundoApellido(new String(persona.getPerSegundoApellido().getBytes(), "UTF-8"));
                pftPersona.setEntIdentificacion(persona.getEntIdentificacion());
                pftPersona.setPerFechaNacimiento(persona.getPerFechaNacimiento());
                result.add(pftPersona);
            }
        } catch (Exception e) {
        }

        return result;
    }

    @Override
    public PftPersona buscarPorCedula(String cedula) {
        PftPersona persona = personaDao.buscarPorCedula(cedula);
        PftPersona result = new PftPersona();
        try {
            if (persona == null) {
                return null;
            }
            result.setEcvId(persona.getEcvId());
            result.setEntId(persona.getEntId());
            result.setPerPrimerNombre(new String(persona.getPerPrimerNombre().getBytes(), "UTF-8"));
            result.setPerSegundoNombre(new String(persona.getPerSegundoNombre().getBytes(), "UTF-8"));
            result.setPerPrimerApellido(new String(persona.getPerPrimerApellido().getBytes(), "UTF-8"));
            result.setPerSegundoApellido(new String(persona.getPerSegundoApellido().getBytes(), "UTF-8"));
            result.setEntIdentificacion(persona.getEntIdentificacion());
            result.setPerFechaNacimiento(persona.getPerFechaNacimiento());
        } catch (Exception e) {
        }

        return result;
    }
}
