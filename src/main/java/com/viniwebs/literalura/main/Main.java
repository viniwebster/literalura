package com.viniwebs.literalura.main;

import com.viniwebs.literalura.model.Autor;
import com.viniwebs.literalura.model.Livro;
import com.viniwebs.literalura.model.Dados;
import com.viniwebs.literalura.repository.AutorRepository;
import com.viniwebs.literalura.repository.LivroRepository;
import com.viniwebs.literalura.service.Api;
import com.viniwebs.literalura.service.ConvertsData;

import java.util.*;

public class Main {
    private final Scanner sc = new Scanner(System.in);
    private static final String URL = "https://gutendex.com/books/?search=";
    private Api api = new Api();

    private final ConvertsData convertsData = new ConvertsData();
    private final List<Livro> livros = new ArrayList<>();

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public Main(LivroRepository livroService, AutorRepository autorService) {
        this.livroRepository = livroService;
        this.autorRepository = autorService;
    }

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
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarPorIdioma();
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
        try {
            System.out.print("Insira o titulo do livro: ");
            String titulo = sc.nextLine();
            String json = api.obterDados(URL + titulo.replace(" ", "%20"));
            Dados dados = convertsData.getData(json , Dados.class);

            Livro livro = new Livro(dados.results().get(0));

            livroRepository.save(livro);
            System.out.println(livro);
            livros.add(livro);
        } catch (Exception e) {
            System.out.println("Erro ao buscar livro");
        }
    }

    private void listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        System.out.println("--------------Livros----------------");
        livros.forEach(System.out::println);
    }

    private void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        Set<Autor> autoresUnicos = new HashSet<>(autores);
        System.out.println("--------------Autores----------------");
        autoresUnicos.forEach(System.out::println);
    }

    private void listarPorIdioma() {
        var opção = -1;
        String idioma = "";

        System.out.println("\nSelecione o idioma do livro: ");
        var menu = """
               \n
               1 - Ingles
               2 - Frances
               3 - Alemao
               4 - Portugues
               5 - Espanhol
               """;

        System.out.println(menu);

        if (sc.hasNextInt()) {
            opção = sc.nextInt();
            sc.nextLine();

            switch (opção) {
                case 1:
                    idioma = "en";
                    break;
                case 2:
                    idioma = "fr";
                    break;
                case 3:
                    idioma = "de";
                    break;
                case 4:
                    idioma = "pt";
                    break;
                case 5:
                    idioma = "es";
                    break;
                default:
                    System.out.println("\nOpção invalida");
            }

            System.out.println("\nListando livros:");
            List<Livro> livros = livroRepository.findByIdiomaContaining(idioma);

            if (!livros.isEmpty()) {
                livros.forEach(System.out::println);
            } else {
                System.out.println("Nenhum resultado, selecione outro idioma");
            }

        } else {
            System.out.println("\nSelecione uma opçao valida");
            sc.next();
        }
    }

    private void listarAutoresVivos() {
        System.out.print("\nDigite o ano: ");
        int ano = sc.nextInt();
        List<Autor> autores = autorRepository.findAutoresVivos(ano);
        if (!autores.isEmpty()) {
            autores.forEach(System.out::println);
        } else  {
            System.out.println("\nNenhum autor vivo no ano informado");
        }
    }
}
