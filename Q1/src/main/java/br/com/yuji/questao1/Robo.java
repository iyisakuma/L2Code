package br.com.yuji.questao1;

public class Robo {

    private int posicaoX = 0;
    private int posicaoY = 0;
    private Direcao direcao = Direcao.NORTE;
    private Sala sala;

    public Robo(int larguraDaSala, int comprimentoDaSala){
        sala = new Sala(larguraDaSala, comprimentoDaSala);
    }

    public void processaAcoes(char[] acoes){
        for(char acao : acoes){
            switch (acao){
                case 'F':
                    umPassoParaFrente();
                    break;
                case 'T':
                    umPassoParaTras();
                    break;
                case 'E':
                    giraParaEsquerda();
                    break;
                case 'D':
                    giraParaDireita();
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%c %d %d", direcao.getSigla(), posicaoX, posicaoY);
    }

    /*
            Métodos privados
        */
    private void umPassoParaFrente() {
        switch (this.direcao) {
            case NORTE:
                if (posicaoY <= sala.getComprimento()) {
                    posicaoY++;
                }
                break;
            case SUL:
                if (posicaoY > 0) {
                    posicaoY--;
                }
                break;
            case OESTE:
                if (posicaoX > 0) {
                    posicaoX--;
                }
                break;
            case LESTE:
                if (posicaoX <= sala.getLargura()) {
                    posicaoX++;
                }
                break;
        }
    }
    private void umPassoParaTras(){
        switch (this.direcao) {
            case SUL:
                if (posicaoY <= sala.getComprimento()) {
                    posicaoY++;
                }
                break;
            case NORTE:
                if (posicaoY > 0) {
                    posicaoY--;
                }
                break;
            case LESTE:
                if (posicaoX > 0) {
                    posicaoX--;
                }
                break;
            case OESTE:
                if (posicaoX <= sala.getLargura()) {
                    posicaoX++;
                }
                break;
        }
    }
    private void giraParaDireita(){
        switch (direcao) {
            case NORTE :
                direcao = Direcao.LESTE;
                break;
            case SUL:
                direcao = Direcao.OESTE;
                break;
            case OESTE:
                direcao = Direcao.NORTE;
                break;
            case LESTE:
                direcao = Direcao.SUL;
                break;
        }
    }
    private void giraParaEsquerda(){
        switch (direcao) {
            case NORTE :
                direcao = Direcao.OESTE;
                break;
            case SUL:
                direcao = Direcao.LESTE;
                break;
            case OESTE:
                direcao = Direcao.SUL;
                break;
            case LESTE:
                direcao = Direcao.NORTE;
                break;
        }
    }
}
