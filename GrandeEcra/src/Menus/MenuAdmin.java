package Menus;

import static Funcoes.FuncoesAdmin.*;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAdmin {

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
                        estatisticasGeraisVendas();
                        break;
                    case 3:
                        receitaSala();
                        break;
                    case 4:
                        receitaFilme();
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
