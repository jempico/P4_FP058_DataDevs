package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name="getall", query="select p from Articulo p")
@Table(name = "articulos")
public class Articulo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_articulo")
    private int id_articulo;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "pvp")
    private Double pvp;
    @Basic
    @Column(name = "gastosenvio")
    private Double gastosenvio;
    @Basic
    @Column(name = "preparacion")
    private Integer preparacion;

    public int getid_articulo() {
        return id_articulo;
    }

    public void setid_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public Double getGastosenvio() {
        return gastosenvio;
    }

    public void setGastosenvio(Double gastosenvio) {
        this.gastosenvio = gastosenvio;
    }

    public Integer getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(Integer preparacion) {
        this.preparacion = preparacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulos = (Articulo) o;
        return id_articulo == articulos.id_articulo && Objects.equals(descripcion, articulos.descripcion) && Objects.equals(pvp, articulos.pvp) && Objects.equals(gastosenvio, articulos.gastosenvio) && Objects.equals(preparacion, articulos.preparacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_articulo, descripcion, pvp, gastosenvio, preparacion);
    }

    @Override
    public String toString() {
        return "Articulos{" +
                "id_articulo=" + id_articulo +
                ", descripcion='" + descripcion + '\'' +
                ", pvp=" + pvp +
                ", gastosenvio=" + gastosenvio +
                ", preparacion=" + preparacion +
                '}';
    }
}
