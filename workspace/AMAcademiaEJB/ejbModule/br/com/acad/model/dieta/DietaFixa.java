package br.com.acad.model.dieta;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.model.catGenerico.FaixaEtariaCat;
import br.com.acad.model.catGenerico.ObjetivoCat;
import br.com.acad.model.catGenerico.SexoCat;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_DIETA_FIXA")
@PrimaryKeyJoinColumn(name="ID_DIETA_ESPECIFICA")
public class DietaFixa extends Dieta {

	
	@ManyToMany
	@JoinTable(name="ACAD_DIETA_FIXA_LIMITACAO_CAT", 
				joinColumns={@JoinColumn(name="DIETA_FIXA_ID")},
				inverseJoinColumns={@JoinColumn(name="LIMITACAO_ID")})
	private List<LimitacaoDietaCat> limitacoes;
	
	@ManyToOne
	@JoinColumn(name="SEXO_ID", nullable=false)
	private SexoCat sexo;
	
	@ManyToOne
	@JoinColumn(name="FAIXA_ETARIA_ID", nullable=false)
	private FaixaEtariaCat faixaEtaria;
	
	@ManyToOne
	@JoinColumn(name="OBJETIVO_ID", nullable=false)
	private ObjetivoCat objetivo;
	
	public DietaFixa(){}

	public List<LimitacaoDietaCat> getLimitacoes() {
		return limitacoes;
	}

	public void setLimitacoes(List<LimitacaoDietaCat> limitacoes) {
		this.limitacoes = limitacoes;
	}

	public SexoCat getSexo() {
		return sexo;
	}

	public void setSexo(SexoCat sexo) {
		this.sexo = sexo;
	}

	public ObjetivoCat getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(ObjetivoCat objetivo) {
		this.objetivo = objetivo;
	}

	public FaixaEtariaCat getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(FaixaEtariaCat faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	
	
	
}
