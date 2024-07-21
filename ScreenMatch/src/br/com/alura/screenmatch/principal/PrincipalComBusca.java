package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.*;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para a busca: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")) {
                    break;
            }
                try {
                    //Titulo meuTitulo = gson.fromJson(json, Titulo.class);

                    BuscaFilme buscaFilme = new BuscaFilme();
                    TituloOmdb meuTituloOmdb = buscaFilme.consultaFilme(busca);
                    System.out.println(meuTituloOmdb);


                    Titulo meuTitulo = new Titulo(meuTituloOmdb);
                    System.out.println("Titulo convertido");
                    System.out.println(meuTitulo);

                    titulos.add(meuTitulo);


                } catch (NumberFormatException e) {
                    System.out.println("Aconteceu um erro: ");
                    System.out.println(e.getMessage());

                } catch (IllegalArgumentException e) {
                    System.out.println("Algum erro no argumento da busca: ");
                    System.out.println(e.getMessage());

                } catch (ErroConversaoDeAnoException e) {
                    System.out.println(e.getMessage());

                }

            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(titulos);
            System.out.println("O programa finalizou corretamente!");

        }

    System.out.println("Finalizou corretamente");


        /*
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
         */
    }
}
