package br.com.caelum.financas.util;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class PopulaConta {
	
	public static void main(String[] args) {
		
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		
		
		conta1.setAgencia("456");
		conta1.setBanco("Caixa Economica Federal");
		conta1.setTitular("Felipe");
		conta1.setNumero("12131646464");
		
		
		conta2.setAgencia("789");
		conta2.setBanco("Banco do Brasil");
		conta2.setTitular("Elci");
		conta2.setNumero("1222121");
		
		conta3.setAgencia("9877");
		conta3.setBanco("Bradesco");
		conta3.setTitular("Camilla");
		conta3.setNumero("78794666");
		
		
		//Insere uma conta
		manager.persist(conta1);
		manager.persist(conta2);
		manager.persist(conta3);
		
		manager.getTransaction().commit();
		
		manager.close();
	}
}
