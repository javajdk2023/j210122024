package br.com.fuctura;

import br.com.fuctura.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Aplicacao {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager em = emf.createEntityManager();

		Veiculo v = new Veiculo("PBF7");
		
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();

		Veiculo veiculoConsulta = em.find(Veiculo.class, 257);

		System.out.println(veiculoConsulta.getPlaca());

		emf.close();
	}

}
