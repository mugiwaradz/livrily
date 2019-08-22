package util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.zinou.Livrily.model.Full_User;
import com.zinou.Livrily.repository.UtilisateurRepositoryImpl;

public class Inscription {
	
	DB db = new DBImpl();
	Logger log = Logger.getLogger(UtilisateurRepositoryImpl.class.getName());
	
	
	public Full_User createClient (Full_User client) throws SQLException {

		String sql = "INSERT INTO `Client` ( `utilisateur_id`, `NumcarteCredit`) VALUES  (?,?)";
		PreparedStatement stmt;

		stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, client.getUtilisateur().getUtilisateur_ID());
		stmt.setInt(2, client.getNumCarteCredit());
		
		stmt.executeUpdate();
		ResultSet generatedKeys = stmt.getGeneratedKeys();
		
		if (generatedKeys.next()) {
			client.setClient_ID(generatedKeys.getInt(1));
		}
		return client;

	}


	public Full_User createLivreur (Full_User livreur) throws SQLException {

		String sql = "INSERT INTO `Livreur` ( `utilisateur_id`, `moyenLivraison`,`typePermetConduire`,`distanceMax`) VALUES  (?,?,?,?)";
		PreparedStatement stmt;

		stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, livreur.getUtilisateur().getUtilisateur_ID());
		stmt.setString(2,livreur.getMoyenLivraison());
		stmt.setString(3,livreur.getTypePermetConduire());
		stmt.setInt(4,livreur.getDistanceMax());
		
		stmt.executeUpdate();
		ResultSet generatedKeys = stmt.getGeneratedKeys();
		
		if (generatedKeys.next()) {
			livreur.setLivreur_ID(generatedKeys.getInt(1));
		}
		return livreur;

	}

	public Full_User createFournisseur (Full_User fournisseur) throws SQLException {

		String sql = "INSERT INTO `Fournisseur` ( `utilisateur_id`, `numeroRegistre`,`numeroFiscale`,`taxid`) VALUES (?,?,?,?)";
		PreparedStatement stmt;

		stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, fournisseur.getUtilisateur().getUtilisateur_ID());
		stmt.setInt(2,fournisseur.getNumeroGestire());
		stmt.setInt(3,fournisseur.getNumeroFiscale());
		stmt.setString(4,fournisseur.getTaxid());

		stmt.executeUpdate();
		ResultSet generatedKeys = stmt.getGeneratedKeys();
		
		if (generatedKeys.next()) {
			fournisseur.setFournisseur_ID(generatedKeys.getInt(1));
		}
		return fournisseur;


	}

	
	
	
	
}
