package enumeration;

public enum DiaSemana {
	
	SEGUNDA("SEGUNDA"), TERÇA("TERÇA"), QUARTA("QUARTA"), QUINTA("QUINTA"), SEXTA("SEXTA");
	
	private String dia;
	
	private DiaSemana(String diaSemana){
		this.dia= diaSemana;
	}
	
	public String toString(){
		return this.dia;
	}

}
