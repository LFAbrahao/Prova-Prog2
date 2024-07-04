package orm.actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.model.Aluno;

public class ListarAlunos {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		String sql = "select a from Aluno as a where a.nome is not null and trim(a.nome) <> ''";
		
		Query query = manager.createQuery(sql);
	
		
		List<Aluno> listaAlunos = query.getResultList();
		
		for (Aluno aluno : listaAlunos) {
			System.out.println("Id: " + aluno.getId() + " ====  Nome : " + aluno.getNome() );
			
		}
		
		manager.close();
		factory.close();
	}
	

}
