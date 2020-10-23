package br.com.jardiano;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Exercicio {

	private Integer valor1;
	private Integer valor2;
	private Integer soma;
	
	public Integer getValor1() {
		return valor1;
	}


	public void setValor1(Integer valor1) {
		this.valor1 = valor1;
	}


	public Integer getValor2() {
		return valor2;
	}


	public void setValor2(Integer valor2) {
		this.valor2 = valor2;
	}


	public Integer getSoma() {
		return soma;
	}


	public void setSoma(Integer soma) {
		this.soma = soma;
	}


	public void somar() {
		this.setSoma(this.getValor1() + this.getValor2());;
	}
	
}