package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Shrek",2001);
        meuFilme.avalia(10);
        Filme segundoFilme = new Filme("Shrek 2",2004);
        segundoFilme.avalia(9);
        Filme terceiroFilme = new Filme("Shrek 3",2007);
        terceiroFilme.avalia(8);
        Serie lost = new Serie("Lost",2004);
        lost.avalia(8.5);

        List<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(segundoFilme);
        lista.add(terceiroFilme);
        lista.add(lost);

        for (Titulo item:lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
            System.out.println("----------------");
        }

        /*ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jaqueline");
        buscaPorArtista.add("Morgana");

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);
        */
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }

}
