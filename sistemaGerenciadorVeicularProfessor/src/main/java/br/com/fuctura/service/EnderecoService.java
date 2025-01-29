package br.com.fuctura.service;

import java.sql.Connection;

import br.com.fuctura.client.EnderecoClient;
import br.com.fuctura.entity.Endereco;
import br.com.fuctura.repository.IEnderecoRepository;

public class EnderecoService {
	
	private IEnderecoRepository repository;
	private EnderecoClient enderecoClient;
	
	
	Endereco save(Connection connection, Endereco endereco) {
			
		var cep = endereco.getCep();
		
		var response = enderecoClient.findEnderecoByCep(cep);
		
		//DTO => Endereco
		
		repository.save(endereco);
		
		return null;
	}
	
}
