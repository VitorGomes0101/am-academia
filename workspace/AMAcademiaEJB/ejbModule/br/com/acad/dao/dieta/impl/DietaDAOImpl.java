package br.com.acad.dao.dieta.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.acad.dao.dieta.interf.DietaDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.dieta.Dieta;

@Stateless
public class DietaDAOImpl extends DAOImpl<Dieta,Integer> implements DietaDAO{

	public DietaDAOImpl() {
		super();
	}

	@Override
	public List<Dieta> buscarTodos() {
		TypedQuery<Dieta> q = em.createQuery("from Dieta", Dieta.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = em.createQuery(SqlLogic.getCountSql(Dieta.STATIC_FIELDS, "Dieta", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<Dieta> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<Dieta> q = em.createQuery(SqlLogic.getSql(Dieta.STATIC_FIELDS, "Dieta", txtSearch, order), Dieta.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}
	
	@Override
	public List<Dieta> filtrarTodos(int page, Map<String, String> filtros, String order){
		TypedQuery<Dieta> q = em.createQuery(SqlLogic.getFilterSql(filtros, "Dieta", order), Dieta.class);
		
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		Query q = em.createQuery(SqlLogic.getCountFilterSql("Dieta", filtros));
		return  (Long) q.getSingleResult();
	}

}
