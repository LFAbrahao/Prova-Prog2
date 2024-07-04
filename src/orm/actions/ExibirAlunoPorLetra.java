package orm.actions;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.model.Aluno;
 	
public class ExibirAlunoPorLetra {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o caractere inicial do nome: ");
		String nome = sc.nextLine();
		char letraInicial = nome.charAt(0);
		
		
		String sql = "select a from Aluno a where a.nome like :letraInicial";
		
		Query query = manager.createQuery(sql);
		query.setParameter("letraInicial", letraInicial + "%");
	
		
		List<Aluno> listaAlunos = query.getResultList();
		
		for (Aluno aluno : listaAlunos) {
			System.out.println("Id: " + aluno.getId() + " ====  Nome : " + aluno.getNome() );
			
		}
		
		sc.close();
		manager.close();
		factory.close();
	}
	

}