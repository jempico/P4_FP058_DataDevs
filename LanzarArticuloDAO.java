package dao;

import modelo.Articulo;


import java.util.List;




public class LanzarArticuloDAO {



    public String addArticulo(Integer id, String descripcion, float pvp, float gastosenvio, Integer preparacion) {
        try {
            Articulo articulo = new Articulo(id, descripcion, pvp, gastosenvio, preparacion);
            IArticuloDAO dao = (IArticuloDAO) FactoryDAO.getDAO("Articulo");
            return dao.addArticulo(articulo);
       
        } catch (Exception e) {
            return "El artículo no ha podido introducirse correctamente";
        }
    }

    public List<Articulo> mostrarArticulos() {
        IArticuloDAO dao = (IArticuloDAO) FactoryDAO.getDAO("Articulo");
        return dao.mostrarArticulos();
    }

    public Boolean existeArticulo(String codigo) {
        IArticuloDAO dao = (IArticuloDAO) FactoryDAO.getDAO("Articulo");
        return dao.existeArticulo(codigo);
    }

    public Articulo buscarArticulo(String codigoArticulo) {
        IArticuloDAO dao = (IArticuloDAO) FactoryDAO.getDAO("Articulo");
        return dao.buscarArticulo(codigoArticulo);
    }
}
