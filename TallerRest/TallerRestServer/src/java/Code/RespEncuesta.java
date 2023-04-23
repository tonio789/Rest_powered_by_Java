/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;

/**
 *
 * @author esteb
 */

//Objeto lista lleno de respuestas de las encuestas 
public class RespEncuesta {

    private int id;
    private ArrayList<Respuestas> respuestas = new ArrayList<>();

    public RespEncuesta() {
    }

    public RespEncuesta(int id, ArrayList<Respuestas> respuestas) {
        this.id = id;
        this.respuestas = respuestas;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Respuestas> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuestas> respuestas) {
        this.respuestas = respuestas;
    }

}
