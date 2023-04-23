/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Code.Encuesta;
import Code.Pregunta;
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
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author esteb
 */
//Servicio API para ver los resultados de las encuestas
@Path("Resultados")
public class ResultadosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ResultadosResource
     */
    public ResultadosResource() {
    }

    /**
     * Retrieves representation of an instance of API.ResultadosResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("id") int id) {

        if (id > Utils.baseEncuesta.size()) {

            return null;

        } else {

            ArrayList<Pregunta> tempPregunta = new ArrayList<>();
            if (Utils.resultados.isEmpty()) {

                return new Gson().toJson(Utils.baseEncuesta.get(id));

            }

            for (int i = 0; i < Utils.baseEncuesta.get(id).getPreguntas().size(); i++) {

                int c1 = 0;
                int c2 = 0;
                int c3 = 0;
                int c4 = 0;

                for (int j = 0; j < Utils.resultados.size(); j++) {

                    for (int k = 0; k < Utils.resultados.get(j).getRespuestas().size(); k++) {

                        switch (Utils.resultados.get(j).getRespuestas().get(k).getRespuesta()) {
                            case 1:
                                c1 = c1 + 1;
                                break;
                            case 2:
                                c2 = c2 + 1;
                                break;
                            case 3:
                                c3 = c3 + 1;
                                break;
                            case 4:
                                c4 = c4 + 1;
                                break;
                        }

                    }
                    Pregunta elementoPregunta = new Pregunta(Utils.baseEncuesta.get(id).getPreguntas().get(j).getId(),
                            Utils.baseEncuesta.get(id).getPreguntas().get(i).getPregunta(),
                            Utils.baseEncuesta.get(id).getPreguntas().get(i).getOpcion1(),
                            Utils.baseEncuesta.get(id).getPreguntas().get(i).getOpcion2(),
                            Utils.baseEncuesta.get(id).getPreguntas().get(i).getOpcion3(),
                            Utils.baseEncuesta.get(id).getPreguntas().get(i).getOpcion4(),
                            c1, c2, c3, c4);
                    tempPregunta.add(elementoPregunta);
                }
            }

            Utils.baseEncuesta.set(id, new Encuesta(Utils.baseEncuesta.get(id).getTitulo(), Utils.baseEncuesta.get(id).getCantidadPreguntas(), tempPregunta));

            return new Gson().toJson(Utils.baseEncuesta.get(id));
        }
    }
}
