package Funcoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BibliotecaFicheiros {

    /**
     * contar colunas do ficheiro
     * @param caminho para o ficheiro
     * @param separador usado
     * @return
     * @throws FileNotFoundException quando nao encontra o ficheiro
     */

    public static int contarColunasFicheiro(String caminho, String separador) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        String cabecalho = sc.nextLine();
        String[] cabecalhoSeparado = cabecalho.split(separador);

        return cabecalhoSeparado.length;
    }


    /**
     * Função que lê o conteúdo de um ficheiro para uma matriz, excluindo cabeçalho
     *
     * @param caminho Caminho para o ficheiro
     * @return Matriz (String) c/ o conteúdo do ficheiro
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static String[][] lerFicheiroParaMatriz(String caminho, String separador) throws FileNotFoundException {

        int numeroLinhasFicheiro = contarLinhasFicheiro(caminho);
        int numeroColunasFicheiro = contarColunasFicheiro(caminho, separador);

        String[][] matrizMusicas = new String[numeroLinhasFicheiro - 1][numeroColunasFicheiro];

        // System.out.println("Linhas: "+matrizMusicas.length);
        // System.out.println("Colunas: "+matrizMusicas[0].length);

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        // Avançar cabeçalho
        sc.nextLine();

        int linhaPreencher = 0;

        while (sc.hasNextLine()) {
            String linhaAtual = sc.nextLine();
            String[] linhaSeparada = linhaAtual.split(separador);

            for (int i = 0; i < linhaSeparada.length; i++) {
                matrizMusicas[linhaPreencher][i] = linhaSeparada[i];
            }

            linhaPreencher++;
        }

        return matrizMusicas;
    }

    /**
     * Função que imprime uma matriz na consola
     *
     * @param matriz Matriz a ser impressa
     */
    public static void imprimirMatriz(String[][] matriz) {

        // Impressão da matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t | ");
            }
            System.out.println();
        }
    }


    /**
     * Função que imprime um ficheiro na consola
     *
     * @param caminho Caminho para o ficheiro a ser impresso (com extensão: .txt, .csv, etc)
     * @throws FileNotFoundException O ficheiro não existe
     */
    public static void imprimirFicheiro(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }
    }

    /**
     * Função que escreve, num ficheiro, algum conteúdo
     *
     * @param caminho  Caminho para o ficheiro a ser escrito
     * @param conteudo Conteúdo que queremos escrever
     * @throws FileNotFoundException Se o ficheiro existir apaga e escreve de novo | Se o ficheiro não existir, cria um novo
     */
    public static void escreverFicheiro(String caminho, String conteudo) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        PrintWriter pw = new PrintWriter(ficheiro);

        pw.println(conteudo);

        pw.close();
    }

    /**
     * Função que copia o conteúdo de um ficheiro para outro ficheiro
     *
     * @param caminhoOriginal Caminho do ficheiro original (que contém a informação)
     * @param caminhoCopia    Caminho do ficheiro cópia (onde queremos colocar a informação)
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static void copiarFicheiro(String caminhoOriginal, String caminhoCopia) throws FileNotFoundException {

        File ficheiroOriginal = new File(caminhoOriginal);
        Scanner sc = new Scanner(ficheiroOriginal);

        File ficheiroCopia = new File(caminhoCopia);
        PrintWriter pw = new PrintWriter(ficheiroCopia);

        while (sc.hasNextLine()) {
            String linhaAtual = sc.nextLine();
            pw.println(linhaAtual);
        }

        pw.close();

    }


    public static int somarNumerosFicheiro(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int total = 0;

        while (sc.hasNextInt()){
            int numeroAtual = sc.nextInt();
            total+=numeroAtual;
        }

        return total;

    }

    /**
     * funçao para contar linhas de um ficheiro
     * @param caminho do ficheiro
     * @return o numero de linhas do ficheiro
     * @throws FileNotFoundException quando nao encontra o ficheiro
     */

    public static int contarLinhasFicheiro(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int numeroLinhas=0;

        while (sc.hasNextLine()){
            numeroLinhas++;
            sc.nextLine();
        }

        return numeroLinhas;

    }

    public static int contarPalavrasFicheiro(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int numeroPalavras=0;

        while (sc.hasNext()){
            numeroPalavras++;
            sc.next();
        }

        return numeroPalavras;

    }
}
