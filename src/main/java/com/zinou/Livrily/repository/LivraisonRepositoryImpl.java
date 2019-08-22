package com.zinou.Livrily.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Livraison;
import com.zinou.Livrily.model.Livraison_Line;
import com.zinou.Livrily.model.Livraisoncomplette;

import util.DB;
import util.DBImpl;

@Service
public class LivraisonRepositoryImpl implements LivraisonRepository {

	DB db = new DBImpl();
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());

	@Override
	public List<Livraisoncomplette> getLivraisons(Boolean estlivre) {

		String sql="SELECT * FROM Livraison inner join livraison_line "
				+ "on (livraison.livraison_id = livraison_line.livraison_id)"
				+ " where livraison.estLivre= (?)";
		PreparedStatement stmt;


		try {
			stmt = db.getConnection().prepareStatement(sql);

			stmt.setBoolean(1, estlivre);
			ResultSet rs = stmt.executeQuery();
			List<Livraisoncomplette> Livraisons = new ArrayList<>();

			int old_livraison_id=0;

			Livraisoncomplette livraisoncomplette = null;
			List<Livraison_Line> livraisonlines = null;
			while (rs.next()) {
				if(old_livraison_id!= rs.getInt(1)) {

					livraisoncomplette = new Livraisoncomplette();
					Livraisons.add(livraisoncomplette);	

					livraisonlines= new ArrayList<>();
					Livraison livraison=new Livraison();
					livraison.setCommande_ID(rs.getInt(1));
					livraison.setLivraison_ID(rs.getInt(2));
					livraison.setLivreur_ID(rs.getInt(3));
					livraison.setNumeroLivraison(rs.getString(4));
					livraison.setVolumneTotal(rs.getInt(5));
					livraison.setEstLivre(rs.getBoolean(6));

					livraisoncomplette.setLivraison(livraison);
					livraisoncomplette.setLivraisonlines(livraisonlines);

					old_livraison_id=rs.getInt(1);
				}

				Livraison_Line livraison_Line= new Livraison_Line();
				livraison_Line.setLivraison_Line_ID(rs.getInt("livraison_line_id"));
				livraison_Line.setProduit_ID(rs.getInt("produit_id"));
				livraison_Line.setQuantitylivre(rs.getInt("quantitylivre"));
				livraison_Line.setVolume(rs.getDouble("volume"));
				livraisonlines.add(livraison_Line);
			}
			return Livraisons;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}


	@Override
	public Livraisoncomplette getLivraisonByID(int livraison_id) {

		String sql="SELECT * FROM Livraison inner join livraison_line "
				+ "on (livraison.livraison_id = livraison_line.livraison_id)"
				+"where livraison.livraison_id=(?);";
		PreparedStatement stmt;


		try {
			stmt = db.getConnection().prepareStatement(sql);

			stmt.setInt(1, livraison_id);
			ResultSet rs = stmt.executeQuery();
			
			Livraisoncomplette livraisoncomplette = null;
			List<Livraison_Line> livraisonlines = null;
			int old_livraison_id=0;

			if (rs.next()) {
				if(old_livraison_id!= rs.getInt(1)) {

					livraisoncomplette = new Livraisoncomplette();

					livraisonlines= new ArrayList<>();
					Livraison livraison=new Livraison();
					livraison.setCommande_ID(rs.getInt(1));
					livraison.setLivraison_ID(rs.getInt(2));
					livraison.setLivreur_ID(rs.getInt(3));
					livraison.setNumeroLivraison(rs.getString(4));
					livraison.setVolumneTotal(rs.getInt(5));
					livraison.setEstLivre(rs.getBoolean(6));

					livraisoncomplette.setLivraison(livraison);
					livraisoncomplette.setLivraisonlines(livraisonlines);

					old_livraison_id=rs.getInt(1);
				}

				Livraison_Line livraison_Line= new Livraison_Line();
				livraison_Line.setLivraison_Line_ID(rs.getInt("livraison_line_id"));
				livraison_Line.setProduit_ID(rs.getInt("produit_id"));
				livraison_Line.setQuantitylivre(rs.getInt("quantitylivre"));
				livraison_Line.setVolume(rs.getDouble("volume"));
				livraisonlines.add(livraison_Line);
			}
			return livraisoncomplette;

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}
	@Override
	public Livraison createLivraison(Livraison livraison) {		

		//		TODO corriger requette
		String sql = "INSERT INTO `livrili`.`livraison` ( `commande_id`, `livreur_id`, `NumeroLivraison`, `volumneTotal`, `estLivre`)  VALUES  (?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, livraison.getCommande_ID());
			stmt.setInt(2, livraison.getLivreur_ID());
			stmt.setString(3, livraison.getNumeroLivraison());
			stmt.setInt(4, livraison.getVolumneTotal());
			stmt.setBoolean(5, livraison.isEstLivre());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				livraison.setLivraison_ID(generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("Creating livraison failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return livraison;

	}

	@Override
	public Livraison_Line createLivraisonLine(Livraison_Line line) {		

		//		TODO corriger requette
		String sql = "INSERT INTO `livrili`.`livraison_line` (`livraison_id`, `produit_id`, `quantitylivre`, `volume`) VALUES  (?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, line.getLivraison_ID());
			stmt.setInt(2, line.getProduit_ID());
			stmt.setInt(3, line.getQuantitylivre());
			stmt.setDouble(4, line.getVolume());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				line.setLivraison_Line_ID(generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("Creating livraison failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return line;

	}

	@Override
	public void updateLivraison(Double volumneTotal, int livraison_id) {		

		//		TODO corriger requette
		String sql = "UPDATE `Livraison` set volumneTotal = ?  where livraison_id = ? ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(2, livraison_id);
			stmt.setDouble(1, volumneTotal);

			stmt.executeUpdate();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

	}


}
