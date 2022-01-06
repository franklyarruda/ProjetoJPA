package teste.basico;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario extends ObterUsuario {

	public static void main(String[] args) {

		for (int i = 1; i < 10; i++) {

			System.out.println(" -1- para novo usuario -2- para finalizar ");
			Scanner entrada = new Scanner(System.in);
			int decisao = entrada.nextInt();
			if (decisao == 1) {
				System.out.println(" nome ");
				String nome = entrada.next();
				System.out.println(" E-mail ");
				String email = entrada.next();

				EntityManagerFactory emf = Persistence.createEntityManagerFactory("exerc-jpa");
				EntityManager em = emf.createEntityManager();

				Usuario novoUsuario = new Usuario(nome, email);

				em.getTransaction().begin();
				em.persist(novoUsuario);
				em.getTransaction().commit();

				System.out.println(" pesquisa digita o id cadastrado ");
				long a = entrada.nextLong();

				Usuario usuario = em.find(Usuario.class, a);
				System.out.println(usuario.getId());
				System.out.println(usuario.getNome());
				System.out.println(usuario.getEmail());

				em.clear();
				emf.close();
			} else {
				if (decisao == 2) {
					System.out.println("fim do programa");
					break;
				}
				entrada.close();
			}
		}
	}

}
