package histoire;

import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Asterix", 8);
		Romain minus= new Romain("Minus",6);
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.fraper(minus);
		asterix.fraper(minus);
		asterix.fraper(minus);		

	}

}
