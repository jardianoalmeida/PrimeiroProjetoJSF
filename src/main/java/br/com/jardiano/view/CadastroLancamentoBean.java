package br.com.jardiano.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.jardiano.model.Lancamento;
import br.com.jardiano.model.Pessoa;
import br.com.jardiano.model.TipoLancamento;
import br.com.jardiano.repository.Lancamentos;
import br.com.jardiano.repository.Pessoas;
import br.com.jardiano.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private Repositorios repositorios = new Repositorios();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();

	@PostConstruct
	public void init() {
		Pessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.todas();
	}
	
	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public void cadastrar() {
		Lancamentos lancamentos = this.repositorios.getLancamentos();
		lancamentos.guardar(this.lancamento);
		
		this.lancamento = new Lancamento();
		
		String msg = "Cadastro efetuado com sucesso!";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
}