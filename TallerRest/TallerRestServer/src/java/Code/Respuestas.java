/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author esteb
 */

//Objeto que almacena todas las respuestas que han dado los usuarios
public class Respuestas {

    private int idPregunta;
    private int respuesta;
    

    public Respuestas() {
    }

    public Respuestas(int idPregunta, int respuesta) {
        this.idPregunta = idPregunta;
        this.respuesta = respuesta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

}
