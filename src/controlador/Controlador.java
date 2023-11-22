package controlador;

import modelo.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

	public void mostrarArticulos() {
		ArrayList<Articulo> lista = datos.mostrarArticulos();
		System.out.println("******* LISTADO DE ARTÍCULOS  ********");
		for (Articulo articulo : lista) {
			System.out.println(lista.indexOf(articulo)+1 + ": " + articulo);
		}
		System.out.println("************************************");

	}

	public void addCliente(String nombre, String domicilio, String email, String nif, String tipoCliente)
	{
		datos.addCliente(nombre, domicilio, email, nif, tipoCliente);
	}

	public void mostrarClientes()
	{
		ArrayList<Cliente> lista = datos.mostrarClientes();

		System.out.println("******* LISTADO DE CLIENTES (ESTÁNDAR Y PREMIUM)  ********");
		for (Cliente cliente : lista) {
			System.out.println(lista.indexOf(cliente) + 1 + ": " + cliente);
		}
		System.out.println("***********************************************************");

	}

	public void mostrarClientesEstandar()
	{
		ArrayList<Cliente> lista = datos.mostrarClientesEstandar();

		System.out.println("******* LISTADO DE CLIENTES (ESTÁNDAR)  ********");
		for (Cliente cliente : lista) {
 				System.out.println(cliente);
		}
		System.out.println("**************************************************");

	}

	public void mostrarClientesPremium()
	{
		ArrayList<Cliente> lista = datos.mostrarClientesPremium();

		System.out.println("******* LISTADO DE CLIENTES (PREMIUM)  ********");
		for (Cliente cliente : lista) {
			System.out.println(cliente);
		}
		System.out.println("**************************************************");
	}

	public void addPedido(int idPedido, Integer indexCliente, Integer idArticulo, int cantidad, String fechaHoraPedido)
	{
		datos.addPedido(idPedido, indexCliente, idArticulo, cantidad, fechaHoraPedido);

	}

	public void mostrarPedidos()
	{
		ArrayList<Pedido> lista = datos.mostrarPedidos();

		System.out.println("******* PEDIDOS  ********");
		for (Pedido pedido : lista) {
			System.out.println(pedido);
		}
		System.out.println("*************************");
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
		ArrayList<Pedido> lista = datos.mostrarPedidosEnviados();
		System.out.println("************** PEDIDOS ENVIADOS **************");
		for (Pedido pedido : lista) {
			System.out.println("-----------------------------------------");
			System.out.println("Fecha pedido: " + pedido.getFecha());
			System.out.println("Tiempo preparacion: " + pedido.getArticulo().getPreparacion());
			System.out.println("Fecha actual: " + LocalDateTime.now());
			System.out.println("Minutos de diferencia: " + pedido.calcDiferencia(pedido.getFecha(), LocalDateTime.now()));

		}
		System.out.println("**************************************************");
	}

	public void mostrarPedidosEnviados(Integer indexCliente) {
		datos.mostrarPedidosEnviados(indexCliente);
	}

	public void mostrarPedidosPendientes() {
		ArrayList<Pedido> lista = datos.mostrarPedidosPendientes();
		System.out.println("************** PEDIDOS PENDIENTES **************");
 		for (Pedido pedido : lista) {
			System.out.println("-----------------------------------------");
			System.out.println("Fecha pedido: " + pedido.getFecha());
			System.out.println("Tiempo preparacion: " + pedido.getArticulo().getPreparacion());
			System.out.println("Fecha actual: " + LocalDateTime.now());
			System.out.println("Minutos de diferencia: " + pedido.calcDiferencia(pedido.getFecha(), LocalDateTime.now()));

		}
		System.out.println("**************************************************");
	}

	public void mostrarPedidosPendientes(Integer indexCliente) {
		datos.mostrarPedidosPendientes(indexCliente);
	}
}

