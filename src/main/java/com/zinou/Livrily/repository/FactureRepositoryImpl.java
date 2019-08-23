package com.zinou.Livrily.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zinou.Livrily.model.Facture;
import com.zinou.Livrily.model.FactureLine;
import com.zinou.Livrily.model.Facturecomplette;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import util.DB;
import util.DBImpl;

@Service
public class FactureRepositoryImpl implements FactureRepository {

	DB db = new DBImpl();
	Logger log = Logger.getLogger(ArticleRepositoryImpl.class.getName());



	@Override
	public List<Facturecomplette> getFactures() {

		String sql="SELECT * FROM Facture inner join Facture_line "
				+ "on (Facture.Facture_id = Facture_line.Facture_id)";

		PreparedStatement stmt;


		try {
			stmt = db.getConnection().prepareStatement(sql);

			//			stmt.setBoolean(1, estlivre);
			ResultSet rs = stmt.executeQuery();
			List<Facturecomplette> factures = new ArrayList<>();

			int old_facture_id=0;

			Facturecomplette facturecomplette = null;
			List<FactureLine> facturelines = null;
			while (rs.next()) {
				if(old_facture_id!= rs.getInt(1)) {

					facturecomplette = new Facturecomplette();
					factures.add(facturecomplette);	

					facturelines= new ArrayList<>();
					Facture facture=new Facture();
					facture.setClient_ID(rs.getInt(1));
					facture.setFacture_ID(rs.getInt(2));
					facture.setLivraison_ID(rs.getInt(3));
					facture.setNumeroFacture(rs.getString(4));
					facture.setTarif(rs.getString(5));
					facture.setTotal(rs.getDouble(6));
					facture.setTva(rs.getInt(7));


					facturecomplette.setFacture(facture);
					facturecomplette.setFacturelines(facturelines);

					old_facture_id=rs.getInt(1);
				}

				FactureLine factureLine= new FactureLine();
				factureLine.setFactureLine_ID(rs.getInt("Factureline_id"));
				factureLine.setProduitID(rs.getInt("produit_id"));
				factureLine.setQuantityFacture(rs.getInt("quantitefacture"));
				factureLine.setTotalLine(rs.getDouble("totaleline"));
				factureLine.setPrix(rs.getDouble("prix"));

				facturelines.add(factureLine);
			}
			return factures;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}

	@Override
	public Facture createFacture(Facture Facture) {		

		//		TODO corriger requette
		String sql = "INSERT INTO `Facture` ( `Livraison_ID`, `Client_ID`, `NumeroFacture`, `tarif`, `tva`) VALUES  (?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, Facture.getLivraison_ID());
			stmt.setInt(2, Facture.getClient_ID());
			stmt.setString(3, Facture.getNumeroFacture());
			stmt.setString(4, Facture.getTarif());
			stmt.setInt(5, Facture.getTva());


			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				Facture.setFacture_ID(generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("Creating Facture failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return Facture;

	}

	@Override
	public FactureLine createFactureLine(FactureLine line) {		

		//		TODO corriger requette
		String sql = "INSERT INTO `Facture_Line` ( `Facture_ID`, `produit_id`, `quantityFacture`, `totalLine`,`prix`) VALUES  (?,?,?,?,?) ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, line.getFacture_ID());
			stmt.setInt(2, line.getProduitID());
			stmt.setInt(3, line.getQuantityFacture());
			stmt.setDouble(4, line.getTotalLine());
			stmt.setDouble(5, line.getPrix());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				line.setFactureLine_ID(generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("Creating Facture failed, no ID obtained.");
			}

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		return line;

	}

	@Override
	public void updateFacture(Double volumneTotal, int Facture_id) {		

		//		TODO corriger requette
		String sql = "UPDATE `Facture` set total = ?  where facture_id = ? ";
		PreparedStatement stmt;
		try {
			stmt = db.getConnection().prepareStatement(sql);
			stmt.setInt(2, Facture_id);
			stmt.setDouble(1, volumneTotal);

			stmt.executeUpdate();

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}

	}

	@Override
	public ResponseEntity<InputStreamResource> printFacture(int id_facture) {
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id_facture", id_facture);
		Connection datasource = db.getConnection();
		try {
			JasperReport jrxmlFile = JasperCompileManager.compileReport("src/main/resources/facture.jrxml");
//			JasperPrint jasperPrint; = JasperFillManager.fillReport(jasperReport, hm, ds); //with datasource
			JasperPrint jasperPrint = JasperFillManager.fillReport(jrxmlFile, parameters, new JREmptyDataSource());

			String filename =   "facture_" + id_facture + ".pdf";
			JasperExportManager.exportReportToPdfFile(jasperPrint, filename);

			ClassPathResource pdfFile = new ClassPathResource(filename);

			return ResponseEntity
					.ok()
					.contentLength(pdfFile.contentLength())
					.contentType(MediaType.parseMediaType("application/octet-stream"))
					.body(new InputStreamResource(pdfFile.getInputStream()));

		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		
		return null;
	}

}
