package package_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Met en oeuvre le patern Singleton: permet de regrouper le code relatif à la connection entre java et la db.
//Il permet aussi de n'avoir qu'une seule connection.
public class Singleton {

	//******ATTRIBUT******
	private static String pilote;

	private static String url;
	private static String login;
	private static String passord;

	private static Connection connect;


	//******CONSTRUCTEUR PAR DEFAUT******
	private Singleton(){
		this("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/feuilledepersonnage", "user_Pers", "c9SDBsTzbeAUqHB2", null);
	}

	//******CONSTRUCTEUR A PARAMETRE******
	private Singleton(String pilote, String url, String login, String passord, Connection connect){
		Singleton.pilote=pilote;
		Singleton.url=url;
		Singleton.login=login;
		Singleton.passord=passord;
		Singleton.connect=connect;
	}
	
	/** Holder */
	private static class SingletonHolder
	{		
		/** Instance unique non préinitialisée */
		private static final Singleton instance = new Singleton();
	}

	//******GETTER AND SETTER******
	public static String getPilote() {
		return pilote;
	}


	public static void setPilote(String pilote) {
		Singleton.pilote = pilote;
	}


	public static String getUrl() {
		return url;
	}


	public static void setUrl(String url) {
		Singleton.url = url;
	}


	public static String getLogin() {
		return login;
	}


	public static void setLogin(String login) {
		Singleton.login = login;
	}


	public static String getPassord() {
		return passord;
	}


	public static void setPassord(String passord) {
		Singleton.passord = passord;
	}


	public static Connection getConnect() {
		return connect;
	}


	public static void setConnect(Connection connect) {
		Singleton.connect = connect;
	}


	//******METHODE DE CLASSE******
	
	public Connection getConnexion(){

		if(connect==null){//si l'attibut est à null, c'est qu'il n'y a pas eu de connection précédemment: on se connecte donc
			try {
				// Etape 1: Chargement du driver
				Class.forName(pilote);
				// Etape 2: Récupération de la connexion
				connect=DriverManager.getConnection(url, login, passord);
			}  
			// gestion des exceptions
			catch (SQLException | ClassNotFoundException e) {
				System.out.println("Error. Cause: "+e.getCause()+". Message: "+e.getMessage());
			}
		}
		else{//sinon si l'objet connect est déja initialisé, c'est que l'on c'est déja connecté donc on a pas besoin de se reconnecter.
			System.out.println("Connection SQL existante");
		}
		return connect;	//retourne la connexion du type Connection qui appertient à l'api java
	}

	/** Point d'accès pour l'instance unique du singleton */
	public static Singleton getInstance()
	{
		return SingletonHolder.instance;
	}


}

