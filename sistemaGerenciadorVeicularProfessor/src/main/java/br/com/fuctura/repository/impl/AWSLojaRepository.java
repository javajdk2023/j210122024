package br.com.fuctura.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import br.com.fuctura.entity.Loja;
import br.com.fuctura.repository.ILojaRepository;

public class AWSLojaRepository implements ILojaRepository {

	@Override
	public Optional<Loja> findById(Connection connection, Integer codigo) throws SQLException {
		System.out.println("Pesquisando na RDS");
		return Optional.empty();
	}

}
