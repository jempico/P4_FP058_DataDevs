package dao;

import modelo.Articulo;
import java.util.List;

public interface IArticuloDAO {
    void addDato(Articulo articulo);

    Articulo obtenerDato(Integer id);

    List<Articulo> mostrarDatos(); 

    Articulo buscarArticulo(String codigo);

    boolean existeArticulo(String codigo);

    
    void addArticulo(Integer codigo, String descripcion, float precio, float gastos, Integer preparacion);

    
    Articulo obtenerArticuloPorCodigo(String codigo);

 
    String agregarArticulo(Articulo articulo);

	List<Articulo> mostrarArticulos();

	String addArticulo(Articulo articulo);

	Articulo obtenerArticulo(Integer id);
}
