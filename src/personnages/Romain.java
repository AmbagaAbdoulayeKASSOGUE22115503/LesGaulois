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
	
	
//	public void recevoirCoup(int forceCoup) {
//		assert (force>0):"Postcondition";
//		int force1=force;
//		force-=forceCoup;
//		if (force>0) {
//			parler("Aïe");
//		}
//		else parler("J'abandonne...");
//		
//		assert (force1>=force):"Préconditionn";
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		 if (force == 0) {
			 parler("Aïe");
		 } 
		 else {
			 equipementEjecte = ejecterEquipement();
		 	parler("J'abandonne...");
		 }
		
			// post condition la force à diminuer
			assert force < oldForce;
			return equipementEjecte;
	}
	
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte+="\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;i++) {
			if (equipements[i] !=null &&
			( equipements[i].equals(Equipement.BOUCLIER) ) 
			|| equipements[i].equals(Equipement.CASQUE) ) {
				
				resistanceEquipement += 8;
				
			} else {
				
			System.out.println("Equipement casque");
			resistanceEquipement += 5;
			
			}
		
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		
		}
	
	
	private Equipement[] ejecterEquipement() {
		
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom +" s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			
			if (equipements[i] != null) {
				
				nbEquipementEjecte++;
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				equipements[i] = null;
			}
		}
		
		return equipementEjecte;
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
