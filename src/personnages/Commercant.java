package personnages;

public class Commercant extends Humain {
	
	
	
	public Commercant(String nom,int argent) {
		super(nom,"Thé",argent);
	}
	
	
	public int seFaireExtorquer(){
		super.parler("J’ai tout perdu! Le monde est trop injuste...");
		super.setArgent(0);
		
		return super.getArgent();
			
	}
	
	public void recevoir(int argent) {
		super.parler(argent+" sous ! Je te remercie généreux donateur !");
		super.setArgent(argent+super.getArgent());
		
	}
	

}
