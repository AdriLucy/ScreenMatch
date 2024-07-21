package br.com.alura.screenmatch.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivo {

    public void salvaJson(List<Titulo> titulos) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter("listaDeFilmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

    }

}
