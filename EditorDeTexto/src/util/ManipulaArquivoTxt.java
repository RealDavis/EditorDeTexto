package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManipulaArquivoTxt {

    /**
     * Método usado para gravar um texto em um arquivo
     *
     * @param nomeArquivo caminha e nome do arquivo que será gravado
     * @param conteudo texto que será gravado
     * @return booleano que informa se a operação foi bem sucedida
     * @throws IOException
     */
    public static boolean gravarArquivoTexto(String nomeArquivo, String conteudo) throws IOException {
        FileWriter fw = new FileWriter(nomeArquivo);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(conteudo);

        fw.close();
        pw.close();

        return true;
    }

    /**
     *Método usado para ler o arquivo de texto
     * @param nomeDoArquivo nome e caminho do arquivo que será lido
     * @return
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static String lerArquivoTxt(String nomeDoArquivo) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);

        String linha = br.readLine();
        String retorno = "";
        
        while (linha != null) {
            retorno += linha + "\n";
            linha = br.readLine();
        }

        fr.close();
        br.close();
        
        return retorno;
    }

}
