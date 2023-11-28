package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;

public interface DaoFactory<T,K> {

    void insertar(T a) throws DaoException;
    void modificar(T a) throws DaoException;
    void eliminar(T a) throws DaoException;
     ArrayList<Articulo> obtenerTodos() throws DaoException;

    T obtener(K id)  throws DaoException;
}