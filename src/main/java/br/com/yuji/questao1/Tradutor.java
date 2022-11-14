package br.com.yuji.questao1;

/*
* Classe responsável por pegar a informacao da primeira linha de entrada
* e extrair o tamanho da largura ou comprimento. Poderia ter feito na classe
* Tester, porém decidi dividir para ficar bem organizado ^^
* */
public class Tradutor {
    enum Info {
        LARGURA(), COMPRIMENTO();
    }

    public static int processa(String primeiraLinha, Info info){
        String[] informacoes = primeiraLinha.split(" ");
        return Integer.valueOf(informacoes[info.ordinal()]);
    }
}
