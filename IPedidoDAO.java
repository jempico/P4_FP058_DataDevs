package dao;

import java.util.List;

import modelo.Pedido;

public interface IPedidoDAO {
	 String addPedido(Integer id);
	   

	void addDato(Pedido pedido);

	Pedido obtenerDato(int id);

	void mostrarDatos();

	void existeDato(int numPedido);

	void eliminarDato(int idPedido);

	void mostrarPedidosPendientes();

	void mostrarPedidosEnviados();

	List<Pedido> pedidosPendientes(String nif);

	List<Pedido> pedidosEnviados(String nif);


	String eliminarPedido(int numPedido);


	void addPedido(Pedido pedido);

}
