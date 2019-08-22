package com.zinou.Livrily.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zinou.Livrily.model.Produit;

import util.DB;
import util.DBImpl;

public class PromotionsRepositoryImpl implements PromotionsRepository {
	DB db = new DBImpl();
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());


	@Override
	public int postPromotion(int promotion,int produit_ID) {

		String sql="UPDATE `livrili`.`produit` SET `promotion` = ? WHERE (`produit_id` = ?);";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(1,promotion);
			stmt.setInt(2, produit_ID);

			stmt.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return promotion;
	}


	@Override
	public List<Produit> getPromotion(int categorieProduit_ID) {

		String sql="SELECT produit.nom ,produit.promotion FROM  produit inner join categorie_produit on (produit.category_produit_id = categorie_produit.categorie_produit_id)";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<Produit> produits = new ArrayList<>();
			while(rs.next()) {
				Produit produit = new Produit();
				produit.setCategoréProduit_ID(categorieProduit_ID);
				produit.setNomProduit(rs.getString(1));
				produit.setPromotion(rs.getInt(2));
				
				if(produit.getPromotion()>0)
					produits.add(produit);

			}

			return produits;

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return null;

	}



}
