package com.zinou.Livrily.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Commande;
import com.zinou.Livrily.model.CommandeLine;
import com.zinou.Livrily.model.Commandecomplette;

import util.DB;
import util.DBImpl;

@Service
public class CommandeRepositoryImpl implements CommandeRepository {
	DB db = new DBImpl();
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());
	@Override
	public List<Commandecomplette> getCommandes(Timestamp date_commande, int id_commande) {

		    ResultSet rs=null;
			String sql = null ;
			try {
			if (date_commande != null) {
				sql="SELECT * FROM commande inner join commande_line "
						+ "on (commande.commande_id = commande_line.commande_id)"
						+ " where commande.datecommande<(?) order by commande.datecommande";
				PreparedStatement stmt;
				stmt = db.getConnection().prepareStatement(sql);
				stmt.setTimestamp(1, date_commande);
				 rs = stmt.executeQuery();

			}else if (id_commande > 0) {
				sql="SELECT * FROM commande inner join commande_line "
						+ "on (commande.commande_id = commande_line.commande_id)"
						+ " where commande.commande_id = (?) ";
				PreparedStatement stmt;
				stmt = db.getConnection().prepareStatement(sql);
				stmt.setInt(1, id_commande);
				 rs = stmt.executeQuery();

			}

			
			List<Commandecomplette> commandes = new ArrayList<>();

			int old_comande_id=0;

			Commandecomplette commandecomplette = null;
			List<CommandeLine> commandelines = null;

			while (rs.next()) {

				if(old_comande_id != rs.getInt(1)) {

					commandecomplette = new Commandecomplette();
					commandes.add(commandecomplette);	

					commandelines= new ArrayList<>();

					Commande commande=new Commande();
					commande.setCommande_ID(rs.getInt(1));	
					commande.setSupermarché_ID(rs.getInt(2));
					commande.setClinet_ID(rs.getInt(3));
					commande.setDtaedeCommande(rs.getTimestamp(4));
					commande.setStatue(rs.getString(5));
					commande.setNumeroCommande(rs.getInt(6));
					commande.setTarif(rs.getString(7));
					commande.setTotal(rs.getDouble(8));
					commande.setTva(rs.getInt(9));
					commandecomplette.setCommande(commande);

					commandecomplette.setCommandelines(commandelines);

					old_comande_id = rs.getInt(1);
				}

				CommandeLine commandeline = new CommandeLine();
				commandeline.setCommandeLine_ID(rs.getInt("commande_line_id"));
				commandeline.setProduit_ID(rs.getInt("produit_id"));
				commandeline.setPrix(rs.getDouble("prix"));
				commandeline.setQuantityCommande(rs.getInt("quantityCommande"));
				commandeline.setTotalLine(rs.getDouble("totalLine"));
				commandelines.add(commandeline);
			}
			return commandes;


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public CommandeLine saveCommandeLine(CommandeLine line) {		

		//		TODO corriger requette
		String sql = "INSERT INTO `Commande_line` ( `Commande_ID`, `produit_id`, `prix`, `quantityCommande`, `totalLine`) VALUES  (?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, line.getCommande_ID());
			stmt.setInt(2, line.getProduit_ID());
			stmt.setDouble(3, line.getPrix());
			stmt.setInt(4, line.getQuantityCommande());
			stmt.setDouble(5, line.getTotalLine());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				line.setCommandeLine_ID(generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("Creating commande line failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return line;

	}


	@Override
	public void updateCommande(Double prixTotal, int commande_ID) {		

		//		TODO corriger requette
		String sql = "UPDATE `Commande` set total = ?  where commande_ID = ? ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setDouble(1, prixTotal);
			stmt.setInt(2, commande_ID);

			stmt.executeUpdate();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

	}
	@Override
	public Commande saveCommande(Commande commande) {		

		//		TODO corriger requette
		//TODO plsql numero commande sequence
		String sql = "INSERT INTO `Commande` ( `client_id`, `supermarche_id`, `datecommande`, `statue`, `NumeroCommande`, `tarif`, `tva`) VALUES  (?,?,?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, commande.getClinet_ID());
			stmt.setInt(2, commande.getSupermarché_ID());
			stmt.setTimestamp(3, commande.getDtaedeCommande());
			stmt.setString(4, "non-Livré");
			stmt.setString(5, null);
			stmt.setInt(6, 0);
			stmt.setInt(7, commande.getTva());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				commande.setCommande_ID(generatedKeys.getInt(1));
				commande.setNumeroCommande(1000+generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("Creating commande failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return commande;

	}

}
