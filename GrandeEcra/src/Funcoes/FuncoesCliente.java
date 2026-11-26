package Funcoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncoesCliente {

    /** funçao para consultar cartaz
     *
     */
    public static void consultarCartaz(){
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
    public static void novoRegisto(){

        Scanner input = new Scanner(System.in);

        String nome;
        String email;
        int contacto;

        System.out.print("Introduza o nome: ");
        nome = input.nextLine();
        System.out.print("Introduza o email: ");
        email = input.nextLine();
        System.out.print("Introduza o contacto: ");
        contacto = input.nextInt();


        System.out.println("Cliente inserido com sucesso");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Contacto: " + contacto);

    }
}
