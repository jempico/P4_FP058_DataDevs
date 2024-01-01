package entity;

public class ListaArticulos  extends Lista<Articulo>{

    @Override
    public String toString() {
        return "Listado de Articulos " + this.lista;
    }


    public Articulo findById(Integer id) {
        Articulo articuloFound = null;
        for (Articulo articulo : this.lista) {
            if (articulo.getid_articulo() == id) {
                articuloFound = articulo;
            }
        }
        return articuloFound;
    }
}
