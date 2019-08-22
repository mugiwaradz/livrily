package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.zinou.Livrily.model.Full_User;
import com.zinou.Livrily.model.Utilisateur;
import com.zinou.Livrily.repository.UtilisateurRepositoryImpl;

public class ExacteUser {
	
	Logger log = Logger.getLogger(UtilisateurRepositoryImpl.class.getName());


	public static String GetClient() {

		String sql = "SELECT * FROM Utilisateur inner join client on (utilisateur.utilisateur_id = client.utilisateur_id)" ; 
		return sql;
	}
	
	public static String GetFournisseur() {

		String sql = "SELECT * FROM Utilisateur inner join fournisseur on (Utilisateur.Utilisateur_id = fournisseur.utilisatuer_id)" ; 
				
		return sql;
	}
	public static  String  GetLivreur() {

		String sql = "SELECT * FROM Utilisateur inner join livreur on (Utilisateur.Utilisateur_id = livreur.utilisatuer_id)" ; 
		return sql;
	}

	public static  String  GetUtilisateur() {

		String sql = "SELECT * FROM Utilisateur where 1=1 ";
		return sql;
	}



	public static Full_User getutilisateur(ResultSet rs) throws SQLException {
		Full_User utilisateur = new Full_User();
		
		Utilisateur user = new Utilisateur();
		user.setUtilisateur_ID((rs.getInt(1)));
		user.setNom(rs.getString(2));
		user.setPrenom(rs.getString(3));
		user.setDateNaissance(rs.getTimestamp(4));
		user.setLieudeudeNaissance(rs.getString(5));
		user.setPhone1(rs.getInt(6));
		user.setPhone2(rs.getInt(7));
		user.setEmail(rs.getString(8));
		user.setLogin(rs.getString(9));
		user.setPasword(rs.getString(10));

		utilisateur.setUtilisateur(user);
		return utilisateur;

	}
}
