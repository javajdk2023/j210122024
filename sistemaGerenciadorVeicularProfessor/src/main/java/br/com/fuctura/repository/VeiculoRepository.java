package br.com.fuctura.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fuctura.entity.Veiculo;

public class VeiculoRepository {

	public Veiculo save(Connection connection, Veiculo veiculo) throws SQLException {
		String comandoSQL = "insert into j210122024.veiculo (placa, modelo, ano, valor)\n" + "values (?, ?, ?, ?)";

		PreparedStatement pstm = connection.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);

		pstm.setString(1, veiculo.getPlaca());
		pstm.setString(2, veiculo.getModelo());
		pstm.setInt(3, veiculo.getAno());
		pstm.setDouble(4, veiculo.getValor());

		pstm.execute();

		ResultSet rs = pstm.getGeneratedKeys();
		if (rs.next()) {
			int idGerado = rs.getInt(1);
			veiculo.setCodigo(idGerado);
		}

		return veiculo;
	}

	// codigo = "; insert into veiculo (valor) values (0);

	public Optional<Veiculo> findById(Connection connection, Integer codigo) throws SQLException {

		String comandoSQL = "select * from Veiculo where codigo = ?";

		PreparedStatement pst = connection.prepareStatement(comandoSQL);

		pst.setInt(1, codigo);

		ResultSet rs = pst.executeQuery();

		//
		while (rs.next()) {
			Veiculo v = extracted(rs);

			return Optional.of(v);
		}

		return Optional.empty();
	}

	public Optional<List<Veiculo>> findAll(Connection connection) throws SQLException {
		String comandoSQL = "select * from veiculo";

		PreparedStatement pst = connection.prepareStatement(comandoSQL);

		ResultSet rs = pst.executeQuery();

		List<Veiculo> lista = new ArrayList<Veiculo>();
		
		while (rs.next()) {
			
			Veiculo v = extracted(rs);
			
			lista.add(v);
		}
		
		return lista.isEmpty() ? Optional.empty() : Optional.of(lista);
	}
	
	private Veiculo extracted(ResultSet rs) throws SQLException {
		int cod = rs.getInt("codigo");
		int ano = rs.getInt("ano");
		double valor = rs.getDouble("valor");
		String modelo = rs.getString("modelo");
		String placa = rs.getString("placa");

		Veiculo v = new Veiculo(placa, modelo, ano, valor);
		v.setCodigo(cod);
		return v;
	}

}
