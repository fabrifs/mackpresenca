package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Acesso")
@NamedQueries(
		{
			@NamedQuery(name="acesso.autenticar", 
			query="select a from Acesso as a where a.login = :login and a.senha = :senha and a.tipo_acesso = :tipo_acesso")
		}
)

public class Acesso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="login")
	private String login;
	@Column(name="senha")
	private String senha;
	@OneToOne
	@JoinColumn(name="pefi", unique=true)
	private PessoaFisica pessoaFisica;
	@Column(name="tipo_acesso")
	private String tipo_acesso;
	
	public Acesso(int id, String login, String senha, PessoaFisica pessoaFisica, String tipo_acesso) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.pessoaFisica = pessoaFisica;
		this.tipo_acesso = tipo_acesso;
	}

	public Acesso() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public String getTipoAcesso() {
		return tipo_acesso;
	}

	public void setTipoAcesso(String tipo_acesso) {
		this.tipo_acesso = tipo_acesso;
	}
	
	

}
