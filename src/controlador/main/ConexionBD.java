package controlador.main;
import java.sql.*;

public class ConexionBD {

    public static void conectar() {

        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinestore","root", "root");
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM articulos");
            System.out.println("BBDD Correctamente conectada");

            while(resultSet.next()) {
                System.out.println(resultSet.getString("descripcion") + " " + resultSet.getString("pvp"));
            }
        } catch(Exception e) {
            System.out.println("Error en la conexión con BD");
            e.printStackTrace();
        }

    }
}
