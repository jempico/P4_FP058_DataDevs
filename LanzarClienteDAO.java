package dao;
import modelo.Cliente;
import modelo.ClienteEstandard;
import modelo.ClientePremium;


public class LanzarClienteDAO {

public String añadirCliente(String nif, String nombre, String domi, String mail, String tipoCliente) {
        try {
            Cliente cliente;
            IClienteDAO dao = (IClienteDAO) FactoryDAO.getDAO("Cliente");

            switch (tipoCliente) {
                case "Estándar":
                    cliente = new ClienteEstandard(nif, nombre, domi, mail);
                    break;
                case "Premium":
                    cliente = new ClientePremium(nif, nombre, domi, mail);
                    break;
                default:
                    return "Tipo de cliente no válido";
            }

            return dao.addCliente(cliente);
        } catch (Exception e) {
            return "El cliente no ha podido introducirse correctamente";
        }
    }

    public Boolean existeCliente(String nif) {
        IClienteDAO dao = (IClienteDAO) FactoryDAO.getDAO("Cliente");
        return dao.existeCliente(nif);
    }
}
