package package_Vue;

import java.sql.ResultSet;
import java.sql.SQLException;

import package_Controleur.GenerateurDeDes;
import package_Model.Gestion_DB;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
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
			while (result.next()){
				System.out.println(result.getString("Force"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	

		//db.makePreparedQueryUpdate("INSERT INTO `feuilledepersonnage`.`descriptioncaracteristique` (`Force`, `Dexterite`, `Constitution`, `Intelligence`, `Sagesse`, `Charisme`) VALUES ('', 'ninja!', '', '', '', '');");
		//db.makeQueryUpdate("INSERT INTO `feuilledepersonnage`.`descriptioncaracteristique` (`Force`, `Dexterite`, `Constitution`, `Intelligence`, `Sagesse`, `Charisme`) VALUES ('', 'ninja!', '', '', '', '');");


	}


}

