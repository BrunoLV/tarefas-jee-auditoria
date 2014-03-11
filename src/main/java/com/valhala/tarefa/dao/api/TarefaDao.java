package com.valhala.tarefa.dao.api;

import java.io.Serializable;
import java.util.List;

import com.valhala.tarefa.model.Tarefa;

/**
 * Interface para as classes de acesso a dados de tarefas.
 * @author Bruno Luiz Viana
 * @version 1.0
 * @since 11/03/2014
 */
public interface TarefaDao {
	
	/**
	 * Método para buscar uma tarefa por id.
	 * @param id
	 * @return
	 */
	Tarefa buscarPorId(Serializable id);
	
	/**
	 * Método para buscar todas tarefas cadastradas.
	 * @return
	 */
	List<Tarefa> buscarTodasTarefas();

} // fim da interface TarefaDao