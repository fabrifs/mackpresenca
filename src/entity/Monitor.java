package entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enumeration.DiaSemana;
@Entity
@Table(name="Monitor")
@NamedQueries(
		{
			@NamedQuery(name="monitor.listarPorDisciplina",
					query="select mo from Monitor as mo where mo.disciplina.id = :id"),
			@NamedQuery(name="monitor.listaPorId",
					query="select mo from Monitor as mo where mo.id = :id")
		}
)
public class Monitor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@OneToOne(fetch = FetchType.EAGER) // 1 para 1
	@JoinColumn(name = "disciplina")
	private Disciplina disciplina;
	@Column(name="nomeAluno")
	private String nomeAluno;
	@Column(name="dia_semana")
	@Enumerated(EnumType.STRING)
	private DiaSemana dia_semana;
	@Column(name="horario")
	private String horario;
	
	public Monitor() {
		// TODO Auto-generated constructor stub
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

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public DiaSemana getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(DiaSemana dia_semana) {
		this.dia_semana = dia_semana;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Monitor(int id, Disciplina disciplina, String nomeAluno, DiaSemana dia_semana, String horario) {
		super();
		this.id = id;
		this.disciplina = disciplina;
		this.nomeAluno = nomeAluno;
		this.dia_semana = dia_semana;
		this.horario = horario;
	}
	

}