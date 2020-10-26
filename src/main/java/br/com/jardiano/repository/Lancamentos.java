package br.com.jardiano.repository;

import java.util.List;

import br.com.jardiano.model.Lancamento;

public interface Lancamentos {

	public List<Lancamento> todos();
	public Lancamento guardar(Lancamento lancamento);
	public void remover(Lancamento lancamento);
	
}
