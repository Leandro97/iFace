package br.ufal.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
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
	
	@OneToMany(mappedBy = "participante", cascade = CascadeType.ALL)
	private List<ComunidadeUsuario> comunidadesQueParticipo;
	
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

	public List<MensagemComunidade> getMensagensCEnviadas() {
		return mensagensCEnviadas;
	}

	public void setMensagensCEnviadas(List<MensagemComunidade> mensagensCEnviadas) {
		this.mensagensCEnviadas = mensagensCEnviadas;
	}

	public List<Comunidade> getComunidadesQuePossuo() {
		return comunidadesQuePossuo;
	}

	public void setComunidadesQuePossuo(List<Comunidade> comunidadesQuePossuo) {
		this.comunidadesQuePossuo = comunidadesQuePossuo;
	}

	public List<ComunidadeUsuario> getComunidadesQueParticipo() {
		return comunidadesQueParticipo;
	}

	public void setComunidadesQueParticipo(List<ComunidadeUsuario> comunidadesQueParticipo) {
		this.comunidadesQueParticipo = comunidadesQueParticipo;
	}
}
