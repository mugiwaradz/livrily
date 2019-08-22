package com.zinou.Livrily.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zinou.Livrily.model.Supermarché;

import util.DB;
import util.DBImpl;

public class SupermarchéRepositoryImpl implements SupermarchéRepository {

	DB db = new DBImpl();
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public Supermarché AjouterSupermarché(Supermarché supermarché) {

		String sql ="INSERT INTO `supermarche` ( `filiale_id`, `nom`, `telephone`, `email`) VALUES (?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, supermarché.getFiliale_ID());
			stmt.setString(2, supermarché.getNomSupermarché());
			stmt.setInt(3, supermarché.getTéléphoneSupermarché());
			stmt.setString(4, supermarché.getEmailSupermarché());

			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();

			if (generatedKeys.next()) {
				supermarché.setSupermarché_ID(generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("Creating Supermarché failed, no ID obtained.");
			}

		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}


		return supermarché;
	}

	@Override
	public boolean SupprimerSupermarché(int id_supermarché) {
		String sql = "DELETE FROM Supermarche  WHERE supermarche_id=?";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(1, id_supermarché);

			int ret=stmt.executeUpdate();
			return ret>0 ;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return false;


	}


}
