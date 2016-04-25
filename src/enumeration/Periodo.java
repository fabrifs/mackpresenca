package enumeration;

public enum Periodo {
	
	PRIMEIRO("PRIMEIRO"), SEGUNDO("SEGUNDO"), TERCEIRO("TERCEIRO"), QUARTO("QUARTO"), QUINTO("QUINTO"), SEXTO("SEXTO"), SETIMO("SETIMO"), OITAVO("OITAVO"), NONO("NONO");
	
	private String periodo;
	
	private Periodo(String periodo){
		this.periodo= periodo;
	}
	
	public String toString(){
		return this.periodo;
	}


}
