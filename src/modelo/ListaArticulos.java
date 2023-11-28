package modelo;

import java.util.ArrayList;

public class ListaArticulos  extends Lista<Articulo>{
    
	public ListaArticulos() {
        super();
    }

    public void add(Articulo articulo) {
        super.add(articulo);
    }

    public void borrar(Articulo articulo) {
        super.borrar(articulo);
    }

    public Articulo getAt(int position) {
        return super.getAt(position);
    }

    public void clear() {
        super.clear();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public int getSize() {
        return super.getSize();
    }

    @Override
    public String toString() {
        return "Listado de Articulos: " + this.lista;
    }
    
 // Método para mostrar todos los artículos
    public ArrayList<Articulo> mostrarArticulos() {
        return this.lista;
    }

    // Método para eliminar un artículo por id
    public void eliminarArticulo(int id) {
        boolean found = false;
        for (Articulo articulo : this.lista) {
            if (articulo.getId() == id) {
                found = true;
                this.lista.remove(articulo);
                System.out.println("***Artículo correctamente eliminado!!***");
                return;
            }
        }
        if (!found) {
            System.out.println("No se ha encontrado el artículo");
        }
    }

    
}