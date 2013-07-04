package br.com.acad.bean.pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.acad.model.pessoa.Aluno;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable{
	
	//daos
	
	
	
	//aluno
	private List<Aluno> alunos;
	private Aluno alunoSelec;
	
	@PostConstruct
	public void init(){
		alunos = new ArrayList<Aluno>();
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Christian");
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Amanda");
		alunos.add(aluno2);
		alunos.add(aluno1); 
		
		
		
	}
	

	//gets sets
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}


	public Aluno getAlunoSelec() {
		return alunoSelec;
	}


	public void setAlunoSelec(Aluno alunoSelec) {
		this.alunoSelec = alunoSelec;
	}
	

	
}