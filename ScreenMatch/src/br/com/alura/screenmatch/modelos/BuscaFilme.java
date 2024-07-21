package br.com.alura.screenmatch.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaFilme {
    public TituloOmdb consultaFilme(String nomeFilme) {
        URI endereco = URI.create("http://www.omdbapi.com/?t=" + nomeFilme.replace(" ", "+") + "&apikey=133c0443");

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), TituloOmdb.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter o filme a partir desse nome");
        }

    }
}
