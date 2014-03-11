package com.valhala.tarefa.producers;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Classe produtora de entity manager da aplicação.
 * @author Bruno Luiz Viana
 * @version 1.0
 * @since 11/03/2014
 */
public class EntityManagerProducer {
	
	@PersistenceContext(name="tarefas-PU")
	private EntityManager manager;
	
	/**
	 * Método utilizado para produzir entity manager para a aplicação.
	 * @return
	 */
	@Produces
	public EntityManager obterEntityManager() {
		return manager;
	} // fim do método obterEntityManager
	
} // fim da classe EntityManagerProducer