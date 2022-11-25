package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import models.Composicao;
import models.Vagao;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static Composicao composicaoR1;
    private static Composicao composicaoR2;

    public static void main(String[] args) throws Exception {
        composicaoR1 = new Composicao(1, "Parado no terminal", new LinkedList<Vagao>(), 0, new ArrayList<String>());
        composicaoR2 = new Composicao(2, "Parado no terminal", new LinkedList<Vagao>(), 0, new ArrayList<String>());

        menu();
    }

    public static void menu() {
        System.out.println("----------------------------------------");
        System.out.println("          VAGÕES FERROVI� RIOS           ");
        System.out.println("----------------------------------------\n");
        System.out.println("Status R1: " + composicaoR1.getStatus());
        System.out.println("Status R2: " + composicaoR2.getStatus()+"\n");
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
        System.out.println("6 - Retornar");
        int opcao = entrada.nextInt();

        if (terminal == 1) {
            switch (opcao) {
                case 1:
                    composicaoR1.setStatus("Parado no terminal");
                    break;
                case 2:
                    composicaoR1.setStatus("Em movimento");
                    break;
                case 3:
                    composicaoR1.setStatus("No ponto de interconexão");
                    break;
                case 4:
                    System.out.println(
                            "Neste terminal foram feitos  desembarque(s) de "+ composicaoR1.listarDesembarques() +
                                    " totalizando " + composicaoR1.getQtdDesembarques() + ", desembarque(s)");
                    break;
                case 5:
                    System.out.println(composicaoR1.getVagoesPilha());
                    break;
                case 6:
                menu();
                break;
            }
        }

        if (terminal == 2) {
            switch (opcao) {
                case 1:
                    composicaoR2.setStatus("Parado no terminal");
                    break;
                case 2:
                    composicaoR2.setStatus("Em movimento");
                    break;
                case 3:
                    composicaoR2.setStatus("No ponto de interconexão");
                    break;
                case 4:
                    System.out.println(
                            "Neste terminal foram feitos  desembarque(s) de "+ composicaoR2.listarDesembarques() +
                                    ", totalizando " + composicaoR2.getQtdDesembarques() + " desembarque(s)");
                    break;
                case 5:
                    System.out.println(composicaoR2.getVagoesPilha());
                    break;
                case 6:
                menu();
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
        System.out.println("4 - Retornar");
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

                if (!(composicaoR1.getVagoesPilha().isEmpty()) &&
                        composicaoR1.getVagoesPilha().peek().getIndexVagao() == indexVagaoUpperCase) {
                    removerVagao(composicaoR1.getVia());
                } else if(!(composicaoR2.getVagoesPilha().isEmpty() )&&
                        composicaoR2.getVagoesPilha().peek().getIndexVagao() == indexVagaoUpperCase){
                    removerVagao(composicaoR2.getVia());
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
            case 4: {
                menu();
                break;
            }
        }
    }

    public static void addVagao(int indexTerminal) {
        System.out.println("Identificador do vagão (Digite uma letra de a-z)");
        char indexVagao = entrada.next().charAt(0);
        char indexVagaoUpperCase = Character.toUpperCase(indexVagao);
        System.out.println("Digite o nome da carga (cobre, ferro, soja, etc)");
        String nomeCarga = entrada.next();
        System.out.println("Digite o peso da carga em kilogramas");
        double qtd = entrada.nextDouble();

        Vagao v = new Vagao(indexVagaoUpperCase, nomeCarga, qtd);

        if (indexTerminal == 1) {
            v.setTipoCarga(1);
            for (int i = 0; i < composicaoR1.getVagoesPilha().size(); i++) {
                if (composicaoR1.getVagoesPilha().get(i).getIndexVagao() == indexVagaoUpperCase) {
                    System.out.println("Este identificador já foi utilizado");
                    menu();
                }
            }
            if (composicaoR1.getStatus() == "Parado no terminal") {
                if (composicaoR1.isEmpilhavel() == true) {
                    composicaoR1.getVagoesPilha().push(v);
                } else {
                    System.out.println(
                            "Essa locomotiva não pode receber um vagão no momento pois sua posição é: "
                                    + composicaoR1.getStatus());
                    menu();
                }
            } else {
                System.out.println("A locomotiva não se encontra parada no terminal.");
                menu();
            }

        }

        if (indexTerminal == 2) {
            v.setTipoCarga(2);
            for (int i = 0; i < composicaoR2.getVagoesPilha().size(); i++) {
                if (composicaoR2.getVagoesPilha().get(i).getIndexVagao() == indexVagaoUpperCase) {
                    System.out.println("Este identificador já foi utilizado");
                    menu();
                }
            }
            if (composicaoR2.getStatus() == "Parado no terminal") {
                if (composicaoR2.isEmpilhavel() == true) {
                    composicaoR2.getVagoesPilha().push(v);
                } else {
                    System.out.println(
                            "Essa locomotiva não pode receber um vagão no momento pois sua posição é: "
                                    + composicaoR2.getStatus());
                    menu();
                }
            } else {
                System.out.println("A locomotiva não se encontra parada no terminal.");
                menu();
            }

        }
        menu();
    }

    public static void removerVagao(int indexTerminal) {
        if (indexTerminal == 1) {
            if (composicaoR1.getStatus() == "Parado no terminal") {
                if (composicaoR1.getVagoesPilha().isEmpty() == false) {
                    System.out
                            .println("O vagão de identificador '" + composicaoR1.getVagoesPilha().peek().getIndexVagao() +
                                    "' foi removido da ponta do terminal "+ indexTerminal);
                    composicaoR1.addDesembarques(composicaoR1.getVagoesPilha().peek().getNomeCarga());
                    composicaoR1.getVagoesPilha().pop();
                    composicaoR1.setQtdDesembarques(composicaoR1.getQtdDesembarques()+1);

                } else {
                    System.out.println("A locomotiva não tem vagões com produtos");
                    menu();
                }
            } else {
                System.out.println("A locomotiva não se encontra parada no terminal.");
                menu();
            }

        }

        if (indexTerminal == 2) {
            if (composicaoR2.getStatus() == "Parado no terminal") {
                if (composicaoR2.getVagoesPilha().isEmpty() == false) {
                    System.out
                            .println("O vagão de identificador '" + composicaoR2.getVagoesPilha().peek().getIndexVagao() +
                                    "' foi removido do terminal "+indexTerminal);
                    composicaoR2.addDesembarques(composicaoR2.getVagoesPilha().peek().getNomeCarga());
                    composicaoR2.getVagoesPilha().pop();
                    composicaoR2.setQtdDesembarques(composicaoR2.getQtdDesembarques()+1);
                } else {
                    System.out.println("A locomotiva não tem vagões com produtos");
                    menu();
                }
            } else {
                System.out.println("A locomotiva não se encontra parada no terminal.");
                menu();
            }

        }
        menu();
    }

    public static void transferVagao(int indexTerminal) {
        if(!(composicaoR1.getVagoesPilha().isEmpty()) || !(composicaoR2.getVagoesPilha().isEmpty())){

        if ((composicaoR1.getStatus() == "No ponto de interconexão")
                && (composicaoR2.getStatus() == "No ponto de interconexão")) {
            if (indexTerminal == 1) {
                char indexVagao = composicaoR1.getVagoesPilha().peek().getIndexVagao();
                String nomeCarga = composicaoR1.getVagoesPilha().peek().getNomeCarga();
                double qtd = composicaoR1.getVagoesPilha().peek().getQtd();

                Vagao v = new Vagao(indexVagao, nomeCarga, qtd);
                v.setTipoCarga(1);

                composicaoR2.getVagoesPilha().push(v);
                composicaoR1.getVagoesPilha().pop();

                composicaoR1.setStatus("Parado no terminal");
                composicaoR2.setStatus("Parado no terminal");
                System.out.println("Foi transferido um vagão da locomotiva R1 para a locomotiva R2 e a locomotiva agora está parada no terminal");
            }

            if (indexTerminal == 2) {
                char indexVagao = composicaoR2.getVagoesPilha().peek().getIndexVagao();
                String nomeCarga = composicaoR2.getVagoesPilha().peek().getNomeCarga();
                double qtd = composicaoR2.getVagoesPilha().peek().getQtd();

                Vagao v = new Vagao(indexVagao, nomeCarga, qtd);
                v.setTipoCarga(2);

                composicaoR1.getVagoesPilha().push(v);
                composicaoR2.getVagoesPilha().pop();

                composicaoR1.setStatus("Parado no terminal");
                composicaoR2.setStatus("Parado no terminal");
                System.out.println("Foi transferido um vagão da locomotiva R2 para a locomotiva R1 e a locomotiva agora está parada no terminal");
            }
        } else {
            System.out.println("Uma ou mais locomotivas não se encontram no ponto de interconexão");
        }
        menu();
    } else {
        System.out.println("Uma ou mais locomotivas não possuem vagões");
        menu();
    }
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