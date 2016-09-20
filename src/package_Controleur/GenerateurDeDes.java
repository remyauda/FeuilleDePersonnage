package package_Controleur;

import java.util.Random;


import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class GenerateurDeDes.
 */
public class GenerateurDeDes {

	/** The nbdes. */
	//******ATTRIBUT******
	protected int nbdes;	//Par exemple: 1 si il faut lancer 1 dés, 2 si il faut lancer 2 dés, 3 si il faut lancer 3 dés, ...
	
	/** The typedes. */
	protected int typedes;	//Par exemple: 4 pour un dés à 4, 6 pour un dés à 6, 20 pour un dés à 20, ...


	/**
	 * Instantiates a new generateur de des.
	 */
	//******CONSTRUCTEUR PAR DEFAUT******
	public GenerateurDeDes(){
		this(3,6);	//Par defaut, le générateur lance 3d6
	}

	/**
	 * Instantiates a new generateur de des.
	 *
	 * @param nbdes the nbdes
	 * @param typedes the typedes
	 */
	//******CONSTRUCTEUR A PARAMETRE******
	public GenerateurDeDes(int nbdes, int typedes){
		this.nbdes=nbdes;
		this.typedes=typedes;
	}


	/**
	 * Gets the nbdes.
	 *
	 * @return the nbdes
	 */
	//******GETTER AND SETTER******
	public int getNbdes() {
		return nbdes;
	}

	/**
	 * Sets the nbdes.
	 *
	 * @param nbdes the new nbdes
	 */
	public void setNbdes(int nbdes) {
		this.nbdes = nbdes;
	}

	/**
	 * Gets the typedes.
	 *
	 * @return the typedes
	 */
	public int getTypedes() {
		return typedes;
	}

	/**
	 * Sets the typedes.
	 *
	 * @param typedes the new typedes
	 */
	public void setTypedes(int typedes) {
		this.typedes = typedes;
	}


	//******METHODE DE CLASSE******

	/**
	 * Resultat des.
	 *
	 * @return the array list
	 */
	//Méthode qui lance nbdes dés à typedes et renvoyant une liste contenant le résultat de chaque dés
	public ArrayList<Integer> resultatDes(){

		ArrayList<Integer> resultatDeChaqueDes=new ArrayList<Integer>();	//Creation du tableau de int qui contiendra les resultats de chaque dés lancés
		for(int i=0;i<nbdes;i++){	//Lance nbdes dés. Par exemple, si nbdes=3 alors il faudra lancer 3 dés.
			Random rand = new Random();
			int resultatdes = Math.abs(rand.nextInt(typedes)+1); //Renvoie un nombre entre 0 exclu et typedes inclu. Par exemple, si le type de dés est un dés à 4 (typedes=4) alors le dés pourra afficher: 1; 2; 3 ou 4
			resultatDeChaqueDes.add(resultatdes);	//Après chaque lancé d'un dés, mettre le résultat dans la liste qui devra afficher les résultats de chaque dés lancé
		}
		return resultatDeChaqueDes;	//retourne le tableau contenant les resultats de chaque dés
	}

	/**
	 * Somme des.
	 *
	 * @return the int
	 */
	public int SommeDes(){
		int somme=0;
		ArrayList<Integer> resultatDeChaqueDes=resultatDes();	//Lance les dés et stock mes résultats dans un tableau
		for(int i=0;i<nbdes;i++){	//Lance nbdes dés. Par exemple, si nbdes=3 alors il faudra lancer 3 dés.
			somme+=resultatDeChaqueDes.get(i);	//Prend les valeurs du tableau et en fait la somme
		}
		return somme; //retourne la somme des dés lancés
	}

}


