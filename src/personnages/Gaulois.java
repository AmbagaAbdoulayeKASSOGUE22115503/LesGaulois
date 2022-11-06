package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees=0;
	private Equipement[] trophees = new Equipement[100];

	
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
	
//	public String prendreParole() {
//		return "Le gaulois "+nom+" : ";
//	}
	
	
	private String prendreParole() {
		return  "Le gaulois " + nom + " : ";
		}


	public void parler(String texte) {
		
		System.out.println(prendreParole()+"<< "+texte+" >>");
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom+" envoie un grand coup dans la mâchoire de "+romain.getNom());
//		romain.recevoirCoup(force/3);
//	}
	
	
	public void frapper(Romain romain) {
		
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "+romain.getNom());
		 trophees = romain.recevoirCoup((force / 3) *effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
				nbTrophees++) {
		this.trophees[nbTrophees] = this.trophees[i];
		
		}
	}
	
	
	
	public void boirePotion(int forcePotion) {
		
		effetPotion=forcePotion;
		parler(" Merci Druide, je sens que ma force est "+forcePotion+" fois décuplée. ");

	} 
	
	
	public String toString() {
			
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void faireUneDonnation(Musee musee) {
		Gaulois gaulois= new Gaulois(nom, force);
		
		if (nbTrophees!=0) {
			
			String message=" Je donne au musee tous mes trophees : \n";
			for (int i=1; i<=nbTrophees; i++) {
				
				message+=("- "+trophees[i]+"\n");
				musee.donnerTrophees(gaulois,trophees[i]);
			}
			parler(message);
		}
		
	}

	
	public static void main(String[] args) {
		
		Gaulois asterix= new Gaulois("Asterix",5);
		Romain minus= new Romain("minus",6);
		Musee musee= new Musee();
		
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		asterix.parler("Je m'appele Asterix et je suis un Gaulois");
		asterix.frapper(minus);
		asterix.boirePotion(5);
		asterix.faireUneDonnation(musee); 
		
		
		
	}
}
