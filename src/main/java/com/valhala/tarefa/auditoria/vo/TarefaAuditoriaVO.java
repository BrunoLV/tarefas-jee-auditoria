package com.valhala.tarefa.auditoria.vo;

import java.io.Serializable;

import org.hibernate.envers.RevisionType;

import com.valhala.tarefa.model.Revisao;
import com.valhala.tarefa.model.Tarefa;

/**
 * VO utilizado para juntar em um objeto os detalhes de uma revisão.
 * @author Bruno Luiz Viana
 * @version 1.0
 * @since 11/03/2014
 */
public class TarefaAuditoriaVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private RevisionType tipoRevisao;
	private Revisao revisao;
	private Tarefa tarefa;
	
	public TarefaAuditoriaVO() {
	} // fim do método construtor

	public TarefaAuditoriaVO(Tarefa tarefa, Revisao revisao, RevisionType tipoRevisao) {
		this.tipoRevisao = tipoRevisao;
		this.revisao = revisao;
		this.tarefa = tarefa;
	} // fim do método construtor

	public RevisionType getTipoRevisao() {
		return tipoRevisao;
	}

	public void setTipoRevisao(RevisionType tipoRevisao) {
		this.tipoRevisao = tipoRevisao;
	}

	public Revisao getRevisao() {
		return revisao;
	}

	public void setRevisao(Revisao revisao) {
		this.revisao = revisao;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

} // fim da classe TarefaAuditoriaVO