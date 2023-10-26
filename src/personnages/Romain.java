package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement[2];
	private int nbEquipement=0;

	
	public Romain(String nom, int force) {
		if (force<0)
			throw new IllegalArgumentException("Invalid force: " + force);
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+ "« " + texte + "».");

	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert (force>=0);
//		int forcePrecondition= force;
//		force-=forceCoup;
//		if (force>0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert (forcePrecondition>force);
//	}
	
	private String soldatParler(String texte){
		return ("Le soldat "+nom+texte);
	}
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement++]=equipement;
		System.out.println(soldatParler(" s’équipe avec un "+equipement+"."));
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement)
		{
			case 0:
				ajouterEquipement(equipement);
				break;
			case 1:
				if (equipements[0]==equipement) System.out.println(soldatParler(" possède déjà un "+equipement+" !"));
				else ajouterEquipement(equipement);
				break;
			default:
				System.out.println(soldatParler(" est déjà bien protégé !"));			
				break;
		}
		
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force==0)
			parler("Aïe");
		else{
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte+= "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i].equals(Equipement.BOUCLIER)) 
					resistanceEquipement += 8;
				else
					resistanceEquipement += 5;
			}
			texte =texte+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	public int getForce() {
		return force;
	}

	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6);
		
//		System.out.println(Equipement.CASQUE); 
//		System.out.println(Equipement.BOUCLIER);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

	
}
