package com.viniwebs.literalura.main;

import com.viniwebs.literalura.model.Livro;
import com.viniwebs.literalura.model.Dados;
import com.viniwebs.literalura.service.Api;
import com.viniwebs.literalura.service.ConvertsData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner sc = new Scanner(System.in);
    private static final String URL = "https://gutendex.com/books/?search=";
    private Api api = new Api();

    private final ConvertsData convertsData = new ConvertsData();
    private final List<Livro> livros = new ArrayList<>();

    public void menu() {
        int opcao = -1;

        while(opcao != 0) {
            String menu = """
                    1 - Buscar livro por titulo
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em determinado ano
                    5 - Listar livros em um determinado idioma
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Selecione uma opção valida");
                    break;
            }
        }
    }

    private void buscarLivro() {
        System.out.print("Insira o titulo do livro: ");
        String titulo = sc.nextLine();
        String json = api.obterDados(URL + titulo.replace(" ", "%20"));
        Dados dados = convertsData.getData(json , Dados.class);

        Livro livro = new Livro(dados.results().get(0));
        System.out.println(livro);
        livros.add(livro);
    }

    private void listarLivros() {
        livros.forEach(System.out::println);
    }
}
