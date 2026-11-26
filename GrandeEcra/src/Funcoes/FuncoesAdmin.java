package Funcoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static Funcoes.BibliotecaFicheiros.imprimirFicheiro;

public class FuncoesAdmin {

    /**
     * Autentica um administrador com base no nome de utilizador e senha
     * fornecidos.
     *
     * @param username O nome de utilizador do administrador a ser autenticado.
     * @param password A senha do administrador a ser autenticada.
     * @return true se o administrador for autenticado com sucesso, false caso
     * contrário.
     * @throws FileNotFoundException Se o ficheiro de login do administrador não
     * for encontrado.
     */
    public static boolean autenticarAdmin(String username, String password) throws FileNotFoundException {

        File ficheiro = new File("GrandeEcra_Ficheiros/GrandeEcra_AdminLogin.csv");
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


    /** funçao par consulta dos ficheiros
     *
     * @throws FileNotFoundException se o ficheiro não for encontrado
     */
    public static void consultaDosFicheiros () throws  FileNotFoundException{
        Scanner input = new Scanner(System.in);

        int op =-1;

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
                case 1: imprimirFicheiro("GrandeEcra_Ficheiros/GrandeEcra_AdminLogin.csv");
                    break;
                case 2: imprimirFicheiro("GrandeEcra_Ficheiros/GrandeEcra_Bilhetes.csv");
                    break;
                case 3: imprimirFicheiro("GrandeEcra_Ficheiros/GrandeEcra_Cartaz.txt");
                    break;
                case 4:imprimirFicheiro("GrandeEcra_Ficheiros/GrandeEcra_Copyright.txt");
                    break;
                case 5: imprimirFicheiro("GrandeEcra_Ficheiros/GrandeEcra_Filmes.csv");
                    break;
                case 6: imprimirFicheiro("GrandeEcra_Ficheiros/GrandeEcra_Quiz.csv");
                    break;
                case 7: imprimirFicheiro("GrandeEcra_Ficheiros/Sala_Mar.csv");
                    break;
                case 8: imprimirFicheiro("GrandeEcra_Ficheiros/Sala_Mar.csv");
                    break;
                case 9: imprimirFicheiro("GrandeEcra_Ficheiros/Sala_Terra.csv");
                    break;
                case 0:
                    System.out.println("A voltar...");
                    break;
                default:
                    System.out.println("Opção inválida, " + op + "!");
                    break;
            }
                }
        }while(op!=0);
    }






    /**
     * Exibe o menu do administrador, permitindo ao utilizador escolher entre
     * várias opções
     */


        public static void menuAdmin() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        int op = -1;

        do {
            System.out.println("\n========== MENU ADMIN ==========\n");
            System.out.println("1 - Consultar ficheiros");
            System.out.println("2 - Estatísticas gerais de vendas");
            System.out.println("3 - Receita por sala");
            System.out.println("4 - Receita por filme");
            System.out.println("5 - Top 3 filmes com maior receita");
            System.out.println("6 - Resetar lotação de uma sala");
            System.out.println("0 - Voltar");
            try {
                System.out.print("\nEscolha uma opção: ");
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
                        consultaDosFicheiros();
                        break;
                    case 2:
                        // Chamar função para estatísticas gerais de venda
                        break;
                    case 3:
                        // Chamar função para receita por sala
                        break;
                    case 4:
                        // Chamar função para receita por filme
                        break;
                    case 5:
                        // Chamar função para top 3 filmes com maior receita
                        break;
                    case 6:
                        // Chamar função para resetar lotação de uma sala
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


}
