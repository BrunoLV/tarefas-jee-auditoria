package com.valhala.tarefa.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.valhala.tarefa.dao.api.TarefaDao;
import com.valhala.tarefa.model.Tarefa;

/**
 * Implementação para acesso a dados de tarefas.
 * @author Bruno Luiz Viana
 * @version 1.0
 * @since 11/03/2014
 */
public class TarefaDaoImpl implements TarefaDao {
	
	private static final Class<Tarefa> CLASSE_PERSISTENTE = Tarefa.class;

	@Inject
	private EntityManager manager;
	
	public TarefaDaoImpl() {
	} // fim do método construtor
	
	@Override
	public Tarefa buscarPorId(Serializable id) {
		return manager.find(TarefaDaoImpl.CLASSE_PERSISTENTE, id);
	} // fim do método buscarPorId

	@Override
	public List<Tarefa> buscarTodasTarefas() {
		TypedQuery<Tarefa> query = manager.createNamedQuery(Tarefa.NAMEDQUERY_BUSCAR_TODOS, TarefaDaoImpl.CLASSE_PERSISTENTE);
		return query.getResultList();
	} // fim do método buscarTodasTarefas

} // fim da classe TarefaDaoImpl