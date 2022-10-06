package personnages;

public class Gaulois {
	private String nom;
	private int force,effetPotion=1;
	
	public Gaulois(String nom,int force) {
		this.nom=nom;
		this.force=force;
	}

	public String getNom() {
		return nom;
	}
	
	public String prendreParole() {
		return "Le gaulois"+nom+":";
	}

	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+texte+">>");
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom+"envoie un grand coup dans la mâchoire de"+romain.getNom());
		romain.recevoirCoup(force/3);
	}
	
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
}
