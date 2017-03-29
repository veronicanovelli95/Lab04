package it.polito.tdp.lab04.model;

import java.util.List;

public class Corso {
   
	private String codins;
	private int crediti;
	private String nome;
	private int pd;
	List<Studente> studenti;
	
	public Corso(String codins, int crediti, String nome, int pd) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
		this.studenti = null;
	}

	@Override
	public String toString() {
		return nome;
	}

	public String getNome() {
		
		return codins;
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}

	public String getCodins() {
		return codins;
	}

	public int getCrediti() {
		return crediti;
	}

	public int getPd() {
		return pd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}

	
	
	
	
}
