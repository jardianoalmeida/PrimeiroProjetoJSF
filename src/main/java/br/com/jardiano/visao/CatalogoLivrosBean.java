package br.com.jardiano.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import br.com.jardiano.dominio.Livro;

@ManagedBean
//none, request, view, session e application
// @NoneScoped // Não guarda nada
// @RequestScoped // Nada fica guardado na tela
// @SessionScoped // Mant�m os dados salvos visiveis para todos os usuarios
//@ViewScoped
@ApplicationScoped
public class CatalogoLivrosBean implements Serializable{

	private List<Livro> livros;
	private Livro livro;
	
	public CatalogoLivrosBean() {
		this.livros = new ArrayList<Livro>();
		this.livro = new Livro();
	}
	
	public void incluir() {
		this.livros.add(this.livro);
		this.livro = new Livro();
	}

	public Livro getLivro() {
		return livro;
	}

	public List<Livro> getLivros() {
		return livros;
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
