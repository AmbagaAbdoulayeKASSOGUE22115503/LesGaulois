package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement[2];
	private int nbEquipement=0;
	
	public Romain(String nom, int force) {
		assert (force>=0);
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
	
	public void recevoirCoup(int forceCoup) {
		assert (force>=0);
		int forcePrecondition= force;
		force-=forceCoup;
		if (force>0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert (forcePrecondition>force);
	}
	
	private String soldatParler(String texte){
		return ("Le soldat "+nom+texte);
	}
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement++]=equipement;
		System.out.println(soldatParler(" s’équipe avec un "+equipement+"."));
	}
	
	public void sEquipement(Equipement equipement) {
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
	
	public static void main(String[] args) {
		Romain minus= new Romain("Minus",6);
		
//		System.out.println(Equipement.CASQUE);
//		System.out.println(Equipement.BOUCLIER);
		
		minus.sEquipement(Equipement.CASQUE);
		minus.sEquipement(Equipement.CASQUE);
		minus.sEquipement(Equipement.BOUCLIER);
		minus.sEquipement(Equipement.CASQUE);
	}
	
}
