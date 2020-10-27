package br.com.jardiano;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.jardiano.financeiro.model.Pessoa;
import br.com.jardiano.financeiro.util.HibernateUtil;


public class TesteHibernate {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
		//Pega no banco pra mim
		List<Pessoa> pessoas = session.createCriteria(Pessoa.class)
				//.add(Restrictions.gt("codigo", 3))
				.list();
		
		//Mostra pra mim
		for (Pessoa p : pessoas) {
			System.out.println(p.getCodigo() + " - " + p.getNome());
		}
		
		session.close();
	}
	
}
