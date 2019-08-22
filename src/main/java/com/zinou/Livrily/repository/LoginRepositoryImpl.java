package com.zinou.Livrily.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.DB;
import util.DBImpl;

public class LoginRepositoryImpl implements LoginRepository {

	DB db = new DBImpl();
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public boolean Login(String login, String pasword) {

		String sql = "SELECT * FROM utilisateur  WHERE login = ? AND pasword=? ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, pasword);

			ResultSet rs = stmt.executeQuery();
			if(rs.next()) 
				return true;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return false;
	}

}
