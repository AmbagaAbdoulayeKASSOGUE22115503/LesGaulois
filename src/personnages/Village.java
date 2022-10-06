package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;

	
	public Village(String nom, Chef chef,int nbVillageoisMaximum) {
		this.nom = nom;
		this.chef = chef;
		villageois= new Gaulois[nbVillageoisMaximum];
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		nbVillageois++;
		villageois[nbVillageois]=gaulois;
	}
	
	public Gaulois trouverHabitant(int nVillageois) {
		return villageois[nVillageois];
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void afficherVillageois(Chef chef,Gaulois villageois[],int nbVillageois) {
		System.out.println("Dans le village du chef"+nom+" vivent les légendaires Gaulois:");
		for (int i=1; i<=nbVillageois; i++) {
			System.out.println("-"+villageois[i].getNom());
		}
		
	}
	
	public static void main(String[] args) {
		Chef chef= new Chef("Abraracourcix",6,null);
		Village village= new Village("Village des Irréductibles",chef,30);
		chef.setVillage(village);
		Gaulois g1= new Gaulois("Astérix",8);
		village.ajouterHabitant(g1);
		
		Gaulois g2= new Gaulois("Obélix",25);
		village.ajouterHabitant(g2);
		
		village.afficherVillageois(chef,village.villageois,2);
		
		//Gaulois g1 = village.trouverHabitant(1);
		//System.out.println(gaulois);
		//(le reponse afficher à l'execution est le premier Gaulois ajouté dans le village: Gaulois [nom=Astérix, force=8, 
		//effetPotion=1])
		
		//Gaulois gaulois = village.trouverHabitant(30);
		//(parce qu'il ne y a aucun habitant encore installer dans le village)
		
		
		
		
	}
	
}
	

