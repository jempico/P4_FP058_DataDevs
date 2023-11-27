package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionOS {
    private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/onlinestore"; 
    private static final String USUARIO = "root";
    private static final String CLAVE = "1234";

    private static Connection conexion;

  
    public static Connection obtenerConexion() {
        if (conexion == null) {
            try {
                Class.forName(CONTROLADOR);
                conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            } catch (ClassNotFoundException | SQLException e) {
               
            	throw new RuntimeException("Error al conectar con la base de datos", e);
               
            }
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();}
             catch (SQLException e) {
                
                e.printStackTrace();
            }
        }
    }

	public PreparedStatement prepareStatement(Object selectclientes) {
		// TODO Auto-generated method stub
		 if (conexion != null) {
	            try {
	                return conexion.prepareStatement(null);
	            } catch (SQLException e) {
	                
	                e.printStackTrace();
	            }
	        }
		return null;
	}

	

	public void close() {
		// TODO Auto-generated method stub
		
	}
	}

    
    


