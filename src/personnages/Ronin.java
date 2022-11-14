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
	}
	
	public void provoquer(Yakuza adversaire) {
		int force=2*honneur;
		
		if (force>=adversaire.getReputation()) {
			super.setArgent(super.getArgent()+adversaire.getArgent());
			honneur++;
			super.parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre\r\n"
					+ "marchand!");;
			super.parler("Je t’ai eu petit yakusa!");
			adversaire.perdre();
		}
		
		else {
			honneur--;
			super.parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(super.getArgent());
			super.setArgent(0);
		}
	}
}
