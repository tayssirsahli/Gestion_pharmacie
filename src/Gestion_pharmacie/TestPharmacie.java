package Gestion_pharmacie;

import java.util.Collection;

public class TestPharmacie {

	public static void main(String[] args) {

		Patient patientTest = new Patient("David");
		System.out.println("L'ordonnance de David est vide : " + patientTest.ordonnanceVide());

		patientTest.ajoutMedicament("Ibuprofène");
		patientTest.ajoutMedicament("Paracetamol");
		System.out.println("L'ordonnance de David contient le médicament Ibuprofène : "
				+ patientTest.contientMedicament("Ibuprofène"));

		System.out.println("Affichage de l'ordonnance de David :");
		patientTest.affiche();

		System.out.println("Triage de l'ordonnance de David :");
		patientTest.trieOrdonnace();
		patientTest.affiche();
		DossierPharmacie pharmacie = new DossierPharmacie("MaPharmacie");

		pharmacie.nouveauPatient("Alice", new String[] { "Paracetamol", "Aspirine" });
		pharmacie.nouveauPatient("Bob", new String[] { "Ibuprofène" });
		pharmacie.nouveauPatient("Claire", new String[] { "Paracetamol", "Vitamine C" });

		pharmacie.affiche();

		pharmacie.ajoutMedicament("Alice", "Vitamine C");
		System.out.println("\nAprès ajout de Vitamine C à Alice:");
		pharmacie.affichePatient("Alice");

		System.out.println("\nPatients prenant le médicament Paracetamol:");
		Collection<String> patientsAvecParacetamol = pharmacie.affichePatientAvecMedicament("Paracetamol");
		for (String patient : patientsAvecParacetamol) {
			pharmacie.affichePatient(patient);
		}

	}

}
