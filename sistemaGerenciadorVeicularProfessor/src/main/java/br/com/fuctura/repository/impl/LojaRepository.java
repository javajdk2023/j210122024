package br.com.fuctura.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import br.com.fuctura.entity.Loja;
import br.com.fuctura.entity.Veiculo;
import br.com.fuctura.repository.ILojaRepository;

public class LojaRepository implements ILojaRepository {
	
	
	public Optional<Loja> findById(Connection connection, Integer codigo) throws SQLException{
		String comandoSQL = "select "
				+ "l.nome, v.placa, v.ano, v.valor "
				+ "from veiculo v \n"
				+ "inner join loja_veiculo lv \n"
				+ "on v.codigo = lv.cod_veiculo \n"
				+ "inner join loja l\n"
				+ "on l.codigo = lv.cod_loja \n"
				+ "where l.codigo = ?";
		
		System.out.println(comandoSQL);
		
		PreparedStatement pst = connection.prepareStatement(comandoSQL);
		
		pst.setInt(1, codigo);
		
		ResultSet rs = pst.executeQuery();
		
		Loja l = new Loja();
		
		while(rs.next()) {
			String nomeLoja = rs.getString("nome");
			String placaVeiculo = rs.getString("placa");
			Double valorVeiculo = rs.getDouble("valor");
			
			Veiculo v = new Veiculo();
			v.setPlaca(placaVeiculo);
			v.setValor(codigo);
			
			l.setNome(nomeLoja);
			
			l.add(v);
		}
		
		return Optional.of(l);
	}
	
}
