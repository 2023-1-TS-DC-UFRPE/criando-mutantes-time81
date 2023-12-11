package br.ufrpe.poo.banco.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.ufrpe.poo.banco.exceptions.ClienteJaPossuiContaException;
import br.ufrpe.poo.banco.exceptions.ClienteNaoPossuiContaException;

/**
 * Classe de teste respons�vel por testar as condi��es dos m�todos
 * adicionarConta e removerConta da classe Cliente.
 * 
 * @author Aluno
 * 
 */
public class TesteCliente {

	private Cliente cliente;

	@Before
	public void setup() {
		cliente = new Cliente("João", "12345678901");
		try {
			cliente.adicionarConta("001");
			cliente.adicionarConta("002");
			cliente.adicionarConta("003");
		} catch (ClienteJaPossuiContaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetNome() {
		Cliente cliente = new Cliente("John Doe", "123456789");
		assertEquals("John Doe", cliente.getNome());
	}

	@Test
	public void testSetNome() {
		Cliente cliente = new Cliente("John Doe", "123456789");
		cliente.setNome("Jane Smith");
		assertEquals("Jane Smith", cliente.getNome());
	}

	@Test
	public void testGetCpf() {
		Cliente cliente = new Cliente("John Doe", "123456789");
		assertEquals("123456789", cliente.getCpf());
	}

	@Test
	public void testSetCpf() {
		Cliente cliente = new Cliente("John Doe", "123456789");
		cliente.setCpf("987654321");
		assertEquals("987654321", cliente.getCpf());
	}

	/**
	 * Testa a inser��o de uma nova conta vinculada ao cliente
	 */
	@Test
	public void adicionarContaTest() {
		Cliente c1 = new Cliente("nome", "123");
		try {
			c1.adicionarConta("1");
		} catch (ClienteJaPossuiContaException e) {
			fail();
		}
		assertEquals(c1.procurarConta("1"), 0);
	}

	/**
	 * Testa a condi��o da tentativa de adicionar uma conta j� existente � lista de
	 * contas do cliente
	 * 
	 * @throws ClienteJaPossuiContaException
	 */

	@Test(expected = ClienteJaPossuiContaException.class)
	public void adicionarContaJaExistenteTest() throws ClienteJaPossuiContaException {
		Cliente c1 = new Cliente("nome", "123");
		 c1.adicionarConta("1"); // adiciona a conta a 1� vez
		c1.adicionarConta("1"); // tentativa de adicionar a mesma conta
								// novamente
	}
	
	@Test(expected = ClienteJaPossuiContaException.class)
	public void adicionarContaInvalidaTest() throws ClienteJaPossuiContaException {
		Cliente c1 = new Cliente("nome", "123");
		// c1.adicionarConta("1"); // adiciona a conta a 1� vez
		c1.adicionarConta("-1"); // tentativa de adicionar a mesma conta
								// novamente
	}

	/**
	 * Teste a remo��o de uma conta da lista de contas do cliente
	 */
	@Test
	public void removerContaClienteTest() {
		Cliente c1 = new Cliente("nome", "123");
		try {
			c1.adicionarConta("1"); // adiciona conta com n�mero 1
			c1.removerConta("1"); // remove a conta de n�mero 1
		} catch (Exception e) {
			fail("Exce��o inesperada lancada!");
		}

		assertEquals(c1.procurarConta("1"), -1);
	}

	/**
	 * Testa a remo��o de uma determinada conta que n�o est� vinculada ao cliente
	 * 
	 * @throws ClienteNaoPossuiContaException
	 */
	@Test(expected = ClienteNaoPossuiContaException.class)
	public void removerContaClienteSemContaTest() throws ClienteNaoPossuiContaException {
		Cliente c1 = new Cliente("nome", "123");
		c1.removerConta("1"); // tenta remover a conta de um cliente sem contas
	}

	@Test
	public void testRemoverTodasAsContas() {
		cliente.removerTodasAsContas();
		assertNull(cliente.getContas());
	}

	@Test
	public void testProcurarConta_Existente() {
		int indice = cliente.procurarConta("002");
		assertEquals(1, indice);
	}

	@Test
	public void testProcurarConta_Inexistente() {
		int indice = cliente.procurarConta("004");
		assertEquals(-1, indice);
	}

	@Test
	public void testEquals() {
		Cliente cliente = new Cliente("João", "12345678901");
		Cliente cliente2 = new Cliente("João", "12345678901");
		assertTrue(cliente.equals(cliente2));
	}
	@Test
	
	public void testEqualsInvalido() {
		
		Conta conta = new Conta("1901", 0);
		Cliente cliente = new Cliente("João", "12345678901");
		assertFalse(cliente.equals(conta));
	}
	

	@Test
	public void testToString() {
		Cliente cliente = new Cliente("João", "12345678901");
		String expected = "Nome: João\nCPF: 12345678901\nContas: []";
		assertEquals(expected, cliente.toString());
	}
}
