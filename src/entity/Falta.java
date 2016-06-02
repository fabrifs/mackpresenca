package entity;

public class Falta {
	
	private String nomeDisciplina;	
	private int quantidadeAulas;
	private int faltasPermitida;
	
	private int quantidadeFaltas;	
	private int faltasRestante;
	private double porcentagemFaltas;
	
	
	public Falta(){
		
	}


	public String getNomeDisciplina() {
		return nomeDisciplina;
	}


	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}


	public int getQuantidadeAulas() {
		return quantidadeAulas;
	}


	public void setQuantidadeAulas(int quantidadeAulas) {
		this.quantidadeAulas = quantidadeAulas;
	}


	public int getFaltasPermitida() {
		return faltasPermitida;
	}


	public void setFaltasPermitida(int faltasPermitida) {
		this.faltasPermitida = faltasPermitida;
	}


	public int getQuantidadeFaltas() {
		return quantidadeFaltas;
	}


	public void setQuantidadeFaltas(int quantidadeFaltas) {
		this.quantidadeFaltas = quantidadeFaltas;
	}


	public int getFaltasRestante() {
		return faltasRestante;
	}


	public void setFaltasRestante(int faltasRestante) {
		this.faltasRestante = faltasRestante;
	}


	public double getPorcentagemFaltas() {
		return porcentagemFaltas;
	}


	public void setPorcentagemFaltas(double porcentagemFaltas) {
		this.porcentagemFaltas = porcentagemFaltas;
	}


	public Falta(String nomeDisciplina, int quantidadeAulas, int faltasPermitida, int quantidadeFaltas,
			int faltasRestante, double porcentagemFaltas) {
		super();
		this.nomeDisciplina = nomeDisciplina;
		this.quantidadeAulas = quantidadeAulas;
		this.faltasPermitida = faltasPermitida;
		this.quantidadeFaltas = quantidadeFaltas;
		this.faltasRestante = faltasRestante;
		this.porcentagemFaltas = porcentagemFaltas;
	}

}