import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // exibir os dados que interessam, como: titulo, poster e classificação
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        var geradora = new GeradorDeFigurinhas();
        for (Map<String, String> filme : listaDeFilmes) {

            String urlImagem = filme.get("imagem");
            String titulo = filme.get("title");
            InputStream inputStream = new URL(urlImagem).openStream();

            String nomeArquivos = titulo + ".png";

            geradora.cria(inputStream, nomeArquivos);

            System.out.println("Titulo:         " + titulo);
            System.out.println();
            // for (Map<String, String> filme : listaDeFilmes) {
            // double classificacao = Double.parseDouble(filme.get("imDbRating"));
            // int estrelas = (int) classificacao;
            // String titulo = filme.get("title");
            // String poster = filme.get("image");
            // System.out.println("Titulo: " + titulo);
            // System.out.println("Poster: " + poster);
            // System.out.print("Rating: ");
            // for (int i = 1; i < estrelas; i++) {
            // System.out.print("\u2B50");
            // }

            // System.out.println("\n");
            // }

        }
    }
}