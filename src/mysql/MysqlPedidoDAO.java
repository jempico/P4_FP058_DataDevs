package mysql;

import dao.ArticuloDAO;
import dao.DaoException;
import dao.PedidoDAO;
import modelo.Articulo;
import modelo.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlPedidoDAO implements PedidoDAO {
    private Connection conn;
    final String INSERT = "INSERT INTO pedidos(id_pedido, cantidad, fecha, id_cliente, id_articulo) VALUES (?, ?, ?, ?, ?)";
    String jdbc = "jdbc:mysql://localhost:3306/onlinestore";

    public MysqlPedidoDAO() {
        try {
            conn = DriverManager.getConnection(jdbc,"root", "1234");
            System.out.println("BBDD Correctamente conectada");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insertar(Pedido a) throws DaoException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getNumeroPedido());
            //stat.setObject(2, a.getCliente()); hay que convertirlo, de momento lo guardamos sin el objeto Cliente
            //stat.setObject(3, a.getArticulo()); hay que convertirlo, de momento lo guardamos sin el objeto Articulo
            stat.setInt(2, a.getCantidad());
            stat.setDate(3,  a.getFechaSqlDate());
            stat.setString(4, a.getCliente().getNif());
            stat.setInt(5, a.getArticulo().getId());
            stat.executeUpdate();
        }catch(SQLException ex) {
            throw new DaoException("Error en SQL", ex);
        }
        finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DaoException("Error en SQL", ex);
                }
            }
        }
    }

	@Override
	public void modificar(Pedido a) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Pedido a) throws DaoException {
		// TODO Auto-generated method stub
		
	}


	

	@Override
	public Pedido obtener(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Articulo> obtenerTodos() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}


}

