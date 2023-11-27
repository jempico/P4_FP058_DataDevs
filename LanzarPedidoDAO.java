package dao;
import java.time.LocalDateTime;
import java.util.List;

import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;


public class LanzarPedidoDAO {


   public String existePedido(Integer id) {
        IPedidoDAO dao = (IPedidoDAO) FactoryDAO.getDAO("Pedido");
        return dao.addPedido(id);
    }

    public String addPedido(int numero_pedido, int unidades_pedido, LocalDateTime fecha_hora_pedido, Cliente cliente, Articulo articulo) {
        IPedidoDAO dao = (IPedidoDAO) FactoryDAO.getDAO("Pedido");
        return dao.addPedido(numero_pedido);
    }

    public String eliminarPedido(int numPedido) {
        IPedidoDAO dao = (IPedidoDAO) FactoryDAO.getDAO("Pedido");
        return dao.eliminarPedido(numPedido);
    }

    public List<Pedido> mostrarPedidosEnviados(String nif) {
        IPedidoDAO dao = (IPedidoDAO) FactoryDAO.getDAO("Pedido");
        return dao.pedidosEnviados(nif);
    }

    public List<Pedido> mostrarPedidosPendientes(String nif) {
        IPedidoDAO dao = (IPedidoDAO) FactoryDAO.getDAO("Pedido");
        return dao.pedidosPendientes(nif);
    }
}
