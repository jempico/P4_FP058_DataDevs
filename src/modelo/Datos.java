package modelo;

import java.util.ArrayList;

public class Datos {
	private ListaArticulos listaArticulos;
	private ListaClientes listaClientes;
	private ListaPedidos listaPedidos;

	public Datos() {
		listaArticulos = new ListaArticulos();
		listaClientes = new ListaClientes();
		listaPedidos = new ListaPedidos();
	}

	public void addArticulo(Integer codigo, String descripcion, float precio, float gastos, Integer preparacion) {
		Articulo articulo = new Articulo(codigo, descripcion, precio, gastos, preparacion);
		listaArticulos.add(articulo);
		System.out.println("***Artículo correctamente añadido!!***");
		System.out.println(articulo.toString());
	}


	public void addPedido(Integer idPedido, Integer indexCliente, Integer indexArticulo, Integer cantidad, String fechaHoraPedido) {
		Articulo articulo = listaArticulos.getAt(indexArticulo -1 );
		Cliente cliente = listaClientes.getAt(indexCliente -1 );
		Pedido pedido = new Pedido(idPedido, cliente, articulo, cantidad, fechaHoraPedido);
		listaPedidos.add(pedido);
		System.out.println("***Pedido correctamente añadido!!***");
		System.out.println(pedido.toString());
		System.out.println("-----------------------------------");
		System.out.println("PRECIO FINAL DEL PEDIDO: " + pedido.precioEnvio() + "€");
		System.out.println("-----------------------------------");
		System.out.println("Desglose de precio:");
		System.out.println("Precio del Articulo:" + articulo.getPvp());
		System.out.println("Unidades artículo:" + cantidad);
		System.out.println("Gastos de envío del Articulo:" + articulo.getGastos());
		System.out.println("Descuento aplicado:" + cliente.descuentoEnv() + "%");
		System.out.println("-----------------------------------");



	}

	public void mostrarPedidos()
	{
		listaPedidos.printList();
	}
	public void eliminarPedido(int numeroPedido)
	{
		listaPedidos.eliminarPedido(numeroPedido);
		mostrarPedidos();
	}


	public ArrayList mostrarArticulos() {
		return listaArticulos.getArrayList();

	}

	public void addCliente(String nombre, String domicilio, String email, String nif, String tipoCliente) {

		Cliente cliente;

		if (tipoCliente.equalsIgnoreCase("Estándar")) {
			cliente = new ClienteEstandard(nombre, domicilio, email, nif);
		} else if (tipoCliente.equalsIgnoreCase("Premium")) {
			cliente = new ClientePremium(nombre, domicilio, email, nif);
		} else {
			System.out.println("Tipo de cliente no válido. Se creará como Estándar por defecto.");
			cliente = new ClienteEstandard(nombre, domicilio, email, nif);
		}

		listaClientes.add(cliente);
		System.out.println("***Cliente correctamente añadido!!***");
		System.out.println(cliente.toString());
	}

	public void mostrarClientes() {
		listaClientes.printList();
	}
 	public void mostrarClientesEstandar() {

		listaClientes.printListEstandar();
	}
	public void mostrarClientesPremium() {
		listaClientes.printListPremium();
	}

	public void mostrarPedidosEnviados() {
		listaPedidos.mostrarPedidosEnviados();
	}

	public void mostrarPedidosEnviados(Integer indexCliente) {
		Cliente clienteFound = listaClientes.getAt(indexCliente-1);
		listaPedidos.mostrarPedidosEnviados(clienteFound);
	}
	public void mostrarPedidosPendientes() {
		listaPedidos.mostrarPedidosPendientes();
	}

	public void mostrarPedidosPendientes(Integer indexCliente) {
		Cliente clienteFound = listaClientes.getAt(indexCliente-1);
		listaPedidos.mostrarPedidosPendientes(clienteFound);
	}
}
