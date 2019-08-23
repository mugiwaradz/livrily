package com.zinou.Livrily.repository;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import com.zinou.Livrily.model.Facture;
import com.zinou.Livrily.model.FactureLine;
import com.zinou.Livrily.model.Facturecomplette;



public interface FactureRepository {

	List<Facturecomplette> getFactures();

	Facture createFacture(Facture Facture);

	FactureLine createFactureLine(FactureLine line);

	void updateFacture(Double volumneTotal, int Facture_id);

	ResponseEntity<InputStreamResource> printFacture(int id_facture);

}
