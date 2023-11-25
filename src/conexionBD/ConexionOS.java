package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionOS {
    private static Connection connection;

    static {
        // Bloque estático para inicializar la conexión
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/onlinestore";
            String usuario = "root";
            String contraseña = "1234";
            connection = DriverManager.getConnection(url, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException e) {
            // Manejo adecuado de la excepción
            e.printStackTrace();
            // Aquí podrías lanzar una excepción personalizada o registrarla según tus
            // necesidades
        }
    }

    public static Connection obtenerConexion() {
        return connection;
    }

    public static void cerrarConexion() {
        if (connection != null) {
            try {
                // Cerrar la conexión solo si está abierta
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Statement obtenerStatement() {
        Statement statement = null;
        try {
            // Obtener la conexión utilizando la conexión existente
            Connection connection = obtenerConexion();
            // Crear un Statement
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
