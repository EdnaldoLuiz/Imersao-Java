import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        String url = "http://localhost:8080/linguagem";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir os dados que interessam, como: titulo, poster e classificação
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradorDeFigurinhas();

        extrator.extraiConteudos(json);

        for (int tamanho = 0; tamanho < 3; tamanho++) {

            Conteudo conteudo = conteudos.get(tamanho);

            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();

            String nomeArquivos = "imgs/saida/linguagens/" + conteudo.titulo() + ".png";

            geradora.cria(inputStream, nomeArquivos);

            System.out.println(conteudo.titulo());
            System.out.println();
        }
    }
}
