package Funcoes;

import static Funcoes.BibliotecaFicheiros.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncoesCliente {

    /**
     * funçao para consultar cartaz
     *
     */
    public static void consultarCartaz() {
        File ficheiro = new File("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Cartaz.txt");
        try {
            Scanner sc = new Scanner(ficheiro);

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                System.out.println(linha);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um erro: ficheiro não encontrado");
        }
    }

    /**
     * Funçao para criar novo registo
     */
    public static void novoRegisto() {

        Scanner input = new Scanner(System.in);

        String nome;
        String email;
        String contacto;

        System.out.print("Introduza o nome: ");
        nome = input.nextLine();
        System.out.print("Introduza o email: ");
        email = input.nextLine();
        System.out.print("Introduza o contacto: ");
        contacto = input.nextLine();

        System.out.println("Cliente inserido com sucesso");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Contacto: " + contacto);

    }

    /**
     * Função para pesquisar filmes por género
     *
     */
    public static void pesquisarFilme() {

        Scanner input = new Scanner(System.in);

        System.out.print("Qual o genero que deseja pesquisar: ");
        String generoProcurado = input.nextLine();

        try {
            File ficheiro = new File("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Filmes.csv");
            Scanner sc = new Scanner(ficheiro);

            boolean encontrado = false;

            // avançar o cabeçalho do ficheiro
            sc.nextLine();

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] linhaSeparada = linha.split(";");
                if (linhaSeparada[2].equalsIgnoreCase(generoProcurado)) {
                    System.out.println("Titulo: " + linhaSeparada[1] + " | Realizador: " + linhaSeparada[3] + " |" + "Ano: " + linhaSeparada[4] + "| " + "Duração: " + linhaSeparada[5] + " |" + "Idade Minima: " + linhaSeparada[6] + " | " + "Classificação: " + linhaSeparada[7]);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Não foram encontrados filmes para o género: " + generoProcurado);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um erro: ficheiro não encontrado");
        }
    }

    /**
     * Função para visualizar o mapa de uma sala
     *
     * @return void
     */
    public static void visualizarMapaSala() {

        try {
            String nomeSala = escolherSala();
            String caminhoFicheiro = "GrandeEcra/GrandeEcra_Ficheiros/Sala_" + nomeSala + ".csv";

            String[][] matrizSala = lerFicheiroParaMatrizSemCabecalho(caminhoFicheiro, ";");
            mostrarMapa(nomeSala, matrizSala);
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um erro: ficheiro não encontrado");
        }

    }

    /**
     * Escolhe uma sala de cinema entre as opções disponíveis.
     *
     * @return nome da sala escolhida (Mar, Terra ou Sol)
     */
    public static String escolherSala() {

        Scanner input = new Scanner(System.in);

        int sala = -1;
        String nomeSala = "";

        do {
            System.out.println("\n1 - Sala Mar");
            System.out.println("2 - Sala Terra");
            System.out.println("3 - Sala Sol");

            System.out.print("Escolha a sala: ");
            try {
                sala = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção invalida, insira um número.");
                input.nextLine(); // limpar o buffer do scanner
                sala = -1;
            }
        } while (sala < 1 || sala > 3);

        switch (sala) {
            case 1:
                nomeSala = "Mar";
                break;
            case 2:
                nomeSala = "Terra";
                break;
            case 3:
                nomeSala = "Sol";
                break;
        }
        return nomeSala;
    }

    /**
     * Mostra o mapa da sala de cinema e retorna o número de lugares livres.
     *
     * @param nomeSala nome da sala de cinema (Mar, Terra ou Sol)
     * @param matrizSala matriz que representa os lugares da sala (1 - ocupado,
     * 0 - livre)
     * @return número de lugares livres na sala
     */
    public static int mostrarMapa(String nomeSala, String[][] matrizSala) {

        int contadorLugaresOcupados = 0;
        int contadorLugaresLivres = 0;

        System.out.println("\nSala " + nomeSala + ":");
        System.out.println("Ecra");
        System.out.println("=============");
        System.out.println(" ");

        // Letras das filas da sala
        String[] linhaSala = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

        System.out.print("  "); // Espaço para alinhar com as letras das filas
        // Imprimir números das colunas da sala
        for (int i = 0; i < matrizSala[0].length; i++) {
            System.out.print(" " + (i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < matrizSala.length; i++) {
            System.out.print(linhaSala[i] + " ");
            for (int j = 0; j < matrizSala[i].length; j++) {
                if (matrizSala[i][j].equals("1")) {
                    System.out.print(" X ");
                    contadorLugaresOcupados++;
                } else {
                    System.out.print(" O ");
                    contadorLugaresLivres++;
                }
            }
            System.out.println(); // muda de linha no fim de cada fila
        }

        // estatísticas: dentro do try, mas fora dos dois for (correm uma só vez)
        System.out.println();
        double totalLugares = contadorLugaresOcupados + contadorLugaresLivres;
        double taxaOcupacao = (contadorLugaresOcupados / totalLugares) * 100;

        System.out.println("O - Disponível | X - Ocupado");
        System.out.println("Lotação: " + totalLugares + " | Disponiveis: " + contadorLugaresLivres + " | Ocupados: " + contadorLugaresOcupados);
        System.out.println("Taxa de ocupação: " + taxaOcupacao + "%");

        return contadorLugaresLivres;

    }

    public static void reservarBilhetes() {

        String[] linhaSala = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

        Scanner sc = new Scanner(System.in);
        int quantidadeBilhetes = 0;

        String nomeSala = escolherSala();
        String caminhoFicheiro = "GrandeEcra/GrandeEcra_Ficheiros/Sala_" + nomeSala + ".csv";

        try {
            // ler a sala e mostrar o mapa
            String[][] matrizSala = lerFicheiroParaMatrizSemCabecalho(caminhoFicheiro, ";");
            int livres = mostrarMapa(nomeSala, matrizSala);

            if (livres == 0) {
                // sala cheia: informar e regressar ao menu
                System.out.println("Não há lugares disponíveis na sala " + nomeSala);
            } else {
                System.out.println("Há " + livres + " lugares disponíveis na sala " + nomeSala);

                // pedir a quantidade
                do {
                    System.out.print("Quantidade de bilhetes: ");
                    try {
                        quantidadeBilhetes = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Insira um número válido.");
                        sc.nextLine(); // limpar o buffer do scanner
                        quantidadeBilhetes = -1;

                    }
                } while (quantidadeBilhetes < 1 || quantidadeBilhetes > livres);

                // pedir a fila para cada bilhete
                for (int i = 0; i < quantidadeBilhetes; i++) {

                    System.out.println("Bilhete: " + (i + 1));
                    System.out.print("Introduza a fila: ");
                    String fila = sc.next();

                    int posicaoFila = -1;
                    // verificar se a fila introduzida é válida
                    for (int j = 0; j < linhaSala.length; j++) {
                        if (linhaSala[j].equals(fila)) {
                            posicaoFila = j;
                        }
                    }
                    if (posicaoFila == -1) {
                        System.out.println("Fila inválida: " + fila);
                    } else {
                        System.out.println("Fila válida: " + linhaSala[posicaoFila]);
                    }

                    System.out.print("Introduza o lugar: ");
                    int lugar = sc.nextInt();

                }
            
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Ficheiro da sala não encontrado.");
        }

    }
}
