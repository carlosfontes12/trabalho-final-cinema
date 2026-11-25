package PE_CarlosFontes;

import java.util.InputMismatchException;
import java.util.Scanner;



public class MenuInicial {

    /**
     * Exibe o menu inicial do sistema, permitindo ao utilizador escolher entre as
     * opções de ADMIN, CLIENTE ou SAIR.
     */
    public static void menuInicial() {

        Scanner input = new Scanner(System.in);

        // Inicializa a variável de opção do menu
        int op = -1;

        do {

            System.out.print("\n========== GRANDEECRA ==========\n");
            System.out.println("\nGrandes histórias merecem um grande ecrã.");
            System.out.println("\n1 - ADMIN");
            System.out.println("2 - CLIENTE");
            System.out.println("0 - SAIR ");

            System.out.println("\n===============================\n");

            // Solicita ao utilizador que escolha uma opção do menu
            // Tenta ler a opção do utilizador, tratando exceções caso a entrada não seja um número
            try {
                System.out.print("Escolha uma opção: ");
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
                        FuncoesAdmin.menuAdmin();
                        break;
                    case 2:
                        FuncoesCliente.menuCliente();
                        break;
                    case 0:
                        System.out.println("A sair...");
                        break;
                    default:
                        System.out.println("Opção inválida, " + op + "!");
                        break;
                }

            }
        } while (op != 0);

    }

    public static void main(String[] args) {
        menuInicial();
        

    }
}
