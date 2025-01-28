package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

import br.com.fuctura.entity.Loja;
import br.com.fuctura.entity.Veiculo;
import br.com.fuctura.repository.ILojaRepository;
import br.com.fuctura.repository.IVeiculoRepository;
import br.com.fuctura.repository.impl.AWSLojaRepository;
import br.com.fuctura.repository.impl.VeiculoRepository;

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
			
			IVeiculoRepository repository = new VeiculoRepository();
			
			repository.save(connection, v);
			
			if(Objects.nonNull(v.getCodigo())) {
				System.out.println("Veiculo registrado com sucesso!");
				System.out.println("Codigo: " + v.getCodigo());
			}

			
			Optional<Veiculo> veiculoEncontrado = repository.findById(connection, 1);
			
			if(veiculoEncontrado.isPresent()) {
				System.out.println("Encontrou o veículo");
				System.out.println(veiculoEncontrado.get());
			}else {
				System.out.println("Não Encontrado");
			}
			
			var veiculoEncontrados = repository.findAll(connection);
			
			if(veiculoEncontrado.isPresent()) {
				for(Veiculo veiculo : veiculoEncontrados.get()) {
					System.out.println(veiculo);
				}
			}
			
			ILojaRepository lojaRepository = new AWSLojaRepository();
			
			Optional<Loja> l = lojaRepository.findById(connection, 3);
			
			if(l.isPresent()) {
				System.out.println("Loja: " + l.get());
			}
			
		} catch (SQLException e) {
			System.out.println("Erro de conexão, motivo: ");
			e.printStackTrace();
		}
	}
}
