/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

/**
 *
 * @author Fitec
 */
@Entity
@SqlResultSetMapping(
        name = "categoria_nota",
        entities = @EntityResult(entityClass = CategoriaNota.class)
)
@NamedNativeQueries({
    @NamedNativeQuery(name = "CategoriaNota.findByPersona", query = "SELECT c.codigo AS codigo_categoria,c.nombre AS nombre_categoria,"
            + "n.codigo AS codigo_nota,n.cuerpo AS nombre_nota "
            + "FROM"
            + " categoria c INNER JOIN nota n ON n.codigo_categoria = c.codigo "
            + "WHERE "
            + "	n.codigo_persona = ?",
            resultSetMapping = "categoria_nota")
})
public class CategoriaNota implements Serializable {

    private static final long serialVersionUID = 1L;
 
    @Id
    @Column(name = "codigo_categoria")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigoCAtegoria;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @Column(name = "codigo_nota")
    private Boolean codigoNota;

    @Column(name = "nombre_nota")
    private String nombreNota;

    public Integer getCodigoCAtegoria() {
        return codigoCAtegoria;
    }

    public void setCodigoCAtegoria(Integer codigoCAtegoria) {
        this.codigoCAtegoria = codigoCAtegoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Boolean getCodigoNota() {
        return codigoNota;
    }

    public void setCodigoNota(Boolean codigoNota) {
        this.codigoNota = codigoNota;
    }

    public String getNombreNota() {
        return nombreNota;
    }

    public void setNombreNota(String nombreNota) {
        this.nombreNota = nombreNota;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCAtegoria != null ? codigoCAtegoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaNota)) {
            return false;
        }
        CategoriaNota other = (CategoriaNota) object;
        if ((this.codigoCAtegoria == null && other.codigoCAtegoria != null) || (this.codigoCAtegoria != null && !this.codigoCAtegoria.equals(other.codigoCAtegoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CategoriaNota[ id=" + codigoCAtegoria + " ]";
    }
    
}
