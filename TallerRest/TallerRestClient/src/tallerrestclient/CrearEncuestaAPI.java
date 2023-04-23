/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerrestclient;

import Code.Encuesta;
import Code.Pregunta;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author esteb
 */
//Clase cliente API para crear las encuestas desde el cliente administador
public class CrearEncuestaAPI extends API {

    public CrearEncuestaAPI() {
        super("http://localhost:8080/TallerRestServer/webresources/CrearEncuesta");
    }

    public Encuesta createEncuesta() {

        Pregunta pregunta = new Pregunta();

        Scanner sc = new Scanner(System.in);
        //   System.out.println("Ingrese ID");
        //    int id = sc.nextInt();
        //    sc.nextLine();
        System.out.println("Ingrese título");
        String titulo = sc.nextLine();
        System.out.println("Ingrese cantidad de preguntas");
        int cantPreguntas = sc.nextInt();
        sc.nextLine();
        ArrayList<Pregunta> tempList = new ArrayList<>();
        for (int i = 0; i < cantPreguntas; i++) {
            System.out.println("Ingrese la pregunta:");
            String preguntaTemp = sc.nextLine();
            System.out.println("Opción 1:");
            String o1 = sc.nextLine();
            System.out.println("Opción 2:");
            String o2 = sc.nextLine();
            System.out.println("Opción 3:");
            String o3 = sc.nextLine();
            System.out.println("Opción 4:");
            String o4 = sc.nextLine();

            Pregunta elemento = new Pregunta(i, preguntaTemp, o1, o2, o3, o4, 0, 0, 0, 0);
            tempList.add(elemento);
        }
    //    Encuesta elementoEncuesta = new Encuesta(titulo, cantPreguntas, tempList);

        String json = super.Post(new Gson().toJson(new Encuesta(titulo, cantPreguntas, tempList)));
        return new Gson().fromJson(json, Encuesta.class);

    }

}
