package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlteracaoUsuarios {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exerc-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 7L);
		usuario.setNome("Macakscopal ssdd");
		usuario.setEmail("Makakscopal@ssdd.com.br");

		em.merge(usuario); //pegar usuario que está no banco para fazer alteração

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
