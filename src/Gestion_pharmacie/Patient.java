package Gestion_pharmacie;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Patient {

	private String nom;
	private Set<String> ordonnance;

	public Patient(String n) {
		nom = n;
		ordonnance = new HashSet<String>();
	}

	public Set<String> getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Set<String> ordonnance) {
		this.ordonnance = ordonnance;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	// 1-Compléter le code des méthodes suivantes:
	// --teste si l’ordonnance est vide ou pas

	public boolean ordonnanceVide() {

		return ordonnance.isEmpty();
	}

	// Ajoute un medicament à l’ordonnacee
	public void ajoutMedicament(String m) {

		ordonnance.add(m);
	}

	// Affiche le nom du patient ainsi que son ordonnance
	public void affiche() {

		System.out.println("Patient: " + nom);
		System.out.println("Ordonnance:");
		for (String medicament : ordonnance) {
			System.out.println("- " + medicament);
		}

	}

	// teste si l’ordonnance contient un médicament_/
	public boolean contientMedicament(String m) {

		return ordonnance.contains(m);
	}

	// trie l’ordonnance du patient selon l’ordre alphabétique

	public void trieOrdonnace() {

		Set<String> sortedOrdonnance = new TreeSet<>(ordonnance);
		ordonnance.clear();
		ordonnance.addAll(sortedOrdonnance);

	}

}
