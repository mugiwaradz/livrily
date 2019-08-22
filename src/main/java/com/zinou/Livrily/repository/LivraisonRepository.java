package com.zinou.Livrily.repository;

import java.util.List;

import com.zinou.Livrily.model.Livraison;
import com.zinou.Livrily.model.Livraison_Line;
import com.zinou.Livrily.model.Livraisoncomplette;


public interface LivraisonRepository {

	List<Livraisoncomplette> getLivraisons(Boolean estlivre);

	Livraisoncomplette getLivraisonByID(int livraison_id);

	Livraison createLivraison(Livraison livraison);

	Livraison_Line createLivraisonLine(Livraison_Line line);

	void updateLivraison(Double volumneTotal, int livraison_id);

}
