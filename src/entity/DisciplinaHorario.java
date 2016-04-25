package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enumeration.DiaSemana;
import enumeration.Periodo;

@Entity
@Table(name="DisciplinaHorario")
public class DisciplinaHorario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@ManyToOne
	@JoinColumn(name="disciplina")
	private Disciplina disciplina;
	@Column(name="turma")
	private String turma;
	@Column(name="predioPadrao")
	private int predioPadrao;
	@Column(name="salaPadrao")
	private int salaPadrao;
	@Column(name="diaSemana")
	@Enumerated(EnumType.STRING)
	private DiaSemana diaSemana;
	@Column(name="periodo")
	@Enumerated(EnumType.STRING)
	private Periodo periodo;
	
	//DEFINE RELACIONAMENTO BIDIRECIONAL
	@ManyToMany(mappedBy="disciplinaHorario")
	private List<PessoaFisica> pessoaFisica;
	
	public DisciplinaHorario() {
		// TODO Auto-generated constructor stub
	}

	public DisciplinaHorario(int id, Disciplina disciplina, String turma, int predioPadrao, int salaPadrao,
			DiaSemana diaSemana, Periodo periodo, List<PessoaFisica> pessoaFisica) {
		super();
		this.id = id;
		this.disciplina = disciplina;
		this.turma = turma;
		this.predioPadrao = predioPadrao;
		this.salaPadrao = salaPadrao;
		this.diaSemana = diaSemana;
		this.periodo = periodo;
		this.pessoaFisica = pessoaFisica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public int getPredioPadrao() {
		return predioPadrao;
	}

	public void setPredioPadrao(int predioPadrao) {
		this.predioPadrao = predioPadrao;
	}

	public int getSalaPadrao() {
		return salaPadrao;
	}

	public void setSalaPadrao(int salaPadrao) {
		this.salaPadrao = salaPadrao;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public List<PessoaFisica> getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(List<PessoaFisica> pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

}
