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
	
	public int getForce() {
		return force;
	}
	
	public String prendreParole() {
		return "Le gaulois "+nom+" : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole()+"<< "+texte+" >>");
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom+" envoie un grand coup dans la mâchoire de "+romain.getNom());
		romain.recevoirCoup(force/3);
	}
	
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		parler(" Merci Druide, je sens que ma force est "+forcePotion+" fois décuplée. ");
	} 
	
	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Asterix",8);
		Romain r1= new Romain("Pop",0);
		
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.parler("Je m'appele Asterix et je suis un Gaulois");
		asterix.frapper(r1);
		asterix.boirePotion(5);
		
	}
}
