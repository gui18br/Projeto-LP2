package models;

import java.util.List;
import java.util.Stack;

public class Locomotiva {

    protected int via;
    protected String status;
    protected Stack<Vagao> vagoesPilha;
    protected List<String> listarDesembarque;
    protected int qtdDesembarques;

    public Locomotiva(int via, String status, Stack<Vagao> vagoesPilha, int qtdDesembarques, List<String> listarDesembarque) {
        this.via = via;
        this.status = status;
        this.vagoesPilha = vagoesPilha;
        this.qtdDesembarques = qtdDesembarques;
        this.listarDesembarque = listarDesembarque;
    }

    public boolean isEmpilhavel() {
        if (status == "Parado no terminal") {
            return true;
        } else {
            return false;
        }
    }

    public int getVia() {
        return this.via;
    }

    public void setVia(int via) {
        this.via = via;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Stack<Vagao> getVagoesPilha() {
        return this.vagoesPilha;
    }

    public void setVagoes(Stack<Vagao> vagoes) {
        this.vagoesPilha = vagoes;
    }

    public int getQtdDesembarques() {
        return qtdDesembarques;
    }

    public void setQtdDesembarques(int qtdDesembarques) {
        this.qtdDesembarques = qtdDesembarques;
    }

    public void addDesembarques(String v){
        this.listarDesembarque.add(v);
    }

    public List<String> listarDesembarques(){
        return this.listarDesembarque;
    }

    @Override
    public String toString() {
        return "{" +
                " via='" + getVia() + "'" +
                ", status='" + getStatus() + "'" +
                ", vagoesPilha='" + getVagoesPilha() + "'" +
                "}";
    }

}