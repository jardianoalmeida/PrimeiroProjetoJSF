package br.com.jardiano.repository;

import java.util.List;

import br.com.jardiano.model.Pessoa;


public interface Pessoas {

	public List<Pessoa> todas();
	public Pessoa porCodigo(Integer codigo);
	
}