package br.com.acad.bean.pessoa;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.bean.Bean;
import br.com.acad.dao.pessoa.interf.ProfessorFuncDAO;
import br.com.acad.model.pessoa.ProfessorFunc;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProfessorBean extends Bean<ProfessorFunc> implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	@EJB
	private ProfessorFuncDAO professorFuncDAO;
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	@PostConstruct
	@Override
	public void init() {
		page = 1;
		dao = professorFuncDAO;
		staticFields = ProfessorFunc.STATIC_FIELDS;
		staticFieldsOrderLabel = ProfessorFunc.STATIC_FIELDS_ORDER_LABEL;
		staticFieldsOrderValue = ProfessorFunc.STATIC_FIELDS_ORDER_VALUE;
		order = staticFieldsOrderLabel[0];
		atualizar();
	}
	
	/**
	 * show form de entity
	 */
	@Override
	public void showNewEntity() {
		showEntity = true;
		entity = new ProfessorFunc();
	}

	/**
	 * inclui ou edita entity no banco
	 */
	@Override
	public void incluirEntity() {
		entity.setIsProfessor(true);
		incluirGeneric( entity!=null? entity.getId():0);
	}

	/**
	 * deleta entity do banco
	 */
	@Override
	public void deletarEntity() {
		deletarGeneric(entity!=null?entity.getId():0);
	}
	
	/**
	 * Sobreescrita do metodo buscarTodos para buscar somente professores
	 */
	@Override
	public List<ProfessorFunc> buscarTodos() {
		if(search!=null && search.length()>0){
			page = 1;
		}
		if(staticFieldsOrderLabel!=null){
			int posicao =  Arrays.asList(staticFieldsOrderLabel).indexOf(order);
			return professorFuncDAO.buscarTodosProf(page, search, staticFieldsOrderValue[posicao]);
		}else{
			return professorFuncDAO.buscarTodosProf(page, search, order);
		}
	}
	
	
	/**
	 * Sobreescrita do metodo contarTodos para contar somente professores
	 */
	@Override
	public long contarTodos() {
		return professorFuncDAO.contarTodosProf(search);
	}
	
	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
