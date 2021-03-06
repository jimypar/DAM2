package main;

import clases.CuentaAhorro;
import clases.CuentaCorriente;
import clases.GestorCuentas;

public class Main {

	public static void main(String[] args) {

		System.out.println("Creamos un banco");
		GestorCuentas banco = new GestorCuentas();
		System.out.println("Creamos 2 clientes y listamos");
		banco.altaCliente("1111111", "Alberto", "1999-11-01");
		banco.altaCliente("2222222", "Carlos", "2000-02-28");
		banco.listarClientes();
		System.out.println("");

		System.out.println("Buscar cliente 1111111");
		System.out.println(banco.buscarCliente("1111111"));

		System.out.println("");
		System.out.println("Creamos tres cuentas y listamos");
		banco.altaCuenta("11-1111-11", 124, 0.2);
		banco.altaCuenta("22-2222-22", 654, 0.3);
		banco.altaCuenta("33-3333-33", 541, 0.2);
		banco.listarCuentas();
		System.out.println("4? Asignar titulares y listar");
		banco.asignarCuentaCliente("1111111", "11-1111-11");
		banco.asignarCuentaCliente("2222222", "22-2222-22");
		banco.asignarCuentaCliente("3333333", "33-3333-33");
		banco.listarCuentas();
		System.out.println("");
		System.out.println("5? Buscar cuenta 11-1111-11");
		System.out.println(banco.buscarCuenta("11-1111-11"));
		System.out.println("");
		System.out.println("6? Listar cuentas de un titular");
		banco.listarCuentasTitular("1111111");
		System.out.println("");
		System.out.println("7? Eliminar cuenta 11-1111-11 y listamos");
		banco.eliminarCuenta("11-1111-11");
		banco.listarCuentas();

		System.out.println("");
		System.out.println("8? Creamos una cuenta plan pensiones,asignamos titular");
		banco.altaCuentaPlanPesiones("44-4444-44", 321, 0.15, 0.35);
		banco.asignarCuentaCliente("1111111", "44-4444-44");
		banco.listarCuentas();
		System.out.println("");
		System.out.println("9? Creamos cuenta de ahorro fija, asignamos titular y listamos");
		banco.altaCuentaAhorro("55-5555-55", 354, 0.15);
		banco.asignarCuentaCliente("1111111", "55-5555-55");
		banco.listarCuentas();
		System.out.println("");
		System.out.println("10? Crear cuenta corriente asignamos titular y listamos");
		banco.altaCuentaCorriente("66-6666-66", 475, 0.3);
		banco.asignarCuentaCliente("2222222", "66-6666-66");
		banco.listarCuentas();
		System.out.println("");
		System.out.println("11? Ingreso en cuenta y listar");
		banco.ingreso(banco.buscarCuenta("33-3333-33"), 225);
		banco.listarCuentas();
		System.out.println("");
		System.out.println("12? reintegro de una cuenta corriente y listamos");
		banco.reintegro((CuentaCorriente) banco.buscarCuenta("66-6666-66"), 120);
		banco.listarCuentas();
		System.out.println("");
		System.out.println("13? Ingreso mes en una cuenta ahorro fija y listar");
		banco.ingresoMes((CuentaAhorro) banco.buscarCuenta("55-5555-55"));
		banco.listarCuentas();

	}

}
