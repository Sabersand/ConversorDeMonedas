import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConversor {

    public Moneda moneda(String divisa, String cambio, double valor) {
        HttpClient client = HttpClient.newHttpClient();

        URI uriURL = URI.create("https://v6.exchangerate-api.com/v6/70171c9556e4044c55ac3108/latest/"+divisa+"/"+cambio+"/"+valor);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uriURL)
                .build();

        HttpResponse<String> response;
        {
            try {
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            } catch (Exception e) {
                throw new RuntimeException("No fue posible procesar tu solicitud");
            }
            return new Gson().fromJson(response.body(), Moneda.class);
        }

    }
}
