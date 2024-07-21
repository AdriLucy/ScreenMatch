package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Shrek",2003);
        meuFilme.setDuracaoEmMinutos(110);

        meuFilme.avalia(9);
        meuFilme.avalia(9);
        meuFilme.avalia(10);

        meuFilme.exibeFichaTecnica();

        //Segundo filme
        Filme segundoFilme = new Filme("Shrek 2",2005);
        segundoFilme.setDuracaoEmMinutos(130);

        segundoFilme.avalia(8);
        segundoFilme.avalia(9);
        segundoFilme.avalia(10);

        segundoFilme.exibeFichaTecnica();

        //Terceiro filme
        Filme terceiroFilme = new Filme("Shrek 3",2007);
        terceiroFilme.setDuracaoEmMinutos(120);

        terceiroFilme.avalia(8);
        terceiroFilme.avalia(7);
        terceiroFilme.avalia(10);

        terceiroFilme.exibeFichaTecnica();


        //Serie Lost
        Serie lost = new Serie("Lost",2005);
        lost.setTemporadas(5);
        lost.setEpisodiosPorTemporada(24);
        lost.setMinutosPorEpisodio(54);
        lost.avalia(9);
        //System.out.println("Duração total da serie: " + lost.getDuracaoEmMinutos());

        lost.exibeFichaTecnica();


        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        //calculadora.inclui(meuFilme);
        //calculadora.inclui(lost);
        //System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        //filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacao(300);
        //filtro.filtra(episodio);

        ArrayList<Filme> ListaDeFilmes = new ArrayList<>();
        ListaDeFilmes.add(meuFilme);
        ListaDeFilmes.add(segundoFilme);
        ListaDeFilmes.add(terceiroFilme);
        System.out.println("Tamanho da lista: " + ListaDeFilmes.size());
        //System.out.println("Primeiro filme: " + ListaDeFilmes.get(0).getNome());
        System.out.println(ListaDeFilmes);



    }
}