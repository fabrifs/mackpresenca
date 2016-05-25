package entity;

public class Falta {
	
	private String nomeDisciplina;
	
	private int quantidadeAulas;
	
	private int quantidadeFaltas;
	
	private double porcentagemPermitida;
	
	private double porcentagemFaltasRestante;
	
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

	public int getQuantidadeFaltas() {
		return quantidadeFaltas;
	}

	public void setQuantidadeFaltas(int quantidadeFaltas) {
		this.quantidadeFaltas = quantidadeFaltas;
	}

	public double getPorcentagemPermitida() {
		return porcentagemPermitida;
	}

	public void setPorcentagemPermitida(double porcentagemPermitida) {
		this.porcentagemPermitida = porcentagemPermitida;
	}

	public double getPorcentagemFaltasRestante() {
		return porcentagemFaltasRestante;
	}

	public void setPorcentagemFaltasRestante(double porcentagemFaltasRestante) {
		this.porcentagemFaltasRestante = porcentagemFaltasRestante;
	}

	public Falta(String nomeDisciplina, int quantidadeAulas, int quantidadeFaltas, double porcentagemPermitida,
			double porcentagemFaltasRestante) {
		super();
		this.nomeDisciplina = nomeDisciplina;
		this.quantidadeAulas = quantidadeAulas;
		this.quantidadeFaltas = quantidadeFaltas;
		this.porcentagemPermitida = porcentagemPermitida;
		this.porcentagemFaltasRestante = porcentagemFaltasRestante;
	}
	
	

}
