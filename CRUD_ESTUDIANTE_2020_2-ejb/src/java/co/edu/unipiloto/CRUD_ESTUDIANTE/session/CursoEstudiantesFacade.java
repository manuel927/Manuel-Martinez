/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.CRUD_ESTUDIANTE.session;

import co.edu.unipiloto.CRUD_ESTUDIANTE.entity.CursoEstudiantes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author manuel martinez
 */
@Stateless
public class CursoEstudiantesFacade extends AbstractFacade<CursoEstudiantes> implements CursoEstudiantesFacadeLocal {

    @PersistenceContext(unitName = "CRUD_ESTUDIANTE_2020_2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoEstudiantesFacade() {
        super(CursoEstudiantes.class);
    }
    
}
