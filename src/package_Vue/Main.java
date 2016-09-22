package package_Vue;

import java.sql.ResultSet;
import java.sql.SQLException;

import package_Controleur.GenerateurDeDes;
import package_Model.Gestion_DB;


public class Main {

	public static void main(String[] args) {


		/*GenerateurDeDes mylance=new GenerateurDeDes(10,20);
		System.out.println(mylance.resultatDes());
		 */
		Gestion_DB db=new Gestion_DB();

		//db.lireDescriptioncaracteristique("Force");
		ResultSet result=db.makePreparedQuerySearch("SELECT * FROM descriptioncaracteristique");
		//ResultSet result=db.makeQuerySearch("SELECT * FROM descriptioncaracteristique");


		//(parcours Resultset)
		try {
			while(result.next()){
				System.out.println(result.getString("description"));
				System.out.println("\n/************************/\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		/*
		 *Pour écrire que la colonne Force
		 * try {
			result.absolute(1);
				System.out.println(result.getString("description"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		*/

		//db.makePreparedQueryUpdate("INSERT INTO `feuilledepersonnage`.`descriptioncaracteristique` (`Force`, `Dexterite`, `Constitution`, `Intelligence`, `Sagesse`, `Charisme`) VALUES ('', 'ninja!', '', '', '', '');");
		//db.makeQueryUpdate("INSERT INTO `feuilledepersonnage`.`descriptioncaracteristique` (`Force`, `Dexterite`, `Constitution`, `Intelligence`, `Sagesse`, `Charisme`) VALUES ('', 'ninja!', '', '', '', '');");


	}


}

