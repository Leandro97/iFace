package br.ufal.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Não mapeada
@Entity
@Table(name = "comunidade")
public class Comunidade {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String descricao;
	
	@ManyToOne
	private Usuario dono;

	@OneToMany(mappedBy = "receptor", cascade = CascadeType.ALL)
	private List<MensagemComunidade> mensagensRecebidas;
	
	public Comunidade() {
	}
	
	public Comunidade(String nome, String descricao, Usuario dono) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
