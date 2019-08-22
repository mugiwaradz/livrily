package com.zinou.Livrily.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zinou.Livrily.model.Client;

import util.DB;
import util.DBImpl;

public class ClientRepositoryImpl implements ClientRepository {


	DB db = new DBImpl();
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());
	
	@Override
	public Client getClient(int client_id) {

		String sql = "SELECT * FROM Client";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			Client client = new Client(); //TODO verifié
			while(rs.next()) {
				client.setClient_ID(rs.getInt("Client_ID"));
				client.setUtilisateur_ID(rs.getInt("utilisateur_id"));
				client.setEnvoyerMail(rs.getBoolean("envoyerMail"));
				client.setEnvoyerSMS(rs.getBoolean("envoyerSMS"));
				client.setNumCarteCredit(rs.getInt("NumCarteCredit"));
			}

			return client;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

		return null;
	}
}