package personnages;

public class Yakuza extends Humain{
	private String clan;
	private int reputation=0;
	
	public Yakuza(String nom, String boissonPreferee, int argent, String clan) {
		super(nom,boissonPreferee,argent);
		this.clan= clan;
	}
	
	
	public String getClan() {
		return clan;
	}
	
	public int getReputation() {
		return reputation;
	}
	
	public void extorquer(Commercant victime) {
		super.parler(" Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ? ");
		victime.parler(victime.getNom()+" , si tu tiens à la vie donne moi ta bourse !");
		
		int argentExtorquer= victime.getArgent();
		super.setArgent(argentExtorquer+super.getArgent());
		
		victime.seFaireExtorquer();
		super.parler(" J’ai piqué les "+argentExtorquer+" sous de "+victime.getNom()+", ce qui \r\n"
				+ "me fait "+super.getArgent()+" sous dans ma poche. Hi ! Hi !");
		reputation++;
		
	}
	
	public void perdre() {
		reputation--;
		super.parler("J’ai perdu mon duel et mes "+super.getArgent()+" sous, snif... J'ai déshonoré le clan de "+clan);
		super.setArgent(0);
		
	}
	
	public void gagner(int gain) {
		super.setArgent(gain);
		reputation++;
		super.parler("Ce ronin pensait vraiment battre "+super.getNom()+" du clan de "+clan+" ? Je l'ai dépouillé de ses "+gain+" sous.");
		
	}
	
}
