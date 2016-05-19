package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Aula_Presenca")
@NamedQueries(
		{
			@NamedQuery(name="presenca.contaFaltas",
					query="select count(pres.id) from Presenca as pres where pres.idAluno = :idAluno and pres.idDisciplina = :idDisciplina")
		}
)
public class Presenca {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "aula")
	private int idAula;
	@Column(name = "aluno")
	private int idAluno;
	@Column(name = "disciplina")
	private int idDisciplina;
	
	
	public Presenca() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Presenca(int id, int idAula, int idAluno, int idDisciplina) {
		super();
		this.id = id;
		this.idAula = idAula;
		this.idAluno = idAluno;
		this.idDisciplina = idDisciplina;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAula() {
		return idAula;
	}
	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	
	

}
