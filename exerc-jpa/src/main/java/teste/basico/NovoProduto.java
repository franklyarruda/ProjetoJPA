package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	
	public static void main(String[] args) {
		
		
	
	Produto produto = new Produto("makeikossdd1232", 11.21);
	
	DAO<Produto> dao = new DAO<Produto>(Produto.class);
	//dao.abrirT().incluir(produto).fecharT().fechar();
	dao.incluirAtomico(produto);
	
	System.out.println("ID do produto: " + produto.getId());
	}

}
