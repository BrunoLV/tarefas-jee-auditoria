package com.valhala.tarefa.auditoria.api;

import java.io.Serializable;
import java.util.List;

import com.valhala.tarefa.auditoria.vo.TarefaAuditoriaVO;

/**
 * Interface das classes para consulta de auditorias.
 * @author Bruno Luiz Viana
 * @version 1.0
 * @since 11/03/2014
 *
 */
public interface TarefaAuditoria {
	
	/**
	 * Médoto utilizado para retornar os números das revisões de uma tarefa.
	 * @param id
	 * @return
	 */
	List<Number> buscarRevisoesDeUmaTarefa(Serializable id);
	
	/**
	 * Método utilizado para retornar o detalhe de uma revisão.
	 * @param revisao
	 * @return
	 */
	TarefaAuditoriaVO buscarAuditoriaDeTarefasPorNumeroRevisao(Serializable revisao);

} // fim da interface TarefaAuditoria