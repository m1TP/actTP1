package main;

import implementation.LigneDeToit;

public class MainLigneDeToit {

	public static void main(String[] args) {
		
		Integer[][] lignedetoit1 = {{1,10},{5,6},{8,0},{10,8},{12,0}};
		Integer[][] lignedetoit2 = {{2,12},{7,0},{9,4},{11,2},{14,0}};

		LigneDeToit test = new LigneDeToit(lignedetoit1, lignedetoit2);
		test.fusionDeLignes();
		test.afficherResultat();
		test.creerAffichageSVGResultat("resultatFusion");
		
	}

}
