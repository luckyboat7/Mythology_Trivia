import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TriviaCheckIn {
    public static void main(String[] args) throws IOException, InterruptedException {
        String triviaUrl = "https://opentdb.com/api.php?amount=5&category=20&difficulty=easy";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(triviaUrl)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println(response.body());
        } else {
            System.out.println("Request failed. Status code: " + response.statusCode());
        }
    }
}