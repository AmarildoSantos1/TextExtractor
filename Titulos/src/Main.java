import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String url = "https://pt.wikipedia.org/wiki/Picu%C3%AD"; //  URL do site para extrair os títulos
        String outputFile = "titles.txt"; // Arquivo de saída

        try {
            // Requisição HTTP da página web
            Document document = Jsoup.connect(url).get();

            // Seleciona todos os elementos de título (por exemplo, <h1>, <h2>, etc.)
            Elements titleElements = document.select("h1, h2, h3, h4, h5, h6");

            // Arquivo de saída
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Elementos de título, os títulos no arquivo
            for (Element titleElement : titleElements) {
                String title = titleElement.text();
                writer.write(title);
                writer.newLine();
            }

            // break
            writer.close();

            System.out.println("Títulos extraídos e salvos em " + outputFile);
        } catch (IOException e) {
            System.err.println("Erro ao extrair títulos: " + e.getMessage());
        }
    }
}
