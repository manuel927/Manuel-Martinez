/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.CRUD_ESTUDIANTE.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manuel martinez
 */
@Entity
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCodigocurso", query = "SELECT c FROM Curso c WHERE c.codigocurso = :codigocurso"),
    @NamedQuery(name = "Curso.findByNombrecurso", query = "SELECT c FROM Curso c WHERE c.nombrecurso = :nombrecurso"),
    @NamedQuery(name = "Curso.findByCreditos", query = "SELECT c FROM Curso c WHERE c.creditos = :creditos"),
    @NamedQuery(name = "Curso.findBySemestre", query = "SELECT c FROM Curso c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Curso.findByAdmitidos", query = "SELECT c FROM Curso c WHERE c.admitidos = :admitidos")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOCURSO")
    private Integer codigocurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRECURSO")
    private String nombrecurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDITOS")
    private int creditos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEMESTRE")
    private int semestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADMITIDOS")
    private int admitidos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<CursoEstudiantes> cursoEstudiantesCollection;

    public Curso() {
    }

    public Curso(Integer codigocurso) {
        this.codigocurso = codigocurso;
    }

    public Curso(Integer codigocurso, String nombrecurso, int creditos, int semestre, int admitidos) {
        this.codigocurso = codigocurso;
        this.nombrecurso = nombrecurso;
        this.creditos = creditos;
        this.semestre = semestre;
        this.admitidos = admitidos;
    }

    public Integer getCodigocurso() {
        return codigocurso;
    }

    public void setCodigocurso(Integer codigocurso) {
        this.codigocurso = codigocurso;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAdmitidos() {
        return admitidos;
    }

    public void setAdmitidos(int admitidos) {
        this.admitidos = admitidos;
    }

    @XmlTransient
    public Collection<CursoEstudiantes> getCursoEstudiantesCollection() {
        return cursoEstudiantesCollection;
    }

    public void setCursoEstudiantesCollection(Collection<CursoEstudiantes> cursoEstudiantesCollection) {
        this.cursoEstudiantesCollection = cursoEstudiantesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigocurso != null ? codigocurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codigocurso == null && other.codigocurso != null) || (this.codigocurso != null && !this.codigocurso.equals(other.codigocurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.CRUD_ESTUDIANTE.entity.Curso[ codigocurso=" + codigocurso + " ]";
    }
    
}
