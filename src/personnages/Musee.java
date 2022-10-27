package personnages;

public class Musee {
	private Trophee[] tabTrophee;
	private int nbMaxTrophee= 200;
	private int nbTrophee=0;
	
	public Musee() {
	tabTrophee= new Trophee[200];
	}
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee newTrophee= new Trophee(gaulois, equipement);
		
		if (nbTrophee<nbMaxTrophee) {
			
			nbTrophee++;
			tabTrophee[nbTrophee]=newTrophee;
			
		}
			
	}
	
	
	
}
