package br.com.acad.model.treino;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.acad.model.catGenerico.FaixaEtariaCat;
import br.com.acad.model.catGenerico.ObjetivoCat;
import br.com.acad.model.catGenerico.SexoCat;

@SuppressWarnings("serial")
@Entity
@Table(name="ACAD_TREINO_FIXO")
@PrimaryKeyJoinColumn(name="ID_TREINO_FIXO")
public class TreinoFixo extends Treino {

	@ManyToOne
	@JoinColumn(name="SEXO_ID", nullable=false)
	private SexoCat sexo;
	
	@ManyToOne
	@JoinColumn(name="FAIXA_ETARIA_ID", nullable=false)
	private FaixaEtariaCat faixaEtaria;
	
	@ManyToOne
	@JoinColumn(name="OBJETIVO_ID", nullable=false)
	private ObjetivoCat objetivo;
	
	@ManyToOne
	@JoinColumn(name="DURACAO_TREINO_ID", nullable=false)
	private DuracaoTreinoCat duracao;
	
	@ManyToOne
	@JoinColumn(name="DIAS_SEMANA_ID", nullable=false)
	private DiasTreinoCat diasSemana;
	
	public TreinoFixo(){}

	public TreinoFixo(SexoCat sexo, FaixaEtariaCat faixaEtaria,
			ObjetivoCat objetivo, DuracaoTreinoCat duracao,
			DiasTreinoCat diasSemana) {
		super();
		this.sexo = sexo;
		this.faixaEtaria = faixaEtaria;
		this.objetivo = objetivo;
		this.duracao = duracao;
		this.diasSemana = diasSemana;
	}

	public SexoCat getSexo() {
		return sexo;
	}

	public void setSexo(SexoCat sexo) {
		this.sexo = sexo;
	}

	public FaixaEtariaCat getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(FaixaEtariaCat faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public ObjetivoCat getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(ObjetivoCat objetivo) {
		this.objetivo = objetivo;
	}

	public DuracaoTreinoCat getDuracao() {
		return duracao;
	}

	public void setDuracao(DuracaoTreinoCat duracao) {
		this.duracao = duracao;
	}

	public DiasTreinoCat getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(DiasTreinoCat diasSemana) {
		this.diasSemana = diasSemana;
	}
	
	
	
}
