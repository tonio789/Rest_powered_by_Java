/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Code.Encuesta;
import Code.RespEncuesta;
import Code.Utils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author esteb
 */

//Servicio API para llenar/responder las encuestas
@Path("llenarEncuesta")
public class ResponderEncuestaResource {
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LlenarEncuestaResource
     */
    public ResponderEncuestaResource() {
    }

    /**
     * Retrieves representation of an instance of API.LlenarEncuestaResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("id") int id) {
        
        if (Utils.baseEncuesta != null && !Utils.baseEncuesta.isEmpty()) {
            return new Gson().toJson(Utils.baseEncuesta.get(id));
        } else {
            return null;
        }
    }

    /**
     * PUT method for updating or creating an instance of LlenarEncuestaResource
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(String content) {
        
        RespEncuesta respEncuesta = new Gson().fromJson(content, RespEncuesta.class);
        Utils.resultados.add(respEncuesta);
        
        return new Gson().toJson(respEncuesta);
    }
}
