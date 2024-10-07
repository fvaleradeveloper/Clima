//import WeatherResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {
    public static void main(String[] args) {
        String apiKey = "9666548feb5c4fb42ebaa677f5eab359"; // Tu API key
        String lat = "-12.00139"; // Latitud
        String lon = "-76.95000"; // Longitud
        String lang = "sp,es"; // Idioma

        try {
            String urlString = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s&units=metric&lang=%s", lat, lon, apiKey, lang);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Cerrar las conexiones
            in.close();
            connection.disconnect();

            // Deserializar el JSON a objeto WeatherResponse
            Gson gson = new Gson();
            WeatherResponse weatherResponse = gson.fromJson(content.toString(), WeatherResponse.class);

            // Serializar el objeto nuevamente a JSON para guardar
            String jsonOutput = gson.toJson(weatherResponse, WeatherResponse.class);

            // Guardar en un archivo JSON
            FileWriter fileWriter = new FileWriter("clima.json");
            fileWriter.write(jsonOutput);
            fileWriter.close();

            System.out.println("Archivo clima.json ha sido generado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

