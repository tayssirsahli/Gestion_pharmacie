package Gestion_pharmacie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class DossierPharmacie {

	private String nom;
	private HashMap<String, Patient> patients;

	public DossierPharmacie(String n) {
		nom = n;

		patients = new HashMap<String, Patient>();
	}

	/*
	 * /--Ajoute un nouveau patient de nom et ordonnance données --/
	 */
	public void nouveauPatient(String nom, String[] ord) {
		String nomLowerCase = nom.toLowerCase();
		if (!patients.containsKey(nomLowerCase)) {
			Patient nouveauPatient = new Patient(nom);
			for (String medicament : ord) {
				nouveauPatient.ajoutMedicament(medicament);
			}
			patients.put(nomLowerCase, nouveauPatient);
		}
	}
	/*
	 * /-- Ajoute u nouveau medicamet su un patient déjà existant. Renvoie false si
	 * le patient n’existe pas et true si l’ajout a pu être effectué--/
	 */

	public boolean ajoutMedicament(String nom, String m) {
		String nomLowerCase = nom.toLowerCase();
		if (patients.containsKey(nomLowerCase)) {
			patients.get(nomLowerCase).ajoutMedicament(m);
			return true;
		}
		return false;
	}

	// --Affiche le nom et l’ordonnace du patient donné
	public void affichePatient(String nom) {

		String nomLowerCase = nom.toLowerCase();
		if (patients.containsKey(nomLowerCase)) {
			patients.get(nomLowerCase).affiche();
		} else {
			System.out.println("Le patient " + nom + " n'existe pas dans ce dossier de pharmacie.");
		}
	}

	// -- affiche le nom de la pharmacie et tous les patients dudossier
	public void affiche() {
		System.out.println("Pharmacie: " + nom);
		System.out.println("Patients:");
		for (Patient patient : patients.values()) {
			patient.affiche();
		}
	}

	// _ _ retourne la collection des patients qui prenne le medicament m_/

	public Collection<String> affichePatientAvecMedicament(String m) {
		Collection<String> patientsAvecMedicament = new ArrayList<>();
		for (Patient patient : patients.values()) {
			if (patient.contientMedicament(m)) {
				patientsAvecMedicament.add(patient.getNom());
			}
		}
		return patientsAvecMedicament;
	}
}
