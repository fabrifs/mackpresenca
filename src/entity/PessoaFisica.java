package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PessoaFisica")
public class PessoaFisica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="nome")
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="nasc")
	private Date nasc;
	@Column(name="ra")
	private int ra;
	@Column(name="email")
	private String email;
	@Column(name="endereco")
	private String endereco;
	@Column(name="end_num")
	private int end_num;
	@Column(name="end_compl")
	private String end_compl;
	@Column(name="cep")
	private String cep;
	@Column(name="cidade")
	private String cidade;
	@Column(name="estado")
	private String estado;
	@OneToOne(mappedBy="pessoaFisica")
	private Acesso acesso;
	
	public PessoaFisica(){
		
	}
	
	public PessoaFisica(int id, String nome, Date nasc, int ra, String email, String endereco, int end_num, String end_compl,
			String cep, String cidade, String estado) {
		this.id = id;
		this.nome = nome;
		this.nasc = nasc;
		this.ra = ra;
		this.email = email;
		this.endereco = endereco;
		this.end_num = end_num;
		this.end_compl = end_compl;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public void setAcesso(Acesso a){
		this.acesso = a;
	}
	
	public Acesso getAcesso(){
		return acesso;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNasc() {
		return nasc;
	}
	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getEnd_num() {
		return end_num;
	}
	public void setEnd_num(int end_num) {
		this.end_num = end_num;
	}
	public String getEnd_compl() {
		return end_compl;
	}
	public void setEnd_compl(String end_compl) {
		this.end_compl = end_compl;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
