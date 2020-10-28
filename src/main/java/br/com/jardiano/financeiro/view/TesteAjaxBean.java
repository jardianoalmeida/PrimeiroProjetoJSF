package br.com.jardiano.financeiro.view;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TesteAjaxBean {

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}