/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerrestclient;

import Code.Encuesta;
import Code.RespEncuesta;
import Code.Respuestas;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author esteb
 */

//Clase API para llenar las encuestas desde cliente usuario
public class LlenarEncuesta extends API {

    public LlenarEncuesta() {
        super("http://localhost:8080/TallerRestServer/webresources/llenarEncuesta");
    }

    public void Llenar() {

        llenarEncuesta(jalarEncuesta());

    }

    public Encuesta jalarEncuesta() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Inserte ID de encuesta:"));
        String json = super.get("?id=" + id);
        if (json.isEmpty()) {
            return null;
        }
        Encuesta encuesta = new Gson().fromJson(json, Encuesta.class);
        return encuesta;

    }

    public RespEncuesta llenarEncuesta(Encuesta encuesta) {

        String titulo = encuesta.getTitulo();

        JOptionPane.showMessageDialog(null, "Encuesta\n" + titulo);

        ArrayList<Respuestas> tempList = new ArrayList<>();
        for (int i = 0; i < encuesta.getPreguntas().size(); i++) {

            String pregunta = encuesta.getPreguntas().get(i).getPregunta();
            String O1 = encuesta.getPreguntas().get(i).getOpcion1();
            String O2 = encuesta.getPreguntas().get(i).getOpcion2();
            String O3 = encuesta.getPreguntas().get(i).getOpcion3();
            String O4 = encuesta.getPreguntas().get(i).getOpcion4();

            String mensaje = "Pregunta" + i + ": " + pregunta
                    + "\n1. " + O1
                    + "\n2. " + O2
                    + "\n3. " + O3
                    + "\n4. " + O4;
            int respuesta = 0;
            do {
                respuesta = Integer.parseInt(JOptionPane.showInputDialog(mensaje));

            } while (respuesta > 4 && respuesta<1);

            tempList.add(new Respuestas(i, respuesta));

        }

        RespEncuesta elemento = new RespEncuesta(encuesta.getId(), tempList);

        String json = super.Post(new Gson().toJson(new RespEncuesta(encuesta.getId(), tempList)));
        return new Gson().fromJson(json, RespEncuesta.class);

    }

}
