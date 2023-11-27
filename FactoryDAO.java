package dao;

public class FactoryDAO {

    public static IClienteDAO getClienteDAO() {
        return new ClienteDAO();
    }

    public static IArticuloDAO getArticuloDAO() {
        return new ArticuloDAO();
    }

    public static IPedidoDAO getPedidoDAO() {
        return new PedidoDAO();
    }

	public static IArticuloDAO getDAO(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
