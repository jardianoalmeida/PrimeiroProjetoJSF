package br.com.jardiano.util;

import java.io.Serializable;

import org.hibernate.Session;

import br.com.jardiano.repository.Lancamentos;
import br.com.jardiano.repository.Pessoas;
import br.com.jardiano.repository.infra.LancamentosHibernate;
import br.com.jardiano.repository.infra.PessoasHibernate;

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