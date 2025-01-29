package br.com.fuctura.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Veiculo;
import br.com.fuctura.repository.IVeiculoRepository;

public class VeiculoService {

	private IVeiculoRepository repository;

	Optional<List<Veiculo>> findAvaliable(Connection connection) throws SQLException {
		return repository.findByIsDisponivel(connection, true);
	}
	
	Optional<List<Veiculo>> findUnAvaliable(Connection connection) throws SQLException {
		return repository.findByIsDisponivel(connection, false);
	}
}
