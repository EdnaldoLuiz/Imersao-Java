import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        
        // lendo imagem
        // InputStream inputStream = new FileInputStream(new File(imersaoJava/imgs/entrada.filme.jpg));
        // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_9.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.createGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 200);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        graphics.drawString("MUITO TOP!", 400, novaAltura - 30);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}
