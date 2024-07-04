package orm.actions;

import java.sql.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class AtualizarAlunoPorId {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Aluno aluno = new Aluno();
		
		System.out.println("Digite o Id do Aluno a ser Alterado");
		aluno.setId(sc.nextLong());
		sc.nextLine();
		
		System.out.println("Digite o nome");
		aluno.setNome(sc.nextLine());
		
		System.out.println("Digite o email");
		aluno.setEmail(sc.nextLine());
		
		System.out.println("Digite o cpf:");
		aluno.setCpf(sc.nextLine());
		
		System.out.println("Digite data de nascimento (AAAA-MM-DD) :");
		aluno.setDataNascimento(Date.valueOf(sc.nextLine()));
		
		System.out.println("Digite a naturalidade:");
		aluno.setNaturalidade(sc.nextLine());
		
		System.out.println("Digite o endereco: ");
		aluno.setEndereco(sc.nextLine());
		
		
		//2
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		//3. Operar com "merge"
		manager.getTransaction().begin();
		manager.merge(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Cadastro Atualizado");
		
		sc.close();
		manager.close();
		factory.close();
	}
	
}
