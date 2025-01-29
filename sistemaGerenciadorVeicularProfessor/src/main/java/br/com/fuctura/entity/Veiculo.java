package br.com.fuctura.entity;

public class Veiculo {

	private Integer codigo;
	private String placa;
	private String modelo;
	private int ano;
	private double valor;
	private boolean isDisponivel;
	

	public Veiculo(String placa, String modelo, int ano, double valor) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
	}

	public Veiculo() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
	
	public boolean isDisponivel() {
		return isDisponivel;
	}

	public void setDisponivel(boolean isDisponivel) {
		this.isDisponivel = isDisponivel;
	}

	@Override
	public String toString() {
		return "Veiculo [codigo=" + codigo + ", placa=" + placa + ", modelo=" + modelo + ", ano=" + ano + ", valor="
				+ valor + "]";
	}

	// Getters&Setter;

}
