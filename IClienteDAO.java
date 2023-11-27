package dao;

import java.util.List;

import modelo.Cliente;

public interface IClienteDAO {
	

	void addDato(Cliente cliente);

	Cliente obtenerDato(Integer id);

	void mostrarDatos();

	void mostrarClientesPremium();

	void mostrarClientesEstandar();

	List<Cliente> mostrarClientes();

	void addCliente(String nombre, String domicilio, String email, String nif, String tipoCliente);

	String addCliente(Cliente cliente);

	Boolean existeCliente(String nif);

}
