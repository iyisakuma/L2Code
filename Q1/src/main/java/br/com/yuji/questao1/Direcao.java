package br.com.yuji.questao1;

public enum Direcao {
    NORTE('N'), SUL('S'), OESTE('O'), LESTE('L');

    private final char sigla;

    Direcao(char sigla){
        this.sigla = sigla;
    }

    public char getSigla(){
        return sigla;
    }
}
