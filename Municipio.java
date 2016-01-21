/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fitec
 */
@Entity
@SqlResultSetMapping(
        name="municipios",
        entities=@EntityResult(entityClass=Municipio.class)
)
@NamedNativeQueries({
    @NamedNativeQuery(name="municipio.concat",query="select concat(m.MunicipioCodigo, d.DepartamentoCodigo) as MunicipioCodigo,"
            + "MunicipioNombre as MunicipioNombre"
            + " from municipio m inner join departamento d on m.DepartamentoCodigo = d.DepartamentoCodigo", 
            resultSetMapping="municipios"),
    @NamedNativeQuery(name="municipiodepartamento.concat",query="select concat(m.MunicipioCodigo, d.DepartamentoCodigo) as MunicipioCodigo,"
            + "MunicipioNombre as MunicipioNombre, d.DepartamentoNombre as DepartamentoNombre"
            + " from municipio m inner join departamento d on m.DepartamentoCodigo = d.DepartamentoCodigo", 
            resultSetMapping="municipios")
        
})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MunicipioCodigo")
    private String municipioCodigo;
    @Basic(optional = false)
    @Column(name = "MunicipioNombre")
    private String municipioNombre;
    
    @Basic(optional = false)
    @Column(name = "DepartamentoNombre")
    private String departamentoNombre;
    

    public Municipio() {
    }

    public String getDepartamentoNombre() {
        return departamentoNombre;
    }

    public void setDepartamentoNombre(String departamentoNombre) {
        this.departamentoNombre = departamentoNombre;
    }
    
    

    public Municipio(String municipioCodigo) {
        this.municipioCodigo = municipioCodigo;
    }

    public Municipio(String municipioCodigo, String municipioNombre, String departamentoNombre) {
        this.municipioCodigo = municipioCodigo;
        this.municipioNombre = municipioNombre;
        this.departamentoNombre = departamentoNombre;

    }

    public String getMunicipioCodigo() {
        return municipioCodigo;
    }

    public void setMunicipioCodigo(String municipioCodigo) {
        this.municipioCodigo = municipioCodigo;
    }

    public String getMunicipioNombre() {
        return municipioNombre;
    }

    public void setMunicipioNombre(String municipioNombre) {
        this.municipioNombre = municipioNombre;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipioCodigo != null ? municipioCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.municipioCodigo == null && other.municipioCodigo != null) || (this.municipioCodigo != null && !this.municipioCodigo.equals(other.municipioCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelos.Municipio[ municipioCodigo=" + municipioCodigo + " ]";
    }

  
}
