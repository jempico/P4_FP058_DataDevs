package mysql;

import dao.ArticuloDAO;
import dao.DaoException;
import modelo.Articulo;
import modelo.ListaArticulos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlArticuloDAO implements ArticuloDAO {
    private Connection conn;
    final String INSERT = "INSERT INTO articulos(id_articulo, descripcion, pvp, gastosenvio, preparacion) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE articulos SET id_articulo=?, descripcion =?, pvp =?, gastosenvio =?, preparacion=?";
    final String DELETE = "DELETE FROM articulos WHERE id_articulo=?";
    final String GETALL = "SELECT id_articulo, descripcion, pvp, gastosenvio, preparacion FROM articulos";
    final String GETONE = "SELECT id_articulo, descripcion, pvp, gastosenvio, preparacion WHERE id_articulo =?";
    String jdbc = "jdbc:mysql://localhost:3306/onlinestore";

    public MysqlArticuloDAO() {
        try {
            conn = DriverManager.getConnection(jdbc,"root", "1234");
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

    public void modificar(Articulo a) throws DaoException {
    	PreparedStatement stat = null;
    	try {
    		stat.getConnection().prepareStatement(UPDATE);
    		stat.setInt(1, a.getId());
            stat.setString(2, a.getDescripcion());
            stat.setFloat(3, a.getPvp());
            stat.setFloat(4, a.getGastos());
            stat.setInt(5, a.getPreparacion());
            stat.executeUpdate();
    		
    	}catch(SQLException ex) {
    		throw new DaoException("Error de SQL", ex);
    	} finally {
    		if (stat != null) {
    			try {
    				stat.close();
    			}catch (SQLException ex) {
    				throw new DaoException("Error de SQL", ex);
    			}
    		}
    	}
    }
public void eliminar(Articulo a) throws DaoException {
	 PreparedStatement stat = null;
     try {
         stat = conn.prepareStatement(DELETE);
         stat.setInt(1, a.getId());
         if (stat.executeUpdate() == 0) {
             throw new DaoException("Error de SQL");
         }
     } catch (SQLException ex) {
         throw new DaoException("Error de SQL", ex);
     } finally {
         if (stat != null) {
             try {
                 stat.close();
             } catch (SQLException ex) {
                 throw new DaoException("Error de SQL", ex);
             }
         }
     }	
		}
public ArrayList<Articulo> obtenerTodos() throws DaoException {
    Statement stat = null;
    ResultSet rs = null;

    try {
        stat = conn.createStatement();
        rs = stat.executeQuery(GETALL);
        
        ListaArticulos listaArticulos = new ListaArticulos();

        while (rs.next()) {
            int idArticulo = rs.getInt("id_articulo");
            String descripcion = rs.getString("descripcion");
            float pvp = rs.getFloat("pvp");
            float gastosEnvio = rs.getFloat("gastosenvio");
            int preparacion = rs.getInt("preparacion");

            Articulo articulo = new Articulo(idArticulo, descripcion, pvp, gastosEnvio, preparacion);
           
			listaArticulos.add(articulo);
        }
        
        return listaArticulos.mostrarArticulos();


    } catch (SQLException ex) {
        throw new DaoException("Error de SQL", ex);
    } finally {
        cerrarRecursos(stat, rs);
    }

}



	private void cerrarRecursos(Statement stat, ResultSet rs) {
	// TODO Auto-generated method stub
	
}

	@Override
	public Articulo obtener(Integer id) throws DaoException {
		
		    PreparedStatement stat = null;
		    ResultSet rs = null;
		    try {
		        stat = conn.prepareStatement(GETONE);
		        stat.setInt(1, id);
		        rs = stat.executeQuery();

		        if (rs.next()) {
		            // Crear y devolver un objeto Articulo con los datos obtenidos de la base de datos
		            return new Articulo(
		                    rs.getInt("id_articulo"),
		                    rs.getString("descripcion"),
		                    rs.getFloat("pvp"),
		                    rs.getFloat("gastosenvio"),
		                    rs.getInt("preparacion")
		            );
		        } else {
		           throw new DaoException("No se encontró el artículo con ID: " + id);
		        }
		    } catch (SQLException ex) {
		        throw new DaoException("Error de SQL", ex);
		    } finally {
		        if (rs != null) {
		            try {
		                rs.close();
		            } catch (SQLException ex) {
		                throw new DaoException("Error de SQL", ex);
		            }
		        }
		        if (stat != null) {
		            try {
		                stat.close();
		            } catch (SQLException ex) {
		                throw new DaoException("Error de SQL", ex);
		            }
		        }
		    }
		}

	}










