package package_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
//Met en oeuvre le patern Singleton: permet de regrouper le code relatif à la connection entre java et la db.
/**
 * The Class Singleton.
 */
//Il permet aussi de n'avoir qu'une seule connection.
public class Singleton {

	/** The pilote. */
	//******ATTRIBUT******
	private static String pilote;

	/** The url. */
	private static String url;
	
	/** The login. */
	private static String login;
	
	/** The passord. */
	private static String passord;

	/** The connect. */
	private static Connection connect;


	/**
	 * Instantiates a new singleton.
	 */
	//******CONSTRUCTEUR PAR DEFAUT******
	public Singleton(){
		this("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/feuilledepersonnage", "root", "Kaleidoscope98", null);
	}

	/**
	 * Instantiates a new singleton.
	 *
	 * @param pilote the pilote
	 * @param url the url
	 * @param login the login
	 * @param passord the passord
	 * @param connect the connect
	 */
	//******CONSTRUCTEUR A PARAMETRE******
	public Singleton(String pilote, String url, String login, String passord, Connection connect){
		Singleton.pilote=pilote;
		Singleton.url=url;
		Singleton.login=login;
		Singleton.passord=passord;
		Singleton.connect=connect;
	}

	/**
	 * Gets the pilote.
	 *
	 * @return the pilote
	 */
	//******GETTER AND SETTER******
	public static String getPilote() {
		return pilote;
	}


	/**
	 * Sets the pilote.
	 *
	 * @param pilote the new pilote
	 */
	public static void setPilote(String pilote) {
		Singleton.pilote = pilote;
	}


	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public static String getUrl() {
		return url;
	}


	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public static void setUrl(String url) {
		Singleton.url = url;
	}


	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public static String getLogin() {
		return login;
	}


	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public static void setLogin(String login) {
		Singleton.login = login;
	}


	/**
	 * Gets the passord.
	 *
	 * @return the passord
	 */
	public static String getPassord() {
		return passord;
	}


	/**
	 * Sets the passord.
	 *
	 * @param passord the new passord
	 */
	public static void setPassord(String passord) {
		Singleton.passord = passord;
	}


	/**
	 * Gets the connect.
	 *
	 * @return the connect
	 */
	public static Connection getConnect() {
		return connect;
	}


	/**
	 * Sets the connect.
	 *
	 * @param connect the new connect
	 */
	public static void setConnect(Connection connect) {
		Singleton.connect = connect;
	}


	/**
	 * Gets the connexion.
	 *
	 * @return the connexion
	 */
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
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else{//sinon si l'objet connect est déja initialisé, c'est que l'on c'est déja connecté donc on a pas besoin de se reconnecter.
			System.out.println("Connection SQL existante");
		}
		return connect;	//retourne la connexion du type Connection qui appertient à l'api java
	}




}

