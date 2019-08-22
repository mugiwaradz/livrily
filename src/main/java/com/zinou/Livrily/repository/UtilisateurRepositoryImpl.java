package com.zinou.Livrily.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zinou.Livrily.model.Full_User;

import util.DB;
import util.DBImpl;
import util.ExacteUser;
import util.Inscription;

public class UtilisateurRepositoryImpl implements  UtilisateurRepository {

	DB db = new DBImpl();
	Logger log = Logger.getLogger(UtilisateurRepositoryImpl.class.getName());
	Full_User user=new Full_User();


	@Override
	public List<Full_User> getUtilsateurs(int type_user, String sql)  {
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<Full_User> utilsateurs = new ArrayList<>();
			while(rs.next()) {

				Full_User utilisateur = ExacteUser.getutilisateur(rs);
				utilisateur.setType_user(type_user);
				switch (type_user) {
				case 1:
					utilisateur.setNumCarteCredit((rs.getInt("NumcarteCredit")));
					utilisateur.setEnvoyerMail((rs.getBoolean("EnvoyerMail")));
					utilisateur.setEnvoyerSMS((rs.getBoolean("EnvoyerSMS")));
					utilisateur.setClient_ID(rs.getInt("client_id"));
					break;
				case 2:
					utilisateur.setMoyenLivraison((rs.getString("moyenLivraison")));
					utilisateur.setTypePermetConduire((rs.getString("typePermetConduire")));
					utilisateur.setDistanceMax((rs.getInt("distanceMax")));
					break;
				case 3:
					utilisateur.setNumeroFiscale((rs.getInt("numeroFiscale")));
					utilisateur.setNumeroGestire((rs.getInt("numeroGestire")));
					utilisateur.setTaxid((rs.getString("taxid")));
					break;

				default:
					break;
				}
				utilsateurs.add( utilisateur );
			}

			return utilsateurs;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Full_User createutilisateurs(Full_User full_user) {

		String sql = "INSERT INTO `livrili`.`utilisateur` ( `nom`, `prenom`, `datedenaissance`, `lieudenaissance`, `phone`, `phone2`, `email`, `login`, `pasword`)  VALUES  (?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, full_user.getUtilisateur().getNom());
			stmt.setString(2, full_user.getUtilisateur().getPrenom());
			stmt.setTimestamp(3, full_user.getUtilisateur().getDateNaissance());
			stmt.setString(4, full_user.getUtilisateur().getLieudeudeNaissance());
			stmt.setInt(5, full_user.getUtilisateur().getPhone1());
			stmt.setInt(6, full_user.getUtilisateur().getPhone2());
			stmt.setString(7, full_user.getUtilisateur().getEmail());
			stmt.setString(8, full_user.getUtilisateur().getLogin());
			stmt.setString(9, full_user.getUtilisateur().getPasword());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				full_user.getUtilisateur().setUtilisateur_ID(generatedKeys.getInt(1));
				Inscription inscription =new Inscription();
				switch (full_user.getType_user()) {

				case 1:inscription.createClient(full_user);
				break;

				case 2:inscription.createLivreur(full_user);
				break;

				case 3:inscription.createFournisseur(full_user);
				break;

				default:
					break;
				}

			}
			else {
				throw new SQLException("Creating user failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return full_user ;
	}


	@Override
	public boolean deleteutilisateurs(int id_utilisateur) {
		String sql = "DELETE FROM utilisateur WHERE utilisateur_id=?";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(1, id_utilisateur);

			int ret=stmt.executeUpdate();
			return ret>0 ;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return false;
	}

}




