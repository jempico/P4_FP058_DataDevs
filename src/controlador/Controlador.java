package controlador;

import modelo.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

import dao.ArticuloDAO;

public class Controlador {
	private final ArticuloDAO articuloDAO;// Código añadido para DAO
	
	public Datos datos;

	 public Controlador(ArticuloDAO articuloDAO) {// Código añadido para DAO
	        this.articuloDAO = articuloDAO;
	        
	{}
		datos = new Datos();
	}
	// Agregado constructor sin argumentos
	    public Controlador() {
	        this.articuloDAO = null;
	        datos = new Datos();
	    }
	 
	public void addArticulo(Integer codigo, String descripcion, float precio, float gastos, Integer preparacion)
	{
		datos.addArticulo(codigo, descripcion, precio, gastos, preparacion);
	}

	public ArrayList mostrarArticulos() { return datos.mostrarArticulos(); }

	public void addCliente(String nombre, String domicilio, String email, String nif, String tipoCliente)
	{
		datos.addCliente(nombre, domicilio, email, nif, tipoCliente);
	}

	public ArrayList mostrarClientes() { return datos.mostrarClientes(); }

	public ArrayList mostrarClientesEstandar() { return datos.mostrarClientesEstandar(); }

	public ArrayList mostrarClientesPremium() { return datos.mostrarClientesPremium(); }

	/*public void addPedido(int idPedido, Integer indexCliente, Integer idArticulo, int cantidad, String fechaHoraPedido)  {
		datos.addPedido(idPedido, indexCliente, idArticulo, cantidad, fechaHoraPedido);
	}*/

	public ArrayList mostrarPedidos() { return datos.mostrarPedidos(); }

	public void eliminarPedido(int numeroPedido)
	{
		datos.eliminarPedido(numeroPedido);
	}

	public boolean existePedido(int numPedido)
	{
        return false;
    }

	public ArrayList mostrarPedidosEnviados() { return datos.mostrarPedidosEnviados();}

	public void mostrarPedidosEnviados(Integer indexCliente) {
		datos.mostrarPedidosEnviados(indexCliente);
	}

	public ArrayList mostrarPedidosPendientes() { return datos.mostrarPedidosPendientes(); }

	public void mostrarPedidosPendientes(Integer indexCliente) {
		datos.mostrarPedidosPendientes(indexCliente);
	}
}


