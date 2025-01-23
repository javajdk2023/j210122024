package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import br.com.fuctura.entity.Veiculo;
import br.com.fuctura.repository.VeiculoRepository;

public class Aplicacao {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/postgres?loglevel=2";
		String user = "postgres";
		String pass = "123";
		
		
		try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			
			System.out.println("Conectado com sucesso!");
			
			String placa = "kyz7418";
			String modelo = "Celta";
			int ano = 2013;
			double valor = 45000.0;
			
			Veiculo v = new Veiculo(placa, modelo, ano, valor);
			
			VeiculoRepository repository = new VeiculoRepository();
			
			repository.save(connection, v);
			
			if(Objects.nonNull(v.getCodigo())) {
				System.out.println("Veiculo registrado com sucesso!");
				System.out.println("Codigo: " + v.getCodigo());
			}
			
		} catch (SQLException e) {
			System.out.println("Erro de conexão, motivo: ");
			e.printStackTrace();
		}
	}
}
