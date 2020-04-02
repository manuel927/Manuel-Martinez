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
@Table(name = "ESTUDIANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByStudentid", query = "SELECT e FROM Estudiantes e WHERE e.studentid = :studentid"),
    @NamedQuery(name = "Estudiantes.findByFirstname", query = "SELECT e FROM Estudiantes e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Estudiantes.findByLastname", query = "SELECT e FROM Estudiantes e WHERE e.lastname = :lastname"),
    @NamedQuery(name = "Estudiantes.findByYearlevel", query = "SELECT e FROM Estudiantes e WHERE e.yearlevel = :yearlevel")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private Integer studentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YEARLEVEL")
    private int yearlevel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiantes")
    private Collection<CursoEstudiantes> cursoEstudiantesCollection;

    public Estudiantes() {
    }

    public Estudiantes(Integer studentid) {
        this.studentid = studentid;
    }

    public Estudiantes(Integer studentid, String firstname, String lastname, int yearlevel) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearlevel = yearlevel;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearlevel() {
        return yearlevel;
    }

    public void setYearlevel(int yearlevel) {
        this.yearlevel = yearlevel;
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
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.CRUD_ESTUDIANTE.entity.Estudiantes[ studentid=" + studentid + " ]";
    }
    
}
