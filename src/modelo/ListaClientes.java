package modelo;

import java.util.ArrayList;
public class ListaClientes extends Lista<Cliente> {
    public ArrayList getEstandardClients() {
        ArrayList clientesEstandar = new ArrayList<>();
        for (Cliente cliente : this.lista) {
            if (cliente.getTipoCliente() == 1) {
                clientesEstandar.add(cliente);

            }
        }
        return clientesEstandar;
    }

    public ArrayList getPremiumClients() {
        ArrayList clientesEstandar = new ArrayList<>();
        for (Cliente cliente : this.lista) {
            if (cliente.getTipoCliente() == 2) {
                clientesEstandar.add(cliente);

            }
        }
        return clientesEstandar;
    }

    @Override
    public String toString() {
        return "Listado de Clientes " + this.lista;
    }

}
