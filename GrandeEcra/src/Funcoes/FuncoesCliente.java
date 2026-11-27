package Funcoes;

import java.io.File;
import java.io.FileNotFoundException;
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

    
    /** Função para pesquisar filmes por género
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
                    System.out.println("Titulo: " + linhaSeparada[1] + " | Realizador: " + linhaSeparada[3] + " |"  + "Ano: " + linhaSeparada[4] + "| " + "Duração: " + linhaSeparada[5] + " |"  + "Idade Minima: " + linhaSeparada[6] + " | " + "Classificação: " + linhaSeparada[7]);
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
}
