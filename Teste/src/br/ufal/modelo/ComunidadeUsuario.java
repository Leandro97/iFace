package br.ufal.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comunidade_Usuario")
public class ComunidadeUsuario implements Serializable {	
	
	@Id
	@ManyToOne
	private Comunidade comunidade;
	
	@Id
	@ManyToOne
	private Usuario participante;
	
	private boolean confirmado;
	
	public ComunidadeUsuario() {
		
	}

	public ComunidadeUsuario(Comunidade comunidade,Usuario participante, boolean confirmado) {
		this.comunidade = comunidade;
		this.participante = participante;
		this.confirmado = confirmado;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	public Usuario getParticipante() {
		return participante;
	}

	public void setParticipante(Usuario participante) {
		this.participante = participante;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	
}
