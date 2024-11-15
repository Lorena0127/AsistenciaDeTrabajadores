package com.asistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Api {

    public JSONObject apiConnect() throws IOException {
        try {
            URL url = new URL("https://randomuser.me/api/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            System.out.println(jsonResponse);
            return jsonResponse;

        } catch (IOException e) {
            System.err.println("Error al conectar con la API: " + e.getMessage());
            throw e;
        }
    }
}
