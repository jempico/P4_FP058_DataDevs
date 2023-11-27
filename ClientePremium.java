package modelo;

public class ClientePremium extends Cliente{

	public ClientePremium(String nombre, String domicilio, String email, String nif) {
		super(nombre, domicilio, email, nif, 2);

	}

	@Override
	public String tipoCliente() {
		return "Cliente Premium";
	}

	@Override
	public float calcAnual() {
		return 30;
	}

	@Override
	public float descuentoEnv() {
		return 20;
	}

	@Override
	public String toString() {
		return "ClientePremium{} " + super.toString()+", cuota anual="+ calcAnual()+ ", descuento gastos envío=" + descuentoEnv();
	}
}
