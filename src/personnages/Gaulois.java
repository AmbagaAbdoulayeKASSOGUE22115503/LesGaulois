package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion=1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
		
		
	}

//	private String prendreParole() {
//		return "Le gaulois "+ nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	
//	public void fraper(Romain romain) {
//		System.out.println(nom+ " envoie un grand coup dans la mâchoire de  "+ romain.getNom() );
//		romain.recevoirCoup(effetPotion*(force / 3));
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] nouveauxTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; nouveauxTrophees != null && i < nouveauxTrophees.length; i++,
		nbTrophees++) {
		this.trophees[nbTrophees] = nouveauxTrophees[i];
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, je sens que ma force est "+effetPotion+" fois décuplée. ");
	}
	
	
	public void faireUneDonnation(Musee musee){
		String texte="Je donne au musee tous mes trophees : ";
		for(int i=0;i<nbTrophees;++i)
		{
			musee.donnerTrophees(this, trophees[i]);
			texte+="\n-"+trophees[i];
			
		}
		parler(texte);
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Asterix", 8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.boirePotion(4);

	}
	
}
