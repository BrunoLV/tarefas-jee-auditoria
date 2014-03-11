package com.valhala.tarefa.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.valhala.tarefa.auditoria.vo.TarefaAuditoriaVO;
import com.valhala.tarefa.model.Tarefa;
import com.valhala.tarefa.service.TarefaService;

@Named("TarefaBean")
@RequestScoped
public class TarefaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Tarefa> tarefas;
	private List<TarefaAuditoriaVO> auditorias;
	private Tarefa tarefa;
	
	@EJB
	private TarefaService service;
	
	public TarefaBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		this.tarefa = new Tarefa();
		this.tarefas = service.buscarTodasTarefas();
		if (FacesContext.getCurrentInstance().getExternalContext().getFlash().containsKey("id")) {
			Serializable id = (Serializable) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
			System.out.println("ID: " + id);
			this.auditorias = service.buscarDetalhesAuditoria(id);
		} else {
			this.auditorias = new ArrayList<>();
		}
	}
	
	public String mostrarRevisoes(Serializable id) {
		System.out.println(id);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", id);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "/paginas/lista-revisoes.xhtml?faces-redirect=true";
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	public List<TarefaAuditoriaVO> getAuditorias() {
		return auditorias;
	}
	
	public void setAuditorias(List<TarefaAuditoriaVO> auditorias) {
		this.auditorias = auditorias;
	}

}
