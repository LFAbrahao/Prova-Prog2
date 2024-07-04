package orm.actions;

import java.sql.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class InsereAluno {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		Aluno aluno = new Aluno();
		
		System.out.println("Digite o nome do aluno:");
		aluno.setNome(sc.nextLine());
		System.out.println("Nome = " + aluno.getNome());
		
		System.out.println("Digite o email de " + aluno.getNome() +" :");
		aluno.setEmail(sc.nextLine());
		System.out.println("Email = " + aluno.getEmail());
		
		System.out.println("Digite o cpf:");
		aluno.setCpf(sc.nextLine());
		System.out.println("CPF = " + aluno.getCpf());
		
		System.out.println("Digite data de nascimento (AAAA-MM-DD) :");
		aluno.setDataNascimento(Date.valueOf(sc.nextLine()));
		System.out.println("Data nascimento =" + aluno.getDataNascimento());
		
		System.out.println("Digite a naturalidade:");
		aluno.setNaturalidade(sc.nextLine());
		System.out.println("Naturalidade: " + aluno.getNaturalidade());
		
		System.out.println("Digite o endereco: ");
		aluno.setEndereco(sc.nextLine());
		System.out.println("Endereco: " + aluno.getEndereco());
		
		//2. Conectar ao operador do ORM / JPA
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		//3. Executar a operação:
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Aluno inserido com sucesso");
		System.out.println("ID : " + aluno.getId());
		System.out.println("Nome : " + aluno.getNome());
		
		sc.close();
		manager.close();
		factory.close();
	}
	
}
