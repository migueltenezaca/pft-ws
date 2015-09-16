/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.pft.encrypt;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

/**
 *
 * @author cesar
 */
public class ServerCallBack implements CallbackHandler {

    //private Map<String, String> passwords = new HashMap<String, String>();

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];        
        pc.setPassword("changeit");
        
        /*
        for (Callback callback : callbacks) {
            if (callback instanceof WSPasswordCallback) {
                WSPasswordCallback pc = (WSPasswordCallback) callback;

                String pass = passwords.get(pc.getIdentifier());
                if (pass != null) {
                    pc.setPassword(pass);
                    return;
                }
            }
        }
        */
    }

    /**
     * @return the passwords
     */
//    public Map<String, String> getPasswords() {
//        return passwords;
//    }
//
//    /**
//     * @param passwords the passwords to set
//     */
//    public void setPasswords(Map<String, String> passwords) {
//        this.passwords = passwords;
//    }

}
