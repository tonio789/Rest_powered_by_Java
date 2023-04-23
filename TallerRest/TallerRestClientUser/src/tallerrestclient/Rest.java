/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerrestclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author JeanCarlos
 */
public class Rest {

    //Este método nos permite enviar peticiones con el método GET
    public String get(final String url) throws MalformedURLException, IOException {
        URL obj = new URL(url);//Creamos un objeto con la dirección del recurso
        //Creamos un HttpURLConection con la información del objeto URL
        HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
        //Indicamos que la llamada va a ser por medio del GET
        httpConnection.setRequestMethod("GET");
        //Indicamos el MediaType que vamos a usar en el servicio
        httpConnection.setRequestProperty("Content-Type", "application/json");
        //Obtenemos el código de respuesta del servidor
        int responseCode = httpConnection.getResponseCode();
        if (responseCode != 200 && responseCode != 204) {
            System.out.println("Problemas con el servidor " + responseCode);
            return null;
        }
        //Vamos a leer la respuesta del servidor
        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
        String respuesta;
        String respuestaCompleta = "";//vamos a guardar la respuesta del servidor
        while ((respuesta = responseBuffer.readLine()) != null) {
            respuestaCompleta += respuesta;
        }
        httpConnection.disconnect();
        return respuestaCompleta;
    }

    //Este método nos permite enviar peticiones con el método POST
    public String post(final String url, final String jsonData) throws MalformedURLException, IOException {
        //Creamos un objeto con la dirección del recurso
        //Creamos un HttpURLConection con la información del objeto URL
        HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
        //cuando usamos POST, PUT requerimos poner este valor en true
        httpConnection.setDoOutput(true);
        //Indicamos que la llamada va a ser por medio del POST
        httpConnection.setRequestMethod("POST");
        //Indicamos el MediaType que vamos a usar en el servicio
        httpConnection.setRequestProperty("Content-Type", "application/json");
        //vamos a enviar los datos Json al servidor
        OutputStream outputStream = httpConnection.getOutputStream();
        outputStream.write(jsonData.getBytes());
        outputStream.flush();
        int responseCode = httpConnection.getResponseCode();
        if (responseCode != 200 && responseCode != 204) {
            System.out.println("Problemas con el servidor " + responseCode);
            return null;
        }
        //Vamos a leer la respuesta del servidor
        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));
        String respuesta;
        String respuestaCompleta = "";//vamos a guardar la respuesta del servidor
        while ((respuesta = responseBuffer.readLine()) != null) {
            respuestaCompleta += respuesta;
        }
        httpConnection.disconnect();
        return respuestaCompleta;
    }

}

