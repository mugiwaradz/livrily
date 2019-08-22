package com.zinou.Livrily.service;

import java.io.File;
import java.util.List;

import com.zinou.Livrily.model.Facturecomplette;


public interface FactureService {

	List<Facturecomplette> getFactures();

	boolean createFacture(int id_facture);

	File printFacture(int id_facture);

}
