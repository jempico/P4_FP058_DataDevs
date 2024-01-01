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

    public void addArticulo(Integer codigo, String descripcion, Double precio, Double gastos, Integer preparacion)
    {
        datos.addArticulo(codigo, descripcion, precio, gastos, preparacion);
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

    public List<Pedido> mostrarPedidos() { return datos.mostrarPedidos(); }

    public List<Pedido> mostrarPedidosPendientes() { return datos.mostrarPedidosPendientes(); }

    public void eliminarPedido(int numeroPedido)
    {
        datos.eliminarPedido(numeroPedido);
    }

}

