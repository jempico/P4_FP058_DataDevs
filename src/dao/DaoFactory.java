package dao;

import java.util.List;

public interface DaoFactory<T,K> {

    void insertar(T a) throws DaoException;
    //void modificar(T a) throws DaoException;
    void eliminar(K id) throws DaoException;
    List<T> obtenerTodos() throws DaoException;
    T obtener(K id) throws DaoException;
}