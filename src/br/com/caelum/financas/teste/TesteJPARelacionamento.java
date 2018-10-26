package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setAgencia("0102");
		conta.setBanco("Itau");
		conta.setNumero("12134");
		conta.setTitular("Eduardo Pinheiro");
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Supermecado");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(150.00));
		
		movimentacao.setConta(conta);
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(movimentacao);
		
		
		em.getTransaction().commit();
		em.close();
		
	}
}	
