import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConversor {

    private static final String API_KEY = "70171c9556e4044c55ac3108"; // Usa tu propia API KEY
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public Moneda obtenerTasaDeCambio(String divisaBase, String divisaObjetivo) {
        var client = HttpClient.newHttpClient();
        var uriURL = URI.create(BASE_URL + API_KEY + "/pair/" + divisaBase + "/" + divisaObjetivo);

        var request = HttpRequest.newBuilder().uri(uriURL).build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("No se pudo completar la solicitud ya que existe el siguiente error: " + response.statusCode());
            }
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No fue posible procesar tu solicitud", e);
        }
    }
}
