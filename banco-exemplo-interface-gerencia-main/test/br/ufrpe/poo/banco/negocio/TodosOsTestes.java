package br.ufrpe.poo.banco.negocio;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteConta.class, TesteContaImposto.class, TestePoupanca.class,
		TesteContaEspecial.class, TesteBanco.class,
		TesteTransferencia.class,TesteCliente.class})
public class TodosOsTestes {

}
