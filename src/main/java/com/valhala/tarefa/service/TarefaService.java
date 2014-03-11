package com.valhala.tarefa.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.valhala.tarefa.auditoria.api.TarefaAuditoria;
import com.valhala.tarefa.auditoria.vo.TarefaAuditoriaVO;
import com.valhala.tarefa.dao.api.TarefaDao;
import com.valhala.tarefa.model.Tarefa;

/**
 * Classe para executar as regras da aplicação.
 * @author Bruno Luiz Viana
 * @version 1.0
 * @since 11/03/2014
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TarefaService {
	
	@Inject
	private TarefaDao dao;
	
	@Inject
	private TarefaAuditoria auditoria;
	
	/**
	 * Método utilizado para acionar a busca de uma tarefa por id.
	 * @param id
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Tarefa buscarTarefaPorId(Serializable id) {
		return dao.buscarPorId(id);
	} // fim do método buscarTarefaPorId
	
	/**
	 * Método utilizado para acionar a buscar de todas tarefas registradas.
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Tarefa> buscarTodasTarefas() {
		return dao.buscarTodasTarefas();
	} // fim do método buscarTodasTarefas
	
	/**
	 * Método utilizado para acionar a busca das revisões de uma tarefa.
	 * @param id
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<TarefaAuditoriaVO> buscarDetalhesAuditoria(Serializable id) {
		List<TarefaAuditoriaVO> auditoriaVOs = new ArrayList<>();
		List<Number> numerosRevisoes = this.auditoria.buscarRevisoesDeUmaTarefa(id);
		for (Number number : numerosRevisoes) {
			TarefaAuditoriaVO auditoriaVO = this.auditoria.buscarAuditoriaDeTarefasPorNumeroRevisao((Long)number);
			auditoriaVOs.add(auditoriaVO);
		} // fim do bloco for
		return auditoriaVOs;
	} // fim do método buscarDetalhesAuditoria
	
} // fim da classe TarefaService