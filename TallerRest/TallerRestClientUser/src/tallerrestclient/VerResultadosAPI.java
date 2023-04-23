/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerrestclient;

import Code.Encuesta;
import Code.RespEncuesta;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author esteb
 */

//Clase API  para poder ver los resultados desde el cliente usuario
public class VerResultadosAPI extends API {

    public VerResultadosAPI() {
        super("http://localhost:8080/TallerRestServer/webresources/Resultados");
    }

    List<RespEncuesta> resEnc = new ArrayList<>();

    public void Respuestas() {

        printResultados(jalarResultados());

    }

    public Encuesta jalarResultados() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Inserte ID de pregunta:"));
        String json = super.get("?id=" + id);
        if (json.isEmpty()) {
            return null;
        }

        Encuesta encuesta = new Gson().fromJson(json, Encuesta.class);
        return encuesta;

    }

    public void printResultados(Encuesta encuesta) {

        String titulo = encuesta.getTitulo();

        JOptionPane.showMessageDialog(null, "Resultados\n" + titulo);

        for (int i = 0; i < encuesta.getPreguntas().size(); i++) {

            String pregunta = encuesta.getPreguntas().get(i).getPregunta();
            String O1 = encuesta.getPreguntas().get(i).getOpcion1();
            String O2 = encuesta.getPreguntas().get(i).getOpcion2();
            String O3 = encuesta.getPreguntas().get(i).getOpcion3();
            String O4 = encuesta.getPreguntas().get(i).getOpcion4();

            int c1 = encuesta.getPreguntas().get(i).getC1();
            int c2 = encuesta.getPreguntas().get(i).getC2();
            int c3 = encuesta.getPreguntas().get(i).getC3();
            int c4 = encuesta.getPreguntas().get(i).getC4();

            String mensaje = "Pregunta" + i + ": " + pregunta
                    + "\n1. " + O1 + " Resultado: " + c1
                    + "\n2. " + O2 + " Resultado: " + c2
                    + "\n3. " + O3 + " Resultado: " + c3
                    + "\n4. " + O4 + " Resultado: " + c4;

            JOptionPane.showMessageDialog(null, mensaje);
        }

    }

}
