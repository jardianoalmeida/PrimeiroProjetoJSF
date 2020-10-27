package br.com.jardiano.financeiro.service;

import br.com.jardiano.financeiro.model.Lancamento;
import br.com.jardiano.financeiro.repository.Lancamentos;

public class GestaoLancamentos {

	private Lancamentos lancamentos;
	
	public GestaoLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public void salvar(Lancamento lancamento) throws RegraNegocioException {
		if (existeLancamentoSemelhante(lancamento)) {
			throw new RegraNegocioException("Já existe um lançamento igual a este.");
		}
		
		this.lancamentos.guardar(lancamento);
	}
	
	private boolean existeLancamentoSemelhante(Lancamento lancamento) {
		Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);
		
		return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
	}
	
	public void excluir(Lancamento lancamento) throws RegraNegocioException {
		if (lancamento.isPago()) {
			throw new RegraNegocioException("Lançamento pago não pode ser excluído.");
		}
		
		this.lancamentos.remover(lancamento);
	}
	
}