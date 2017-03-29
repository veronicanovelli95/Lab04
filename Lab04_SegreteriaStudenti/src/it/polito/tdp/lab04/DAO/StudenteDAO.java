package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public List<Studente> getStudenti() {
		
	final String sql = "SELECT * FROM studente";

	List<Studente> studenti = new LinkedList<Studente>();
	
	try {
		Connection conn = ConnectDB.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			
			// Crea un nuovo JAVA Bean Corso
			// Aggiungi il nuovo Corso alla lista
			Studente s = new Studente(rs.getInt("matricola"),rs.getString("nome"),rs.getString("cognome"),rs.getString("CDS"));
			studenti.add(s);
		}

		return studenti;

	} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db");
	}
  }
	

	
	public List<Studente> getTuttiStudenti() {
		
		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo Corso alla lista
				Studente s = new Studente(rs.getInt("matricola"),rs.getString("nome"),rs.getString("cognome"),rs.getString("CDS"));
				studenti.add(s);
			}

			return studenti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public void getCorsi(Studente s) {
		
		int stud = s.getMatricola();
		
		final String sql = "SELECT codins, crediti, nome, pd FROM corso WHERE codins IN (SELECT codins FROM iscrizione WHERE matricola = ?) ";

		List<Corso> corsi = new LinkedList<Corso>();
		
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, stud);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				corsi.add(c);
			}
		
              s.setCorsi(corsi);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
}
