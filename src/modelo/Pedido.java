package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Pedido {
	private int idPedido;
	private Cliente cliente;
	private Articulo articulo;
	private int cantidad;
	private LocalDateTime fecha;

	public boolean pedidoEnviado() {
		return false;
	}

	public float precioEnvio() {
		Float pvp = articulo.getPvp();
		Float costeEnvio = articulo.getGastos();
		Integer tipoCliente = cliente.getTipoCliente();
		if (tipoCliente == 2) {
			return (pvp * cantidad) + (costeEnvio - costeEnvio * (cliente.descuentoEnv()/100));
		}
		return (pvp * cantidad) + costeEnvio;
	}

	public Pedido(int idPedido, Cliente cliente, Articulo articulo, int cantidad, String fechaHoraPedido) {
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.articulo = articulo;
		this.cantidad = cantidad;
		this.fecha = parseFecha(fechaHoraPedido);
	}

	public int getNumeroPedido() {
		return idPedido;
	}

	public void setNumeroPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	private LocalDateTime parseFecha(String fechaToParse) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(fechaToParse, formatter);
		return dateTime;
	}

	@Override
	public String toString() {
		return "Pedido{" +
				"idPedido=" + idPedido +
				", cliente=" + cliente +
				", articulo=" + articulo +
				", cantidad=" + cantidad +
				", fecha=" + fecha +
				'}';
	}
}

