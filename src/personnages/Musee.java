package personnages;

public class Musee {
	private Trophee[] tabTrophees= new Trophee[200];
	private int nbTrophee=0;
	
	public void donnerTrophees(Gaulois gaulois,Equipement equipement) {
		assert(nbTrophee<200);
		Trophee newTrophee= new Trophee(gaulois,equipement);
		tabTrophees[nbTrophee++]=newTrophee;
	}
	
	public String extraireInstructionsCaml() {
		String expOcamel="let musee = [\n";
		for(int i=0;i<nbTrophee;++i)
		{
			expOcamel+="\""+tabTrophees[i].donnerNom()+"\",  \""+tabTrophees[i].getequipement()+"\";\n";
		}
		expOcamel+="]";
		return expOcamel;
	}
	
}
