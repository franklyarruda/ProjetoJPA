package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exerc-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 8L);
		em.detach(usuario);//não altera de tiver esse comando
		
		usuario.setNome("Troca");
		em.merge(usuario);//colocanod o merge ele altera no banco
		
		
		
		
		em.getTransaction().commit();
		
		
		
		emf.close();
		em.clear();
	}

}
