package br.ufrpe.poo.banco.negocio;

import br.ufrpe.poo.banco.dados.IRepositorioClientes;
import br.ufrpe.poo.banco.dados.IRepositorioContas;
import br.ufrpe.poo.banco.exceptions.InicializacaoSistemaException;
import br.ufrpe.poo.banco.exceptions.RepositorioException;

public class BancoGetInstanceRetornaNovaReferencia extends Banco {
	
	protected BancoGetInstanceRetornaNovaReferencia(IRepositorioClientes clientes, IRepositorioContas contas) {
		super(clientes, contas);
	}

	public static Banco getInstance() throws InicializacaoSistemaException,
			RepositorioException {
		Banco.instance = null;
		return Banco.getInstance();
	}

}
