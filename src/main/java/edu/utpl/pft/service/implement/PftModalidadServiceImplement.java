/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.service.implement;

import edu.utpl.pft.dao.PftModalidadDao;
import edu.utpl.pft.entity.PftModalidad;
import edu.utpl.pft.service.PftModalidadService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel Tenezaca
 */
@Stateless
public class PftModalidadServiceImplement implements PftModalidadService {

    @EJB
    private PftModalidadDao pftModalidadDao;

    @Override
    public List<PftModalidad> buscarTodo() {
        List<PftModalidad> modalidades = pftModalidadDao.buscarTodo();
        List<PftModalidad> result = new ArrayList<>();
        for (PftModalidad modalidad : modalidades) {
            PftModalidad pftModalidad = new PftModalidad();
            pftModalidad.setModCodigo(modalidad.getModCodigo());
            pftModalidad.setModId(modalidad.getModId());
            pftModalidad.setModNombre(modalidad.getModNombre());
            result.add(pftModalidad);
        }
        return result;
    }

}
