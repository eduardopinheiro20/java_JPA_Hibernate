package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoCategoria {

	
	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagem");

		Categoria categoria2 = new Categoria("Negócio");
		
		Conta c1 = new Conta();
		c1.setId(2);
		
		Movimentacao mov1 = new Movimentacao();
		mov1.setData(Calendar.getInstance());//hoje
		mov1.setDescricao("Viagem para SP");
		mov1.setTipo(TipoMovimentacao.SAIDA);
		mov1.setValor(new BigDecimal("1000"));
		mov1.setCategoria(Arrays.asList(categoria1, categoria2));
		
		mov1.setConta(c1);	
		
		
		Movimentacao mov2 = new Movimentacao();
		mov2.setData(Calendar.getInstance());//hoje
		mov2.setDescricao("Viagem para BH");
		mov2.setTipo(TipoMovimentacao.SAIDA);
		mov2.setValor(new BigDecimal("1500"));
		mov2.setCategoria(Arrays.asList(categoria1, categoria2));
		
		mov2.setConta(c1);
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		//em.persist(categoria1);
		//em.persist(categoria2);
		//em.persist(mov1);
		//em.persist(mov2);
		
		Categoria categoria = em.find(Categoria.class, 4);
		categoria.setNome("Lazer");
		
		
		em.getTransaction().commit();
		em.close();
	}
}
