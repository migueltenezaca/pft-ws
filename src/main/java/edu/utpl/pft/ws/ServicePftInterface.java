/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author Miguel Tenezaca
 */
@WebService()
@SOAPBinding(style = Style.DOCUMENT)
public interface ServicePftInterface {
    
    @WebMethod(operationName = "get_personas")
    public String getPersonas();

    /**
     * Web service operation
     *
     * @param cedula
     * @return
     */
    @WebMethod(operationName = "get_persona_por_cedula")
    public String personaPorCedula(@WebParam(name = "cedula") final String cedula);
    
    @WebMethod(operationName = "get_modalidades")
    public String getModalidades() ;
}
