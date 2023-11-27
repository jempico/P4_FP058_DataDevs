package controlador;

import vista.GestionOS;
import conexionBD.ConexionOS;
import dao.ArticuloDAO;  
import dao.ClienteDAO;   
import dao.PedidoDAO;    
import dao.IArticuloDAO; 
import dao.IClienteDAO;  
import dao.IPedidoDAO;   

public class OnlineStore {

    public static void main(String[] args) {
        // Inicializar la conexión a la base de datos
        ConexionOS.obtenerConexion();

        // Crear instancias de los DAOs necesarios
        IArticuloDAO articuloDAO = new ArticuloDAO();  
        IClienteDAO clienteDAO = new ClienteDAO();     
        IPedidoDAO pedidoDAO = new PedidoDAO(); 
        
        Controlador controlador = new Controlador(articuloDAO, clienteDAO, pedidoDAO);
        
        // Verificar que las instancias de DAO no son null
        if (articuloDAO != null && clienteDAO != null && pedidoDAO != null) {
            // Iniciar la interfaz de usuario
            GestionOS gestion = new GestionOS(clienteDAO, articuloDAO, pedidoDAO);
            gestion.inicio();
        } else {
            System.out.println("Una o más instancias de DAO son nulas.");
        }

        // Cerrar la conexión a la base de datos al finalizar
        ConexionOS.cerrarConexion();
    }
}
