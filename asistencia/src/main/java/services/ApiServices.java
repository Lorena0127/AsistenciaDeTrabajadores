package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ApiServices {

    public JSONObject GetApiData(String gender) {
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

        }
        return null;
    }

}
