package br.com.acad.bean.pessoa;

import java.io.Serializable;
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
public class FuncionarioBean extends Bean<ProfessorFunc> implements Serializable {

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
		atualizar();
		atualizaPages();
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
		entity.setIsProfessor(false);
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
	 * Sobreescrita do metodo buscarTodos para buscar somente funcionario
	 */
	@Override
	public List<ProfessorFunc> buscarTodos() {
		return professorFuncDAO.buscarTodosFunc(page, search, order);
	}
	
	
	/**
	 * Sobreescrita do metodo contarTodos para contar somente funcionario
	 */
	@Override
	public long contarTodos() {
		return professorFuncDAO.contarTodosFunc(search);
	}

	/************************************************************************************************************/
	//GET FIELDS
	/************************************************************************************************************/
	
	

	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	
}
