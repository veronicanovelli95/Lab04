package it.polito.tdp.lab04.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	private CorsoDAO corsoDB;
	private StudenteDAO studenteDB;
	private List<Corso> corsi;
	

	public Model() {
		corsoDB = new CorsoDAO();
		corsi = corsoDB.getTuttiICorsi();
	}

	public List<Corso> getCorsi() {
		if (corsi == null)
			corsi = corsoDB.getTuttiICorsi();
		return corsi;
	}

	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		if (corsi.contains(corso)) {
			if (corso.getStudenti() == null) {
				corsoDB.getStudentiIscrittiAlCorso(corso);
			}
		}
		return corso.getStudenti();
	}

	public Studente cercaStudente(int matricola) {
		List<Studente> studenti = studenteDB.getStudenti();
		for(Studente stu : studenti){
			if(stu.getMatricola()==(matricola))
				return stu;
		}
		
		return null;
	}

	
	
}
