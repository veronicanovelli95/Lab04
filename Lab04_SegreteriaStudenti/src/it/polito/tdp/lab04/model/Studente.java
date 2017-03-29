package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Studente {
	 private int matricola;
	 private String nome;
	 private String cognome;
	 private String CDS;
	 List<Corso> corsi;
	 
	public Studente(int matricola, String nome, String cognome, String cDS) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		CDS = cDS;
	}
	@Override
	public String toString() {
		return matricola + " "+ nome;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setCDS(String cDS) {
		CDS = cDS;
	}
	public int getMatricola() {
		return matricola;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getCDS() {
		return CDS;
	}
	public List<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	
	
	
	
	 
}
