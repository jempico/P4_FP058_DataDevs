
    package controlador;

    import modelo.*;
    import dao.*;

    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.List;
   


    public class Controlador {
        private IArticuloDAO articuloDAO;
        private IClienteDAO clienteDAO;
        private IPedidoDAO pedidoDAO;
       

        public Controlador(IArticuloDAO articuloDAO, IClienteDAO clienteDAO, IPedidoDAO pedidoDAO) {
            this.articuloDAO = articuloDAO;
            this.clienteDAO = clienteDAO;
            this.pedidoDAO = pedidoDAO;
            
        }

        public Controlador(IClienteDAO clienteDAO2, IArticuloDAO articuloDAO2, IPedidoDAO pedidoDAO2) {
            // TODO Auto-generated constructor stub
        }

    	public void addArticulo(Integer codigo, String descripcion, float precio, float gastos, Integer preparacion) {
            Articulo articulo = new Articulo(codigo, descripcion, precio, gastos, preparacion);
            articuloDAO.addDato(articulo);
        }

        public Articulo obtenerArticulo(Integer id) {
            return articuloDAO.obtenerDato(id);
        }

        public void addCliente(String nombre, String domicilio, String email, String nif, String tipoCliente) {
            Cliente cliente;
            if (tipoCliente.equalsIgnoreCase("Estándar")) {
                cliente = new ClienteEstandard(nombre, domicilio, email, nif);
            } else if (tipoCliente.equalsIgnoreCase("Premium")) {
                cliente = new ClientePremium(nombre, domicilio, email, nif);
            } else {
               
                return;
            }

            clienteDAO.addDato(cliente);
        }

        public Cliente obtenerCliente(Integer id) {
            return clienteDAO.obtenerDato(id);
        }

        public void addPedido(int idPedido, Integer indexCliente, Integer idArticulo, int cantidad, String fechaHoraPedido) {
            Cliente cliente = clienteDAO.obtenerDato(indexCliente);
            Articulo articulo = articuloDAO.obtenerDato(idArticulo);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime fechaFormateada = LocalDateTime.parse(fechaHoraPedido, formatter);
            Pedido pedido = new Pedido(idPedido, cliente, articulo, cantidad, fechaFormateada);

            pedidoDAO.addDato(pedido);
            
        }

        public Pedido obtenerPedido(int id) {
            return pedidoDAO.obtenerDato(id);
            
        }
        
        
        // Métodos de consulta
        
        public List<Articulo> mostrarArticulos() {
            articuloDAO.mostrarDatos();
    		return null;
        }


        public void mostrarPedidosEnviados() {
            pedidoDAO.mostrarPedidosEnviados();
        }

    	

    	public void mostrarPedidosPendientes() {
    		pedidoDAO.mostrarPedidosPendientes();
    	}

    	public void eliminarPedido(int idPedido) {
    		 pedidoDAO.eliminarDato(idPedido);
    		
    	}

    	public void existePedido(int numPedido) {
    		pedidoDAO.existeDato(numPedido);
    	}

    	public  void mostrarPedidos() {
    		pedidoDAO.mostrarDatos();
    	}

    	public void mostrarClientesEstandar() {
    		clienteDAO.mostrarClientesEstandar();
    	}

    	public  void mostrarClientesPremium() {
    		clienteDAO.mostrarClientesPremium();
    	}

    	public void mostrarClientes() {
            clienteDAO.mostrarDatos();
        }
    }


