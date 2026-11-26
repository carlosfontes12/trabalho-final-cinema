package Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Funcoes.FuncoesCliente.consultarCartaz;

public class MenuCliente {

    /**
     * Exibe o menu do cliente, permitindo ao utilizador escolher entre várias opções relacionadas com filmes e reservas.
     */

    public static void menuCliente() {

        Scanner input = new Scanner(System.in);

        int op = -1;

        do {
            System.out.println("\n========== MENU CLIENTE ==========\n");
            System.out.println("1 - Novo Registo");
            System.out.println("2 - Consultar cartaz cinematográfico");
            System.out.println("3 - Pesquisar filmes");
            System.out.println("4 - Visualizar mapa de uma sala");
            System.out.println("5 - Reservar bilhetes");
            System.out.println("6 - Recomendar filmes");
            System.out.println("7 - Quiz cinematográfico");
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
                        // Chamar função para novo registo
                        break;
                    case 2:
                        consultarCartaz();
                        break;
                    case 3:
                        // Chamar função para pesquisar filmes
                        break;
                    case 4:
                        // Chamar função para visualizar mapa de uma sala
                        break;
                    case 5:
                        // Chamar função para reservar bilhetes
                        break;
                    case 6:
                        // Chamar função para recomendar filmes
                        break;
                    case 7:
                        // Chamar função para quiz cinematográfico
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
