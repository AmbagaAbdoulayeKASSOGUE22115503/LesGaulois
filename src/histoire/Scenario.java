package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix= new Gaulois("Asterix", 8);
		Gaulois obelix= new Gaulois("Obélix",20);
		Romain minus= new Romain("Minus",36);
		Druide panoramix= new Druide("Panoramix",5,10);
		
		//scénario
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.fraper(minus);
		asterix.fraper(minus);
		asterix.fraper(minus);

	}

}
