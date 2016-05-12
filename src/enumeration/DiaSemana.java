package enumeration;

public enum DiaSemana {
	
	SEGUNDA(1), TERÇA(2), QUARTA(3), QUINTA(4), SEXTA(5);
	
	private int dia;
	
	private DiaSemana(int diaSemana){
		this.dia= diaSemana;
	}
	
	public int toInt(){
		return this.dia;
	}

}
