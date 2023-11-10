package controlador;

import modelo.*;

public class Controlador {
	public Datos datos;

	public Controlador()
	{
		datos = new Datos();
	}

	public void addArticulo(Integer codigo, String descripcion, float precio, float gastos, Integer preparacion)
	{
		datos.addArticulo(codigo, descripcion, precio, gastos, preparacion);
	}

	public void mostrarArticulos()
	{
		datos.mostrarArticulos();
	}

	public void addCliente(String nombre, String domicilio, String email, String nif, String tipoCliente)
	{
		datos.addCliente(nombre, domicilio, email, nif, tipoCliente);
	}

	public void mostrarClientes()
	{
		datos.mostrarClientes();
	}

	public void mostrarClientesEstandar()
	{
		datos.mostrarClientesEstandar();
	}

	public void mostrarClientesPremium()
	{
		datos.mostrarClientesPremium();
	}

	public void addPedido(int idPedido, Integer indexCliente, Integer idArticulo, int cantidad, String fechaHoraPedido)
	{
		datos.addPedido(idPedido, indexCliente, idArticulo, cantidad, fechaHoraPedido);

	}

	public void mostrarPedidos()
	{
		datos.mostrarPedidos();
	}

	public void eliminarPedido(int numeroPedido)
	{
		datos.eliminarPedido(numeroPedido);
	}

	public boolean existePedido(int numPedido)
	{
        return false;
    }

	public void mostrarPedidosEnviados() {
		datos.mostrarPedidosEnviados();
	}

	public void mostrarPedidosEnviados(Integer indexCliente) {
		datos.mostrarPedidosEnviados(indexCliente);
	}

	public void mostrarPedidosPendientes() {
		datos.mostrarPedidosPendientes();
	}

	public void mostrarPedidosPendientes(Integer indexCliente) {
		datos.mostrarPedidosPendientes(indexCliente);
	}
}

