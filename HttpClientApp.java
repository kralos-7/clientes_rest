import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class HttpClientApp {
	public void invoke() throws URISyntaxException {
  		HttpClient client = HttpClient.newBuilder()
      			.version(Version.HTTP_2)
      			.followRedirects(Redirect.NORMAL)
      			.build();
  		HttpRequest request = HttpRequest.newBuilder()
     			.uri(new URI("http://127.0.0.1:8484/users/"))
     			.GET()
     			.timeout(Duration.ofSeconds(10))
     			.build();
  		client.sendAsync(request, BodyHandlers.ofString())
    			.thenApply(HttpResponse::body)
    			.thenAccept(System.out::println)
    			.join();
 	}

	public static void main(String[] args) {
		try {
	 		HttpClientApp cliente = new HttpClientApp();
	 		cliente.invoke();
			System.out.println("succesfully!");
	 	} catch (URISyntaxException e) {
	 		e.printStackTrace();
		}
 	}
}
