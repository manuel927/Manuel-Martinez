/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.CRUD_ESTUDIANTE.session;

import co.edu.unipiloto.CRUD_ESTUDIANTE.entity.CursoEstudiantes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author manuel martinez
 */
@Local
public interface CursoEstudiantesFacadeLocal {

    void create(CursoEstudiantes cursoEstudiantes);

    void edit(CursoEstudiantes cursoEstudiantes);

    void remove(CursoEstudiantes cursoEstudiantes);

    CursoEstudiantes find(Object id);

    List<CursoEstudiantes> findAll();

    List<CursoEstudiantes> findRange(int[] range);

    int count();
    
}
