package entity;
import javax.persistence.*;
import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Datos {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;
    Session session;
    SessionFactory sessionFactory;

    public Datos() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");

        // Create EntityManager
        entityManager = entityManagerFactory.createEntityManager();

        // Begin transaction
        transaction = entityManager.getTransaction();
        session = entityManager.unwrap(Session.class);
        sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);

    }

    public void addArticulo(Integer codigo, String descripcion, Double precio, Double gastos, Integer preparacion) {
        try {
            transaction.begin();
            Articulo articulo = new Articulo();
            articulo.setid_articulo(codigo);
            articulo.setDescripcion( descripcion);
            articulo.setPvp(precio);
            articulo.setGastosenvio(gastos);
            articulo.setPreparacion(preparacion);
            entityManager.merge(articulo);
            System.out.println("***Artículo correctamente añadido!!***");
            System.out.println(articulo.toString());
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // Handle exceptions and roll back the transaction if necessary
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }

    public void addPedido(Integer id_cliente, Integer idArticulo, Integer cantidad, String fechaHoraPedido) {

        try {
            transaction.begin();

            if (fechaHoraPedido == null || fechaHoraPedido.trim().isEmpty()) {
                throw new IllegalArgumentException("fechaHoraPedido is null or empty");
            }
            // Parse fechaHoraPedido into a java.util.Date
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            java.util.Date parsedDate = dateFormat.parse(fechaHoraPedido);

            // Convert to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());


            Pedido pedido = new Pedido();
            pedido.setFecha(sqlDate);
            pedido.setCantidad(cantidad);
            pedido.setIdArticulo(idArticulo);
            pedido.setIdCliente(id_cliente);

            entityManager.persist(pedido);
            entityManager.flush(); // Flush changes to the database

            // Clear the persistence context to detach entities
            entityManager.clear();


            Articulo articuloFound = entityManager.find(Articulo.class, idArticulo);

            if (articuloFound != null) {
                System.out.println("Articulo found: " + articuloFound);

            } else {
                System.out.println("Articulo no encontrado con el número: " + idArticulo);
            }

            transaction.commit();

            System.out.println("***Pedido correctamente añadido!!***");
            System.out.println(pedido.toString());
        } catch (Exception e) {
            // Handle exceptions and roll back the transaction if necessary
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }



    public void addCliente(String nombre, String domicilio, String email, String nif, Integer tipoCliente) {
        try {
            transaction.begin();
            Cliente cliente = new Cliente();
            cliente.setNif(nif);
            cliente.setDomicilio(domicilio);
            cliente.setEmail(email);
            if (tipoCliente == 1) {
                cliente.setTipoCliente("premium");
                cliente.setTipo(1);
            } else {
                cliente.setTipoCliente("estándar");
                cliente.setTipo(2);
            }
            cliente.setNombre(nombre);
            cliente.setCalcAnual();
            cliente.setDescuentoEnv();

            entityManager.merge(cliente);
            System.out.println("***Cliente Estandar correctamente añadido!!***");
            System.out.println(cliente.toString());
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // Handle exceptions and roll back the transaction if necessary
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    public List<Articulo> mostrarArticulos() {
        List<Articulo> listArticulo;
        try {
            // get all the objects from Employee table
            listArticulo = entityManager.createNamedQuery("getall", Articulo.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listArticulo;

    }

    public List<Cliente> mostrarClientes() {
        List<Cliente> listaClientes;
        try {
            transaction.begin();
            // get all the objects from Employee table
            listaClientes = entityManager.createNamedQuery("getallClientes", Cliente.class).getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
        return listaClientes;

    }


    public List<Pedido> mostrarPedidos(){
        List<Pedido> listaPedidos;
        try {
            transaction.begin();
            // get all the objects from Employee table
            listaPedidos = entityManager.createNamedQuery("getallPedidos", Pedido.class).getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
        return listaPedidos;

    }

    public void eliminarPedido(int numeroPedido)
    {
        try {
            transaction.begin();

            // Use the EntityManager to find the Pedido entity by its id and then remove it
            Pedido pedido = entityManager.find(Pedido.class, numeroPedido);

            if (pedido != null) {
                entityManager.remove(pedido);
                System.out.println("Pedido eliminado correctamente");
            } else {
                System.out.println("Pedido no encontrado con el número: " + numeroPedido);
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    public List<Pedido> mostrarPedidosPendientes() {

        List<Pedido> pedidosPendientes;
        List<Pedido> pedidos ;

        try {
            transaction.begin();
            // get all the objects from Employee table
            pedidosPendientes = entityManager.createNamedQuery("getallPedidos", Pedido.class).getResultList();
            transaction.commit();
            for (Pedido pedido : pedidosPendientes) {
                //if (pedido.getArticulo().getPreparacion() > pedido.calcDiferencia(pedido.getFecha(), LocalDateTime.now())) {
                //    pedidosPendientes.add(pedido);
                //}
            } } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return pedidosPendientes;
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

}
