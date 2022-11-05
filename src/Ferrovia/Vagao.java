package Ferrovia;

public class Vagao{

	private char vagao;
	private int locomotiva;
	private double pesoVagao;
	private String commoditie;

	public Vagao() {
		
	}
	
	public Vagao(char vagao, int locomotiva, double pesoVagao, String commoditie) {
		this.vagao = vagao;
		this.locomotiva = locomotiva;
		this.pesoVagao = pesoVagao;
		this.commoditie = commoditie;
	}

	public char getVagao() {
		return vagao;
	}

	public void setVagao(char vagao) {
		this.vagao = vagao;
	}

	public int getLocomotiva() {
		return locomotiva;
	}

	public void setLocomotiva(int locomotiva) {
		this.locomotiva = locomotiva;
	}

	public double getPesoVagao() {
		return pesoVagao;
	}

	public void setPesoVagao(double pesoVagao) {
		this.pesoVagao = pesoVagao;
	}

	public String getCommoditie() {
		return commoditie;
	}

	public void setCommoditie(String commoditie) {
		this.commoditie = commoditie;
	}
	
}
