package br.ufal.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "amizade")
public class Amizade {
	@Id
	@GeneratedValue
	private int id;
	private int idAmigo1;
	private int idAmigo2;
	
	public Amizade() {
	}

	public Amizade(int idAmigo1, int idAmigo2) {
		this.idAmigo1 = idAmigo1;
		this.idAmigo2 = idAmigo2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAmigo1() {
		return idAmigo1;
	}

	public void setIdAmigo1(int idAmigo1) {
		this.idAmigo1 = idAmigo1;
	}

	public int getIdAmigo2() {
		return idAmigo2;
	}

	public void setIdAmigo2(int idAmigo2) {
		this.idAmigo2 = idAmigo2;
	}
	
}
