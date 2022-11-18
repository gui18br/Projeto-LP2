package main;

import java.util.Stack;
import java.io.IOException;
import java.util.Scanner;
import models.*;
import java.util.*;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static Locomotiva locomotivaR1;
    private static Locomotiva locomotivaR2;

    public static void main(String[] args) throws Exception {
        locomotivaR1 = new Locomotiva(1, "Parado no terminal", new Stack<Vagao>(), 0, new ArrayList<String>());
        locomotivaR2 = new Locomotiva(2, "Parado no terminal", new Stack<Vagao>(), 0, new ArrayList<String>());

        menu();
    }

    public static void menu() {
        System.out.println("----------------------------------------");
        System.out.println("          VAGÕES FERROVIÁRIOS           ");
        System.out.println("----------------------------------------\n");
        System.out.println("*********** Selecione uma opção ***********");
        System.out.println("  |      Opcao 1 - Terminal R1       |  ");
        System.out.println("  |      Opcao 2 - Terminal R2       |  ");
        System.out.println("  |      Opcao 3 - Vagões            |  ");
        System.out.println("  |      Opcao 4 - Sair              |  ");

        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                terminalMenu(opcao);
                break;
            case 2:
                terminalMenu(opcao);
                break;
            case 3:
                vagoesMenu();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    public static void terminalMenu(int terminal) {
        System.out.println("\n\n**************** Selecione uma opção ****************");
        System.out.println("1 - Alterar status para: Parado no terminal ");
        System.out.println("2 - Alterar status para: Em movimento ");
        System.out.println("3 - Alterar status para: No ponto de interconexão");
        System.out.println("4 - Consultar quantidade de desembarques");
        System.out.println("5 - Listar vagões");
        int opcao = entrada.nextInt();

        if (terminal == 1) {
            switch (opcao) {
                case 1:
                    locomotivaR1.setStatus("Parado no terminal");
                    break;
                case 2:
                    locomotivaR1.setStatus("Em movimento");
                    break;
                case 3:
                    locomotivaR1.setStatus("No ponto de interconexão");
                    break;
                case 4:
                    System.out.println(
                            "Neste terminal foram feitos  desembarque(s) de "+ locomotivaR1.listarDesembarques() +
                                    " totalizando " + locomotivaR1.getQtdDesembarques() + ", desembarque(s)");
                    break;
                case 5:
                    System.out.println(locomotivaR1.getVagoesPilha());
                    break;
            }
        }

        if (terminal == 2) {
            switch (opcao) {
                case 1:
                    locomotivaR2.setStatus("Parado no terminal");
                    break;
                case 2:
                    locomotivaR2.setStatus("Em movimento");
                    break;
                case 3:
                    locomotivaR2.setStatus("No ponto de interconexão");
                    break;
                case 4:
                    System.out.println(
                            "Neste terminal foram feitos  desembarque(s) de "+ locomotivaR2.listarDesembarques() +
                                    ", totalizando " + locomotivaR2.getQtdDesembarques() + " desembarque(s)");
                    break;
                case 5:
                    System.out.println(locomotivaR2.getVagoesPilha());
                    break;
            }
        }
        menu();
    }

    public static void vagoesMenu() {
        System.out.println("\n\n**************** Selecione uma opção ****************");
        System.out.println("1 - Embarcar produto em vagão ");
        System.out.println("2 - Desembarcar produto de um vagão");
        System.out.println("3 - Transferir vagão");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1: {
                System.out.println("Adicionar à terminal R1 ou R2? (Digite 1 ou 2)");
                int terminalInput = entrada.nextInt();

                switch (terminalInput) {
                    case 1:
                        addVagao(terminalInput);
                        break;
                    case 2:
                        addVagao(terminalInput);
                        break;
                }
                break;
            }
            case 2: {
                System.out.println("Informe o identificador do vagão que você deseja remover (Letra de a-z)");
                char indexVagao = entrada.next().charAt(0);
                char indexVagaoUpperCase = Character.toUpperCase(indexVagao);

                if (!(locomotivaR1.getVagoesPilha().isEmpty()) &&
                        locomotivaR1.getVagoesPilha().peek().getIndexVagao() == indexVagaoUpperCase) {
                    removerVagao(locomotivaR1.getVia());
                } else if(!(locomotivaR2.getVagoesPilha().isEmpty() )&&
                        locomotivaR2.getVagoesPilha().peek().getIndexVagao() == indexVagaoUpperCase){
                    removerVagao(locomotivaR2.getVia());
                } else {
                    System.out.println("O identificador não se encontra na ponta de nenhum dos terminais");
                    menu();
                }
                break;
            }

            case 3: {
                System.out.println("Transferir vagão do terminal R1 ou R2? (Digite 1 ou 2)");
                int terminalInput = entrada.nextInt();

                switch (terminalInput) {
                    case 1:
                        transferVagao(terminalInput);
                        break;
                    case 2:
                        transferVagao(terminalInput);
                        break;
                }
                break;
            }
        }
    }

    public static void addVagao(int indexTerminal) {
        System.out.println("Identificador do vagão (Digite uma letra de a-z)");
        char indexVagao = entrada.next().charAt(0);
        char indexVagaoUpperCase = Character.toUpperCase(indexVagao);
        System.out.println("Tipo de carga (digite 1 para Minério ou 2 para grão)");
        int tipoCarga = entrada.nextInt();
        System.out.println("Digite o nome da carga (cobre, ferro, soja, etc)");
        String nomeCarga = entrada.next();
        System.out.println("Digite o peso da carga em kilogramas");
        double qtd = entrada.nextDouble();

        Vagao v = new Vagao(indexVagaoUpperCase, tipoCarga, nomeCarga, qtd);

        if (indexTerminal == 1) {
            for (int i = 0; i < locomotivaR1.getVagoesPilha().size(); i++) {
                if (locomotivaR1.getVagoesPilha().get(i).getIndexVagao() == indexVagaoUpperCase) {
                    System.out.println("Este identificador já foi utilizado");
                    System.exit(0);
                }
            }
            if (!(tipoCarga == 1)) {
                System.out.println("O terminal R1 só aceita cargas do tipo minério");
                System.exit(0);
            }
            if (locomotivaR1.getStatus() == "Parado no terminal") {
                if (locomotivaR1.isEmpilhavel() == true) {
                    locomotivaR1.getVagoesPilha().push(v);
                } else {
                    System.out.println(
                            "Essa locomotiva não pode receber um vagão no momento pois sua posição é: "
                                    + locomotivaR1.getStatus());
                    System.exit(0);
                }
            } else {
                System.out.println("A locomotiva não se encontra parada no terminal.");
                System.exit(0);
            }

        }

        if (indexTerminal == 2) {
            for (int i = 0; i < locomotivaR2.getVagoesPilha().size(); i++) {
                if (locomotivaR2.getVagoesPilha().get(i).getIndexVagao() == indexVagaoUpperCase) {
                    System.out.println("Este identificador já foi utilizado");
                    System.exit(0);
                }
            }
            if (!(tipoCarga == 2)) {
                System.out.println("O terminal R2 só aceita cargas do tipo grãos");
                System.exit(0);
            }
            if (locomotivaR2.getStatus() == "Parado no terminal") {
                if (locomotivaR2.isEmpilhavel() == true) {
                    locomotivaR2.getVagoesPilha().push(v);
                } else {
                    System.out.println(
                            "Essa locomotiva não pode receber um vagão no momento pois sua posição é: "
                                    + locomotivaR2.getStatus());
                    System.exit(0);
                }
            } else {
                System.out.println("A locomotiva não se encontra parada no terminal.");
                System.exit(0);
            }

        }
        menu();
    }

    public static void removerVagao(int indexTerminal) {
        if (indexTerminal == 1) {
            if (locomotivaR1.getStatus() == "Parado no terminal") {
                if (locomotivaR1.getVagoesPilha().isEmpty() == false) {
                    System.out
                            .println("O vagão de identificador '" + locomotivaR1.getVagoesPilha().peek().getIndexVagao() +
                                    "' foi removido da ponta do terminal "+ indexTerminal);
                    locomotivaR1.addDesembarques(locomotivaR1.getVagoesPilha().peek().getNomeCarga());
                    locomotivaR1.getVagoesPilha().pop();
                    locomotivaR1.setQtdDesembarques(locomotivaR1.getQtdDesembarques()+1);

                } else {
                    System.out.println("A locomotiva não tem vagões com produtos");
                    System.exit(0);
                }
            } else {
                System.out.println("A locomotiva não se encontra parada no terminal.");
                System.exit(0);
            }

        }

        if (indexTerminal == 2) {
            if (locomotivaR2.getStatus() == "Parado no terminal") {
                if (locomotivaR2.getVagoesPilha().isEmpty() == false) {
                    System.out
                            .println("O vagão de identificador '" + locomotivaR2.getVagoesPilha().peek().getIndexVagao() +
                                    "' foi removido do terminal "+indexTerminal);
                    locomotivaR2.addDesembarques(locomotivaR2.getVagoesPilha().peek().getNomeCarga());
                    locomotivaR2.getVagoesPilha().pop();
                    locomotivaR2.setQtdDesembarques(locomotivaR2.getQtdDesembarques()+1);
                } else {
                    System.out.println("A locomotiva não tem vagões com produtos");
                    System.exit(0);
                }
            } else {
                System.out.println("A locomotiva não se encontra parada no terminal.");
                System.exit(0);
            }

        }
        menu();
    }

    public static void transferVagao(int indexTerminal) {
        if ((locomotivaR1.getStatus() == "No ponto de interconexão")
                && (locomotivaR2.getStatus() == "No ponto de interconexão")) {
            if (indexTerminal == 1) {
                char indexVagao = locomotivaR1.getVagoesPilha().peek().getIndexVagao();
                int tipoCarga = locomotivaR1.getVagoesPilha().peek().getTipoCarga();
                String nomeCarga = locomotivaR1.getVagoesPilha().peek().getNomeCarga();
                double qtd = locomotivaR1.getVagoesPilha().peek().getQtd();

                Vagao v = new Vagao(indexVagao, tipoCarga, nomeCarga, qtd);

                locomotivaR2.getVagoesPilha().push(v);
                locomotivaR1.getVagoesPilha().pop();

                System.out.println("Foi transferido um vagão da locomotiva R1 para a locomotiva R2");
            }

            if (indexTerminal == 2) {
                char indexVagao = locomotivaR2.getVagoesPilha().peek().getIndexVagao();
                int tipoCarga = locomotivaR2.getVagoesPilha().peek().getTipoCarga();
                String nomeCarga = locomotivaR2.getVagoesPilha().peek().getNomeCarga();
                double qtd = locomotivaR2.getVagoesPilha().peek().getQtd();

                Vagao v = new Vagao(indexVagao, tipoCarga, nomeCarga, qtd);

                locomotivaR1.getVagoesPilha().push(v);
                locomotivaR2.getVagoesPilha().pop();

                System.out.println("Foi transferido um vagão da locomotiva R2 para a locomotiva R1");
            }
        } else {
            System.out.println("Uma ou mais locomotivas não se encontram no ponto de interconexão");
        }
        menu();
    }

    // public static void clearConsole() {
    // if (System.getProperty("os.name").contains("Windows"))
    // try {
    // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // else
    // try {
    // Runtime.getRuntime().exec("clear");
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

}