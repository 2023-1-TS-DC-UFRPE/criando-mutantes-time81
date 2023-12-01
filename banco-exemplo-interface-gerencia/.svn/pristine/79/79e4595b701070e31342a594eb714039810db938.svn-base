package br.ufrpe.poo.banco.negocio;

import br.ufrpe.poo.banco.exceptions.SaldoInsuficienteException;

/**
 * Conta bancaria do tipo conta normal.
 * 
 * @author
 * 
 */
public class Conta extends ContaAbstrata {

	private static final long serialVersionUID = 1L;

	public Conta(String numero, double valor) {
		super(numero, valor);
	}

	@Override
	public void debitar(double valor) throws SaldoInsuficienteException {
		if (this.getSaldo() < valor)
			throw new SaldoInsuficienteException(this.getNumero(),
					this.getSaldo());
		this.setSaldo(this.getSaldo() - valor);
	}

}