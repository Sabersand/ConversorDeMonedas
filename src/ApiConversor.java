import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public Moneda obtenerTasaDeCambio(String divisaBase, String divisaObjetivo) {
    HttpClient client = HttpClient.newHttpClient();
    URI uriURL = URI.create("https://v6.exchangerate-api.com/v6/70171c9556e4044c55ac3108/pair/" + divisaBase + "/" + divisaObjetivo);

    HttpRequest request = HttpRequest.newBuilder().uri(uriURL).build();

    try {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la solicitud: " + response.statusCode());
        }
        return new Gson().fromJson(response.body(), Moneda.class);
    } catch (IOException | InterruptedException e) {
        throw new RuntimeException("No fue posible procesar tu solicitud", e);
    }
}
