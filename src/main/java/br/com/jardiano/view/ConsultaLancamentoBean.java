package br.com.jardiano.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.com.jardiano.model.Lancamento;
import br.com.jardiano.repository.Lancamentos;
import br.com.jardiano.util.FacesUtil;
import br.com.jardiano.util.HibernateUtil;
import br.com.jardiano.util.Repositorios;

@ManagedBean
//@SessionScoped
public class ConsultaLancamentoBean implements Serializable {
	private Repositorios repositorios = new Repositorios();
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	
	@PostConstruct
	public void inicializar() {
		Lancamentos lancamentos = this.repositorios.getLancamentos();
		this.lancamentos = lancamentos.todos();
	}

	public void excluir() {
		if (this.lancamentoSelecionado.isPago()) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lançamento já foi pago e não pode ser excluído.");
		} else {
			Lancamentos lancamentos = this.repositorios.getLancamentos();
			lancamentos.remover(this.lancamentoSelecionado);
			
			this.inicializar();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento excluído com sucesso!");
		}
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}
	
}