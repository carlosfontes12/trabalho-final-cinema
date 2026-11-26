package Funcoes;

import static Funcoes.BibliotecaFicheiros.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncoesAdmin {

    /**
     * Autentica um administrador com base no nome de utilizador e senha
     * fornecidos.
     *
     *
     * @param username O nome de utilizador do administrador a ser autenticado.
     * @param password A senha do administrador a ser autenticada.
     * @return true se o administrador for autenticado com sucesso, false caso
     * contrário.
     * @throws FileNotFoundException Se o ficheiro de login do administrador não
     * for encontrado.
     */
    public static boolean autenticarAdmin(String username, String password) throws FileNotFoundException {

        File ficheiro = new File("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_AdminLogin.csv");
        Scanner sc = new Scanner(ficheiro);
        while (sc.hasNextLine()) {

            String linhaAtual = sc.nextLine();
            String[] linhaSeparada = linhaAtual.split(";");
            if (linhaSeparada[0].equals(username) && linhaSeparada[1].equals(password)) {
                sc.close();
                return true;
            }

        }
        sc.close();
        return false;
    }

    /**
     * funçao para consulta dos ficheiros
     *
     * @throws FileNotFoundException se o ficheiro não for encontrado
     */
    public static void consultaDosFicheiros() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        int op = -1;

        do {
            System.out.println("================== Consulta dos ficheiros ==================");
            System.out.println("1. GrandeEcra_AdminLogin.csv ");
            System.out.println("2. GrandeEcra_Bilhetes.csv ");
            System.out.println("3. GrandeEcra_Cartaz.txt");
            System.out.println("4. GrandeEcra_Copyright.txt");
            System.out.println("5. GrandeEcra_Filmes.csv");
            System.out.println("6. GrandeEcra_Quiz.csv");
            System.out.println("7. Sala_Mar.csv");
            System.out.println("8. Sala_Sol.csv");
            System.out.println("9. Sala_Terra.csv");
            System.out.println("0. Voltar...");

            try {
                System.out.print("Qual dos ficheiros pretende visualizar: ");
                op = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida, por favor insira um número!");
                input.next(); // limpar o buffer do scanner
                //-1 indica leitura inválida, para o switch não ser executado
                op = -1;
            }
            if (op != -1) {
                switch (op) {
                    case 1:
                        imprimirFicheiro("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_AdminLogin.csv");
                        break;
                    case 2:
                        imprimirFicheiro("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Bilhetes.csv");
                        break;
                    case 3:
                        imprimirFicheiro("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Cartaz.txt");
                        break;
                    case 4:
                        imprimirFicheiro("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Copyright.txt");
                        break;
                    case 5:
                        imprimirFicheiro("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Filmes.csv");
                        break;
                    case 6:
                        imprimirFicheiro("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Quiz.csv");
                        break;
                    case 7:
                        imprimirFicheiro("GrandeEcra/GrandeEcra_Ficheiros/Sala_Mar.csv");
                        break;
                    case 8:
                        imprimirFicheiro("GrandeEcra/GrandeEcra_Ficheiros/Sala_Sol.csv");
                        break;
                    case 9:
                        imprimirFicheiro("GrandeEcra/GrandeEcra_Ficheiros/Sala_Terra.csv");
                        break;
                    case 0:
                        System.out.println("A voltar...");
                        break;
                    default:
                        System.out.println("Opção inválida, " + op + "!");
                        break;
                }
            }
        } while (op != 0);
    }

    /**
     * Funçao estatisticas de venda
     *
     * @throws FileNotFoundException quando nao encontra o ficheiro
     */
    public static void estatisticasGeraisVendas() throws FileNotFoundException {

        if ((contarLinhasFicheiro("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Bilhetes.csv") - 1) == 0) {
            System.out.println("Total de bilhetes vendidos: 0");
            System.out.println("Receita total: 0€");
            System.out.println("Valor medio por bilhete: 0€");
        } else {
            System.out.println("Total de bilhetes vendidos:  " + (contarLinhasFicheiro("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Bilhetes.csv") - 1));
            System.out.println("Receita total: " + receitaTotal() + "€");
            System.out.println("Valor medio por bilhete: " + (receitaTotal() / (contarLinhasFicheiro("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Bilhetes.csv") - 1)) + " €");
        }
    }

    /**
     * funçao que dá o valor total da receita
     *
     * @return total da receita
     * @throws FileNotFoundException quando nao encontra o ficheiro
     */
    public static double receitaTotal() throws FileNotFoundException {

        double receitaTotal = 0;

        //ler o ficheiro
        File ficheiro = new File("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Bilhetes.csv");
        Scanner sc = new Scanner(ficheiro);

        //salta o cabeçalho
        sc.nextLine();

        // percorre o ficheiro e faz o somatorio do total
        while (sc.hasNextLine()) {

            String linhaAtual = sc.nextLine();
            String[] linhaSeparada = linhaAtual.split(";");
            receitaTotal += Double.parseDouble(linhaSeparada[10]);

        }
        sc.close();
        return receitaTotal;

    }

    /**
     * Função que mostra a receita por sala
     *
     * @throws FileNotFoundException caso nao encontre o ficheiro
     */
    public static void receitaSala() throws FileNotFoundException {

        double receitaMar = 0, receitaTerra = 0, receitaSol = 0;
        int contadorMar = 0, contadorTerra = 0, contadorSol = 0;

        //ler o ficheiro
        File ficheiro = new File("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Bilhetes.csv");
        Scanner sc = new Scanner(ficheiro);

        //salta o cabeçalho
        sc.nextLine();

        // percorre o ficheiro e faz o somatorio do total
        while (sc.hasNextLine()) {

            String linhaAtual = sc.nextLine();
            String[] linhaSeparada = linhaAtual.split(";");

            if (linhaSeparada[6].equals("Mar")) {
                receitaMar += Double.parseDouble(linhaSeparada[10]);
                contadorMar++;
            }
            if (linhaSeparada[6].equals("Sol")) {
                receitaSol += Double.parseDouble(linhaSeparada[10]);
                contadorSol++;
            }
            if (linhaSeparada[6].equals("Terra")) {
                receitaTerra += Double.parseDouble(linhaSeparada[10]);
                contadorTerra++;
            }

        }
        System.out.println("Sala Mar: " + receitaMar + "€" + " | Bilhetes: " + contadorMar);
        System.out.println("Sala Sol: " + receitaSol + "€" + " | Bilhetes: " + contadorSol);
        System.out.println("Sala Terra: " + receitaTerra + "€" + " | Bilhetes: " + contadorTerra);
        sc.close();
    }

    /**
     * Função que mostra a receita de um filme específico dado o seu título
     *
     * @throws FileNotFoundException caso nao encontre o ficheiro
     */
    public static void receitaFilme() throws FileNotFoundException {

        double receitaFilme = 0;
        int contadorFilme = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Qual o titulo do filme: ");
        String tituloFilme = input.nextLine();

        //ler o ficheiro
        File ficheiro = new File("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Bilhetes.csv");
        Scanner sc = new Scanner(ficheiro);

        //salta o cabeçalho
        sc.nextLine();

        // percorre o ficheiro e faz o somatorio do total
        while (sc.hasNextLine()) {

            String linhaAtual = sc.nextLine();
            String[] linhaSeparada = linhaAtual.split(";");
            if (linhaSeparada[5].equals(tituloFilme)) {
                receitaFilme += Double.parseDouble(linhaSeparada[10]);
                contadorFilme++;
            }

        }
        sc.close();
        if (contadorFilme == 0) {
            System.out.println("Não existe vendas para o filme " + tituloFilme);
        } else {
            System.out.println("Receita do filme " + tituloFilme + ": " + receitaFilme + "€" + " | Bilhetes: " + contadorFilme);
        }

    }

    /**
     * Mostra os top 3 filmes com maior receita
     * @throws FileNotFoundException
     */
    public static void topFilmes() throws FileNotFoundException {

        String[][] filmes = lerFicheiroParaMatriz("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Filmes.csv", ";");
        double[] receitas = new double[filmes.length];
        int bilhetes[] = new int[filmes.length];

        File ficheiro = new File("GrandeEcra/GrandeEcra_Ficheiros/GrandeEcra_Bilhetes.csv");
        Scanner sc = new Scanner(ficheiro);

        //salta o cabeçalho
        sc.nextLine();

        while (sc.hasNextLine()) {
            String linhaAtual = sc.nextLine();
            String[] linhaSeparada = linhaAtual.split(";");
            for (int i = 0; i < filmes.length; i++) {
                if (linhaSeparada[5].equals(filmes[i][1])) {
                    receitas[i] += Double.parseDouble(linhaSeparada[10]);
                    bilhetes[i]++;
                }
            }
        }
        sc.close();

        System.out.println("***** TOP 3 FILMES COM MAIOR RECEITA *****");
        for (int i = 0; i < 3; i++) {
            // começa a procura assumindo que o primeiro filme é o maior
            double maior = receitas[0];
            int posMaior = 0;

            for (int j = 1; j < filmes.length; j++) {
                if (receitas[j] > maior) {
                    maior = receitas[j];
                    posMaior = j;
                }
            }

            System.out.println("Filme: " + filmes[posMaior][1] + " | Bilhetes: " + bilhetes[posMaior] + " | Receita: " + receitas[posMaior] + " €");
            receitas[posMaior] = -1; // para não ser escolhido novamente
        }

    }

}
