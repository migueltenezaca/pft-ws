/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.ws;

import com.google.gson.Gson;
import edu.utpl.pft.service.PftModalidadService;
import edu.utpl.pft.service.PftPersonaService;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author Miguel Tenezaca
 */
@WebService(endpointInterface = "edu.utpl.pft.ws.ServicePftInterface", serviceName = "ServicePft")
public class ServicePft implements ServicePftInterface {

    @EJB
    private PftPersonaService personaService;
    @EJB
    private PftModalidadService pftModalidadService;

    @Resource
    WebServiceContext webServiceContext;

    /**
     * Web service operation
     *
     * @return
     */
    @Override
    public String getPersonas() {
        Gson gson = new Gson();
        return gson.toJson(personaService.buscarTodo());
    }

    //CON AUTENTICACION
    /**
     * Web service operation
     *
     * @param cedula
     * @return
     */
    @Override
    public String personaPorCedula(@WebParam(name = "cedula") final String cedula) {
      //  Boolean autenticate = autenticar();
        Gson gson = new Gson();
        //if (autenticate) {
            System.out.println("Se autentico: ");
            return gson.toJson(personaService.buscarPorCedula(cedula));
        //}

        //return gson.toJson("Error de autenticacion");
    }

    @Override
    public String getModalidades() {
        Gson gson = new Gson();
        return gson.toJson(pftModalidadService.buscarTodo());
    }

    /*
    private Boolean autenticar() {
        MessageContext messageContext = webServiceContext.getMessageContext();

        //obtiene los headers de la peticion
        Map<?, ?> requestHeaders = (Map<?, ?>) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        List<?> usernameList = (List<?>) requestHeaders.get("username");
        List<?> passwordList = (List<?>) requestHeaders.get("password");

        String username = "";
        String password = "";

        if (usernameList != null) {
            username = usernameList.get(0).toString();
        }

        if (passwordList != null) {
            password = passwordList.get(0).toString();
        }

        //Consultar nombre de usuario y password en la db
        //Sifrar a md5 o Code64
        if (username.equals("usuario") && password.equals("1234")) {

            System.out.println("usuario valido");
            return Boolean.TRUE;
        } else {

            System.out.println("Usuario no logeado");
            return Boolean.FALSE;
        }

    }
    */
}
