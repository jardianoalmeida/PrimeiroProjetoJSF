package br.com.jardiano.financeiro.repository;

import java.util.List;

import br.com.jardiano.financeiro.model.Pessoa;

public interface Pessoas {

	public List<Pessoa> todas();
	public Pessoa porCodigo(Integer codigo);
	
}