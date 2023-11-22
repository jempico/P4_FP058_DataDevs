package modelo;

public class ListaClientes extends Lista<Cliente> {
    public void printListEstandar() {
        System.out.println("******* LISTADO DE CLIENTES (ESTÁNDAR)  ********");
        for (Cliente cliente : this.lista) {
            if (cliente.getTipoCliente() == 1) {
                System.out.println(cliente);
            }
        }
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
