package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import conexionBD.ConexionOS;
import modelo.Cliente;
import modelo.ClienteEstandard;
import modelo.ClientePremium;
import querysEstaticas.QuerysEstaticas;

public class ClienteDAO implements IClienteDAO {
    ConexionOS cOS = new ConexionOS();
    Connection conexion = cOS.obtenerConexion();

    

    @Override
    public void addDato(Cliente cliente) {
        try {
            String query = "INSERT INTO clientes (nombre, domicilio, email, nif, tipoCliente) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setString(1, cliente.getNombre());
                statement.setString(2, cliente.getDomicilio());
                statement.setString(3, cliente.getEmail());
                statement.setString(4, cliente.getNif());
                statement.setLong(5, cliente.getTipoCliente());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void addCliente(String nombre, String domicilio, String email, String nif, String tipoCliente) {
        // Implementar la lógica para agregar un cliente a la base de datos
    }

    @Override
    public Cliente obtenerDato(Integer id) {
        // Implementar la lógica para obtener un cliente de la base de datos
        return null;
    }

    @Override
    public void mostrarDatos() {
        // Implementar la lógica para mostrar todos los datos (clientes) de la base de datos
    }

    @Override
    public void mostrarClientesPremium() {
        // Implementar la lógica para mostrar los clientes premium de la base de datos
    }

    @Override
    public void mostrarClientesEstandar() {
        // Implementar la lógica para mostrar los clientes estándar de la base de datos
    }

    @Override
    public List<Cliente> mostrarClientes() {
        // Implementar la lógica para obtener y mostrar todos los clientes de la base de datos
        return null;
    }

	@Override
	public String addCliente(Cliente cliente) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean existeCliente(String nif) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
