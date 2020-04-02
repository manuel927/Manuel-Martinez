/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.CRUD_ESTUDIANTE.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manuel martinez
 */
@Entity
@Table(name = "CURSO_ESTUDIANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoEstudiantes.findAll", query = "SELECT c FROM CursoEstudiantes c"),
    @NamedQuery(name = "CursoEstudiantes.findByCursoid", query = "SELECT c FROM CursoEstudiantes c WHERE c.cursoEstudiantesPK.cursoid = :cursoid"),
    @NamedQuery(name = "CursoEstudiantes.findByStudentid", query = "SELECT c FROM CursoEstudiantes c WHERE c.cursoEstudiantesPK.studentid = :studentid"),
    @NamedQuery(name = "CursoEstudiantes.findById", query = "SELECT c FROM CursoEstudiantes c WHERE c.id = :id")})
public class CursoEstudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursoEstudiantesPK cursoEstudiantesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @JoinColumn(name = "CURSOID", referencedColumnName = "CODIGOCURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiantes estudiantes;

    public CursoEstudiantes() {
    }

    public CursoEstudiantes(CursoEstudiantesPK cursoEstudiantesPK) {
        this.cursoEstudiantesPK = cursoEstudiantesPK;
    }

    public CursoEstudiantes(CursoEstudiantesPK cursoEstudiantesPK, int id) {
        this.cursoEstudiantesPK = cursoEstudiantesPK;
        this.id = id;
    }

    public CursoEstudiantes(int cursoid, int studentid) {
        this.cursoEstudiantesPK = new CursoEstudiantesPK(cursoid, studentid);
    }

    public CursoEstudiantesPK getCursoEstudiantesPK() {
        return cursoEstudiantesPK;
    }

    public void setCursoEstudiantesPK(CursoEstudiantesPK cursoEstudiantesPK) {
        this.cursoEstudiantesPK = cursoEstudiantesPK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoEstudiantesPK != null ? cursoEstudiantesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoEstudiantes)) {
            return false;
        }
        CursoEstudiantes other = (CursoEstudiantes) object;
        if ((this.cursoEstudiantesPK == null && other.cursoEstudiantesPK != null) || (this.cursoEstudiantesPK != null && !this.cursoEstudiantesPK.equals(other.cursoEstudiantesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.CRUD_ESTUDIANTE.entity.CursoEstudiantes[ cursoEstudiantesPK=" + cursoEstudiantesPK + " ]";
    }
    
}
