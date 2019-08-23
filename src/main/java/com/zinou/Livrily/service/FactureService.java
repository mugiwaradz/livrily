package com.zinou.Livrily.service;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import com.zinou.Livrily.model.Facturecomplette;



public interface FactureService {

	List<Facturecomplette> getFactures();

	boolean createFacture(int id_facture);

	ResponseEntity<InputStreamResource> printFacture(int id_facture);

}
