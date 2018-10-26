package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
		
		
		Conta conta = new Conta();
		
		conta.setId(5);
		conta.setTitular("Eduardo");
		conta.setNumero("12121212");
		conta.setAgencia("123");
		conta.setBanco("Santander");
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
	
		em.getTransaction().begin();
		
		conta = em.find(Conta.class, 5);
		
		em.remove(conta);
		
		em.getTransaction().commit();
		
		
		
		
		
		em.close();

		
	}	
	
}