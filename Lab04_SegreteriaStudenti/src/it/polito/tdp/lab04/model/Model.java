package it.polito.tdp.lab04.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {

	private CorsoDAO corsoDB;
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

	public Studente cercaStudente(String s) {
		for(Corso c : corsi){
			
			if(c.getStudenti().contains(s))
				for(Studente stu : c.getStudenti())
					if (stu.toString().equals(s))
						return stu;
		}
		return null;
	}

}
