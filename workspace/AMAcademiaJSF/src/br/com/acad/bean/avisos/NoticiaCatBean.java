package br.com.acad.bean.avisos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.dao.avisos.interf.NoticiaCatDAO;
import br.com.acad.model.avisos.NoticiaCat;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class NoticiaCatBean implements Serializable {

	/************************************************************************************************************/
	//ATRIBUTOS
	/************************************************************************************************************/
	
	//daos
	@EJB
	private NoticiaCatDAO noticiaCatDAO;
	
	//noticiaCat
	private NoticiaCat noticiaCat;
	private List<NoticiaCat> noticiasCats;
	private boolean showIncluirNoticiaCat;
	
	
	
	/************************************************************************************************************/
	//METODOS
	/************************************************************************************************************/
	
	//init
	@PostConstruct
	public void init(){
		noticiasCats = noticiaCatDAO.buscaTodos();
		showIncluirNoticiaCat = false;
	}
	
	//mostra painel de inserção de um novo noticiaCat
	public void showNoticiaCat(){
		noticiaCat = new NoticiaCat();
		showIncluirNoticiaCat = true;
	}
	
	//mostra painel de edição de um noticiaCat
	public void showEditNoticiaCat(){
		showIncluirNoticiaCat = true;
	}
	
	//fecha painel de inserção de noticiaCat
	public void dontShowNoticiaCat(){
		noticiaCat = new NoticiaCat();
		showIncluirNoticiaCat = false;
	}
	
	//inclui ou edita noticiaCait
	public void incluirNoticiaCat(){
		if(noticiaCat.getId()==0){
			noticiaCat = noticiaCatDAO.insert(noticiaCat);
			noticiasCats.add(noticiaCat);
		}else{
			noticiaCatDAO.update(noticiaCat);
		}
		noticiaCat = new NoticiaCat();
		showIncluirNoticiaCat = false;
	}
	
	//deleta noticiaCat
	public void deletarNoticiaCat(){
		noticiaCatDAO.removeById(noticiaCat.getId());
		noticiasCats.remove(noticiaCat);
		showIncluirNoticiaCat = false;
	}
      
	//atualiza informações
	public void atualizar(){
		noticiasCats = noticiaCatDAO.buscaTodos();
		noticiaCat = new NoticiaCat();
		showIncluirNoticiaCat = false;
	}

	
	/************************************************************************************************************/
	//GETS E SETS
	/************************************************************************************************************/
	
	public NoticiaCat getNoticiaCat() {
		return noticiaCat;
	}


	public void setNoticiaCat(NoticiaCat noticiaCat) {
		this.noticiaCat = noticiaCat;
	}


	public List<NoticiaCat> getNoticiasCats() {
		return noticiasCats;
	}


	public void setNoticiasCats(List<NoticiaCat> noticiasCats) {
		this.noticiasCats = noticiasCats;
	}

	public boolean isShowIncluirNoticiaCat() {
		return showIncluirNoticiaCat;
	}

	public void setShowIncluirNoticiaCat(boolean showIncluirNoticiaCat) {
		this.showIncluirNoticiaCat = showIncluirNoticiaCat;
	}

	
	
	
	
	
	
	
	
	
}
