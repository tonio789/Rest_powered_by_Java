/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Code.Encuesta;
import Code.Utils;
import com.google.gson.Gson;
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

//Servicio API para crear encuestas
@Path("CrearEncuesta")
public class CrearEncuestaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CrearEncuestaResource
     */
    public CrearEncuestaResource() {
    }

    /**
     * Retrieves representation of an instance of API.CrearEncuestaResource
     *
     * @return an instance of java.lang.String
     */
    //método GET de API 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("id") int id) {
        if (Utils.baseEncuesta != null && !Utils.baseEncuesta.isEmpty()) {
            return new Gson().toJson(Utils.baseEncuesta.get(id));
        } else {
            return null;
        }
    }
//método POST de API
    @POST
    @Consumes(MediaType.APPLICATION_JSON)

    public String postJson(String content) {
        Encuesta encuesta = new Gson().fromJson(content, Encuesta.class);
        encuesta.setId(Utils.baseEncuesta.size() + 1);
        Utils.baseEncuesta.add(encuesta);

        return new Gson().toJson(encuesta);
    }
}
