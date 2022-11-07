package personnages;

public class Ronin extends Humain{
	private int honneur=1;
	
	
	public Ronin(String nom, String boissonPreferee, int argent) {
		super(nom,boissonPreferee,argent);
	}
	
	public int getHonneur() {
		return honneur;
	}
	
	public void donner(Commercant beneficiaire) {
		int don= (super.getArgent()*10)/100;
		super.setArgent(getArgent()-don);
		
		super.parler(beneficiaire.getNom()+" prend ces "+don+" sous.");
		beneficiaire.recevoir(don);
		honneur++;
	}
}
