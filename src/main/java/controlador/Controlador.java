package controlador;
import entity.*;
import java.util.ArrayList;
import java.util.List;


public class Controlador {
    public Datos datos;

    public Controlador()
    {
        datos = new Datos();
    }

    public void addArticulo(String descripcion, Double precio, Double gastos, Integer preparacion)
    {
        datos.addArticulo(descripcion, precio, gastos, preparacion);
    }

    public void addPedido(Integer idCliente, Integer idArticulo, Integer cantidad, String fechaHoraPedido)  {
        datos.addPedido(idCliente, idArticulo, cantidad, fechaHoraPedido);
    }

    public void addCliente(String nombre, String domicilio, String email, String nif, Integer tipoCliente)
    {
        datos.addCliente(nombre, domicilio, email, nif, tipoCliente);
    }

    public List<Articulo> mostrarArticulos() { return datos.mostrarArticulos(); }

    public List<Cliente> mostrarClientes() { return datos.mostrarClientes(); }

    public List mostrarClientesEstandar() { return datos.mostrarClientesEstandar(); }

    public List mostrarClientesPremium() { return datos.mostrarClientesPremium(); }


    public List<Pedido> mostrarPedidos() { return datos.mostrarPedidos(); }

    public List<Pedido> mostrarPedidosPendientes() { return datos.mostrarPedidosPendientes(); }

    public List<Pedido> mostrarPedidosPendientes(Integer indexCliente) {
        return datos.mostrarPedidosPendientes(indexCliente);
    }

    public List<Pedido> mostrarPedidosEnviados() { return datos.mostrarPedidosEnviados();}

    public List<Pedido> mostrarPedidosEnviados(Integer indexCliente) {
        return datos.mostrarPedidosEnviados(indexCliente);
    }


    public void eliminarPedido(int numeroPedido)
    {
        datos.eliminarPedido(numeroPedido);
    }

}

