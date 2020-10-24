package br.com.jardiano.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import br.com.jardiano.dominio.Produto;

@ManagedBean
@NoneScoped // Não guarda nada
// @RequestScoped // Nada fica guardado na tela
// @SessionScoped // Mant�m os dados salvos visiveis para todos os usuarios
public class GestaoProdutosBean implements Serializable{

	private List<Produto> produtos;
	private Produto produto;
	
	public GestaoProdutosBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou bean");
	}

	@PreDestroy
	public void finalizar() {
		System.out.println("FinaSSlizou bean");
	}
}
