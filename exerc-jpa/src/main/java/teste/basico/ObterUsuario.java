package teste.basico;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ObterUsuario {
	
	public static void main(String[] args) {
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exerc-jpa");
		EntityManager em = emf.createEntityManager();
		
		List<Usuario> usuarios = em.createQuery("select u from Usuario u", Usuario.class)
				.setMaxResults(8).getResultList();
		
		for(Usuario usuario: usuarios) {
			System.out.println(" ID: " + usuario.getId() +" Nome " + usuario.getNome()
			+ " E-mail: " + usuario.getEmail());
		}
		
		
		em.close();
		emf.close();
		
	}

}
