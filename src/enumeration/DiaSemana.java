package enumeration;

public enum DiaSemana {
	
	SEGUNDA("SEGUNDA"), TER�A("TER�A"), QUARTA("QUARTA"), QUINTA("QUINTA"), SEXTA("SEXTA");
	
	private String dia;
	
	private DiaSemana(String diaSemana){
		this.dia= diaSemana;
	}
	
	public String toString(){
		return this.dia;
	}

}
