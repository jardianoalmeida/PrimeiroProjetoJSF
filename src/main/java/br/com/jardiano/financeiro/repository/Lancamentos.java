package br.com.jardiano.financeiro.repository;

import java.util.List;

import br.com.jardiano.financeiro.model.Lancamento;

public interface Lancamentos {

	public List<Lancamento> todos();
	public Lancamento comDadosIguais(Lancamento lancamento);
	public Lancamento porCodigo(Integer codigo);
	
	public Lancamento guardar(Lancamento lancamento);
	public void remover(Lancamento lancamento);
	
}