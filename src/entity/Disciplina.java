package entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Disciplina")
@NamedQueries(
		{
			@NamedQuery(name="disciplina.listaPorId",
					query="select dis from Disciplina as dis where dis.id = :id")
		}
)
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="professorCoordenador")
	private int professorCoordenador; //id da PessoaFisica
	@Column(name="nomeDisciplina")
	private String nomeDisciplina;
	@Column(name="cargaHoraria")
	private int cargaHoraria;//em horas
	@Column(name="curso")
	private String curso;
	@OneToMany(mappedBy="disciplina", fetch=FetchType.EAGER)
	private Collection<DisciplinaHorario> disciplinaHorario;

	

	
	
	public Collection<DisciplinaHorario> getDisciplinaHorario() {
		return disciplinaHorario;
	}

	public void setDisciplinaHorario(Collection<DisciplinaHorario> disciplinaHorario) {
		this.disciplinaHorario = disciplinaHorario;
	}


	public Disciplina() {
		// TODO Auto-generated constructor stub
	}
	
	public Disciplina(int id, String curso, int professorCoordenador, String nomeDisciplina, int cargaHoraria) {
		super();
		this.id = id;
		this.curso = curso;
		this.professorCoordenador = professorCoordenador;
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getProfessorCoordenador() {
		return professorCoordenador;
	}
	public void setProfessorCoordenador(int professorCoordenador) {
		this.professorCoordenador = professorCoordenador;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	
	

}
