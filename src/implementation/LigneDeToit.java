package implementation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LigneDeToit {

	/* variables */
	private Integer[][] ldt1;
	private Integer[][] ldt2;
	public Integer[][] ldtResultat;
	
	/* structure */
	public LigneDeToit(Integer[][] ldt1, Integer[][] ldt2){
		this.ldt1=ldt1;
		this.ldt2=ldt2;
		this.ldtResultat=new Integer[ldt1.length+ldt2.length][2];
	}
	
	
	
	/* getter et setter */
	public Integer[][] getLdt1() {	return ldt1;}
	public void setLdt1(Integer[][] ldt1) {	this.ldt1 = ldt1;}
	public Integer[][] getLdt2() {	return ldt2;}
	public void setLdt2(Integer[][] ldt2) {	this.ldt2 = ldt2;}


	
	
	
	
	/**
	 * Fonction pour determiner la ligne de toit correspondant à la fusion de deux lignes de toits
	 */
	public void fusionDeLignes(){
		Integer[][] tmp = new Integer[ldt1.length+ldt2.length][2];
		int i=0;
		
		/* On ajoute à tmp tous les couples de coordonnées des 2 listes de lignes de toit */
		for(;i<ldt1.length;i++){
			tmp[i][0]= this.getLdt1()[i][0];
			tmp[i][1]= this.getLdt1()[i][1];
		}

		for(int j=0;j<ldt2.length;j++){
			tmp[i][0]= this.getLdt2()[j][0];
			tmp[i][1]= this.getLdt2()[j][1];
			i++;
		}
		/* On tri la liste des coordonnées */
		tribulles(tmp);
		
		
		
		
		/* Init de la liste avec la premier valeur */
		ldtResultat[0] = tmp[0];
		
		/* Determine les points de ligne de toit suivant */
		for(i=1;i<ldt1.length+ldt2.length;i++){
			ldtResultat[i] = calculNextLigneToit(tmp[i-1][0], tmp[i-1][1], tmp[i][0], tmp[i][1]);
			
			/* Si point de ligne de toit inutile */
			if(ldtResultat[i][1]==ldtResultat[i-1][1]){
				ldtResultat[i][0]=0;
				ldtResultat[i][1]=0;
			}
		}
		
		System.out.println("Fusion des lignes de toit effectué");
	}
	
	
	
	
	/**
	 * Fonction pour determiner le prochain point de ligne de toit
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public Integer[] calculNextLigneToit(Integer x1, Integer y1, Integer x2, Integer y2){
		Integer[] resultat = new Integer[2];
		
		/* Si croisement */
		if( x1 < x2 && y1 > y2 ){
			resultat[0]=x2;
			resultat[1]=y1;
		}else{
			resultat[0]=x2;
			resultat[1]=y2;
		}
		
		//System.out.println("("+x1+","+y1+") vs ("+x2+","+y2+") = ("+resultat[0]+","+resultat[1]+")");
		
		return resultat;
	}
	
	
	/* tri à bulles */
	public static void tribulles(Integer[][] tmp)
    {
            for (int i=0 ;i<=(tmp.length-2);i++)
                    for (int j=(tmp.length-1);i < j;j--)
                            if (tmp[j][0] < tmp[j-1][0])
                            {
                                    Integer[] x=tmp[j-1];
                                    tmp[j-1]=tmp[j];
                                    tmp[j]=x;
                            }
    }
	
	
	
	/**
	 * Fonction qui affiche dans le terminal les valeurs enregistrés dans le tableau des coordonnées fusionner
	 */
	public void afficherResultat(){
		System.out.println("Les coordonnées des points de la ligne de toit fusionné sont :");
		for(int i=0;i<ldtResultat.length;i++)
			if(ldtResultat[i][0]!=0)
				System.out.println("("+ldtResultat[i][0]+","+ldtResultat[i][1]+")");
	}
	
	
	/**
	 * Fonction pour créer un fichier html contenant la ligne de toit fussioner
	 */
	public void creerAffichageSVGResultat(String nomFichier){
		try {
			File fichier = new File(nomFichier+".svg");
			FileOutputStream fos;
			fos = new FileOutputStream(fichier);

			// chaîne à rajouter - entete
			String enco = "<svg xmlns='http://www.w3.org/2000/svg' width='300' height='200' viewBox='-10 -150 200 150'>\n";
			
			// ligne de toit
			enco += "<polyline points='";
			enco += ldtResultat[0][0]+","+0+" "+ldtResultat[0][0]+","+ldtResultat[0][1]+" ";
			for(int i=1;i<ldtResultat.length;i++)
				if(ldtResultat[i-1][0]==0)
					enco += ldtResultat[i][0]+","+ldtResultat[i-2][1]+" "+ldtResultat[i][0]+","+ldtResultat[i][1]+" ";
				else if(ldtResultat[i][0]!=0)
					enco += ldtResultat[i][0]+","+ldtResultat[i-1][1]+" "+ldtResultat[i][0]+","+ldtResultat[i][1]+" ";
			
			enco += "' stroke='blue' stroke-width='1' fill='none' transform='scale(5,-5)'/></svg>";
			
			// ecriture chaine dans le fichier
			fos.write(enco.getBytes()); 
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
