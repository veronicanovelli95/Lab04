package it.polito.tdp.lab04.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SegreteriaStudentiController {

	private Model model;
	List<Corso> corsi = new LinkedList<Corso>();

	@FXML
	private ComboBox<Corso> comboCorso;

	@FXML
	private Button btnCercaIscrittiCorso;

	@FXML
	private Button btnCercaCorsi;


    @FXML
    private ImageView btnCercaNome;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextField txtMatricola;

	@FXML
	private Button btnReset;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCognome;

	public void setModel(Model model) {
      this.model = model;
      comboCorso.getItems().addAll(model.getCorsi());
	}

	@FXML
	void doReset(ActionEvent event) {
      txtMatricola.clear();
      txtNome.clear();
      txtCognome.clear();
      txtResult.clear();
	}

	@FXML
	void doCercaNome(ActionEvent event) {
     String s = txtMatricola.getText();
     Studente stu = model.cercaStudente(s);
     txtNome.setText(stu.getNome());
     txtCognome.setText(stu.getCognome());
	}

	

	@FXML
	void doCercaIscrittiCorso(ActionEvent event) {
     Corso c = comboCorso.getValue();
     String result=model.getStudentiIscrittiAlCorso(c).toString();
     txtResult.setText( result);
     
	}

	@FXML
	void doCercaCorsi(ActionEvent event) {
    
	}

	@FXML
	void doIscrivi(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
		
	}

}
