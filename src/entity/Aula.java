package entity;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Aula")
@NamedQueries(
		{
			@NamedQuery(name="aula.validaInicio", 
					query="select au from Aula as au where au.disciplinaHorario.id = :idDh and au.professor.id = :idProfessor"),	
			@NamedQuery(name="aula.findById", 
					query="select au from Aula as au where au.id= :id"),	
			@NamedQuery(name="aula.findByDateDisc", 
				query="select au from Aula as au where au.disciplinaHorario.id = :idDh and au.data > :dataInicio and au.data < :dataFim"),	
			@NamedQuery(name="aula.findByDate", 
				query="select au from Aula as au where au.data > :dataInicio and au.data < :dataFim")	
		}
)
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@OneToOne(fetch = FetchType.EAGER) // 1 para 1
	@JoinColumn(name = "prof_aula")
	private PessoaFisica professor;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_mes")
	private Date data;
	@Column(name = "comentario")
	private String comentario;
	@Column(name = "predio_real")
	private int predioReal;
	@Column(name = "sala_real")
	private int salaReal;
	@Column(name = "b_aula_fin")
	private Boolean aulaFinalizada;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="disciplinaHorario")
	private DisciplinaHorario disciplinaHorario;

	public DisciplinaHorario getDisciplinaHorario() {
		return disciplinaHorario;
	}

	public void setDisciplinaHorario(DisciplinaHorario disciplinaHorario) {
		this.disciplinaHorario = disciplinaHorario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PessoaFisica getProfessor() {
		return professor;
	}

	public void setProfessor(PessoaFisica professor) {
		this.professor = professor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getPredioReal() {
		return predioReal;
	}

	public void setPredioReal(int predioReal) {
		this.predioReal = predioReal;
	}

	public int getSalaReal() {
		return salaReal;
	}

	public void setSalaReal(int salaReal) {
		this.salaReal = salaReal;
	}

	public Boolean getAulaFinalizada() {
		return aulaFinalizada;
	}

	public void setAulaFinalizada(Boolean aulaFinalizada) {
		this.aulaFinalizada = aulaFinalizada;
	}

	public Aula(int id, PessoaFisica professor, Date data, String comentario, int predioReal, int salaReal,
			Boolean aulaFinalizada) {
		super();
		this.id = id;
		this.professor = professor;
		this.data = data;
		this.comentario = comentario;
		this.predioReal = predioReal;
		this.salaReal = salaReal;
		this.aulaFinalizada = aulaFinalizada;
	}

	public Aula() {
		// TODO Auto-generated constructor stub
	}

}
