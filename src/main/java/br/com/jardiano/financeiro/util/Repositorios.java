package br.com.jardiano.financeiro.util;

import java.io.Serializable;

import org.hibernate.Session;

import br.com.jardiano.financeiro.repository.Lancamentos;
import br.com.jardiano.financeiro.repository.Pessoas;
import br.com.jardiano.financeiro.repository.infra.LancamentosHibernate;
import br.com.jardiano.financeiro.repository.infra.PessoasHibernate;

public class Repositorios implements Serializable {

	public Pessoas getPessoas() {
		return new PessoasHibernate(this.getSession());
	}
	
	public Lancamentos getLancamentos() {
		return new LancamentosHibernate(this.getSession());
	}
	
	private Session getSession() {
		return (Session) FacesUtil.getRequestAttribute("session");
	}
	
}
