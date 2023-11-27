package querysEstaticas;

public class QuerysEstaticas  {

    // Consultas para la tabla de Articulos
    static final String INSERT_ARTICULO =
            "INSERT INTO nombre_de_tu_base_de_datos.ARTICULOS (codigo_articulo, descripcion, precio_venta, gastos_envio, tiempo_preparacion) "
                    + "VALUES (?, ?, ?, ?, ?)";
    static final String SELECT_ALL_ARTICULOS =
            "SELECT * FROM ARTICULOS ORDER BY CODIGO_ARTICULO ASC";
    static final String SELECT_EXISTE_ARTICULO =
            "SELECT codigo_articulo FROM ARTICULOS WHERE CODIGO_ARTICULO = ? ORDER BY CODIGO_ARTICULO ASC";

    // Consultas para la tabla de Clientes
    static final String INSERT_CLIENTE =
            "INSERT INTO nombre_de_tu_base_de_datos.CLIENTES (nif, nombre, domicilio, email, tipo_cliente, cuota_anual, descuento_envio)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    static final String SELECT_EXISTE_CLIENTE =
            "SELECT * FROM nombre_de_tu_base_de_datos.CLIENTES WHERE NIF = ?";
    static final String SELECT_TIPO_CLIENTE =
            "SELECT * FROM nombre_de_tu_base_de_datos.CLIENTES WHERE tipo_cliente = ?";

    // Consultas para la tabla de Pedidos
    static final String DELETE_PEDIDO =
            "DELETE FROM nombre_de_tu_base_de_datos.PEDIDOS WHERE numero_pedido = ?";
    static final String SELECT_PEDIDO =
            "SELECT tiempo_preparacion, fecha_hora_pedido FROM nombre_de_tu_base_de_datos.pedidos " +
                    "INNER JOIN nombre_de_tu_base_de_datos.articulos ON articulo_fk = codigo_articulo " +
                    "WHERE numero_pedido = ?";
    static final String SELECT_EXISTE_PEDIDO =
            "SELECT numero_pedido FROM PEDIDOS WHERE NUMERO_PEDIDO = ? ORDER BY NUMERO_PEDIDO ASC";
    static final String INSERT_PEDIDO =
            "INSERT INTO nombre_de_tu_base_de_datos.PEDIDOS (numero_pedido, unidades_pedido, fecha_hora_pedido, " +
                    "total_pedido, cliente_fk, articulo_fk) VALUES (?, ?, ?, ?, ?, ?)";
    static final String SELECT_ARTICULO =
            "SELECT * FROM ARTICULOS WHERE CODIGO_ARTICULO = ?";
    static final String SELECT_PEDIDO_POR_CLIENTE =
            "SELECT numero_pedido, unidades_pedido, fecha_hora_pedido, total_pedido, nif, nombre, domicilio, email, " +
                    "tipo_cliente, codigo_articulo, descripcion, precio_venta, gastos_envio, tiempo_preparacion " +
                    "FROM nombre_de_tu_base_de_datos.pedidos, nombre_de_tu_base_de_datos.clientes, " +
                    "nombre_de_tu_base_de_datos.articulos WHERE articulo_fk = codigo_articulo " +
                    "AND cliente_fk = nif AND cliente_fk = ?";

    public static String getInsertArticulo() {
        return INSERT_ARTICULO;
    }

    public static String getSelectAllArticulos() {
        return SELECT_ALL_ARTICULOS;
    }

    

    public static String getSelectPedidoPorCliente() {
        return SELECT_PEDIDO_POR_CLIENTE;
    }

	public static Object getSelectclientes() {
		// TODO Auto-generated method stub
		return null;
	}

  
}
