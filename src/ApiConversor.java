import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ApiConversor {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/70171c9556e4044c55ac3108/latest/USD"))
            .build();
}
