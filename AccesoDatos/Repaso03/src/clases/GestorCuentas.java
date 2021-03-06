package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class GestorCuentas {

	private ArrayList<Cliente> listaClientes;
	private ArrayList<Cuenta> listaCuentas;

	public GestorCuentas() {
		listaClientes = new ArrayList<Cliente>();
		listaCuentas = new ArrayList<Cuenta>();

	}

	public void altaCliente(String dni, String nombre, String fechaNacimiento) {

		Cliente nuevoCliente = new Cliente(dni, nombre);
		nuevoCliente.setFechaNacimiento(LocalDate.parse(fechaNacimiento));

	}

	public void listarClientes() {

		for (Cliente cliente : listaClientes) {
			if (cliente != null) {
				System.out.println(cliente);
			}
		}

	}

	public Cliente buscarCliente(String dni) {

		for (Cliente cliente : listaClientes) {
			if (cliente != null && cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;

	}

	public Cuenta buscarCuenta(String dni) {

		for (Cuenta cuenta : listaCuentas) {
			if (cuenta != null && cuenta.getNumero().equals(dni)) {
				return cuenta;
			}
		}
		return null;

	}

	public void altaCuenta(String numero, double saldo, double interes) {

		Cuenta nuevaCuenta = new Cuenta(numero, saldo, interes);

		listaCuentas.add(nuevaCuenta);

	}

	public void altaCuentaCorriente(String numero, double saldo, double interes) {

		Cuenta nuevaCuenta = new CuentaCorriente(numero, saldo, interes);

		listaCuentas.add(nuevaCuenta);

	}

	public void altaCuentaPlanPesiones(String numero, double saldo, double interes, double cotizacion) {

		Cuenta nuevaCuenta = new CuentaPlanPension(numero, saldo, interes, cotizacion);

		listaCuentas.add(nuevaCuenta);

	}

	public void altaCuentaAhorro(String numero, double saldo, double interes) {

		Cuenta nuevaCuenta = new CuentaAhorro(numero, saldo, interes);

		listaCuentas.add(nuevaCuenta);

	}

	public void eliminarCuenta(String numero) {
		Iterator<Cuenta> iteradorCuentas = listaCuentas.iterator();

		while (iteradorCuentas.hasNext()) {
			Cuenta cuenta = iteradorCuentas.next();
			if (cuenta.getNumero().equals(numero)) {
				iteradorCuentas.remove();
			}
		}

	}

	public void listarCuentas() {

		for (Cuenta cuenta : listaCuentas) {

			if (cuenta != null) {
				System.out.println(cuenta);
			}

		}

	}

	public void listarCuentasTitular(String dni) {

		for (Cuenta cuenta : listaCuentas) {

			if (cuenta.getTitular() != null && cuenta.getTitular().getDni().equals(dni)) {
				System.out.println(cuenta);
			}

		}

	}

	public void asignarCuentaCliente(String dni, String numeroCuenta) {

		Cliente cliente = buscarCliente(dni);
		Cuenta cuenta = buscarCuenta(numeroCuenta);
		cuenta.setTitular(cliente);

	}

	public void ingreso(Cuenta cuenta, int dinero) {
		cuenta.ingreso(dinero);
	}

	public void reintegro(CuentaCorriente cuenta, int dinero) {
		cuenta.ingreso(dinero);
	}

	public void ingresoMes(CuentaAhorro cuenta) {
		cuenta.ingresoMes();
	}

}
