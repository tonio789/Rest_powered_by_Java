/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerrestclient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ulacit
 */
//Clase API abstracta que será clase maestra para el resto de servicios API
public abstract class API {
    
    private final String URL;
    private Rest rest;
    
    public API(final String URL)
    {
        this.URL = URL;
        rest = new Rest();
    }
    
    protected String get()
    {
        try {
            return rest.get(URL);
        } catch (IOException ex) {
            Logger.getLogger(API.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
     protected String get(final String queryParam)
    {
        try {
            return rest.get(URL  + queryParam);
        } catch (IOException ex) {
            Logger.getLogger(API.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    protected String Post(final String json)
    {
        try {
            return rest.post(URL, json);
        } catch (IOException ex) {
            Logger.getLogger(API.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
}
