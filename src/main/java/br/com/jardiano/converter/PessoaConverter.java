package br.com.jardiano.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.jardiano.model.Pessoa;
import br.com.jardiano.util.HibernateUtil;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		
		if (value != null) {
			Session session = HibernateUtil.getSession();

			// Pega no banco pra mim
		    retorno = (Pessoa) session.get(Pessoa.class, new Integer(value));

			session.close();
//			GestaoPessoas gestaoPessoas = new GestaoPessoas();
//			retorno = gestaoPessoas.buscarPorCodigo(new Integer(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Pessoa) value).getCodigo().toString();
		}
		return null;
	}

}