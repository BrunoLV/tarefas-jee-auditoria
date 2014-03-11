package com.valhala.tarefa.auditoria.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditQueryCreator;
import org.hibernate.envers.query.criteria.AuditCriterion;
import org.hibernate.envers.query.criteria.SimpleAuditExpression;
import org.hibernate.envers.query.property.PropertyNameGetter;
import org.hibernate.envers.query.property.RevisionNumberPropertyName;

import com.valhala.tarefa.auditoria.api.TarefaAuditoria;
import com.valhala.tarefa.auditoria.vo.TarefaAuditoriaVO;
import com.valhala.tarefa.model.Revisao;
import com.valhala.tarefa.model.Tarefa;

/**
 * Implementação das consultas de auditoria de tarefas.
 * @author Bruno Luiz Viana
 * @version 1.0
 * @since 11/03/2014
 */
public class TarefaAuditoriaImpl implements TarefaAuditoria {

	private static final Class<Tarefa> CLASSE_AUDITADA = Tarefa.class;
	
	@Inject
	private EntityManager manager;
	
	public TarefaAuditoriaImpl() {
	} // fim do método construtor

	@Override
	public List<Number> buscarRevisoesDeUmaTarefa(Serializable id) {
		this.manager.joinTransaction();
		AuditReader reader = AuditReaderFactory.get(manager);
		List<Number> numbers = reader.getRevisions(TarefaAuditoriaImpl.CLASSE_AUDITADA, (Long)id);
		return numbers;
	} // fim do método buscarRevisoesDeUmaTarefa

	@Override
	public TarefaAuditoriaVO buscarAuditoriaDeTarefasPorNumeroRevisao(Serializable revisao) {
		this.manager.joinTransaction();
		AuditReader reader = AuditReaderFactory.get(manager);
		AuditQueryCreator creator = reader.createQuery();
		PropertyNameGetter propriedade = new RevisionNumberPropertyName();
		AuditCriterion criterio = new SimpleAuditExpression(propriedade, revisao, "=");
		Object[] objeto = (Object[]) creator.forRevisionsOfEntity(TarefaAuditoriaImpl.CLASSE_AUDITADA, false, false).add(criterio).getSingleResult();
		TarefaAuditoriaVO auditoriaVO = new TarefaAuditoriaVO((Tarefa)objeto[0], (Revisao)objeto[1], (RevisionType)objeto[2]);
		return auditoriaVO;
	} // fim do método buscarAuditoriaDeTarefasPorNumeroRevisao

} // fim da classe TarefaAuditoriaImpl