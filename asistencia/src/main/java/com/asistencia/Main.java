package com.asistencia;

import org.json.JSONArray;
import org.json.JSONObject;


public class Main {
    public static void main(String[] args) {
        Api api = new Api();
        try {
            JSONObject response = api.apiConnect();
            JSONArray resultsArray = response.getJSONArray("results");
            JSONObject resultsJson = resultsArray.getJSONObject(0);
            JSONObject pictures = resultsJson.getJSONObject("picture");
            String largePicture = pictures.getString("large");
            // User newUser = new User(null, null, null, null, null, null, null, null, null,
            // null, 0)

            System.out.println(largePicture);

        } catch (Exception e) {
            // Manejo de errores
            System.err.println("Error al conectar con la API: " + e.getMessage());
        }
    }
}
