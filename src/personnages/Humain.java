package personnages;

public class Humain {
	private String nom;
	private String boissonPreferee;
	private int argent;
	
	
	public Humain(String nom, String boissonPreferee, int argent) {
		this.nom=nom;
		this.boissonPreferee=boissonPreferee;
		this.argent=argent;
	}
	
	public String prendreParole() {
		return  "(" + getNom() + ")- ";
	}
	
	
	public void parler(String texte) {
			
			System.out.println(prendreParole()+texte);
	}
		
	

	
	public String getNom() {
		return nom;
	}



	public int getArgent() {
		return argent;
	}


	public void direBonjour() {
		parler("Bonjour ! Je m'appelle "+getNom()+" et j'aime boire du "+boissonPreferee+".");
		
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de "+boissonPreferee+" ! GLOUPS !");
		
	}
	
	public void acheter(String bien, int prix){
		
		if ( getArgent()>=prix) {
			parler("J'ai "+getArgent()+" sous poche. Je vais pouvoir m'offrir "+ bien+" à "+prix+" sous.");
			argent-= prix;
		}
		else {
			parler("Je n'ai plus que "+getArgent()+" sous poche. Je ne peux même pas m'offrir "+ bien+" à "+prix+" sous.");
		}
		
}
	
	
}
