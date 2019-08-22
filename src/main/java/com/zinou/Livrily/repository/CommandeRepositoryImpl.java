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

		String sql = null ;
		if (date_commande != null)
			sql="SELECT * FROM commande inner join commande_line "
					+ "on (commande.commande_id = commande_line.commande_id)"
					+ " where commande.datecommande<(?) order by commande.datecommande";
		
		else if (id_commande > 0)
			sql="SELECT * FROM commande inner join commande_line "
					+ "on (commande.commande_id = commande_line.commande_id)"
					+ " where commande.id_commande = (?) ";

		PreparedStatement stmt;

		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setTimestamp(1, date_commande);
			ResultSet rs = stmt.executeQuery();
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
					commande.setNumeroCommande(rs.getString(5));
					commande.setStatue(rs.getString(6));
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
		String sql = "INSERT INTO `Commande_line` ( `Commande_ID`, `produit_id`, `prix`, `promotion`, `quantityCommande`, `totalLine`) VALUES  (?,?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, line.getCommande_ID());
			stmt.setInt(2, line.getProduit_ID());
			stmt.setDouble(3, line.getPrix());
			stmt.setInt(4, line.getPromotion());
			stmt.setInt(5, line.getQuantityCommande());
			stmt.setDouble(6, line.getTotalLine());

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
		String sql = "INSERT INTO `Commande` ( `client_id`, `supermarché_id`, `DateDeCommande`, `statue`, `NumeroCommande`, `tarif`, `tva`) VALUES  (?,?,?,?,getNumeroCommande(),?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, commande.getClinet_ID());
			stmt.setInt(2, commande.getSupermarché_ID());
			stmt.setTimestamp(3, commande.getDtaedeCommande());
			stmt.setString(4, commande.getStatue());
			stmt.setString(5, commande.getTarif());
			stmt.setInt(6, commande.getTva());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				commande.setCommande_ID(generatedKeys.getInt(1));
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
