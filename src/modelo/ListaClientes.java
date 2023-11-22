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

    public void printListPremium() {
        System.out.println("******* LISTADO DE CLIENTES (PREMIUM)  ********");
        for (Cliente cliente : this.lista) {
            if (cliente.getTipoCliente() == 2) {
                System.out.println(cliente);
            }
        }
    }

    @Override
    public String toString() {
        return "Listado de Clientes " + this.lista;
    }

}
