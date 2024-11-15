package com.asistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class Api {

    private String gender;

    public JSONObject apiConnect(String gender) throws IOException {
        this.gender = gender;
        try {
            URL url = new URL("https://randomuser.me/api/?gender=" + gender);
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
            return jsonResponse;

        } catch (IOException e) {
            System.err.println("Error al conectar con la API: " + e.getMessage());
            throw e;
        }
    }

    public User createUserFromResponse(JSONObject response) {

        JSONArray resultsArray = response.getJSONArray("results");
        JSONObject resultsJson = resultsArray.getJSONObject(0);
        JSONObject pictures = resultsJson.getJSONObject("picture");
        JSONObject location = resultsJson.getJSONObject("location");
        JSONObject dob = resultsJson.getJSONObject("dob");
        JSONObject info = response.getJSONObject("info");

        String city = location.getString("city");
        String state = location.getString("state");
        String country = location.getString("country");
        String avatar = pictures.getString("large");
        String id = info.getString("seed");
        int age = dob.getInt("age");
        String role = "general";
        User newUser = new User(id, null, null, null, role, avatar, this.gender, city, state,
                country, age);
        return newUser;
    }
}
