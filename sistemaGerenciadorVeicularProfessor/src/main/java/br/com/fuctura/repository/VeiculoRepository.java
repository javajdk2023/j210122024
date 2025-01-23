package br.com.fuctura.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	
}
