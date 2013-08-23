package br.com.acad.dao.catGenerico.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.acad.dao.catGenerico.interf.SexoCatDAO;
import br.com.acad.dao.generico.impl.DAOImpl;
import br.com.acad.logic.SqlLogic;
import br.com.acad.model.cat.SexoCat;

@Repository
public class SexoCatDAOImpl extends DAOImpl<SexoCat,Integer> implements SexoCatDAO{

	public SexoCatDAOImpl() {
		super();
	}

	@Override
	public List<SexoCat> buscarTodos() {
		TypedQuery<SexoCat> q = getEntityManager().createQuery("from SexoCat", SexoCat.class);
		return q.getResultList();
	}

	@Override
	public long contarTodos(String search) {
		Query q = getEntityManager().createQuery(SqlLogic.getCountSql(SexoCat.STATIC_FIELDS, "SexoCat", search));
		return  (Long) q.getSingleResult();
	}

	@Override
	public List<SexoCat> buscarTodos(int page, String txtSearch, String order) {
		TypedQuery<SexoCat> q = getEntityManager().createQuery(SqlLogic.getSql(SexoCat.STATIC_FIELDS, "SexoCat", txtSearch, order), SexoCat.class);
				
		q.setMaxResults(SqlLogic.TABLE_SIZE);

		if(page>0){
			q.setFirstResult((page -1)*SqlLogic.TABLE_SIZE);
		}else{
			q.setFirstResult(1);
		}
		
		return q.getResultList();
	}

	@Override
	public List<SexoCat> filtrarTodos(int page, Map<String, String> filtros,
			String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long contarTodosFiltro(Map<String, String> filtros) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}