package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement=0;
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipements=new Equipement[3];
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
	
	public void ajouterEquipement(Equipement equipement) {
		nbEquipement+=1;
		equipements[nbEquipement]=equipement;
		System.out.println("Le soldat "+nom+" s’équipe avec un "+equipement);
		
	}
	
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}
	
	public void sEquiper(Equipement equipement) {
		switch ( nbEquipement) {
		case 2:
			System.out.println("Le soldat "+nom+" est déjà bien protégé");
			break;
		case 1:
			if ( equipements[1]==equipement) {
				System.out.println("Le soldat "+nom+" possède déjà un "+equipement);
			}
			else {
				ajouterEquipement(equipement);
			}
			break;
		default:
			nbEquipement+=1;
			equipements[nbEquipement]=equipement;
			System.out.println("Le soldat "+nom+" s’équipe avec un "+equipement);
			break;
		}

		}
		
	
	public static void main(String[] args) {
		
		Romain minus= new Romain(" Minus",6);
//		System.out.println(minus);
//		minus.parler("Je suis minus et je suis un Romain!");
//		minus.recevoirCoup(3);
//		System.out.println(Equipement.BOUCLIER);
//		System.out.println(Equipement.CASQUE);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
	
	
}
