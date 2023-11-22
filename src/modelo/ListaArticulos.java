package modelo;

public class ListaArticulos  extends Lista<Articulo>{
    
    @Override
    public String toString() {
        return "Listado de Articulos " + this.lista;
    }
}
