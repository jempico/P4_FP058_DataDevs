package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conexionBD.ConexionOS;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;

public class PedidoDAO implements IPedidoDAO {
    ConexionOS cOS = new ConexionOS();
    Connection conexion = cOS.obtenerConexion();

    @Override
    public void addPedido(Pedido pedido) {
        
    }

    @Override
    public void addDato(Pedido pedido) {
        try {
            String query = "INSERT INTO pedidos (idPedido, idCliente, idArticulo, cantidad, fechaHoraPedido) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setInt(1, pedido.getNumeroPedido());
                statement.setString(2, pedido.getCliente().getNif());
                statement.setInt(3, pedido.getArticulo().getId());
                statement.setInt(4, pedido.getCantidad());
                statement.setString(5, pedido.getFecha().toString());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido obtenerDato(int id) {
        // Implementar la lógica para obtener un pedido de la base de datos
        return null;
    }

    @Override
    public void mostrarDatos() {
        // Implementar la lógica para mostrar todos los datos (pedidos) de la base de datos
    }

    @Override
    public void existeDato(int numPedido) {
        // Implementar la lógica para verificar si un pedido existe en la base de datos
    }

    @Override
    public void eliminarDato(int idPedido) {
        // Implementar la lógica para eliminar un pedido de la base de datos
    }

    @Override
    public void mostrarPedidosPendientes() {
        // Implementar la lógica para mostrar los pedidos pendientes de la base de datos
    }

    @Override
    public void mostrarPedidosEnviados() {
        // Implementar la lógica para mostrar los pedidos enviados de la base de datos
    }

    @Override
    public List<Pedido> pedidosPendientes(String nif) {
        // Implementar la lógica para obtener los pedidos pendientes de un cliente específico
        return null;
    }

    @Override
    public List<Pedido> pedidosEnviados(String nif) {
        // Implementar la lógica para obtener los pedidos enviados de un cliente específico
        return null;
    }

	@Override
	public String addPedido(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminarPedido(int numPedido) {
		// TODO Auto-generated method stub
		return null;
	}
}
