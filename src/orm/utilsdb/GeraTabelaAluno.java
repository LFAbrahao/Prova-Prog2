package orm.utilsdb;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//classe responsavel pelo DDL -> Data Definition Language
public class GeraTabelaAluno {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		factory.close();
		
	}

}
