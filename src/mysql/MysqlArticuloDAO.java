package mysql;

import dao.ArticuloDAO;
import dao.DaoException;
import modelo.Articulo;

import java.sql.*;
import java.util.List;

public class MysqlArticuloDAO implements ArticuloDAO {
    private Connection conn;
    final String INSERT = "INSERT INTO articulos(id_articulo, descripcion, pvp, gastosenvio, preparacion) VALUES (?, ?, ?, ?, ?)";
    String jdbc = "jdbc:mysql://localhost:3306/onlinestore";

    public MysqlArticuloDAO() {
        try {
            conn = DriverManager.getConnection(jdbc,"root", "root");
            System.out.println("BBDD Correctamente conectada");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insertar(Articulo a) throws DaoException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getId());
            stat.setString(2, a.getDescripcion());
            stat.setFloat(3, a.getPvp());
            stat.setFloat(4, a.getGastos());
            stat.setInt(5, a.getPreparacion());
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
}
