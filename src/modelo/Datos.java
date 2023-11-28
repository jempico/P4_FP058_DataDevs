package modelo;

import dao.DaoException;
import mysql.MysqlArticuloDAO;
import mysql.MysqlPedidoDAO;

import java.util.ArrayList;

public class Datos {
	private ArrayList<Articulo> listaArticulos;
	private ListaClientes listaClientes;
	private ListaPedidos listaPedidos;

	MysqlArticuloDAO mysqlArticuloDAO = new MysqlArticuloDAO();
	MysqlPedidoDAO mysqlPedidoDAO = new MysqlPedidoDAO();

	public Datos() {
		listaArticulos = new ArrayList<>();
		listaClientes = new ListaClientes();
		listaPedidos = new ListaPedidos();
		 mysqlArticuloDAO = new MysqlArticuloDAO();
	}

	public void addArticulo(Integer codigo, String descripcion, float precio, float gastos, Integer preparacion) {
		Articulo articulo = new Articulo(codigo, descripcion, precio, gastos, preparacion);
		listaArticulos.add(articulo);
		try {
			mysqlArticuloDAO.insertar(articulo);
		} catch (DaoException e) {
			throw new RuntimeException(e);
		}

		System.out.println("***Artículo correctamente añadido!!***");
		System.out.println(articulo.toString());
	}


	/*public void addPedido(Integer idPedido, Integer indexCliente, Integer indexArticulo, Integer cantidad, String fechaHoraPedido) {
		Articulo articulo = listaArticulos.getAt(indexArticulo -1 );
		Cliente cliente = listaClientes.getAt(indexCliente -1 );
		Pedido pedido = new Pedido(idPedido, cliente, articulo, cantidad, fechaHoraPedido);
		listaPedidos.add(pedido);
		 try {
			 mysqlPedidoDAO.insertar(pedido);
		} catch (DaoException e) {
			throw new RuntimeException(e);
		}
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



	}*/

	public ArrayList mostrarPedidos()
	{
		return listaPedidos.getArrayList();
	}
	public void eliminarPedido(int numeroPedido)
	{
		listaPedidos.eliminarPedido(numeroPedido);
		mostrarPedidos();
	}


	public ArrayList<Articulo> mostrarArticulos() {
	    try {
	        return mysqlArticuloDAO.obtenerTodos();
	    } catch (DaoException e) {
	        throw new RuntimeException(e);
	    }
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
		// PARA AINHOA:
		//try {
		//			mysqlClienteDAO.insertar(cliente);
		//		} catch (DaoException e) {
		//			throw new RuntimeException(e);
		//		}
		System.out.println("***Cliente correctamente añadido!!***");
		System.out.println(cliente.toString());
	}

	public ArrayList mostrarClientes() {
		return listaClientes.getArrayList();
		// PARA AINHOA:
		//try {
		//			return mysqlClienteDAO.obtenerTodos();
		//		} catch (DaoException e) {
		//			throw new RuntimeException(e);
		//		}

	}
 	public ArrayList mostrarClientesEstandar() {

		return listaClientes.getEstandardClients();
		// PARA ELI:
		//try {
		//			return mysqlClienteDAO.obtenerClientesEstandar(); //<<-- este método tendrá que crearse dentro de mysqlClienteDAO filtrando por la columna tipoCliente = "estandar"
		//		} catch (DaoException e) {
		//			throw new RuntimeException(e);
		//		}

	}
	public ArrayList mostrarClientesPremium() {

		return listaClientes.getPremiumClients();

		// PARA ELI:
		//try {
		//			return mysqlClienteDAO.obtenerClientesPremium(); //<<-- este método tendrá que crearse dentro de mysqlClienteDAO filtrando por la columna tipoCliente = "premium"
		//		} catch (DaoException e) {
		//			throw new RuntimeException(e);
		//		}
	}

	public ArrayList mostrarPedidosEnviados() {
		return listaPedidos.mostrarPedidosEnviados();
	}

	public void mostrarPedidosEnviados(Integer indexCliente) {
		Cliente clienteFound = listaClientes.getAt(indexCliente-1);
		listaPedidos.mostrarPedidosEnviados(clienteFound);
	}
	public ArrayList mostrarPedidosPendientes() {
		return listaPedidos.mostrarPedidosPendientes();
	}

	public void mostrarPedidosPendientes(Integer indexCliente) {
		Cliente clienteFound = listaClientes.getAt(indexCliente-1);
		listaPedidos.mostrarPedidosPendientes(clienteFound);
	}
}
}
