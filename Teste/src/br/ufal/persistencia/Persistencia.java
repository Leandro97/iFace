package br.ufal.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Persistencia {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("iface");;
	EntityManager manager;
}
