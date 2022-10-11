package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert (force>0);  
		
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public String prendreParole() {
		return "Le romain"+nom+":";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+" << "+texte+" >> ");
	}
	
	
	public void recevoirCoup(int forceCoup) {
		assert (force>0):"Postcondition";
		int force1=force;
		force-=forceCoup;
		if (force>0) {
			parler("Aïe");
		}
		else parler("J'abandonne...");
		
		assert (force1>=force):"Préconditionn";
	}
	
	
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	
	public static void main(String[] args) {
		
		Romain minus= new Romain(" Minus",6);
		System.out.println(minus);
		minus.parler("Je suis minus et je suis un Romain!");
		minus.recevoirCoup(3);
		
	}
	
	
}
