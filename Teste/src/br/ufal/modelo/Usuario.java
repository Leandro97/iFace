package br.ufal.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	@Column(unique = true)
	private String username;
	private String senha;
	
	@OneToMany(mappedBy = "receptor", cascade = CascadeType.ALL)
	private List<MensagemUsuario> mensagensURecebidas;
	
	@OneToMany(mappedBy = "emissor", cascade = CascadeType.ALL)
	private List<MensagemUsuario> mensagensUEnviadas;
	
	@OneToMany(mappedBy = "emissor", cascade = CascadeType.ALL)
	private List<MensagemComunidade> mensagensCEnviadas;
	
	@OneToMany(mappedBy = "dono", cascade = CascadeType.ALL)
	private List<Comunidade> comunidadesQuePossuo;
	
	public Usuario() {
	}
	
	public Usuario(String nome, String username, String senha) {
		super();
		this.nome = nome;
		this.username = username;
		this.senha = senha;
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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<MensagemUsuario> getMensagensURecebidas() {
		return mensagensURecebidas;
	}

	public void setMensagensURecebidas(List<MensagemUsuario> mensagensURecebidas) {
		this.mensagensURecebidas = mensagensURecebidas;
	}

	public List<MensagemUsuario> getMensagensUEnviadas() {
		return mensagensUEnviadas;
	}

	public void setMensagensUEnviadas(List<MensagemUsuario> mensagensUEnviadas) {
		this.mensagensUEnviadas = mensagensUEnviadas;
	}
}
