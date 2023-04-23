/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerrestclient;

/**
 *
 * @author esteb
 */
public class TallerRestClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CrearEncuestaAPI crear = new CrearEncuestaAPI();
       VerResultadosAPI ver = new VerResultadosAPI();
       
    //   crear.createEncuesta();
       ver.Respuestas();
               
    }
    
}
