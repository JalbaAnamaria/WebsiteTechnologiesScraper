import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HtmlReader {

    public static String read(String domain) throws IOException, InterruptedException {
        URI uri = URI.create("https://" + domain);

        HttpClient httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest,
                HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + httpResponse.statusCode());
        System.out.println("Body length: " + httpResponse.body().length());


        return httpResponse.body();
    }
}
