package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class RemoverAlunoPorId {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		Aluno aluno = new Aluno();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o Id do Aluno a ser removido: ");
		Long id = sc.nextLong();
		aluno.setId(id);
		aluno = manager.find(Aluno.class, aluno.getId());
		
		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Aluno de Id " + aluno.getId() + " deletado ");
		
		sc.close();
		manager.close();
		factory.close();
		
	}

}
