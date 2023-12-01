package br.ufrpe.poo.banco.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import br.ufrpe.poo.banco.dados.IRepositorioContas;
import br.ufrpe.poo.banco.exceptions.ContaJaCadastradaException;
import br.ufrpe.poo.banco.exceptions.InicializacaoSistemaException;
import br.ufrpe.poo.banco.exceptions.RepositorioException;

/**
 * Especializacao de Banco utilizada para testar o Banco como um unidade. Em
 * cada testes usa um repositorio mock no lugar do repositorio.
 * 
 */
public class TesteBancoUnidade extends Banco {

	/**
	 * Constroi Banco passando um repositorio nulo. Em cada teste um objeto mock
	 * sera utilizado no lugar da referencia nula.
	 */
	public TesteBancoUnidade() {
		super(null,null);
	}
	
	@Test
	public void testCadastrarNovaConta()
			throws InicializacaoSistemaException, RepositorioException {
		
		TesteBancoUnidade banco = new TesteBancoUnidade();
		ContaAbstrata conta1 = new Conta("1", 0);
		
		//mocking do repositorio de contas
		banco.contas = mock(IRepositorioContas.class);
		when(banco.contas.inserir(conta1)).thenReturn(true);
		when(banco.contas.procurar("1")).thenReturn(conta1);		

		try {
			banco.cadastrar(conta1);
			ContaAbstrata conta2 = banco.procurarConta("1");
			assertEquals(conta1, conta2);
		} catch (RepositorioException e) {
			fail();
		} catch (ContaJaCadastradaException e) {
			fail();
		} 
	}

	@Test(expected = ContaJaCadastradaException.class)
	public void testCadastrarContaExiste()
			throws InicializacaoSistemaException, RepositorioException, 
			ContaJaCadastradaException {
		
		TesteBancoUnidade banco = new TesteBancoUnidade();
		ContaAbstrata conta = new Conta("1", 0);
		
		//mocking do repositorio de contas
		banco.contas = mock(IRepositorioContas.class);
		when(banco.contas.inserir(conta)).thenReturn(false);
		
		try {
			banco.cadastrar(conta);
			fail("ContaJaCadastradaException nao foi lancada");
		} catch (RepositorioException e) {
			fail();
		} 
	}

}