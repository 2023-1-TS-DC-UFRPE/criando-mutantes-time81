package br.ufrpe.poo.banco.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import br.ufrpe.poo.banco.dados.IRepositorioClientes;
import br.ufrpe.poo.banco.dados.IRepositorioContas;
import br.ufrpe.poo.banco.exceptions.ContaJaCadastradaException;
import br.ufrpe.poo.banco.exceptions.InicializacaoSistemaException;
import br.ufrpe.poo.banco.exceptions.RepositorioException;

/**
 * Testa a classe Banco independente da implementação dos repositorios.
 * @author sidneynogueira
 *
 */
public class TesteBancoUnidade {

	private static Banco banco;

	@Before
	public void criaMock() {
		IRepositorioContas contasMock = mock(IRepositorioContas.class); 
		banco = new Banco(null, contasMock);
	}

	@Test
	public void testCadastrarNovaConta() throws InicializacaoSistemaException,
			RepositorioException {

		ContaAbstrata conta1 = new Conta("1", 0);

		// mocking para chamadas de metodos de repositorio de contas que sao
		// realizadas dentro do metodo procurarConta do banco
		when(banco.contas.inserir(conta1)).thenReturn(true);
		when(banco.contas.procurar("1")).thenReturn(conta1);

		try {
			banco.cadastrar(conta1);
			ContaAbstrata conta2 = banco.procurarConta("1");
			assertEquals(conta1, conta2);
		} catch (RepositorioException | ContaJaCadastradaException e) {
			fail();
		}
	}

	@Test(expected = ContaJaCadastradaException.class)
	public void testCadastrarContaExiste()
			throws InicializacaoSistemaException, RepositorioException,
			ContaJaCadastradaException {

		ContaAbstrata conta = new Conta("1", 0);

		// mocking para chamadas de metodos de repositorio de contas que sao
		// realizadas dentro do metodo cadastrar do banco
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