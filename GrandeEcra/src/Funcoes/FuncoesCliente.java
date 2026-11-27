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

        Scanner input = new Scanner(System.in);

        int sala = -1;

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

        String caminhoFicheiro = "";
        String nomeSala = "";
        double contadorLugaresOcupados = 0;
        double contadorLugaresLivres = 0;

        if (sala == 1) {
            caminhoFicheiro = "GrandeEcra/GrandeEcra_Ficheiros/Sala_Mar.csv";
            nomeSala = "Mar";
        } else if (sala == 2) {
            caminhoFicheiro = "GrandeEcra/GrandeEcra_Ficheiros/Sala_Terra.csv";
            nomeSala = "Terra";
        } else if (sala == 3) {
            caminhoFicheiro = "GrandeEcra/GrandeEcra_Ficheiros/Sala_Sol.csv";
            nomeSala = "Sol";
        }
        try {
            String[][] matrizSala = lerFicheiroParaMatrizSemCabecalho(caminhoFicheiro, ";");
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
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um erro: ficheiro não encontrado");
        }

    }

}
