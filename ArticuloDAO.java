package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import conexionBD.ConexionOS;
import modelo.Articulo;
import querysEstaticas.QuerysEstaticas;

public class ArticuloDAO implements IArticuloDAO {
    ConexionOS cOS = new ConexionOS();
    Connection conexion = cOS.obtenerConexion();
 
        public void addDato(Articulo articulo) {
        	 try (PreparedStatement statement = conexion.prepareStatement(QuerysEstaticas.getInsertArticulo())) {
                 statement.setInt(1, articulo.getid());
                 statement.setString(2, articulo.getDescripcion());
                 statement.setFloat(3, articulo.getPvp());
                 statement.setFloat(4, articulo.getGastos());
                 statement.setInt(5, articulo.getPreparacion());

                 // Ejecutar la consulta
                 statement.executeUpdate();
                }
             catch (SQLException e) {
                e.printStackTrace();
            }
        
}

    @Override
    public Articulo obtenerDato(Integer id) {
        // Implementar la lógica para obtener un artículo de la base de datos
        return null;
    }

    @Override
    public List<Articulo> mostrarDatos() {
		return null;
        // Implementar la lógica para mostrar todos los datos (artículos) de la base de datos
    }
    
    @Override
    public String addArticulo(Articulo articulo) {
		return null;
        // Implementar la lógica para agregar un artículo a la base de datos
    }

    @Override
    public List<Articulo> mostrarArticulos() {
        // Implementar la lógica para mostrar todos los artículos de la base de datos
        return null;
    }

    @Override
    public boolean existeArticulo(String codigo) {
        // Implementar la lógica para verificar si un artículo existe en la base de datos
        return false;
    }

    @Override
    public Articulo buscarArticulo(String codigo_articulo) {
        // Implementar la lógica para buscar un artículo por código en la base de datos
        return null;
    }

    @Override
    public Articulo obtenerArticulo(Integer id) {
        // TODO Implementar la lógica para obtener un artículo por su ID
        return null;
    }

	@Override
	
	public void addArticulo(Integer id, String descripcion, float pvp, float gastos, Integer preparacion) {
	    Articulo articulo = new Articulo(id, descripcion, pvp, gastos, preparacion);

	    try (PreparedStatement statement = conexion.prepareStatement(QuerysEstaticas.getInsertArticulo())) {
	        statement.setInt(1, articulo.getid());
	        statement.setString(2, articulo.getDescripcion());
	        statement.setFloat(3, articulo.getPvp());
	        statement.setFloat(4, articulo.getGastos());
	        statement.setInt(5, articulo.getPreparacion());

	        // Ejecutar la consulta
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public Articulo obtenerArticuloPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String agregarArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		return null;
	}

}
