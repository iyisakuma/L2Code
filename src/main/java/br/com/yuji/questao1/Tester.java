package br.com.yuji.questao1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static br.com.yuji.questao1.Tradutor.Info.LARGURA;
import static br.com.yuji.questao1.Tradutor.Info.COMPRIMENTO;

public class Tester {

    private static Scanner input = new Scanner(System.in);
    private static List<String> dadosDeTeste = new ArrayList<>();

    public static void main(String[] args) {
        menu();
        while (true) {
            processaPrograma();
            if (!continua()) {
                break;
            }

        }
        terminaPrograma();
    }

    public static void menu() {
        System.out.println("------------------------INSTRUÇÃO PARA TESTE------------------------");
        System.out.println("-->Para dados de teste insira sempre pares de dados.\n" +
                "-->Onde a primeira linha contém os dados da sala e a segunda linha contém o log dos movimentos do rôbo.");
        System.out.println("--------------------------------------------------------------------");

    }

    public static void lerDadosParaTeste() {

    }

    public static void processaPrograma() {
        String primeiraLinha, segundaLinha;
        System.out.println("-->Dados para o teste: ");
        try {
            primeiraLinha = input.nextLine();
            //Guarda Informacao referente a largura e comprimento da sala
            int larguraDaSala = Tradutor.processa(primeiraLinha, LARGURA);
            int comprimentoDaSala = Tradutor.processa(primeiraLinha, COMPRIMENTO);
            var robo = new Robo(larguraDaSala, comprimentoDaSala);
            //Guarda Informacao das acoes
            segundaLinha = input.nextLine();
            robo.processaAcoes(segundaLinha.toCharArray());
            System.out.println("\nResultado:" + robo);
        } catch (Exception ex) {
            System.out.println("WARNING:Entradas de dados inválidos.");
            if (mostraErroLog()) {
                ex.printStackTrace();
            }
            terminaPrograma();
            System.exit(1);
        }
    }

    public static boolean continua() {
        System.out.println("-->Deseja inserir mais teste? 1.Sim 2.Não" +
                "\nAVISO: Entrada inválida irá fechar o programa.");
        return input.nextLine().equals("1");
    }

    public static boolean mostraErroLog() {
        System.out.println("-->Deseja mostrar log de erro? 1.Sim 2.Não");
        return input.nextLine().equals("1");
    }

    public static void terminaPrograma() {
        System.out.println("Finalizando o programa.");
        input.close();
    }
}
