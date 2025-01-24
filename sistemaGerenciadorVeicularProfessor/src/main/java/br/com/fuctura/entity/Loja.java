package br.com.fuctura.entity;

import java.util.ArrayList;
import java.util.List;

public class Loja {
	
	private Integer codigo;
	private String nome;
	private List<Veiculo> veiculos;
	
	//construtor
	public Loja() {
		this.veiculos = new ArrayList<Veiculo>();
	}

	public Loja(String nome) {
		this.nome = nome;
		this.veiculos = new ArrayList<Veiculo>();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void add(Veiculo veiculo) {
		this.veiculos.add(veiculo);
	}

	@Override
	public String toString() {
		return "Loja [codigo=" + codigo + ", nome=" + nome + ", veiculos=" + veiculos + "]";
	}
	
}
