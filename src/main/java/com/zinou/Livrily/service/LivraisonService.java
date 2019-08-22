package com.zinou.Livrily.service;

import java.util.List;

import com.zinou.Livrily.model.Livraisoncomplette;


public interface LivraisonService {

	List<Livraisoncomplette> getLivraisons(Boolean estlivre, int livraison_id);

	boolean createLivraison(int id_commande, int livreur_id);

}
