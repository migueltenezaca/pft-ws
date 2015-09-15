/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.dao;

import edu.utpl.pft.entity.PftPersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel Tenezaca
 */
@Local
public interface PftPersonaDao {

    void create(PftPersona pftPersona);

    void edit(PftPersona pftPersona);

    void remove(PftPersona pftPersona);

    PftPersona find(Object id);

    List<PftPersona> findAll();

    List<PftPersona> findRange(int[] range);

    int count();

    List<PftPersona> buscarTodo();

    PftPersona buscarPorCedula(String cedula);
}
