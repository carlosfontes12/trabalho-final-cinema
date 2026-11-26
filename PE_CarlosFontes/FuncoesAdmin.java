package PE_CarlosFontes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

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

        File ficheiro = new File("PE_CarlosFontes/GrandeEcra_Ficheiros/GrandeEcra_AdminLogin.csv");
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
     * Exibe o menu do administrador, permitindo ao utilizador escolher entre
     * várias opções
     */
    public static void menuAdmin() {
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
                        // Chamar função para consultar ficheiros
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
