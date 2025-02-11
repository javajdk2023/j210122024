package br.com.fuctura.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue
	private Integer codigo;
	
//	@Column(length = 7)
	private String placa;

	//construtor
	public Veiculo(String placa) {
		this.placa = placa;
	}
	
	//construtor padrao
	public Veiculo() {}
	
	//getter&setters
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
}
