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
import br.com.jardiano.util.FacesUtil;
import br.com.jardiano.util.HibernateUtil;

@ManagedBean
//@SessionScoped
public class ConsultaLancamentoBean implements Serializable {

	private List<String> lancamentos = new ArrayList<String>();
	private Lancamento lancamentoSelecionado;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar() {
		Session session = HibernateUtil.getSession();

		this.lancamentos = session.createCriteria(Lancamento.class)
				.addOrder(Order.desc("dataVencimento")).list();

		session.close();
	}

	public void excluir() {
		if (this.lancamentoSelecionado.isPago()) {
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Lançamento já foi pago e não pode ser excluído.");
		} else {
			Session session = HibernateUtil.getSession();
			Transaction trx = session.beginTransaction();
			
			session.delete(this.lancamentoSelecionado);
			
			trx.commit();
			session.close();
			
			this.inicializar();
			
			FacesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lançamento excluído com sucesso!");
		}
	}
	
	public List<String> getLancamentos() {
		return lancamentos;
	}
	
	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

}