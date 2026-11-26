package Funcoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncoesCliente {


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
}
